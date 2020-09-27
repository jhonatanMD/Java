package com.api.carrito.ws.service;

import com.api.carrito.ws.model.VentaEntity;

import java.util.List;

public interface IServiceVenta {

    public VentaEntity saveVenta(VentaEntity venta);

    public List<VentaEntity> findAll();

}
