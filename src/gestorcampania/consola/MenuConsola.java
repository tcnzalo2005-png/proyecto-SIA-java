package gestorcampania.consola;

import gestorcampania.GestorCampania;
import gestorcampania.herramientas.Scan;
import gestorcampania.herramientas.excepciones.ScanException;

public class MenuConsola
{
    // Objeto encargado de gestionar la entrada de datos desde consola.
    private Scan scan = new Scan();

    // Objeto encargado de mostrar mensajes y vistas por consola.
    private VistaConsola vista = new VistaConsola();

    // Menú encargado de gestionar las operaciones relacionadas con campañas.
    private MenuCampanias menuCamp = new MenuCampanias();

    // Menú encargado de gestionar las operaciones relacionadas con donantes.
    private MenuDonantes menuDon = new MenuDonantes();

    // Menú encargado de gestionar las consultas disponibles.
    private MenuConsultas menuCon = new MenuConsultas();

    // Muestra el menú principal y ejecuta la opción seleccionada.
    public void menu(GestorCampania gestor)
    {
        int opcion = 0;

        do
        {
            vista.vistaMenu();

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
                // Finaliza la ejecución del menú principal.
                case 0:
                    vista.msjSalir();
                    break;

                // Accede al menú de gestión de campañas.
                case 1:
                    menuCamp.menuCampanias(gestor);
                    break;

                // Accede al menú de gestión de donantes.
                case 2:
                    menuDon.menuDonantes(gestor);
                    break;

                // Accede al menú de consultas.
                case 3:
                    menuCon.menuConsultas(gestor);
                    break;

                // Informa que la opción ingresada no es válida.
                default:
                    vista.entradaInvalida();
            }
        }
        while(opcion != 0);
    }
}