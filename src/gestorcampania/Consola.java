package gestorcampania;

import java.util.Scanner;
import java.time.LocalDate;

public class Consola
{
    private Scanner entrada = new Scanner(System.in);

    public void menu(GestorCampania gestor)
    {
        int opcion = 0;

        do
        {
            System.out.println
            (
                " ===== GESTOR CAMPAÑAS =====\n" +
                "1- Gestionar campañas\n" +
                "2- Gestionar donantes\n" +
                "3- Consultar\n" +
                "0- Salir"
            );

            System.out.print("Opcion: ");
            opcion = entrada.nextInt();

            switch(opcion)
            {
                case 0:
                    System.out.println("Saliendo...\n");
                    break;

                case 1:
                    menuCampanias(gestor);
                    break;

                case 2:
                    menuDonantes(gestor);
                    break;

                case 3:
                    menuConsultas(gestor);
                    break;

                default:
                    System.out.println("Entrada invalida\n");
            }
        }
        while(opcion != 0);

        entrada.close();
    }

    private void menuCampanias(GestorCampania gestor)
    {
        Campania campania = null;
        int id = 0;
        int opcion = 0;

        do
        {
            System.out.println
            (
                " ===== MENU CAMPAÑAS =====\n" +
                "1- Crear campaña\n" +
                "2- Listar campaña\n" +
                "3- Buscar campaña\n" +
                "4- Modificar campaña\n" +
                "5- Eliminar campaña\n" +
                "0- Volver"
            );

            System.out.print("Opcion: ");
            opcion = entrada.nextInt();

            switch(opcion)
            {
                case 0:
                    System.out.println("Volviendo...\n");
                    break;

                case 1:
                    int tipo;

                    do
                    {
                        System.out.println
                        (
                            " ===== TIPO CAMPAÑA =====\n" +
                            "1- Campaña fija\n" +
                            "2- Campaña movil\n" +
                            "0- Volver"
                        );

                        System.out.print("Opcion: ");
                        tipo = entrada.nextInt();

                        switch(tipo)
                        {
                            case 0:
                                System.out.println("Volviendo...\n");
                                break;

                            case 1:
                                crearCampaniaFija(gestor);
                                break;

                            case 2:
                                crearCampaniaMovil(gestor);
                                break;

                            default:
                                System.out.println("Entrada invalida\n");
                        }
                    }
                    while(tipo < 0 || tipo > 2);

                    break;
                
                case 2:
                    System.out.println(" ===== LISTA CAMPAÑAS =====");
                    System.out.println(gestor.mostrarCampania());
                    break;

                case 3:
                    System.out.println(" ===== BUSCAR CAMPAÑA =====");
                    System.out.print("ID campaña: ");
                    id = entrada.nextInt();

                    campania = gestor.buscarCampania(id);
                    if(campania == null)
                        System.out.println("No se encontro la campaña deseada\n");
                    
                    else
                        System.out.println(campania.mostrarCampania());

                    break;

                case 4:
                    modificarCampania(gestor);
                    break;

                case 5:
                    System.out.println(" ===== ELIMINAR CAMPAÑA =====");
                    System.out.println("Seleccione '-1' para cancelar");
                    System.out.print("ID campaña: ");
                    id = entrada.nextInt();

                    if(id == -1)
                    {
                        System.out.println("Volviendo...\n");
                        break;
                    }

                    campania = gestor.buscarCampania(id);
                    if(campania == null)
                        System.out.println("No se encontro la campaña deseada\n");

                    else
                        gestor.eliminarCampania(id);

                    break;

                default:
                    System.out.println("Entrada invalida");
            }
        }
        while(opcion != 0);
    }

    private void crearCampaniaFija(GestorCampania gestor)
    {
        int opcion = 0;

        System.out.println(" ===== CREAR CAMPAÑA FIJA =====");

        System.out.print("ID Campaña: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Nombre campaña: ");
        String nombre = entrada.nextLine();

        System.out.print("Ubicacion: ");
        String ubicacion = entrada.nextLine();

        System.out.println("¿Desea utilizar la fecha actual?");
        System.out.println("""
            1- Si
            2- No
            """);
        
        System.out.print("Opcion: ");
        opcion = entrada.nextInt();
        if(opcion == 1)
            gestor.crearCampaniaFija(id, nombre, ubicacion);

        else
        {
            System.out.println("Dia: ");
            int dia = entrada.nextInt();
            entrada.nextLine();

            System.out.println("Mes: ");
            int mes = entrada.nextInt();
            entrada.nextLine();

            System.out.println("Año: ");
            int anio = entrada.nextInt();
            entrada.nextLine();

            LocalDate fecha = LocalDate.of(anio, mes, dia);

            gestor.crearCampaniaFija(id, nombre, fecha, ubicacion);
        }
    }

