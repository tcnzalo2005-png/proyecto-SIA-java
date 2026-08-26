package gestorcampania;

import java.time.LocalDate;

public class CampaniaFija extends Campania {
    private String ubicacion;
    
    public CampaniaFija(int idCampania, String nombreCampania, LocalDate fecha, String ubicacion){
        this.ubicacion = ubicacion;
        super(idCampania, nombreCampania, fecha);
    }

    @Override
    public void mostrarCampania(){
        System.out.println("Id campaña: " + getIdCampania());
        System.out.println("Nombre campaña: " + getNombreCampania());
        System.out.println("Fecha campaña: " + getFecha());
        System.out.println("Ubicacion: " + ubicacion);
    }
    
    public void modificarCampania(String nombreCampania, LocalDate fecha){
        setNombreCampania(nombreCampania);
        setFecha(fecha);
    }
}
