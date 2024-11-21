Para el login y register, crear una base de datos de usuario (Numero de cedula, nombreCompleto, correo, numero de telefono, provincia, canton, y distrito)
y hacer la funcionalidad de que al momento de registrar un usuario verifique si el usuario ya existe verificando el correo, el numero de cedula, y el telefono y despues, 
lo ingrese en la base de datos, y asi mismo cuando se haga el login que se verifique que si el usuario esta en la base de datos verificando el correo numero de cedula y telefono, 
pues deja entrar de lo contrario no lo deja entrar

Para la MainActivity donde dice Bienvenido Fabian Jimenez, eso debe cambiarse el nombre segun el usuario que hizo login, por ejemplo si el usuario que hizo login se llama Jose, 
entonces ahi deberia aparecer Bienvenido Jose, asi con todos los usuarios

Para el ShopActivity crear otra actividad donde se va a reutilizar, el mismo activity para mostrar todas las categorias segun el id, si el id es 1 va a mostrar en productsActivity; 
todas las baterias, si el id es 2 va a mostrar todos los frenos en productsActivity y asi consecutivamente, para la base de datos de producto(id nombre descripcion, cantidadStock, imagen, precio), 
y despues en un formulario se va a mostrar toda la informacion de cada producto cuando le demos a cada producto, como nombre, la descripcion, el precio, la cantidad en stock y la imagen

Para profileActivity que en el cuadro rojo traiga todos los datos de la base de datos, del usuario que esta haciendo login, por ejemplo si fabian jimenez hizo el login, toda la informacion que ingreso 
ese usuario al momento de registrarse, deberia de mostrarse en el cuadro rojo, y Tambien que en el texto que aparece ahi, de editar la informacion que aparezca un formulario en el cual, en los espacios 
para modificar, se vean reflejados los datos originales del usuario, y que el usuario los pueda cambiar excepto el numero de cedula, y apenas le de aceptar al formulario deben actualizarse todos los datos 
nuevos en la base de datos, y debe actualizarse en el momento para que los cambios hechos se vean reflejados en el cuadro rojo, y cuando el usuario le de cerrar session  que se cierre la session de toda la 
aplicacion y deberia, volver a la actividad del login

En BranchesActivity No hay que hacer nada 

ContactActivity hay que hacer funcionar ese formulario el cual, cuando se rellene con los datos que solicta, obviamente para poder enviarlo todos los campos no deben de ser nulos, esto lo que va a hacer es enviar
la solicitud del usuario a un correo auxiliar, y automaticamente lo que va a hacer es segun el usuario que esta logueado, en el asunto del correo va a estar el nombre del usuario que esta enviando el correo

LanguageActvity hay que hacer la logica para que segun el idioma que escoja el usuario se cambie en toda la aplicacion sin excepcion, asi con todos los lenguajes que aparecen ahi, y que en todas las actividades
donde aparece el icono del lenguaje se pueda cambiar el idioma y sea funcional para toda la aplicacion.


Para la pantalla principal lo que viene siendo, la funcionalidad del taller todavia no se va a habilitar hasta que se tenga la mayoria de lo mencionado aca
