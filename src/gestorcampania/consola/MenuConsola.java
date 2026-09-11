package gestorcampania.consola;

import gestorcampania.GestorCampania;
import gestorcampania.herramientas.Scan;
import gestorcampania.herramientas.excepciones.ScanException;

public class MenuConsola
{
    Scan scan = new Scan();
    VistaConsola vista = new VistaConsola();

    MenuCampanias menuCamp = new MenuCampanias();
    MenuDonantes menuDon = new MenuDonantes();
    MenuConsultas menuCon = new MenuConsultas();

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
                case 0:
                    vista.msjSalir();
                    break;

                case 1:
                    menuCamp.menuCampanias(gestor);
                    break;

                case 2:
                    menuDon.menuDonantes(gestor);
                    break;

                case 3:
                    menuCon.menuConsultas(gestor);
                    break;

                default:
                    vista.entradaInvalida();
            }
        }
        while(opcion != 0);
    }
}
