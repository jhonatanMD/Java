package com.api.carrito.ws.serviceimpl;

import com.api.carrito.ws.model.VentaEntity;
import com.api.carrito.ws.repository.IRepositoryVenta;
import com.api.carrito.ws.service.IServiceVenta;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceVentaImpl implements IServiceVenta {

	
	 static final Logger logVenta = Logger.getLogger("Venta");
	 
    @Autowired
    IRepositoryVenta Iventa;

    @Override
    public VentaEntity saveVenta(VentaEntity venta) {
    	
    	logVenta.info("Se guardo Venta "+ venta.toString());
    	
        return Iventa.save(venta);
    }

    @Override
    public List<VentaEntity> findAll() {
    	logVenta.info("Lista de ventas "+ Iventa.findAll());
        return Iventa.findAll();
    }
}
