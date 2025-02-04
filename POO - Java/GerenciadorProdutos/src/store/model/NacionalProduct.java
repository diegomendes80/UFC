package store.model;

import store.model.story.model.ProductCategory;

public class NacionalProduct extends Produto{

    public NacionalProduct(String barcode, String nome, double price, ProductCategory category,String expirationDate) {
        super(barcode, nome, price, category, expirationDate);
    }

    @Override
    public double calcFinalPrice() {
        return this.getPrice() + (this.getPrice() * 0.1);
    }

    @Override
    public String toString(){
        return "Produto: " + this.getName() + "\n"
                +"Categoria: " + this.getCategory()
                + "Barcode: " + this.getBarcode()
                +"Data de validade: " + this.getExpirationDate()
                + "Preço: " + this.getPrice()
                +"Valor total: " + this.calcFinalPrice();
    }
}
