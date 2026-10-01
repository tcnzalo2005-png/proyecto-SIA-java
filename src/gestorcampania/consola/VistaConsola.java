package gestorcampania.consola;

import gestorcampania.Campania;
import gestorcampania.GestorCampania;
import gestorcampania.Sangre;

public class VistaConsola
{
    // Muestra el menú principal del sistema.
    public void vistaMenu()
    {
        System.out.println
        (
            " ===== GESTOR CAMPAÑAS =====\n" +
            "1- Gestionar campañas\n" +
            "2- Gestionar donantes\n" +
            "3- Consultar\n" +
            "0- Salir\n"
        );
    }

    // Muestra las opciones disponibles para gestionar campañas.
    public void vistaMenuCampanias()
    {
        System.out.println
        (
            " ===== MENU CAMPAÑAS =====\n" +
            "1- Crear campaña\n" +
            "2- Listar campaña\n" +
            "3- Buscar campaña\n" +
            "4- Modificar campaña\n" +
            "5- Eliminar campaña\n" +
            "0- Volver\n"
        );
    }

    // Muestra las opciones disponibles para gestionar donantes.
    // También indica la campaña actualmente seleccionada.
    public void vistaMenuDonantes(Campania campania)
    {
        System.out.println(" ===== MENU DONANTES =====");

        if(campania != null)
            System.out.println("Campaña: " + campania.getNombreCampania());
        else
            System.out.println("NO SE HA SELECCIONADO UNA CAMPAÑA");

        System.out.println
        (
            "1- Seleccionar campaña\n" +
            "2- Crear donante\n" +
            "3- Donar sangre\n" +
            "4- Listar donante\n" +
            "5- Buscar donante\n" +
            "6- Modificar donante\n" +
            "7- Eliminar donante\n" +
            "0- Volver\n"
        );
    }

    // Muestra las opciones disponibles para realizar consultas.
    public void vistaMenuConsultas()
    {
        System.out.println
        (
            " ===== MENU CONSULTAS =====\n" +
            "1- Total sangre donada\n" +
            "2- Total de donadores\n" +
            "3- Total de sangre donada por tipo\n" +
            "0- Volver\n" 
        );
    }

    // Muestra las opciones disponibles para seleccionar el tipo de campaña.
    public void vistaMenuTipoCampania()
    {
        System.out.println
        (
            " ===== TIPO CAMPAÑA =====\n" +
            "1- Campaña fija\n" +
            "2- Campaña movil\n" +
            "0- Volver\n"
        );
    }

    // Muestra el encabezado de la creación de una campaña.
    public void vistaCrearCampania()
    {
        System.out.println(" ===== CREAR CAMPAÑA =====");
    }

    // Muestra el encabezado del listado de campañas.
    public void vistaListarCampania()
    {
        System.out.println(" ===== LISTAR CAMPAÑAS =====");
    }

    // Muestra el encabezado de la búsqueda de una campaña.
    public void vistaBuscarCampania()
    {
        System.out.println(" ===== BUSCAR CAMPAÑA =====");
    }

    // Muestra las opciones para seleccionar si se utilizará la fecha actual.
    public void vistaSeleccionarFecha()
    {
        System.out.println
        (
            " = ¿Usar fecha actual? =\n" +
            "1- Si\n" +
            "2- No\n"
        );
    }
    
    // Muestra el encabezado y la opción para cancelar la eliminación de una campaña.
    public void vistaEliminarCampania()
    {
        System.out.println
        (
            " ===== ELIMINAR CAMPAÑA =====\n" +
            "Seleccione -1 para cancelar\n"
        );
    }

    // Muestra el encabezado de la modificación de una campaña.
    public void vistaModificarCampania()
    {
        System.out.println(" ===== MODIFICAR CAMPAÑA =====");
    }

    // Muestra el encabezado de la modificación de un donante.
    public void vistaModificarDonante()
    {
        System.out.println(" ===== MODIFICAR DONANTE =====");
    }

    // Muestra el encabezado de la eliminación de un donante.
    public void vistaEliminarDonante()
    {
        System.out.println(" ===== ELIMINAR DONANTE =====");
    }

