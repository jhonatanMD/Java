package com.api.carrito.ws.serviceimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.carrito.ws.model.ClienteEntity;
import com.api.carrito.ws.model.DetalleVentaEntity;
import com.api.carrito.ws.model.DtoDetalleVenta;
import com.api.carrito.ws.model.ProductoEntity;
import com.api.carrito.ws.model.VentaEntity;
import com.api.carrito.ws.repository.IRepositoryCliente;
import com.api.carrito.ws.repository.IRepositoryDetalleVenta;
import com.api.carrito.ws.repository.IRepositoryProducto;
import com.api.carrito.ws.repository.IRepositoryVenta;
import com.api.carrito.ws.service.IServiceDetalleVenta;

@Service
public class ServiceDetalleVentaImpl implements IServiceDetalleVenta {


    static final Logger logDetalleVenta = Logger.getLogger("Detalle");

    @Autowired
    IRepositoryProducto productos;

    @Autowired
    IRepositoryVenta ventas;

    @Autowired
    IRepositoryCliente clientes;

    @Autowired
    IRepositoryDetalleVenta detalleVentaRepository;


    public DtoDetalleVenta findDetalleVenta(int idVenta) {
    	
    	ClienteEntity cliente ;
    	ProductoEntity producto;
    	DetalleVentaEntity detalle;
    	
    	
    	VentaEntity venta = ventas.findById(idVenta).get();
    	cliente = clientes.findById(venta.getIdCliente()).get();
    	detalle = detalleVentaRepository.findByIdVenta(venta.getIdVenta()).get();
    	producto = productos.findById(detalle.getIdProducto()).get();
    	
     	
        DtoDetalleVenta dto = new DtoDetalleVenta();
        
        dto.setIdDetalleVenta(detalle.getIdDetalleVenta());
        dto.setIdVenta(idVenta);
        dto.setCliente(cliente.getNombre() + " " + cliente.getApellido());
        dto.setDni(cliente.getDni());
        dto.setEmail(cliente.getEmail());
        dto.setPrecioProducto(producto.getPrecio());
        dto.setFechaCompra(venta.getFecha());
        dto.setProducto(producto.getNombre());
        logDetalleVenta.info("Se muestra DTO " +dto.toString());
        return dto;
    }


	@Override
	public DetalleVentaEntity saveDetalleVeta(DetalleVentaEntity detalle) {
		
		logDetalleVenta.info("Se guarda Detalle de Venta " +detalle.toString());
		// TODO Auto-generated method stub
		return detalleVentaRepository.save(detalle);
	}
}
