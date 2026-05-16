# Hexagon Arch - Módulo de Arquitectura Hexagonal

## Descripción General

Este módulo es una implementación del patrón **Arquitectura Hexagonal** (también conocida como **Ports & Adapters** o **Onion Architecture**) utilizando Java 23. El módulo demuestra cómo separar la lógica de negocio del mundo exterior mediante puertos e adaptadores.

## ¿Qué es la Arquitectura Hexagonal?

La Arquitectura Hexagonal fue propuesta por **Alistair Cockburn** como una forma de crear sistemas débilmente acoplados. La idea central es que **el centro de la aplicación es la lógica de negocio**, y todo lo demás (bases de datos, interfaces de usuario, APIs externas) se conecta a través de "puertos" y "adaptadores".

```
                    ┌─────────────────────────────┐
                    │      ADAPTADORES DE          │
                    │         ENTRADA              │
                    │   (Input Adapters)           │
                    │  CLI, REST, gRPC, etc.       │
                    └──────────────┬──────────────┘
                                   │
                    ┌──────────────▼──────────────┐
                    │      PUERTOS DE ENTRADA     │
                    │      (Input Ports)          │
                    │    Interfaces de Casos      │
                    │        de Uso               │
                    └──────────────┬──────────────┘
                                   │
                    ┌──────────────▼──────────────┐
                    │          DOMINIO            │
                    │    (Core Business Logic)    │
                    │   Entities, Value Objects,   │
                    │   Domain Services           │
                    └──────────────┬──────────────┘
                                   │
                    ┌──────────────▼──────────────┐
                    │      PUERTOS DE SALIDA      │
                    │     (Output Ports)          │
                    │    Interfaces para         │
                    │    Infraestructura           │
                    └──────────────┬──────────────┘
                                   │
                    ┌──────────────▼──────────────┐
                    │     ADAPTADORES DE          │
                    │        SALIDA               │
                    │   (Output Adapters)         │
                    │   DB, File, External APIs   │
                    └─────────────────────────────┘
```

## Estructura del Proyecto

```
hexagon-arch/
├── src/main/java/com/ceva/hexagon/ch01/
│   ├── domain/                    # ⭐ Capa Interior - No depende de nadie
│   │   ├── Router.java            # Entidad
│   │   ├── RouterId.java          # Value Object
│   │   └── RouterType.java        # Enum (Value Object)
│   │
│   ├── application/               # ⭐ Capa de Casos de Uso
│   │   ├── ports/
│   │   │   ├── input/             # Contratos de entrada ( Driven )
│   │   │   │   └── RouterViewInputPort.java
│   │   │   └── output/            # Contratos de salida ( Driving )
│   │   │       └── RouterViewOutputPort.java
│   │   └── usecases/
│   │       └── RouterViewUseCase.java  # Interfaz del caso de uso
│   │
│   └── framework/                 # ⭐ Capa Exterior - Implementaciones
│       ├── input/
│       │   └── stdin/
│       │       └── RouterViewCLIAdapter.java   # Adapter de entrada
│       └── output/
│           └── file/
│               └── RouterViewFileAdapter.java  # Adapter de salida
│
└── pom.xml
```

## Capas de la Arquitectura

### 1. Domain (Núcleo)

Esta es la capa **más importante** y **no depende de nada**. Contiene:

- **Entidades**: Objetos con identidad propia
- **Value Objects**: Objetos inmutables sin identidad
- **Servicios de Dominio**: Lógica de negocio pura

En este módulo:

| Clase | Tipo | Descripción |
|-------|------|-------------|
| `Router` | Entidad | Representa un router de red con tipo e ID. Contiene lógica de filtrado y búsqueda. |
| `RouterId` | Value Object | Identificador único del router con factory method `of()`. |
| `RouterType` | Enum | Define los tipos de router: `EDGE` y `CORE`. |

**Principio clave**: El dominio NO conoce nada sobre la aplicación, los casos de uso ni los adaptadores.

```java
// El dominio solo conoce conceptos del negocio
public class Router {
    private final RouterType routerType;
    private final RouterId routerId;

    // Lógica de negocio pura - sin dependencias externas
    public static Predicate<Router> filterRouterByType(RouterType routerType) {...}
}
```

### 2. Application (Casos de Uso)

Esta capa **orquesta el flujo** entre el dominio y los adaptadores. Define **qué puede hacer el sistema** sin conocer el cómo.

#### Puertos (Interfaces)

| Puerto | Tipo | Descripción |
|--------|------|-------------|
| `RouterViewInputPort` | Input (Driven) | Define las operaciones que el mundo exterior puede solicitar |
| `RouterViewOutputPort` | Output (Driving) | Define las operaciones que el dominio necesita para obtener datos |

```java
// Puerto de entrada - contrato para ejecutar casos de uso
public interface RouterViewUseCase {
    List<Router> getRouters(Predicate<Router> filter);
}

// Puerto de salida - contrato para obtener datos del exterior
public interface RouterViewOutputPort {
    List<Router> fetchRouters();
}
```

