# Catálogo de Software

## 📚 Descripción

¡Bienvenido al proyecto **Catálogo de Software**! Esta es una aplicación Java diseñada para gestionar un catálogo de productos de software de manera eficiente y amigable. Con una interfaz interactiva, el usuario puede añadir, modificar, eliminar y listar software con facilidad.

## 🚀 Funcionalidades

### 🎮 Menú Interactivo

La aplicación presenta un menú que permite al usuario realizar diversas acciones:

1. **➕ Añadir Software**
   - Agrega un nuevo producto al catálogo con información detallada: ID, nombre, tipo de IA, lenguaje, uso principal y precio.

2. **✏️ Modificar Software**
   - Modifica los detalles de un software existente proporcionando su ID y los nuevos atributos.

3. **❌ Eliminar Software**
   - Elimina un software del catálogo usando su ID.

4. **📋 Listar Software**
   - Muestra todos los productos en el catálogo. Si no hay software, informa al usuario.

5. **🚪 Salir**
   - Opción para cerrar la aplicación, asegurando que todos los cambios se guarden automáticamente.

### ⚙️ Manejo de Errores

La aplicación está diseñada para manejar entradas no válidas, asegurando que el usuario siempre reciba mensajes claros y precisos. Se verifican condiciones como:
- IDs no válidos (menor o igual a 0)
- IDs duplicados al añadir software
- Entradas de tipo incorrecto, utilizando excepciones para prevenir errores.

## 💻 Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

- **interfaz**: Contiene la clase `Menu` para la interacción con el usuario.
- **dominio**: Incluye las clases `Catalogo` y `Software`, esenciales para la gestión del catálogo.
- **controlador**: (Opcional) Para futuras mejoras y lógica adicional.

## 📊 Diagrama UML

A continuación se presenta el diagrama UML del proyecto, que ilustra la estructura y las relaciones entre las clases:

![Diagrama UML](https://github.com/Mgonzalo11/Programacion-I/blob/main/Primer%20Semestre/Practica_Final/DiagramaUML.png)

## 📦 Requisitos

- **Java JDK**: Asegúrate de tener instalado Java Development Kit para ejecutar la aplicación.
- **IDE**: Se recomienda usar un entorno de desarrollo como IntelliJ IDEA o Eclipse para facilitar el desarrollo.

## 📈 Contribuciones

¡Las contribuciones son bienvenidas! Si tienes ideas o mejoras, no dudes en abrir un *issue* o enviar un *pull request*.

## 📞 Contacto

Para preguntas o más información, contacta conmigo miguelgonzalovazquez04@gmail.com

## 🔗 Licencia

Este proyecto está licenciado bajo la Apache License 2.0.
Para más detalles, consulta el archivo `LICENSE`.

---

¡Disfruta gestionando tu catálogo de software!
