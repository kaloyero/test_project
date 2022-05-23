package apibase.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Entities {
    private int id;
    private String ref;
    private double total;
    private String type;
    private String reason;
    private String carrier;
    private apibase.pojos.Products products;
    private apibase.pojos.Paging paging;
    private int external_id;
    private String tracking_number;
    private String customer_full_name;
    private String created_at;
    private String updated_at;
    public Entities(int id, String ref, double total, String type, String reason, String carrier, apibase.pojos.Products products) {
        this.id = id;
        this.ref = ref;
        this.total = total;
        this.type = type;
        this.reason = reason;
        this.carrier = carrier;
        this.products = products;
    }
    public Entities() {
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public apibase.pojos.Products getProducts() {
        return products;
    }

    public void setProducts(apibase.pojos.Products products) {
        this.products = products;
    }

    public apibase.pojos.Paging getPaging() {
        return paging;
    }

    public void setPaging(apibase.pojos.Paging paging) {
        this.paging = paging;
    }

    public int getExternal_id() {
        return external_id;
    }

    public void setExternal_id(int external_id) {
        this.external_id = external_id;
    }

    public String getTracking_number() {
        return tracking_number;
    }

    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }

    public String getCustomer_full_name() {
        return customer_full_name;
    }

    public void setCustomer_full_name(String customer_full_name) {
        this.customer_full_name = customer_full_name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }


}
