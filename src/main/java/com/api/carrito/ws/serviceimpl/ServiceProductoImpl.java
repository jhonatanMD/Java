package com.api.carrito.ws.serviceimpl;

import com.api.carrito.ws.model.ProductoEntity;
import com.api.carrito.ws.repository.IRepositoryProducto;
import com.api.carrito.ws.service.IServiceProducto;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProductoImpl implements IServiceProducto {
	
	static final Logger logProducto = Logger.getLogger("Producto");

    @Autowired
    IRepositoryProducto Iproducto;

    @Override
    public ProductoEntity saveProducto(ProductoEntity producto) {
    	
    	logProducto.info("se guardo producto "+ producto.toString());
        return Iproducto.save(producto);
    }

    @Override
    public List<ProductoEntity> findAllProdcutos() {
    	
    	logProducto.info("se lista productos "+ Iproducto.findAll());
        return Iproducto.findAll();
    }

    @Override
    public ProductoEntity updProducto(ProductoEntity producto) {
    	logProducto.info("se actualizo producto "+ producto.toString());
        return Iproducto.save(producto);
    }

    @Override
    public void deleteProducto(int id) {

    	logProducto.info("se elimino producto con id : "+ id);
        Iproducto.deleteById(id);
    }
}
