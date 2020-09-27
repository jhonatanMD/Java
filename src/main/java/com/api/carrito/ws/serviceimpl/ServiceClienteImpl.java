package com.api.carrito.ws.serviceimpl;

import com.api.carrito.ws.model.ClienteEntity;
import com.api.carrito.ws.repository.IRepositoryCliente;
import com.api.carrito.ws.service.IServiceCliente;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceClienteImpl implements IServiceCliente {


    static final Logger logCliente = Logger.getLogger("Cliente");
    
    @Autowired
    IRepositoryCliente Icliente;

    @Override
    public ClienteEntity saveCliente(ClienteEntity cliente) {

    	logCliente.info("Se guardo cliente" + cliente.toString());
        return Icliente.save(cliente);
    }

    @Override
    public List<ClienteEntity> findAllClientes() {

    	logCliente.info("Se listo clientes " + Icliente.findAll());
        return Icliente.findAll();
    }

	@Override
	public ClienteEntity findById(int id) {
		
		logCliente.info("Se filtro cliente por id: " + id);
		return Icliente.findAll()
				.stream().filter( x -> x.getId() == id)
				.collect(Collectors.toList()).get(0);
	}
}
