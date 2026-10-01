package gestorcampania.consola;

import gestorcampania.Donante;
import gestorcampania.Campania;
import gestorcampania.GestorCampania;
import gestorcampania.Sangre;
import gestorcampania.herramientas.Scan;
import gestorcampania.herramientas.excepciones.DonarException;
import gestorcampania.herramientas.excepciones.ScanException;

public class GestionDonantes
{
    // Objeto encargado de gestionar la entrada de datos desde consola.
    private Scan scan = new Scan();

    // Objeto encargado de mostrar mensajes y vistas por consola.
    private VistaConsola vista = new VistaConsola();

    // Objeto encargado de gestionar las operaciones relacionadas con campañas.
    private GestionCampanias gesCamp = new GestionCampanias();

    // Permite seleccionar una campaña mediante su identificador.
    public Campania seleccionarCampania(GestorCampania gestor)
    {
        Campania campania = gesCamp.buscarCampania(gestor);

        return campania;
    }

    // Solicita los datos necesarios para registrar un nuevo donante en una campaña.
    public void crearDonante(Campania campania)
    {
        int opcion = 0;
        Sangre sangre = null;

        vista.vistaCrearDonante();

        String rut = scan.Str("Rut: ");
        String nombre = scan.Str("Nombre: ");

        vista.vistaTipoSangre();
        do
        {
            try
            {
                opcion = scan.Int("Opcion: ");
                sangre = Sangre.values()[opcion - 1];
            }
            catch(ScanException e)
            {
                opcion = 0;
            }
        }
        while(opcion < 1 || 8 < opcion );

        // Registra el donante utilizando los datos ingresados.
        campania.crearDonante(rut, nombre, sangre);
    }

    // Busca un donante mediante su RUT y muestra sus datos.
    public Donante buscarDonante(Campania campania)
    {
        Donante donante = null;

        vista.vistaBuscarDonante();

        String rut = scan.Str("Rut: ");
        
        try{
            donante = campania.buscarDonante(rut);
            vista.mostrarBuscarDonante(donante.mostrar());
            
        }catch(DonarException e){
            System.out.println(e.getMessage());
            
        }

        return donante;
    }

    // Busca un donante existente y solicita los nuevos datos para modificarlo.
    public void modificarDonante(Campania campania)
    {
        int opcion = 0;
        Sangre sangre = null;

        vista.vistaModificarDonante();

        String rut = scan.Str("Rut: ");
        Donante donante = null;
        try{
            donante = campania.buscarDonante(rut);
        }catch(DonarException e){
            System.out.println(e.getMessage());
            return;
        }


        String nombre = scan.Str("Nuevo Nombre: ");

        vista.vistaTipoSangre();
        do
        {
            try
            {
                opcion = scan.Int("Opcion: ");
                sangre = Sangre.values()[opcion - 1];
            }
            catch(ScanException e)
            {
                opcion = 0;
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Escoga una opcion valida");
            }
        }
        while(opcion < 1 || 8 < opcion);
        
        // Actualiza los datos del donante seleccionado.
        campania.modificarDonante(donante.getRut(), nombre, sangre);
    }

    // Busca un donante mediante su RUT y lo elimina de la campaña.
    public void eliminarDonante(Campania campania)
    {
        vista.vistaEliminarDonante();

        String rut = scan.Str("Ingrese Rut: ");

        try{
            campania.buscarDonante(rut);
        }catch(DonarException e){
            System.out.println(e.getMessage());
        }

        campania.eliminarDonante(rut);
    }

    // Muestra todos los donantes registrados en la campaña.
    public void listarDonantes(Campania campania)
    {
        System.out.println(campania.mostrarDonante());
    }

    // Solicita la cantidad de sangre donada y registra la donación del donante.
    public void donarSangre(Campania campania) throws DonarException
    {
        int donacion = 0;
        vista.vistaDonarSangre();

        String rut = scan.Str("Rut: ");

        Donante donante = campania.buscarDonante(rut);
        if(donante == null)
        {
            vista.noDonanteEncontrado();
            return;
        }

        try
        {
            donacion = scan.Int("Cantidad donada: ");
        }
        catch(ScanException e)
        {
            vista.entradaInvalida();
        }

       
        // Registra la cantidad de sangre donada por el donante.
        donante.donar(donacion);
    }
}