package org.blimpit.external.verger.inventory.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class QC_PlatForm {
    private String name;
    private String product_id;
    private String supplier_id;
    private String type;
    private String details;
    private String or_ri;
    private String gc_1;
    private String gc_2;
    private String status;
    private String comment;
    private String usedfor;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getOr_ri() {
        return or_ri;
    }

    public void setOr_ri(String or_ri) {
        this.or_ri = or_ri;
    }

    public String getGc_1() {
        return gc_1;
    }

    public void setGc_1(String gc_1) {
        this.gc_1 = gc_1;
    }

    public String getGc_2() {
        return gc_2;
    }

    public void setGc_2(String gc_2) {
        this.gc_2 = gc_2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsedfor() {
        return usedfor;
    }

    public void setUsedfor(String usedfor) {
        this.usedfor = usedfor;
    }
}
