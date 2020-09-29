package com.api.carrito.ws.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.carrito.ws.model.ClienteEntity;
import com.api.carrito.ws.model.DetalleVentaEntity;
import com.api.carrito.ws.model.DtoDetalleVenta;
import com.api.carrito.ws.model.ProductoEntity;
import com.api.carrito.ws.model.VentaEntity;
import com.api.carrito.ws.service.IServiceCliente;
import com.api.carrito.ws.service.IServiceDetalleVenta;
import com.api.carrito.ws.service.IServiceProducto;
import com.api.carrito.ws.service.IServiceVenta;
import com.api.carrito.ws.util.ErrorHandler;
import com.api.carrito.ws.util.ErrorHandlerNotFound;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("/api")
public class ControllerCarrito {

    final static Logger logger = Logger.getLogger(ControllerCarrito.class);
    
      

    final  private IServiceCliente serviceCliente;
    final  private IServiceProducto serviceProducto;
    final private IServiceDetalleVenta serviceDetalleVenta;
    final private IServiceVenta serviceVenta;

    public ControllerCarrito(IServiceCliente serviceCliente,IServiceProducto serviceProducto,IServiceDetalleVenta serviceDetalleVenta,IServiceVenta serviceVenta){
        this.serviceProducto = serviceProducto;
        this.serviceCliente = serviceCliente;
        this.serviceDetalleVenta = serviceDetalleVenta;
        this.serviceVenta=serviceVenta;
    }


    /* Cliente */
    @PostMapping("/saveCliente")
    public ClienteEntity saveCliente(@RequestBody ClienteEntity cliente) throws ErrorHandler{

    	
        return serviceCliente.saveCliente(cliente);
    }
    
   

    @GetMapping("/findAllCliente")
    public List<ClienteEntity> find() throws ErrorHandler{
        return serviceCliente.findAllClientes();
    }


    @GetMapping("/findByCliente/{id}")
    public ClienteEntity findById(@PathVariable("id") int id ) throws ErrorHandler{
        return serviceCliente.findById(id);
    }

    /* Producto */
    @PostMapping("/saveProducto")
    public ProductoEntity saveProducto(@RequestBody ProductoEntity producto) throws ErrorHandler {

        return serviceProducto.saveProducto(producto);
    }

    @GetMapping("/findAllProducto")
    public List<ProductoEntity> findAllProductos() throws ErrorHandler {

        return serviceProducto.findAllProdcutos();
    }

    @PostMapping("/updProducto/{idProd}")
    public ProductoEntity saveProducto(@PathVariable("idProd") int idProd ,@RequestBody ProductoEntity producto) throws ErrorHandler{
        producto.setIdProducto(idProd);
        return serviceProducto.updProducto(producto);
    }

    @PostMapping("/dltProducto/{idProd}")
    public void saveProducto(@PathVariable("idProd") int idProd ) throws ErrorHandler{
         serviceProducto.deleteProducto(idProd);
    }

    /* Detalle de Venta */

    
    @PostMapping("/saveVenta")
    public VentaEntity saveVenta (@RequestBody VentaEntity venta)  throws ErrorHandler{
    	
    	venta.setFecha(new Date());
    	
    	return serviceVenta.saveVenta(venta);
    }
    
    @GetMapping("/findAllVenta")
    public List<VentaEntity> findAllVenta () throws ErrorHandler{
    	
    	return serviceVenta.findAll();
    }
    
    @GetMapping("/getDetalleVenta/{idVenta}")     
    public DtoDetalleVenta getDetalleVenta(@PathVariable("idVenta") int idVenta) throws ErrorHandler{

        return  serviceDetalleVenta.findDetalleVenta(idVenta);
    }

    @PostMapping("/saveDetalleVenta")
    public DetalleVentaEntity saveDetalleVetan(@RequestBody DetalleVentaEntity detalle ) throws ErrorHandler{
         return serviceDetalleVenta.saveDetalleVeta(detalle);
    }

}
