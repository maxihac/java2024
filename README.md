# java2024
Proyecto Java2024

Se recomienda verificar la implementacion  codigo usando Swagger
http://localhost:8080/swagger-ui/index.html#/
En todos los endpoint que tengan id como parametro como
borrar, modificar o buscar por id. Se valida previamente que el id sea valido. En caso de no ser valido los indica el mismo Swagger.
Nota: en el endpoint de agregar venta, a pesar que el swagger nos muestra un ejemplo,lo ideal es colocar lo siguiente en el cuerpo del Json
Endpoint para agregar ventas
POST
http://localhost:8080/ventas/agregar

{
"tipofactura": "B",
"factura": 12346,
"fecha": "2024-09-04",
"total": 5000,
"cliente": {
"idcliente": 1
},
"ventaProductos": [
{
"cantidad": 5,
"producto": {
"idProducto": 1
}
},
{
"cantidad": 3,
"producto": {
"idProducto": 2
}
}
]
}
Y verificar desde la base, que la tabla intermedia VentaProducto se carga correctamente.
Tambien se valido que el endpoint de borrar ventas elimina los registros de la tabla intermedia venta_Producto
Por falta de tiempo se coloca el total en forma manual, lo ideal hubiese sido que sea read.only con una funcion que lo calcule a partir de la suma de todos los  productos,
 de cada venta como  resultado del precio de la tabla producto * la cantidad colocado en venta.
Tambien me hubiese gustado validar que la cantidad en la venta no pueda superar el valor del stock en la tabla producto.
 
