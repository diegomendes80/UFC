package store.model.store.collection;

import store.model.Produto;

import java.util.List;

public class ProductList implements ProductCollection{
    List<Produto> products;

    @Override
    public void addProduct(Produto product) {
        products.add(product);
    }

    @Override
    public Produto getProduct(String barcode) {
        for(int i=0; i < products.size(); i++){
            if(products.get(i).getBarcode() == barcode){
                return products.get(i);
            }
        }
    }

    @Override
    public void removeProduct(String barcode) {
        for(int i=0; i < products.size(); i++){
            if(products.get(i).getBarcode() == barcode){
                products.remove(products.get(i));
            }
        }
    }

    @Override
    public void updateProduct(String barcode, Produto newProduct) {
        for(int i=0; i < products.size(); i++){
            if(products.get(i).getBarcode() == barcode){
                products.remove(products.get(i));
                products.add(newProduct);

            }
        }
    }

    @Override
    public List<Produto> listProducts() {
        for(int i=0; i < products.size(); i++){
            products.get(i).toString();
        }
    }
}
