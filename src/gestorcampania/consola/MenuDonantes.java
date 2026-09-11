package gestorcampania.consola;

import gestorcampania.Campania;
import gestorcampania.GestorCampania;
import gestorcampania.herramientas.Scan;
import gestorcampania.herramientas.excepciones.ScanException;

public class MenuDonantes
{
    GestionDonantes ges = new GestionDonantes();
    Scan scan = new Scan();
    VistaConsola vista = new VistaConsola();

    Campania campania = null;

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
                case 0:
                    vista.msjVolver();
                    break;

                case 1:
                    campania = ges.seleccionarCampania(gestor);
                    break;

                case 2:
                    if(campania == null)
                        vista.noCampaniaSeleccionada();

                    else
                        ges.crearDonante(campania);

                    break;

                case 3:
                    if(campania == null)
                        vista.noCampaniaEncontrada(opcion);

                    else
                        ges.listarDonantes(campania);

                    break;

                case 4:
                    if(campania == null)
                        vista.noCampaniaSeleccionada();

                    else
                        ges.buscarDonante(campania);

                    break;

                case 5:
                    if(campania == null)
                        vista.noCampaniaSeleccionada();

                    else
                        ges.modificarDonante(campania);

                case 6: 
                    if(campania == null)
                        vista.noCampaniaSeleccionada();

                    else
                        ges.eliminarDonante(campania);

                default:
                    vista.entradaInvalida();
            }
        }
        while(opcion != 0);
    }
}
