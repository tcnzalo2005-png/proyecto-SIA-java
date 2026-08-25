
package gestorcampania;
import java.util.*;
import java.time.LocalDate;

public class CampaniaFija extends Campania {
    
    public CampaniaFija(int idCampania, String nombreCampania, LocalDate fecha){
        super(idCampania, nombreCampania, fecha);
    }

    @Override
    public void mostrarCampania(){
        System.out.println("Id campaña: " + getIdCampania());
        System.out.println("Nombre campaña: " + getNombreCampania());
        System.out.println("Fecha campaña: " + getFecha());
    }
    
    public void modificarCampania(String nombreCampania, LocalDate fecha){
        setNombreCampania(nombreCampania);
        setFecha(fecha);
    }
}
