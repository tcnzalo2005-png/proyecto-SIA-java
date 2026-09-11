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
                opcion = scan.Int();
                sangre = Sangre.values()[opcion - 1];
            }
            catch(ScanException e)
            {
                opcion = 0;
            }
        }
        while(opcion < 1 || 8 > opcion );

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
            donante.mostrar();

        return donante;
    }

    public void modificarDonante(Campania campania)
    {
        int cantidad = 0;
        int opcion = 0;
        Sangre sangre = null;

        vista.vistaModificarDonante();

        Donante donante = buscarDonante(campania);
        if(donante == null)
        {
            vista.noDonanteEncontrado();
            return;
        }

        String rut = scan.Str("Rut: ");
        String nombre = scan.Str("Nombre: ");

        vista.vistaTipoSangre();
        

        campania.modificarDonante(rut, nombre, sangre);
    }

    public void eliminarDonante(Campania campania)
    {
        vista.vistaEliminarDonante();

        String rut = scan.Str();

        if(campania.buscarDonante(rut) == null)
        {
            vista.noDonanteEncontrado();
            return;
        }

        campania.eliminarDonante(rut);
    }
}
