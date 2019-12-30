# PRUEBA TÉCNICA TBK

Este proyecto consta de una implementación de una API rest en base a SpringBoot y una base de datos MySql.

Para efectos compatibilidad de la prueba y no depender de herramientas extras esta API vive dentro de
 contenedrores Docker.
 
> ** Por ende es necesario tener instalado [Docker](https://www.docker.com/).

Para levantar el proyecto se debe ocupar docker-compose que orquestará dos imágenes que se construiran en el instante.
```
docker-compose up 
```
> ** Hay que tener en consideración que se debe tener los puertos 8080 y 3306 libres dadoq que están expuestos estos
> desde
 los contenedores.


La construcción se hace de forma interna, no tiene dependencias. Se ocupa una imagen con Maven para construir el
 artefacto del proyecto y luego se instala en otra nueva imágen para ejecurarlo. Y desde ahí se expone el puerto 8080.
 
> Para probar los endpoint usar Ej: localhost:8080/api/ventas


La API cuenta con tres endpoint:

1. POST /auth/login
2. GET /api/ventas
3. POST /api/ventas

##POST Login
Este endpoint recibe dos valores por body:

```
 {
 	"user": "maliaga",
 	"password": "12345"
 }
 ```
 y devuelnve el password encriptado.
 
```
$2a$10$fHuK3SwqohBDUXIXg2zqYeKY9q0BcQtTbLtkfvxCyRp/dx4Oy1zPq
```
Además válida si el usuario está en la base de datos.
 
> ** Usar para la prueba: "maliaga"

##GET Ventas
Este endpoint devuelve todas las ventas que están almacendas en el base de datos.
 ```
[
    {
    "id": 1,
    "nombre": "Primera Venta",
    "detalle": "Detalle 1",
    "createAt": "2017-08-28"
    },
    {
    "id": 2,
    "nombre": "Segunda Venta",
    "detalle": "Detalle 2",
    "createAt": "2017-08-28"
    },
    {
    "id": 3,
    "nombre": "Otra venta de test",
    "detalle": "Detake de la venta",
    "createAt": "2019-12-29"
    }
]
 ```
##POST Ventas
En este endpoint recibe un objeto json para ser guardado en la base de datos.
 ```
{
	"nombre": "Otra venta de test",
	"detalle": "Detalle de la venta"
}
 ```

##Para eliminar los contenedores
 ```
 docker-compose down
 ```