    private void crearCampaniaMovil(GestorCampania gestor)
    {
        int opcion = 0;

        System.out.println(" ===== CREAR CAMPAÑA MOVIL =====");

        System.out.print("ID Campaña: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Nombre campaña: ");
        String nombre = entrada.nextLine();

        System.out.print("Ubicacion: ");
        String ubicacion = entrada.nextLine();

        System.out.println("¿Desea utilizar la fecha actual?");
        System.out.println("""
            1- Si
            2- No
            """);
        
        System.out.print("Opcion: ");
        opcion = entrada.nextInt();
        if(opcion == 1)
            gestor.crearCampaniaMovil(id, nombre, ubicacion);

        else
        {
            System.out.println("Dia: ");
            int dia = entrada.nextInt();
            entrada.nextLine();

            System.out.println("Mes: ");
            int mes = entrada.nextInt();
            entrada.nextLine();

            System.out.println("Año: ");
            int anio = entrada.nextInt();
            entrada.nextLine();

            LocalDate fecha = LocalDate.of(anio, mes, dia);

            gestor.crearCampaniaMovil(id, nombre, fecha, ubicacion);
        }
    }

    private void modificarCampania(GestorCampania gestor)
    {
        int opcion = 0;
        LocalDate fecha;

        System.out.println(" ===== MODIFICAR CAMPAÑA =====");

        System.out.print("ID Campaña: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        Campania campania = gestor.buscarCampania(id);

        if(campania == null)
        {
            System.out.println("No se encontro la campaña deseada\n");
            return;
        }

        System.out.println(" ===== NUEVOS DATOS =====");

        System.out.print("Nombre campaña: ");
        String nombre = entrada.nextLine();

        System.out.print("Ubicacion: ");
        String ubicacion = entrada.nextLine();

        System.out.println
        (
            "¿Desea utilizar la fecha actual?\n" +
            "1- Si\n" +
            "2- No"
        );
        
        System.out.print("Opcion: ");
        opcion = entrada.nextInt();
        if(opcion == 1)
            fecha = LocalDate.now();

        else
        {
            System.out.println("Dia: ");
            int dia = entrada.nextInt();
            entrada.nextLine();

            System.out.println("Mes: ");
            int mes = entrada.nextInt();
            entrada.nextLine();

            System.out.println("Año: ");
            int anio = entrada.nextInt();
            entrada.nextLine();

            fecha = LocalDate.of(anio, mes, dia);
        }

        campania.modificarCampania(nombre, fecha, ubicacion);
    }

    private void menuDonantes(GestorCampania gestor)
    {
        int id;
        int opcion;
        String rut;
        Campania campania = null;
        Donante donante = null;

        do
        {
            System.out.println(" ===== GESTOR DONANTES =====");
            System.out.print("Campaña seleccionada: ");
            if(campania == null)
                System.out.println("NINGUNA");

            else
                System.out.println(campania.getNombreCampania());

            System.out.println
            (
                "1- Seleccionar campaña\n" +
                "2- Crear donante\n" +
                "3- Listar donante\n" +
                "4- Buscar donante\n" +
                "5- Modificar donante\n" +
                "6- Eliminar donante\n" +
                "0- Volver"
            );

            System.out.print("Opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch(opcion)
            {
                case 0:
                    if(campania == null)
                        System.out.println("Volviendo...\n");
                    
                    else
                    {
                        campania = null;
                        opcion = -1;
                    }

                    break;

                case 1:
                    System.out.println(" ===== SELECCIONAR CAMPAÑA =====");
                    System.out.print("ID campaña: ");
                    id = entrada.nextInt();
                    entrada.nextLine();

                    campania = gestor.buscarCampania(id);
                    if(campania == null)
                        System.out.println("No se encontro la campaña deseada\n");

                    break;

                case 2:
                    if(campania == null)
                        System.out.println("Seleccione una campaña primero\n");

                    else
                        crearDonante(campania);

                    break;

                case 3:
                    if(campania == null)
                        listarTodosDonantes(gestor);

                    else
                        campania.mostrarDonante();

                    break;

                case 4:
                    if (campania == null)
                    {
                        System.out.println("Seleccione una campaña primero\n");
                    }
                    else
                    {
                        System.out.println(" ===== BUSCAR DONANTE =====");
                        System.out.print("Rut: ");
                        rut = entrada.nextLine();

                        donante = campania.buscarDonante(rut);
                        if(donante == null)
                            System.out.println("No se logro encontrar al donante");
                        else
                            donante.mostrar();
                    }

                    break;

                case 5:
                    

                default:
                    System.out.println("Entrada invalida\n");
            }
        }
        while(opcion != 0);
    }

    private void crearDonante(Campania campania)
    {

    }

    private void listarTodosDonantes(GestorCampania gestor)
    {

    }

    private void menuConsultas(GestorCampania gestor)
    {

    }
}