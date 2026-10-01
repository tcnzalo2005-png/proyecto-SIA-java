package gestorcampania.consola;

import gestorcampania.Campania;
import gestorcampania.GestorCampania;
import gestorcampania.herramientas.Scan;
import gestorcampania.herramientas.excepciones.DonarException;
import gestorcampania.herramientas.excepciones.ScanException;

public class MenuDonantes
{
    // Objeto encargado de gestionar las operaciones relacionadas con donantes.
    private GestionDonantes ges = new GestionDonantes();

    // Objeto encargado de gestionar la entrada de datos desde consola.
    private Scan scan = new Scan();

    // Objeto encargado de mostrar mensajes y vistas por consola.
    private VistaConsola vista = new VistaConsola();

    // Campaña actualmente seleccionada para realizar operaciones con donantes.
    Campania campania = null;

    // Muestra el menú de donantes y ejecuta la opción seleccionada.
    public void menuDonantes(GestorCampania gestor)
    {
        int opcion = 0;

        do
        {
            vista.vistaMenuDonantes(campania);

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
                // Vuelve al menú anterior.
                case 0:
                    vista.msjVolver();
                    break;

                // Permite seleccionar la campaña sobre la que se realizarán las operaciones.
                case 1:
                    campania = ges.seleccionarCampania(gestor);
                    break;

                // Crea un nuevo donante en la campaña seleccionada.
                case 2:
                    if(campania == null)
                        vista.noCampaniaSeleccionada();

                    else
                        ges.crearDonante(campania);

                    break;
                // Registra una donación de sangre para un donante de la campaña seleccionada.
                case 3:
                    if(campania == null)
                        vista.noCampaniaSeleccionada();

                    else
                        try{
                            ges.donarSangre(campania);
                        }catch(DonarException e){
                            System.out.println(e.getMessage());
                        }
                    
                    break;

                // Muestra los donantes registrados en la campaña seleccionada.
                case 4:
                    if(campania == null)
                        vista.noCampaniaEncontrada(opcion);

                    else
                        ges.listarDonantes(campania);

                    break;

                // Busca un donante dentro de la campaña seleccionada.
                case 5:
                    if(campania == null)
                        vista.noCampaniaSeleccionada();

                    else
                        ges.buscarDonante(campania);

                    break;

                // Permite modificar los datos de un donante de la campaña seleccionada.
                case 6:
                    if(campania == null)
                        vista.noCampaniaSeleccionada();

                    else
                        ges.modificarDonante(campania);

                    break;

                // Permite eliminar un donante de la campaña seleccionada.
                case 7: 
                    if(campania == null)
                        vista.noCampaniaSeleccionada();

                    else
                        ges.eliminarDonante(campania);
                    
                    break;

                // Informa que la opción ingresada no es válida.
                default:
                    vista.entradaInvalida();
            }
        }
        while(opcion != 0);
    }
}