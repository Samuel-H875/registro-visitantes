# Registro de Visitantes

API REST desarrollada con Spring Boot para demostrar el uso de atributos y métodos de instancia, miembros `static`, beans singleton y pruebas unitarias.

## Tecnologías utilizadas

- Java
- Spring Boot
- Maven
- JUnit 5

## Requisitos

- Java 21 o superior
- Proyecto descargado o clonado localmente

## Ejecutar la aplicación

Ubícate en la carpeta raíz del proyecto, donde está el archivo `pom.xml`, y ejecuta:

```powershell
.\mvnw.cmd spring-boot:run
```

La aplicación iniciará en:

```text
http://localhost:8080
```

## Endpoints

### Registrar un visitante

Crea un visitante y lo guarda en la lista administrada por el servicio.

```text
POST /api/visitantes
```

Ejemplo:

```powershell
curl.exe -X POST "http://localhost:8080/api/visitantes?nombre=ana%20maria%20perez&edad=25"
```

Respuesta esperada:

```json
{
  "id": 1,
  "nombre": "Ana Maria Perez",
  "edad": 25
}
```

### Listar visitantes

Retorna los visitantes registrados en el servicio.

```text
GET /api/visitantes
```

Ejemplo:

```powershell
curl.exe "http://localhost:8080/api/visitantes"
```

### Consultar conteos

Compara la cantidad de visitantes guardados en el servicio con la cantidad total de objetos `Visitante` creados.

```text
GET /api/visitantes/conteos
```

Ejemplo:

```powershell
curl.exe "http://localhost:8080/api/visitantes/conteos"
```

Respuesta esperada después de registrar tres visitantes:

```json
{
  "registradosEnElServicio": 3,
  "creadosEnLaClase": 3,
  "edadMinima": 18
}
```

### Normalizar un nombre

Usa el método estático `TextoUtil.normalizarNombre`.

```text
GET /api/visitantes/normalizar
```

Ejemplo:

```powershell
curl.exe "http://localhost:8080/api/visitantes/normalizar?texto=pedro%20jose%20DIAZ"
```

Respuesta esperada:

```json
{
  "normalizado": "Pedro Jose Diaz"
}
```

### Crear visitante fantasma

Crea un objeto `Visitante`, pero no lo guarda en la lista del servicio.

```text
POST /api/visitantes/fantasma
```

Ejemplo:

```powershell
curl.exe -X POST "http://localhost:8080/api/visitantes/fantasma"
```

Este endpoint demuestra que el contador `static` aumenta porque se crea un objeto, aunque la cantidad de visitantes registrados no aumenta porque dicho objeto no se agregó a la lista del servicio.

## Pruebas unitarias

Para ejecutar las pruebas:

```powershell
.\mvnw.cmd test
```

Resultado esperado:

```text
Tests run: 2, Failures: 0, Errors: 0
BUILD SUCCESS
```
