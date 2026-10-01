package gestorcampania.consola; 
 
import gestorcampania.Sangre; 
import gestorcampania.GestorCampania; 
import gestorcampania.herramientas.Scan; 
import gestorcampania.herramientas.excepciones.ScanException; 
 
public class GestionConsultas 
{ 
    // Objeto encargado de gestionar la entrada de datos desde consola.
    private Scan scan = new Scan(); 

    // Objeto encargado de mostrar mensajes y resultados por consola.
    private VistaConsola vista = new VistaConsola(); 
 
    // Muestra el total de sangre donada registrado en el gestor.
    public void totalSangreDonada(GestorCampania gestor) 
    { 
        vista.vistaTotalSangreDonada(); 
        vista.mostrarTotalSangreDonada(gestor); 
    } 
 
    // Muestra el total de donadores registrados en el gestor.
    public void totalDonadores(GestorCampania gestor) 
    { 
        vista.vistaTotalDonadores(); 
        vista.mostarTotalDonadoes(gestor); 
    } 
 
    // Permite seleccionar un tipo de sangre y muestra el total donado de ese tipo.
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