    // Muestra el encabezado y etiqueta del total de sangre donada.
    public void vistaTotalSangreDonada()
    {
        System.out.print
        (
            " = TOTAL SANGRE DONADA =\n" +
            "Total sangre: "
        );
    }

    // Muestra el encabezado y etiqueta del total de donadores.
    public void vistaTotalDonadores()
    {
        System.out.print
        (
            " = TOTAL DONADORES =\n " +
            "Total donadores: "
        );
    }

    // Muestra el encabezado de la consulta de sangre por tipo.
    public void vistaSangrePorTipo()
    {
        System.out.println(" ===== SANGRE POR TIPO =====");
    }

    // Muestra el mensaje previo al resultado del total donado.
    public void msjTotalDonado()
    {
        System.out.println("Total donado: ");
    }

    // Muestra el mensaje de salida del sistema.
    public void msjSalir()
    {
        System.out.println("Saliendo...\n");
    }

    // Muestra el mensaje de retorno al menú anterior.
    public void msjVolver()
    {
        System.out.println("Volviendo...\n");
    }

    // Muestra un mensaje indicando que la entrada ingresada no es válida.
    public void entradaInvalida()
    {
        System.out.println("Entrada invalida");
    }

    // Muestra un mensaje indicando que la fecha ingresada no es válida.
    public void fechaInvalida()
    {
        System.out.println("Fecha invalida");
    }

    // Muestra un mensaje cuando no existe una campaña seleccionada.
    public void noCampaniaSeleccionada()
    {
        System.out.println("Seleccione una campaña");
    }

    // Muestra un mensaje indicando que no se encontró una campaña con el identificador indicado.
    public void noCampaniaEncontrada(int id)
    {
        System.out.println("No se logro encontrar la campaña: " + id);
    }

    // Muestra un mensaje indicando que no se encontró el donante buscado.
    public void noDonanteEncontrado()
    {
        System.out.println("No se logro encontrar al donante deseado");
    }

    // Muestra los datos de una campaña.
    public void mostrarCampania(String datos)
    {
        System.out.println(datos);
    }

    // Muestra el encabezado de la creación de un donante.
    public void vistaCrearDonante()
    {
        System.out.println(" ===== CREAR DONANTE =====");
    }

    // Muestra los tipos de sangre disponibles para seleccionar.
    public void vistaTipoSangre()
    {
        System.out.println(" = TIPOS DE SANGRE =");

        int i = 1;

        for(Sangre sangre : Sangre.values())
        {
            System.out.println(i + "- " + sangre);

            i++;
        }
    }

    // Muestra el encabezado de la búsqueda de un donante.
    public void vistaBuscarDonante()
    {
        System.out.println(" ===== BUSCAR DONANTE =====");
    }

    // Muestra la información de las campañas registradas.
    public void listarCampania(GestorCampania gestor)
    {
        System.out.println(gestor.mostrarCampania());
    }

    // Muestra la información de los donantes recibida como parámetro.
    public void listarDonante(String donantes)
    {
        System.out.println(donantes);
    }

    // Muestra el total de sangre donada correspondiente a un tipo de sangre.
    public void mostarSangrePorTipo(GestorCampania gestor, Sangre tipo)
    {
        System.out.println
        (
            gestor.totalSangreDonadaPorTipo(tipo)
        );
    }

    // Muestra el total de donadores registrados.
    public void mostarTotalDonadoes(GestorCampania gestor)
    {
        System.out.println
        (
            gestor.totalDonadores()
        );
    }

    // Muestra el total de sangre donada.
    public void mostrarTotalSangreDonada(GestorCampania gestor)
    {
        System.out.println
        (
            gestor.totalSangreDonada()
        );
    }

    // Muestra el resultado de la búsqueda de un donante.
    public void mostrarBuscarDonante(String msg)
    {
        System.out.println(msg);
    }

    // Muestra el encabezado del registro de una donación.
    public void vistaDonarSangre()
    {
        System.out.println(" ===== DONAR SANGRE =====");
    }

    // Muestra un mensaje indicando que la donación ingresada no es válida.
    public void msjDonacionInvalida()
    {
        System.out.println("Donacion invalida");
    }
}