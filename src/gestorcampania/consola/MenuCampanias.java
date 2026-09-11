package gestorcampania.consola;

import gestorcampania.herramientas.Scan;
import gestorcampania.herramientas.excepciones.ScanException;

import gestorcampania.Campania;
import gestorcampania.GestorCampania;

public class MenuCampanias
{
    private Campania campania;

    private GestionCampanias ges = new GestionCampanias();
    private Scan scan = new Scan();
    private VistaConsola vista = new VistaConsola();

    public void menuCampanias(GestorCampania gestor)
    {
        int opcion = 0;

        do
        {
            vista.vistaMenuCampanias();

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
                case 0:
                    vista.msjSalir();
                    break;

                case 1:
                    ges.crearCampania(gestor);
                    break;

                case 2:
                    ges.listarCampanias(gestor);
                    break;

                case 3:
                    campania = ges.buscarCampania(gestor);
                    vista.mostrarCampania(campania.mostrarCampania());
                    break;

                case 4:
                    ges.modificarCampania(gestor);
                    break;

                case 5:
                    ges.eliminarCampania(gestor);
                    break;

                default:
                    vista.entradaInvalida();
            }
        }
        while(opcion != 0);
    }
}
