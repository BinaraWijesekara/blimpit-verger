package org.blimpit.external.verger.inventory.utils;

public interface Constant {

    String PATH_CONFFILE = "config.properties";

    /**
     * File Store Path
     */
    String LOCAL_FILE_PATH = "save.file.path.local";
    String SERVER_FILE_PATH = "save.file.path.server";

    /**
     *DB TABLES
     */

    String DB_TABLE_USER = "db.verger.users";
    String DB_TABLE_FEATURES  ="db.verger.features";
    String DB_TABLE_FEATURESMAPPER = "db.verger.featuresmapper";
    String DB_TABLE_LABSAMPLING = "db.lab.sampling";

    /**
     * DB TABLES ATTRIBUTES
     */

    String USER_USERNAME = "db.column.username";
    String USER_NAME = "db.column.name";
    String USER_PASSWORD = "db.column.password";
    String USER_DESIGNATION = "db.column.designation";
    String USER_STATUS = "db.column.status";
    String USER_DEPARTMENT = "db.column.department";
    String FEATURES_ID = "db.column.fid" ;
    String FEATURES_USER_ID = "db.column.uid";

    String LBS_DATE ="db.lbs.column.date";
    String LBS_CUSTOMER = "db.lbs.column.customer";
    String LBS_PRODUCT = "db.lbs.column.product";
    String LBS_TYPE = "db.lbs.column.type";
    String LBS_SAMPLE_SIZE = "db.lbs.column.samplesSize";
    String LBS_IF_LOT = "db.lbs.column.ifLot";
    String LBS_LOT_NUMBER = "db.lbs.column.lotNumber";
    String LBS_SAMPLE_NUMBER = "db.lbs.column.sampleNumber";
    String LBS_FORMULATION = "db.lbs.column.formulation";
    String LBS_STATUS = "db.lbs.column.status";
    String LBS_COMMENT = "db.lbs.column.comment";
    String LBS_SHIPMENT_DATE = "db.lbs.column.shipmentDate";
    String LBS_DOCUMENTS = "db.lbs.column.documents";



}
