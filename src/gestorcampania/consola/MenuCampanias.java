package gestorcampania.consola;

import gestorcampania.herramientas.Scan;
import gestorcampania.herramientas.excepciones.ScanException;

import gestorcampania.Campania;
import gestorcampania.GestorCampania;

public class MenuCampanias
{
    // Campaña seleccionada para realizar operaciones sobre ella.
    private Campania campania;

    // Objeto encargado de gestionar las operaciones relacionadas con campañas.
    private GestionCampanias ges = new GestionCampanias();

    // Objeto encargado de gestionar la entrada de datos desde consola.
    private Scan scan = new Scan();

    // Objeto encargado de mostrar mensajes y vistas por consola.
    private VistaConsola vista = new VistaConsola();

    // Muestra el menú de campañas y ejecuta la opción seleccionada.
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
                // Finaliza el menú de campañas.
                case 0:
                    vista.msjSalir();
                    break;

                // Permite crear una nueva campaña.
                case 1:
                    ges.crearCampania(gestor);
                    break;

                // Muestra las campañas registradas.
                case 2:
                    ges.listarCampanias(gestor);
                    break;

                // Busca una campaña y muestra su información si existe.
                case 3:
                    campania = ges.buscarCampania(gestor);
                    if(campania != null)
                        vista.mostrarCampania(campania.mostrarCampania());
                    
                    break;

                // Permite modificar una campaña existente.
                case 4:
                    ges.modificarCampania(gestor);
                    break;

                // Permite eliminar una campaña existente.
                case 5:
                    ges.eliminarCampania(gestor);
                    break;

                // Informa que la opción ingresada no es válida.
                default:
                    vista.entradaInvalida();
            }
        }
        while(opcion != 0);
    }
}