package gestorcampania;

import java.util.*;
import java.time.LocalDate;

public class CampaniaMovil extends Campania {
    private ArrayList<String> ubicaciones;
    
    public CampaniaMovil(int idCampania, String nombreCampania, LocalDate fecha, String ubicaciones){
        super(idCampania, nombreCampania, fecha);
        this.ubicaciones = new ArrayList<>();
        this.ubicaciones.add(ubicaciones);
    }
    
    public void setUbicacion(String ubicacion){
        this.ubicaciones.add(ubicacion);
    }

    public ArrayList<String> getUbicaciones(){
        return ubicaciones;
    }

    @Override
    public void modificarCampania(String nombreCampania, LocalDate fecha, String ubicacion){
        setNombreCampania(nombreCampania);
        setFecha(fecha);
        setUbicacion(ubicacion);
    }

    @Override
    public String mostrarCampania() {
        String datos = "Id campaña: " + getIdCampania() +
                    "\nNombre campaña: " + getNombreCampania() +
                    "\nFecha campaña: " + getFecha() +
                    "\nUbicaciones: ";

        for (String i : ubicaciones) {
            datos += "\n   " + i;
        }

        return datos;
    }
}
