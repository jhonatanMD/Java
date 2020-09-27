package com.api.carrito.ws.service;

import com.api.carrito.ws.model.ProductoEntity;

import java.util.List;

public interface IServiceProducto {

    public ProductoEntity saveProducto(ProductoEntity producto);
    public List<ProductoEntity> findAllProdcutos();
    public ProductoEntity updProducto(ProductoEntity producto);
    public void deleteProducto(int id);

}
