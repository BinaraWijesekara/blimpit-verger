package org.blimpit.external.verger.inventory.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Products {
    private String name;
    private String product_id;

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
}
