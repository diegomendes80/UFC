package store.model;

import store.model.story.model.ProductCategory;

public class ImportedProduct  extends Produto{
    private String country;
    private double shippingCost;

    public ImportedProduct(String barcode, String nome, double price, String country, double shippingCost, ProductCategory category, String expirationDate) {
        super(barcode, nome, price, category, expirationDate);
        this.country = country;
        this.shippingCost = shippingCost;
    }

    @Override
    public double calcFinalPrice() {
        double fullPrice = this.getPrice() + shippingCost;
        return fullPrice + (fullPrice * 0.2); //20% de imposto -make the L

    }

    public String getCountry() {
        return country;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    @Override
    public String toString(){
        return "Produto: " + this.getName() + "\n"
                +"Categoria: " + this.getCategory()
                + "Barcode: " + this.getBarcode()
                +"Data de validade: " + this.getExpirationDate()
                + "Preço: " + this.getPrice()
                + "País de origem: " + this.getCountry()
                + "Valor frete: " + this.getShippingCost()
                +"Valor total: " + this.calcFinalPrice();
    }
}
