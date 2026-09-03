package gestorcampania;

import java.time.LocalDate;

public class CampaniaFija extends Campania {
    private String ubicacion;
    
    public CampaniaFija(int idCampania, String nombreCampania, LocalDate fecha, String ubicacion){
        super(idCampania, nombreCampania, fecha);
        this.ubicacion = ubicacion;
    }
    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }
    public String getUbicacion(){
        return ubicacion;
    }

    @Override
    public String mostrarCampania(){
        return  "Id campaña: " + getIdCampania() +
                "\nNombre campaña: " + getNombreCampania() +
                "\nFecha campaña: " + getFecha() +
                "\nUbicacion: " + ubicacion;
    }
    
    @Override
    public void modificarCampania(String nombreCampania, LocalDate fecha, String ubicacion){
        setNombreCampania(nombreCampania);
        setFecha(fecha);
        setUbicacion(ubicacion);
    }
}
