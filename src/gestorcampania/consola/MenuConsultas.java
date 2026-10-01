package gestorcampania.consola;

import gestorcampania.GestorCampania;
import gestorcampania.herramientas.Scan;
import gestorcampania.herramientas.excepciones.ScanException;

public class MenuConsultas
{
    // Objeto encargado de gestionar las operaciones relacionadas con las consultas.
    private GestionConsultas ges = new GestionConsultas();

    // Objeto encargado de gestionar la entrada de datos desde consola.
    private Scan scan = new Scan();

    // Objeto encargado de mostrar mensajes y vistas por consola.
    private VistaConsola vista = new VistaConsola();

    // Muestra el menú de consultas y ejecuta la opción seleccionada.
    public void menuConsultas(GestorCampania gestor)
    {
        int opcion = 0;

        do
        {
            vista.vistaMenuConsultas();

            try
            {
                opcion = scan.Int();
            }
            catch(ScanException e)
            {
                opcion = -1;
            }

            switch(opcion)
            {
                // Vuelve al menú anterior.
                case 0:
                    vista.msjVolver();
                    break;

                // Muestra el total de sangre donada.
                case 1:
                    ges.totalSangreDonada(gestor);
                    break;

                // Muestra el total de donadores registrados.
                case 2:
                    ges.totalDonadores(gestor);
                    break;

                // Permite consultar la cantidad de sangre donada según su tipo.
                case 3:
                    ges.sangrePorTipo(gestor);
                    break;
                
                // Informa que la opción ingresada no es válida.
                default:
                    vista.entradaInvalida();
            }
        }
        while(opcion != 0);
    }
}