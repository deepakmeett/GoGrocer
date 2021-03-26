
package com.example.gogrocer.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Get_Data_Model {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("varient_id")
        @Expose
        private Integer varientId;
        @SerializedName("product_id")
        @Expose
        private String  productId;
        @SerializedName("product_name")
        @Expose
        private String productName;
        @SerializedName("product_image")
        @Expose
        private String productImage;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("mrp")
        @Expose
        private Integer mrp;
        @SerializedName("varient_image")
        @Expose
        private String varientImage;
        @SerializedName("unit")
        @Expose
        private String unit;
        @SerializedName("quantity")
        @Expose
        private String  quantity;
        @SerializedName("count")
        @Expose
        private Integer count;

        public Integer getVarientId() {
            return varientId;
        }

        public void setVarientId(Integer varientId) {
            this.varientId = varientId;
        }

        public String  getProductId() {
            return productId;
        }

        public void setProductId(String  productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductImage() {
            return productImage;
        }

        public void setProductImage(String productImage) {
            this.productImage = productImage;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getMrp() {
            return mrp;
        }

        public void setMrp(Integer mrp) {
            this.mrp = mrp;
        }

        public String getVarientImage() {
            return varientImage;
        }

        public void setVarientImage(String varientImage) {
            this.varientImage = varientImage;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String  getQuantity() {
            return quantity;
        }

        public void setQuantity(String  quantity) {
            this.quantity = quantity;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

    }
}
