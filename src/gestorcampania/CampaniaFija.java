package gestorcampania;

import java.time.LocalDate;

public class CampaniaFija extends Campania {
    private String ubicacion;
    
    public CampaniaFija(int idCampania, String nombreCampania, LocalDate fecha, String ubicacion){
        super(idCampania, nombreCampania, fecha);
        this.ubicacion = ubicacion;
    }

    @Override
    public String mostrarCampania(){
        return  "Id campaña: " + getIdCampania();
                "Nombre campaña: " + getNombreCampania();
                "Fecha campaña: " + getFecha();
                "Ubicacion: " + ubicacion;
    }
    
    public void modificarCampania(String nombreCampania, LocalDate fecha){
        setNombreCampania(nombreCampania);
        setFecha(fecha);
    }
}
