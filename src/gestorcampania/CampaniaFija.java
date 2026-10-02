package gestorcampania;

import java.time.LocalDate;

/*Clase subtipo de campaña para crear campañas fijas*/
public class CampaniaFija extends Campania {
    private String ubicacion;   /*Una campaña fija tiene unicamente una ubicacion*/
    
    /*Constructor*/
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
    
    
    /*Metodo sobreescrito y devuelve un tipo String con toda la informacion de la campaña ya que 
    sirve para ser usada tanto en ventana como consola y haci se evita tener que retornar el arreglo completo*/
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

        /*Tipo de campaña para el CSV*/
    @Override
    public String getTipoCSV(){
        return "Fija";
    }

    /*Ubicacion de la campaña para el CSV*/
    @Override
    public String getUbicacionesCSV(){
        return ubicacion;
    }
}
