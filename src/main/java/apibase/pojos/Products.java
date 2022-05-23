package apibase.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Products {
    private int qty;
    private String sku;

    public Products() {
    }

    public Products(int qty, String sku) {
        this.qty = qty;
        this.sku = sku;
    }


    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }


}
