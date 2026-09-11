package gestorcampania.consola;

import gestorcampania.GestorCampania;
import gestorcampania.herramientas.Scan;
import gestorcampania.herramientas.excepciones.ScanException;

public class MenuConsultas
{
    GestionConsultas ges = new GestionConsultas();
    Scan scan = new Scan();
    VistaConsola vista = new VistaConsola();

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
                case 0:
                    vista.msjVolver();
                    break;

                case 1:
                    ges.totalSangreDonada();
                    break;

                case 2:
                    ges.totalDonadores();
                    break;

                case 3:
                    ges.sangrePorTipo();
                    break;
                
                default:
                    vista.entradaInvalida();
            }
        }
        while(opcion != 0);
    }
}
