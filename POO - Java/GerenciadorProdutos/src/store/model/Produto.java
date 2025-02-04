package store.model;

import store.model.story.model.ProductCategory;

public abstract class Produto {
    private String barcode;
    private String name;
    private double price;
    private ProductCategory Category;
    private String expirationDate;

    public Produto(String barcode, String nome, double price, ProductCategory category, String expirationDate) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.Category = category;
        this.expirationDate = expirationDate;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return Category;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public abstract double calcFinalPrice();

}
