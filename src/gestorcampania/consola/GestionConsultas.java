package gestorcampania.consola;

import gestorcampania.Sangre;
import gestorcampania.GestorCampania;
import gestorcampania.herramientas.Scan;
import gestorcampania.herramientas.excepciones.ScanException;

public class GestionConsultas
{
    Scan scan = new Scan();
    VistaConsola vista = new VistaConsola();

    public void totalSangreDonada(GestorCampania gestor)
    {
        vista.vistaTotalSangreDonada();
        vista.mostrarTotalSangreDonada(gestor);
    }

    public void totalDonadores(GestorCampania gestor)
    {
        vista.vistaTotalDonadores();
        vista.mostarTotalDonadoes(gestor);
    }

    public void sangrePorTipo(GestorCampania gestor)
    {
        int opcion = 0;
        Sangre tipo = null;

        vista.vistaSangrePorTipo();

        vista.vistaTipoSangre();
        do
        {
            try
            {
                opcion = scan.Int("Opcion: ");
                tipo = Sangre.values()[opcion - 1];
            }
            catch(ScanException e)
            {
                opcion = 0;
            }
        }
        while(opcion < 1 || 8 < opcion);

        vista.msjTotalDonado();

        vista.mostarSangrePorTipo(gestor, tipo);
    }
}
