package com.api.carrito.ws.service;

import com.api.carrito.ws.model.DetalleVentaEntity;
import com.api.carrito.ws.model.DtoDetalleVenta;

public interface IServiceDetalleVenta {

    public DtoDetalleVenta findDetalleVenta(int idVenta);
    
    public DetalleVentaEntity saveDetalleVeta(DetalleVentaEntity detalle);

}
