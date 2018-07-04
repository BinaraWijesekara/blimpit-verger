package org.blimpit.external.verger.inventory.controller;

import org.blimpit.external.verger.inventory.config.ApplicationProperties;
import org.blimpit.external.verger.inventory.model.LabrotarySampeling;
import org.blimpit.external.verger.inventory.model.ResponseStatus;
import org.blimpit.external.verger.inventory.utils.Constant;
import org.blimpit.utils.connectors.ConnectorException;
import org.blimpit.utils.connectors.mysql.MySQLConnector;
import org.blimpit.utils.connectors.mysql.Record;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabrotarySampelingControl {

    private ApplicationProperties applicationProperties =  ApplicationProperties.getInstance(Constant.PATH_CONFFILE);
    private static MySQLConnector mySQLConnector;

    private String host;
    private String port;
    private String db;
    private String dbusername;
    private String dbpassword;
    private String date = applicationProperties.getValue(Constant.LBS_DATE);
    private String customer = applicationProperties.getValue(Constant.LBS_CUSTOMER);
    private String product = applicationProperties.getValue(Constant.LBS_PRODUCT);
    private String type = applicationProperties.getValue(Constant.LBS_TYPE);
    private String sample_size =applicationProperties.getValue(Constant.LBS_SAMPLE_SIZE);
    private String if_lot = applicationProperties.getValue(Constant.LBS_IF_LOT);
    private String lot_number = applicationProperties.getValue(Constant.LBS_LOT_NUMBER);
    private String sample_number = applicationProperties.getValue(Constant.LBS_SAMPLE_NUMBER);
    private String formulation = applicationProperties.getValue(Constant.LBS_FORMULATION);
    private String status = applicationProperties.getValue(Constant.LBS_STATUS);
    private String comment = applicationProperties.getValue(Constant.LBS_COMMENT);
    private String shipment_date =applicationProperties.getValue(Constant.LBS_SHIPMENT_DATE);
    private String documents = applicationProperties.getValue(Constant.LBS_DOCUMENTS);
    private String tableLabSampling = applicationProperties.getValue(Constant.DB_TABLE_LABSAMPLING);



    public LabrotarySampelingControl() {

        applicationProperties = ApplicationProperties.getInstance("config.properties");
        this.host = applicationProperties.getValue("db.host");
        this.port = applicationProperties.getValue("db.port");
        this.db = applicationProperties.getValue("db.name");
        this.dbusername = applicationProperties.getValue("db.username");
        this.dbpassword = applicationProperties.getValue("db.password");


        try {
            mySQLConnector = (MySQLConnector) MySQLConnector.getInstance(this.host, this.port, this.db, this.dbusername, this.dbpassword);
        } catch (ConnectorException var2) {
            var2.printStackTrace();
        }
    }

    public ResponseStatus addNewLabRecords(LabrotarySampeling labrotarySampeling){

        ResponseStatus responseStatus = new ResponseStatus();
        Map<String,String> map = new HashMap<String, String>();

        map.put("date",labrotarySampeling.getDate());
        map.put("customer",labrotarySampeling.getCustomer());
        map.put("product",labrotarySampeling.getProduct());
        map.put("type",labrotarySampeling.getType());
        map.put(sample_size,String.valueOf(labrotarySampeling.getSampleSize()));
        map.put("if_lot",labrotarySampeling.getIfLot());
        map.put("lot_number",labrotarySampeling.getLotNumber());
        map.put("sample_number",labrotarySampeling.getSampleNumber());
        map.put("formulation",labrotarySampeling.getFormulation());
        map.put("status",labrotarySampeling.getStatus());
        map.put("comment",labrotarySampeling.getComment());
        map.put("shipment_date",labrotarySampeling.getShipmentDate());
        map.put("documents",labrotarySampeling.getDocuments());

        try {
            boolean insert = mySQLConnector.insert(this.tableLabSampling, map);
            if (insert) {
                responseStatus.setSuccess(true);
                responseStatus.setMessage("Insert Successfully");
            } else {
                responseStatus.setSuccess(false);
                responseStatus.setMessage("failed");
            }
        }catch (ConnectorException var6) {
            responseStatus.setSuccess(true);
            responseStatus.setMessage("Cannot insert data, check mysql server is up and running, " + var6.getMessage());
        }
        return responseStatus;
    }

    public List<LabrotarySampeling> getLabSamplingData(){
        List<LabrotarySampeling> labMap = new ArrayList<LabrotarySampeling>();

        try {
            Record[] records = mySQLConnector.read(this.tableLabSampling);
            for (int i =0 ; i < records.length ; i++){
                LabrotarySampeling labrotarySampeling = new LabrotarySampeling();

                labrotarySampeling.setDate(records[i].getRecordAttributes().get("date"));
                labrotarySampeling.setCustomer(records[i].getRecordAttributes().get("customer"));
                labrotarySampeling.setProduct(records[i].getRecordAttributes().get("product"));
                labrotarySampeling.setType(records[i].getRecordAttributes().get("type"));
                String size = records[i].getRecordAttributes().get(sample_size);
                labrotarySampeling.setSampleSize(Integer.valueOf(records[i].getRecordAttributes().get(sample_size)));
                labrotarySampeling.setIfLot(records[i].getRecordAttributes().get("if_lot"));
                labrotarySampeling.setLotNumber(records[i].getRecordAttributes().get("lot_number"));
                labrotarySampeling.setSampleNumber(records[i].getRecordAttributes().get("sample_number"));
                labrotarySampeling.setFormulation(records[i].getRecordAttributes().get("formulation"));
                labrotarySampeling.setStatus(records[i].getRecordAttributes().get("status"));
                labrotarySampeling.setComment(records[i].getRecordAttributes().get("comment"));
                labrotarySampeling.setShipmentDate(records[i].getRecordAttributes().get("shipment_date"));
                labrotarySampeling.setDocuments(records[i].getRecordAttributes().get("documents"));

                labMap.add(labrotarySampeling);

            }
        }catch (ConnectorException var9){

        }
        return labMap;
    }

    public ResponseStatus updateLabSample(LabrotarySampeling labrotarySampeling) {
        ResponseStatus responseStatus = new ResponseStatus();
        Map<String,String> map = new HashMap<String, String>();
        if (labrotarySampeling.getStatus() != null){
            map.put("status",labrotarySampeling.getStatus());
        }
        if (labrotarySampeling.getComment() != null){
            map.put("comment",labrotarySampeling.getComment());
        }
        if (labrotarySampeling.getShipmentDate() !=null){
            map.put("shipment_date",labrotarySampeling.getShipmentDate());
        }

         map.put("lot_number",labrotarySampeling.getLotNumber());
        try {
            boolean insert = mySQLConnector.update(this.tableLabSampling,"lot_number",labrotarySampeling.getLotNumber(),map);
            if (insert){
                responseStatus.setSuccess(true);
                responseStatus.setMessage("Cannot update");
            }else {
                responseStatus.setSuccess(false);
                responseStatus.setMessage("Login failed due to password mismatch");
            }
        }catch (ConnectorException var6){
            responseStatus.setSuccess(true);
            responseStatus.setMessage("Cannot register user, check mysql server is up and running, " + var6.getMessage());
        }return responseStatus;
    }

    public LabrotarySampeling getMaxValue(){
        LabrotarySampeling labrotarySampeling = new LabrotarySampeling();
        String query = "select lot_number from lab_sampling order by id desc limit 0,1;";

        try {
            Record[] records = mySQLConnector.executeQuery(query,null);
            labrotarySampeling.setLotNumber(records[0].getRecordAttributes().get("lot_number"));
        }catch (ConnectorException var9){

        }
        return labrotarySampeling;
    }
}
