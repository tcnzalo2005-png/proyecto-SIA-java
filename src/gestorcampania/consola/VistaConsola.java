package gestorcampania.consola;

import gestorcampania.Campania;
import gestorcampania.GestorCampania;
import gestorcampania.Sangre;

public class VistaConsola
{
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
            "3- Listar donante\n" +
            "4- Buscar donante\n" +
            "5- Modificar donante\n" +
            "6- Eliminar donante\n" +
            "0- Volver\n"
        );
    }

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

    public void vistaCrearCampania()
    {
        System.out.println(" ===== CREAR CAMPAÑA =====");
    }

    public void vistaListarCampania()
    {
        System.out.println(" ===== LISTAR CAMPAÑAS =====");
    }

    public void vistaBuscarCampania()
    {
        System.out.println(" ===== BUSCAR CAMPAÑA =====");
    }

    public void vistaSeleccionarFecha()
    {
        System.out.println
        (
            " = ¿Usar fecha actual? =\n" +
            "1- Si\n" +
            "2- No\n"
        );
    }
    
    public void vistaEliminarCampania()
    {
        System.out.println
        (
            " ===== ELIMINAR CAMPAÑA =====\n" +
            "Seleccione -1 para cancelar\n"
        );
    }

    public void vistaModificarCampania()
    {
        System.out.println(" ===== MODIFICAR CAMPAÑA =====");
    }

    public void vistaModificarDonante()
    {
        System.out.println(" ===== MODIFICAR DONANTE =====");
    }

    public void vistaEliminarDonante()
    {
        System.out.println(" ===== ELIMINAR DONANTE =====");
    }

    public void vistaTotalSangreDonada()
    {
        System.out.print
        (
            " = TOTAL SANGRE DONADA =\n" +
            "Total sangre: "
        );
    }

    public void vistaTotalDonadores()
    {
        System.out.print
        (
            " = TOTAL DONADORES =\n " +
            "Total donadores: "
        );
    }

    public void vistaSangrePorTipo()
    {
        System.out.println(" ===== SANGRE POR TIPO =====");
    }

    public void msjTotalDonado()
    {
        System.out.println("Total donado: ");
    }

    public void msjSalir()
    {
        System.out.println("Saliendo...\n");
    }

    public void msjVolver()
    {
        System.out.println("Volviendo...\n");
    }

    public void entradaInvalida()
    {
        System.out.println("Entrada invalida");
    }

    public void fechaInvalida()
    {
        System.out.println("Fecha invalida");
    }

    public void noCampaniaSeleccionada()
    {
        System.out.println("Seleccione una campaña");
    }

    public void noCampaniaEncontrada(int id)
    {
        System.out.println("No se logro encontrar la campaña: " + id);
    }

    public void noDonanteEncontrado()
    {
        System.out.println("No se logro encontrar al donante deseado");
    }

    public void mostrarCampania(String datos)
    {
        System.out.println(datos);
    }

    public void vistaCrearDonante()
    {
        System.out.println(" ===== CREAR DONANTE =====");
    }

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

    public void vistaBuscarDonante()
    {
        System.out.println(" ===== BUSCAR DONANTE =====");
    }

    public void listarCampania(GestorCampania gestor)
    {
        System.out.println(gestor.mostrarCampania());
    }

    public void listarDonante(String donantes)
    {
        System.out.println(donantes);
    }

    public void mostarSangrePorTipo(GestorCampania gestor, Sangre tipo)
    {
        System.out.println
        (
            gestor.totalSangreDonadaPorTipo(tipo)
        );
    }

    public void mostarTotalDonadoes(GestorCampania gestor)
    {
        System.out.println
        (
            gestor.totalDonadores()
        );
    }

    public void mostrarTotalSangreDonada(GestorCampania gestor)
    {
        System.out.println
        (
            gestor.totalSangreDonada()
        );
    }
}
