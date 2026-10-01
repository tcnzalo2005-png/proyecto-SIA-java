package gestorcampania.consola;

import java.time.DateTimeException;
import java.time.LocalDate;

import gestorcampania.Campania;
import gestorcampania.GestorCampania;
import gestorcampania.herramientas.Scan;
import gestorcampania.herramientas.excepciones.ScanException;

public class GestionCampanias
{
    // Objeto encargado de gestionar la entrada de datos desde consola.
    private Scan scan = new Scan();

    // Objeto encargado de mostrar mensajes y vistas por consola.
    private VistaConsola vista = new VistaConsola();

    // Permite seleccionar el tipo de campaña que se desea crear.
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
                // Permite volver al menú anterior.
                case 0:
                    vista.msjVolver();
                    break;

                // Inicia el proceso de creación de una campaña fija.
                case 1:
                    crearCampaniaFija(gestor);
                    break;

                // Inicia el proceso de creación de una campaña móvil.
                case 2:
                    crearCampaniaMovil(gestor);
                    break;

                // Muestra un mensaje cuando la opción ingresada no es válida.
                default:
                    vista.msjSalir();
            }
        }
        while(tipo != 0);
    }

    // Solicita los datos necesarios para crear una campaña fija.
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
                // Crea la campaña utilizando la fecha actual.
                case 1:
                    gestor.crearCampaniaFija(id, nombre, ubicacion);    
                    break;

                // Solicita una fecha específica para la campaña.
                case 2:
                    LocalDate fecha = solicitarFecha();
                    gestor.crearCampaniaFija(id, nombre, fecha, ubicacion);
                    break;

                // Informa que la opción ingresada no es válida.
                default:
                    vista.entradaInvalida();
            }
        }
        while(opcion != 1 && opcion != 2);
    }

    // Solicita los datos necesarios para crear una campaña móvil.
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
                // Crea la campaña utilizando la fecha actual.
                case 1:
                    gestor.crearCampaniaMovil(id, nombre, ubicacion);    
                    break;

                // Solicita una fecha específica para la campaña.
                case 2:
                    LocalDate fecha = solicitarFecha();
                    gestor.crearCampaniaMovil(id, nombre, fecha, ubicacion);
                    break;

                // Informa que la opción ingresada no es válida.
                default:
                    vista.entradaInvalida();
            }
        }
        while(opcion != 1 && opcion != 2);
    }

    // Solicita al usuario una fecha y la convierte en un objeto LocalDate.
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
            // Maneja errores producidos al ingresar datos que no pueden convertirse a números.
            catch(ScanException e)
            {
                vista.entradaInvalida();
            }
            // Maneja fechas que no existen o que están fuera del rango permitido por LocalDate.
            catch(DateTimeException e)
            {
                vista.fechaInvalida();
            }
        }
    }

    // Busca una campaña mediante su identificador y la devuelve si existe.
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
            // Permite volver a solicitar el identificador cuando la entrada no es válida.
            catch(ScanException e)
            {
                vista.entradaInvalida();
            }
        }
    }

    // Busca una campaña existente y solicita los nuevos datos para modificarla.
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
                // Modifica la campaña utilizando la fecha actual.
                case 1:
                    campania.modificarCampania(nombre, LocalDate.now(), ubicacion);  
                    break;

                // Modifica la campaña utilizando una fecha ingresada por el usuario.
                case 2:
                    LocalDate fecha = solicitarFecha();
                    campania.modificarCampania(nombre, fecha, ubicacion);
                    break;

                // Informa que la opción ingresada no es válida.
                default:
                    vista.entradaInvalida();
            }
        }
        while(opcion != 1 && opcion != 2);
    }

    // Busca una campaña mediante su identificador y la elimina si existe.
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

        // Finaliza la operación si la entrada no fue válida.
        if(id == -1)
        {
            vista.msjVolver();
            return;
        }

        campania = gestor.buscarCampania(id);
        if(campania == null)
            vista.noCampaniaEncontrada(id);
        
        // Elimina la campaña encontrada.
        else
            gestor.eliminarCampania(id);
    }

    // Muestra en consola la información de las campañas registradas.
    public void listarCampanias(GestorCampania gestor)
    {
        vista.vistaListarCampania();

        vista.listarCampania(gestor);
    }
}