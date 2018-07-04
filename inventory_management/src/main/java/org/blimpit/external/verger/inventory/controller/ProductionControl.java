package org.blimpit.external.verger.inventory.controller;

import org.blimpit.external.verger.inventory.config.ApplicationProperties;
import org.blimpit.external.verger.inventory.model.ProductionActivity;
import org.blimpit.external.verger.inventory.model.ResponseStatus;
import org.blimpit.external.verger.inventory.utils.Constant;
import org.blimpit.utils.connectors.ConnectorException;
import org.blimpit.utils.connectors.mysql.MySQLConnector;
import org.blimpit.utils.connectors.mysql.Record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductionControl {

    private ApplicationProperties applicationProperties = ApplicationProperties.getInstance(Constant.PATH_CONFFILE);
    private static MySQLConnector mySQLConnector;


    private String logUsername= applicationProperties.getValue("db.column.log.username");
    private String logCount=applicationProperties.getValue("db.column.log.logcount");
    private String host;
    private String port;
    private String db;
    private String dbusername;
    private String dbpassword;
    private String tablenameProductionActivity;

    public ProductionControl() {
        applicationProperties = ApplicationProperties.getInstance("config.properties");
        this.host = applicationProperties.getValue("db.host");
        this.port = applicationProperties.getValue("db.port");
        this.db = applicationProperties.getValue("db.name");
        this.dbusername = applicationProperties.getValue("db.username");
        this.dbpassword = applicationProperties.getValue("db.password");
        this.tablenameProductionActivity = applicationProperties.getValue("db.production.activity");



        try{
            mySQLConnector = (MySQLConnector)MySQLConnector.getInstance(this.host,this.port,this.db,this.dbusername,this.dbpassword);
        }catch (ConnectorException var2){
            var2.printStackTrace();
        }
    }

    public ResponseStatus addProductionActivity(ProductionActivity productionActivity){
        ResponseStatus responseStatus = new ResponseStatus();
        Map<String,String> map = new HashMap<String, String>();
        map.put("year",String.valueOf(productionActivity.getYear()));
        map.put("month",String.valueOf(productionActivity.getMonth()));
        map.put("day",String.valueOf(productionActivity.getDay()));
        map.put("activity",productionActivity.getActivity());

        boolean insert=false;
        String query ="select count(*) as number from production_activity where year='"+productionActivity.getYear()+"' and month='"+productionActivity.getMonth()+"' and day='"+productionActivity.getDay()+"';";

        try {

            Record[] records = mySQLConnector.executeQuery(query,null);
            Record[] var3 = records;
            Record record = var3[0];
            String number = record.getRecordAttributes().get("number");
            System.out.println("Num = "+number);
            int num = Integer.parseInt(number);
            if (num==0){
                insert=mySQLConnector.insert(this.tablenameProductionActivity,map);
            }else {
                insert = mySQLConnector.update(this.tablenameProductionActivity,"day",String.valueOf(productionActivity.getDay()),map);

            }
            if (insert){
                responseStatus.setSuccess(true);
                responseStatus.setMessage("Production Activity Added Successfully");
            }
            else {
                responseStatus.setSuccess(false);
                responseStatus.setMessage("Failed");
            }
        }catch (ConnectorException var9){
            responseStatus.setSuccess(true);
            responseStatus.setMessage("Cannot register user, check mysql server is up and running, " + var9.getMessage());
        }
        return responseStatus;
    }


    public ProductionActivity[] getProductionActivity(int year , int month){
        ArrayList productionList = new ArrayList();


        String query = "select * from production_activity where year='"+year+"' and month='"+month+"';";
        try {
            Record[] records = mySQLConnector.executeQuery(query,null);
            if (records.length > 0) {
            Record[] var3 = records;
            int var4 = records.length;
            for(int var5 = 0; var5 < var4; ++var5) {
                Record record = var3[var5];
                ProductionActivity productionActivity = new ProductionActivity();
                productionActivity.setDay(Integer.parseInt(record.getRecordAttributes().get("day")));
                productionActivity.setYear(Integer.parseInt(record.getRecordAttributes().get("year")));
                productionActivity.setMonth(Integer.parseInt(record.getRecordAttributes().get("month")));
                productionActivity.setActivity(record.getRecordAttributes().get("activity"));

                productionList.add(productionActivity);
            }
        }

        }catch (ConnectorException var10){

        }
        return (ProductionActivity[])productionList.toArray(new ProductionActivity[productionList.size()]);
    }
}
