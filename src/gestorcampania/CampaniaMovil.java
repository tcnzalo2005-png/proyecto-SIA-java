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

    public void modificarCampania(String nombreCampania, LocalDate fecha, String ubicacion){
        setNombreCampania(nombreCampania);
        setFecha(fecha);
        setUbicacion(ubicacion);
    }

    @Override
    public void mostrarCampania(){
        System.out.println("Id campaña: " + getIdCampania());
        System.out.println("Nombre campaña: " + getNombreCampania());
        System.out.println("Fecha campaña: " + getFecha());
        for(String i : ubicaciones){
            System.out.print("Ubicacion: " + i +" - ");
        }
    }
}
