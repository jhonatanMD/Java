package com.api.carrito.ws.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.api.carrito.ws.model.ClienteEntity;
import com.api.carrito.ws.service.IServiceCliente;
import com.api.carrito.ws.service.IServiceDetalleVenta;
import com.api.carrito.ws.service.IServiceProducto;
import com.api.carrito.ws.service.IServiceVenta;

@RunWith(MockitoJUnitRunner.class)
public class ControllerCarritoTest {
	
	@InjectMocks
	ControllerCarrito controller;
	
	@Mock
	IServiceCliente serviceCliente;
	
	@Mock
    IServiceProducto serviceProducto;
	
	@Mock
    IServiceDetalleVenta serviceDetalleVenta;
	
	@Mock
    IServiceVenta serviceVenta;
	
	@Mock
	ClienteEntity cliente;
	
	@Test
	public void InsertCliente() {
		
		when(serviceCliente.saveCliente(new ClienteEntity())).thenReturn(cliente);
		assertEquals(new ClienteEntity(), any());
	}

}
