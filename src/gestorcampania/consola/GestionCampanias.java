package gestorcampania.consola;

import java.time.DateTimeException;
import java.time.LocalDate;

import gestorcampania.Campania;
import gestorcampania.GestorCampania;
import gestorcampania.herramientas.Scan;
import gestorcampania.herramientas.excepciones.ScanException;

public class GestionCampanias
{
    Scan scan = new Scan();
    VistaConsola vista = new VistaConsola();

    public void crearCampania(GestorCampania gestor)
    {
        int tipo = 0;

        do
        {
            vista.vistaMenuTipoCampania();

            try
            {
                tipo = scan.Int("Tipo campaña: ");
            }
            catch(ScanException e)
            {
                tipo = -1;
            }

            switch(tipo)
            {
                case 0:
                    vista.msjVolver();
                    break;

                case 1:
                    crearCampaniaFija(gestor);
                    break;

                case 2:
                    crearCampaniaMovil(gestor);
                    break;

                default:
                    vista.msjSalir();
            }
        }
        while(tipo != 0);
    }

    private void crearCampaniaFija(GestorCampania gestor)
    {
        int id = 0;
        int opcion = 0;

        vista.vistaCrearCampania();

        try
        {
            id = scan.Int("Id: ");
        }
        catch(ScanException e)
        {
            vista.entradaInvalida();
        }

        String nombre = scan.Str("Nombre campaña: ");
        String ubicacion = scan.Str("Ubicacion: ");

        vista.vistaSeleccionarFecha();

        do
        {
            try
            {
                opcion = scan.Int("Opcion: ");
            }
            catch(ScanException e)
            {
                opcion = -1;
            }

            switch(opcion)
            {
                case 1:
                    gestor.crearCampaniaFija(id, nombre, ubicacion);    
                    break;

                case 2:
                    LocalDate fecha = solicitarFecha();
                    gestor.crearCampaniaFija(id, nombre, fecha, ubicacion);
                    break;

                default:
                    vista.entradaInvalida();
            }
        }
        while(opcion != 1 && opcion != 2);
    }

    private void crearCampaniaMovil(GestorCampania gestor)
    {
        int id = 0;
        int opcion = 0;

        vista.vistaCrearCampania();

        try
        {
            id = scan.Int("Id: ");
        }
        catch(ScanException e)
        {
            vista.entradaInvalida();
        }

        String nombre = scan.Str("Nombre campaña: ");
        String ubicacion = scan.Str("Ubicacion: ");

        vista.vistaSeleccionarFecha();

        do
        {
            try
            {
                opcion = scan.Int("Opcion: ");
            }
            catch(ScanException e)
            {
                opcion = -1;
            }

            switch(opcion)
            {
                case 1:
                    gestor.crearCampaniaMovil(id, nombre, ubicacion);    
                    break;

                case 2:
                    LocalDate fecha = solicitarFecha();
                    gestor.crearCampaniaMovil(id, nombre, fecha, ubicacion);
                    break;

                default:
                    vista.entradaInvalida();
            }
        }
        while(opcion != 1 && opcion != 2);
    }

    private LocalDate solicitarFecha()
    {
        while(true)
        {
            try
            {
                int dia = scan.Int("Dia: ");
                int mes = scan.Int("Mes: ");
                int anio = scan.Int("Año: ");

                LocalDate fecha = LocalDate.of(anio, mes, dia);

                return fecha;
            }
            catch(ScanException e)
            {
                vista.entradaInvalida();
            }
            catch(DateTimeException e)
            {
                vista.fechaInvalida();
            }
        }
    }

    public Campania buscarCampania(GestorCampania gestor)
    {
        int id = 0;
        Campania campania = null;

        vista.vistaBuscarCampania();

        while(true)
        {
            try
            {
                id = scan.Int("ID buscada: ");

                campania = gestor.buscarCampania(id);
                if(campania == null)
                {
                    vista.noCampaniaEncontrada(id);
                    return null;
                }

                return campania;
            }
            catch(ScanException e)
            {
                vista.entradaInvalida();
            }
        }
    }

    public void modificarCampania(GestorCampania gestor)
    {
        int opcion = 0;

        Campania campania = buscarCampania(gestor);
        if(campania == null)
            return;

        String nombre = scan.Str("Nombre campaña: ");
        String ubicacion = scan.Str("Ubicacion: ");

        vista.vistaSeleccionarFecha();

        do
        {
            try
            {
                opcion = scan.Int("Opcion: ");
            }
            catch(ScanException e)
            {
                opcion = -1;
            }

            switch(opcion)
            {
                case 1:
                    campania.modificarCampania(nombre, LocalDate.now(), ubicacion);  
                    break;

                case 2:
                    LocalDate fecha = solicitarFecha();
                    campania.modificarCampania(nombre, fecha, ubicacion);
                    break;

                default:
                    vista.entradaInvalida();
            }
        }
        while(opcion != 1 && opcion != 2);
    }

    public void eliminarCampania(GestorCampania gestor)
    {
        int id = 0;
        Campania campania = null;

        vista.vistaEliminarCampania();

        try
        {
            id = scan.Int("Id: ");
        }
        catch(ScanException e)
        {
            vista.entradaInvalida();
            id = -1;
        }

        if(id == -1)
        {
            vista.msjVolver();
            return;
        }

        campania = gestor.buscarCampania(id);
        if(campania == null)
            vista.noCampaniaEncontrada(id);
        
        else
            gestor.eliminarCampania(id);
    }

    public void listarCampanias(GestorCampania gestor)
    {
        vista.vistaListarCampania();

        vista.listarCampania(gestor);
    }
}
