package org.blimpit.external.verger.inventory.controller;


import org.blimpit.external.verger.inventory.config.ApplicationProperties;
import org.blimpit.external.verger.inventory.model.QC_PlatForm;
import org.blimpit.external.verger.inventory.model.Products;
import org.blimpit.external.verger.inventory.utils.Constant;
import org.blimpit.utils.connectors.ConnectorException;
import org.blimpit.utils.connectors.mysql.MySQLConnector;
import org.blimpit.utils.connectors.mysql.Record;
import org.blimpit.external.verger.inventory.model.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QcControl {
    private ApplicationProperties applicationProperties =  ApplicationProperties.getInstance(Constant.PATH_CONFFILE);
    private static MySQLConnector mySQLConnector;

    private String host;
    private String port;
    private String db;
    private String dbusername;
    private String dbpassword;
    private String tablenameQCPlatForm;
    private String tablenameProducts;
    private String proID;
    private String proName;

    public QcControl() {

        applicationProperties = ApplicationProperties.getInstance("config.properties");
        this.host = applicationProperties.getValue("db.host");
        this.port = applicationProperties.getValue("db.port");
        this.db = applicationProperties.getValue("db.name");
        this.dbusername = applicationProperties.getValue("db.username");
        this.dbpassword = applicationProperties.getValue("db.password");
        this.tablenameQCPlatForm = applicationProperties.getValue("db.qc.platform");
        this.tablenameProducts = applicationProperties.getValue("db.qc.products");
        this.proID = applicationProperties.getValue("db.column.products.id");
        this.proName = applicationProperties.getValue("db.column.products.name");


        try {
            mySQLConnector = (MySQLConnector) MySQLConnector.getInstance(this.host, this.port, this.db, this.dbusername, this.dbpassword);
        } catch (ConnectorException var2) {
            var2.printStackTrace();
        }

    }

    public List<QC_PlatForm> getQC_data() {
        List<QC_PlatForm> QCMap = new ArrayList<QC_PlatForm>();

        try {
            Record[] records = mySQLConnector.read(this.tablenameQCPlatForm);

                for (int i = 0; i<records.length; i++) {
                    QC_PlatForm qc_platForm = new QC_PlatForm();

                    qc_platForm.setName(records[i].getRecordAttributes().get("name"));
                    qc_platForm.setProduct_id(records[i].getRecordAttributes().get("product_id"));
                    qc_platForm.setSupplier_id(records[i].getRecordAttributes().get("supplier_id"));
                    qc_platForm.setType(records[i].getRecordAttributes().get("type"));
                    qc_platForm.setDetails(records[i].getRecordAttributes().get("details"));
                    qc_platForm.setOr_ri(records[i].getRecordAttributes().get("or_ri"));
                    qc_platForm.setGc_1(records[i].getRecordAttributes().get("gc_1"));
                    qc_platForm.setGc_2(records[i].getRecordAttributes().get("gc_2"));
                    qc_platForm.setStatus(records[i].getRecordAttributes().get("status"));
                    qc_platForm.setComment(records[i].getRecordAttributes().get("comment"));
                    qc_platForm.setUsedfor(records[i].getRecordAttributes().get("usedfor"));
                    String q_id = (String)records[i].getRecordAttributes().get("qc_id");
                    qc_platForm.setId(Integer.valueOf(q_id));

                    QCMap.add(qc_platForm);
                }
        }catch (ConnectorException var9){
            }
            return QCMap;
    }

    public Products[] getProducts(){
        ArrayList productIDlist = new ArrayList();

        try {
            Record[] records = mySQLConnector.read(this.tablenameProducts);
            if (records.length > 0) {
                Record[] var3 = records;
                int var4 = records.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    Record record = var3[var5];
                    Products products = new Products();
                    String name = (String)record.getRecordAttributes().get(proName);
                    String proiD = (String)record.getRecordAttributes().get(proID);

                    products.setName(name);
                    products.setProduct_id(proiD);

                    productIDlist.add(products);
                }
            }
        } catch (ConnectorException var10) {
            ;
        }

        return (Products[])productIDlist.toArray(new Products[productIDlist.size()]);
    }

    public List<QC_PlatForm> searchByProductID(String value) {
        List<QC_PlatForm> searchMap = new ArrayList<QC_PlatForm>();
//        String query="select q.* from qc_platform q ,products p where q.product_id='"+value+"' and q.product_id=p.product_id;";
        String query="select distinct q.* from qc_platform q ,products p where q.product_id= (select product_id from products where name='"+value+"');";
        try {
            Record[] records = mySQLConnector.executeQuery(query,null);

            for (int i = 0; i<records.length; i++) {
                    QC_PlatForm qc = new QC_PlatForm();

                    qc.setName(records[i].getRecordAttributes().get("name"));
                    qc.setProduct_id(records[i].getRecordAttributes().get("product_id"));
                    qc.setSupplier_id(records[i].getRecordAttributes().get("supplier_id"));
                    qc.setType(records[i].getRecordAttributes().get("type"));
                    qc.setDetails(records[i].getRecordAttributes().get("details"));
                    qc.setOr_ri(records[i].getRecordAttributes().get("or_ri"));
                    qc.setGc_1(records[i].getRecordAttributes().get("gc_1"));
                    qc.setGc_2(records[i].getRecordAttributes().get("gc_2"));
                    qc.setStatus(records[i].getRecordAttributes().get("status"));
                    qc.setComment(records[i].getRecordAttributes().get("comment"));
                    qc.setUsedfor(records[i].getRecordAttributes().get("usedfor"));
                    String q_id = (String)records[i].getRecordAttributes().get("qc_id");
                    qc.setId(Integer.valueOf(q_id));


                    searchMap.add(qc);
            }
        }catch (ConnectorException var9){
        }
        return searchMap;
    }

    public Products getID(String value){

        Products products = new Products();
        String query = "select product_id from products where name='"+value+"';";
        try {
            Record[] records = mySQLConnector.executeQuery(query,null);
            products = new Products();
            products.setProduct_id(records[0].getRecordAttributes().get("product_id"));


        }catch (ConnectorException var9){

        }
        return products;
    }

    public ResponseStatus addNewEntry(QC_PlatForm qc_platForm) {
        ResponseStatus responseStatus = new ResponseStatus();
        Map<String, String> map = new HashMap();
        map.put("name",qc_platForm .getName());
        map.put("product_id", qc_platForm.getProduct_id());
        map.put("supplier_id", qc_platForm.getSupplier_id());
        map.put("type", qc_platForm.getType());
        map.put("details",qc_platForm.getDetails());
        map.put("or_ri",qc_platForm.getOr_ri());
        map.put("gc_1",qc_platForm.getGc_1());
        map.put("gc_2",qc_platForm.getGc_2());
        map.put("status",qc_platForm.getStatus());
        map.put("comment",qc_platForm.getComment());
        map.put("usedfor",qc_platForm.getUsedfor());


        try {
            boolean insert = mySQLConnector.insert(this.tablenameQCPlatForm, map);
            if (insert) {
                responseStatus.setSuccess(true);
                responseStatus.setMessage("Sent for acceptance from the admin ");
            } else {
                responseStatus.setSuccess(false);
                responseStatus.setMessage("Login failed due to password mismatch");
            }
        } catch (ConnectorException var6) {
            responseStatus.setSuccess(true);
            responseStatus.setMessage("Cannot register user, check mysql server is up and running, " + var6.getMessage());
        }

        return responseStatus;
    }

//    public ResponseStatus updateUsedFor(QcControl mm){
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("usedfor",mm.);
//
//    }

}
