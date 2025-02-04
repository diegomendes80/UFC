package store.model.store.collection;

import store.model.Produto;

import java.util.List;

public interface ProductCollection {
     void addProduct(Produto product);
    Produto getProduct(String barcode);
    void removeProduct(String barcode);
    void updateProduct(String barcode, Produto newProduct);
    List<Produto> listProducts();
}
