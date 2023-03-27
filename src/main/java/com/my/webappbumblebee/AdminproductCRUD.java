/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.webappbumblebee;


public class AdminproductCRUD {
    	protected int no;
    protected String product_id;
    protected String name;
    protected String quality;
    protected String price;

    public AdminproductCRUD() {}

    public AdminproductCRUD(String product_id, String name, String quality, String price) {
        super();
        this.product_id = product_id;
        this.name = name;
        this.quality = quality;
        this.price = price;
      
    }

    public AdminproductCRUD(int no, String product_id, String name, String quality, String price) {
        super();
        this.no = no;
        this.product_id = product_id;
        this.name =name;
        this.quality = quality;
        this.price = price;
    }
    

    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getProduct_id() {
        return product_id;
    }
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getQuality() {
        return quality;
    }
    public void setQuality(String quality) {
        this.quality = quality;
    }
    
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}