#### Implementación del Puerto de Entrada

```java
// El InputPort implementa el UseCase
public class RouterViewInputPort implements RouterViewUseCase {
    private RouterViewOutputPort routerListOutputPort;

    public RouterViewInputPort(RouterViewOutputPort routerListOutputPort){
        this.routerListOutputPort = routerListOutputPort; // Inyección por constructor
    }

    @Override
    public List<Router> getRouters(Predicate<Router> filter) {
        var routers = routerListOutputPort.fetchRouters(); // Obtiene datos vía output port
        return Router.retrieveRouter(routers, filter);      // Delega al dominio
    }
}
```

### 3. Framework (Adaptadores)

Esta capa contiene las **implementaciones concretas** de los puertos. Es la que conecta el hexágono con el mundo exterior.

#### Adaptadores de Entrada (Input Adapters)

Reciben solicitudes del exterior y las traducen a llamadas a los puertos de entrada.

```java
// Adapter CLI - obtiene datos del standard input
public class RouterViewCLIAdapter {

    private RouterViewUseCase routerViewUseCase;

    public RouterViewCLIAdapter(){
        // Wiring: conectamos los adaptadores
        this.routerViewUseCase = new RouterViewInputPort(RouterViewFileAdapter.getInstance());
    }

    public List<Router> obtainRelatedRouters(String type){
        return routerViewUseCase.getRouters(Router.filterRouterByType(RouterType.valueOf(type)));
    }
}
```

#### Adaptadores de Salida (Output Adapters)

Implementan los puertos de salida para comunicarse con sistemas externos (DB, archivos, APIs).

```java
// Adapter de archivo - implementa el output port leyéndolo de routers.txt
public class RouterViewFileAdapter implements RouterViewOutputPort {

    private static RouterViewFileAdapter instance;

    private RouterViewFileAdapter(){} // Singleton

    @Override
    public List<Router> fetchRouters() {
        // Lee el archivo routers.txt del classpath
        return readFileAsString();
    }
}
```

## Flujo de Datos

```
Usuario ejecuta CLI
        │
        ▼
┌───────────────────────┐
│  RouterViewCLIAdapter │  ← Input Adapter (framework/input/stdin)
└───────────┬───────────┘
            │ llama
            ▼
┌───────────────────────────┐
│   RouterViewInputPort     │  ← Input Port (application/ports/input)
│   (implementa UseCase)    │
└───────────┬───────────────┘
            │ delega
            ▼
┌───────────────────────────┐
│      Router               │  ← Dominio (domain)
│  (lógica de negocio)      │
└───────────┬───────────────┘
            │ necesita datos
            ▼
┌───────────────────────────┐
│  RouterViewOutputPort     │  ← Output Port (application/ports/output)
└───────────┬───────────────┘
            │ implementado por
            ▼
┌───────────────────────────┐
│ RouterViewFileAdapter     │  ← Output Adapter (framework/output/file)
│  (lee routers.txt)        │
└───────────────────────────┘
```

## Principios Clave

### 1. Dependencias Apuntan Hacia el Centro

```
Framework → Application → Domain
     │              │
     └──────────────┘
         ← Dependencias
```

- **Domain** no tiene dependencias externas
- **Application** solo depende de **Domain**
- **Framework** es la capa más externa y nadie depende de ella (ella depende de las interfaces)

### 2. Inversión de Dependencias

Las interfaces (puertos) están en la capa **Application**, NO en **Framework**. Esto permite que el dominio y la aplicación no conozcan las implementaciones concretas.

### 3. Intercambiabilidad

Puedes cambiar el adapter de salida de archivo a base de datos sin modificar ninguna otra clase:

```java
// Solo cambiamos el adapter de salida
this.routerViewUseCase = new RouterViewInputPort(
    new RouterViewDatabaseAdapter()  // Solo cambiar aquí
);
```

## Construcción y Ejecución

### Compilar

```bash
cd ~/local-repos/projects/java/javasamples/hexagon-arch
mvn clean compile
```

### Ejecutar Tests

```bash
mvn test
```

### Empaquetar

```bash
mvn package
```

## Extensiones Posibles

1. **Nuevo Adaptador de Entrada**: Crear un REST controller
   - `framework/input/rest/RouterViewRestAdapter.java`
   - Implementar `RouterViewInputPort`

2. **Nuevo Adaptador de Salida**: Conectar a una base de datos
   - `framework/output/jpa/RouterViewJpaAdapter.java`
   - Implementar `RouterViewOutputPort`

3. **Nuevos Casos de Uso**:
   - Agregar router
   - Actualizar router
   - Eliminar router

## Recursos

- [Hexagonal Architecture - Alistair Cockburn](https://alistair.cockburn.us/hexagonal-architecture/)
- [Ports and Adapters Pattern](https://blog.oceanhouse.tech/2022/11/06/ports-and-adapters-architecture/)
- [Clean Architecture - Uncle Bob](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)