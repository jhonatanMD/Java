# JavaBackEndSoaInt
Prueba de desarrollo para back end Carrito de compras


*Lombok : tener el plugin instalado para getter y setter*


# Debe registrar en esta secuencia 


1.Cliente


2 Productos


3.Ventas


4.Detalle de Venta


# Resumen de funcionalidad e implementación 

* Hay un archivo sql que carga los datos para el uso


* Existe un DTO para la consulta general


* Se genero una documentacion en swagger pero el token impide el pase por web , consumirlo por postman


* Los usuarios y contraseña se encuentra en el properties


* cambiar ruta de los archivos log para consumirlo localmente

# Ruta Base  /api

* /saveCliente (guardar cliente)
* /findAllCliente (listar todos los clientes)
* /findByCliente/{id} (filtrar cliente por id)
* /saveProducto (guardar producto)
* findAllProducto (listar todos los productos)
* /updProducto/{idProd} (actualizar producto)
* /dltProducto/{idProd} (eliminar producto)
* /saveVenta (guardar venta)
* /findAllVenta (buscar ventas)
* /getDetalleVenta/{idVenta} (filtrar detalle de venta)
* /saveDetalleVenta (guardar detalle de venta)



