package com.api.carrito.ws.service;

import com.api.carrito.ws.model.ClienteEntity;

import java.util.List;


public interface IServiceCliente {

    public ClienteEntity saveCliente (ClienteEntity cliente);
    public List<ClienteEntity> findAllClientes ();
    
    public ClienteEntity findById(int id); 	
    
    
}
