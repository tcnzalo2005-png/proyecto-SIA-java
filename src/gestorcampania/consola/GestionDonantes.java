package gestorcampania.consola;

import gestorcampania.Donante;
import gestorcampania.Campania;
import gestorcampania.GestorCampania;
import gestorcampania.Sangre;
import gestorcampania.herramientas.Scan;
import gestorcampania.herramientas.excepciones.ScanException;

public class GestionDonantes
{
    Scan scan = new Scan();
    VistaConsola vista = new VistaConsola();
    GestionCampanias gesCamp = new GestionCampanias();

    public Campania seleccionarCampania(GestorCampania gestor)
    {
        Campania campania = gesCamp.buscarCampania(gestor);

        return campania;
    }

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

        campania.crearDonante(rut, nombre, sangre);
    }

    public Donante buscarDonante(Campania campania)
    {
        Donante donante = null;

        vista.vistaBuscarDonante();

        String rut = scan.Str("Rut: ");

        donante = campania.buscarDonante(rut);
        if(donante == null)
            vista.noDonanteEncontrado();

        else
            vista.mostrarBuscarDonante(donante.mostrar());

        return donante;
    }

    public void modificarDonante(Campania campania)
    {
        int opcion = 0;
        Sangre sangre = null;

        vista.vistaModificarDonante();

        Donante donante = buscarDonante(campania);
        if(donante == null)
        {
            vista.noDonanteEncontrado();
            return;
        }

        String rut = scan.Str("Nuevo Rut: ");
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
        }
        while(opcion < 1 || 8 < opcion);
        
        campania.modificarDonante(rut, nombre, sangre);
    }

    public void eliminarDonante(Campania campania)
    {
        vista.vistaEliminarDonante();

        String rut = scan.Str("Ingrese Rut: ");

        if(campania.buscarDonante(rut) == null)
        {
            vista.noDonanteEncontrado();
            return;
        }

        campania.eliminarDonante(rut);
    }

    public void listarDonantes(Campania campania)
    {
        System.out.println(campania.mostrarDonante());
    }

    public void donarSangre(Campania campania)
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

        if(donacion <= 0)
            vista.msjDonacionInvalida();

        else
            donante.donar(donacion);
    }
}
