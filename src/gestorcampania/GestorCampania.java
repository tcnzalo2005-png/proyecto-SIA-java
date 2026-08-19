package gestorcampania;
import java.util.*;
import java.time.LocalDate;

public class GestorCampania {
    private ArrayList<Campania> listaCampania;
    
    public GestorCampania(){
        this.listaCampania = new ArrayList<>();
    }
    public void crearCampania(int idCampania, String nombreCampania, LocalDate fecha){
        Campania nuevo = new Campania(idCampania, nombreCampania, fecha);
        listaCampania.add(nuevo);
    }
    public void crearCampania(int idCampania, String nombreCampania){
        Campania nuevo = new Campania(idCampania, nombreCampania, LocalDate.now());
        listaCampania.add(nuevo);
    }

    public Campania buscarCampania(int idBuscar){
        for(Campania i : listaCampania){
            if(i.getIdCampania() == idBuscar){
                return i;
            }
        }
        return null;
    }
    public void eliminarCampania(int idBuscar){
        Campania eliminar = buscarCampania(idBuscar);
        if(eliminar != null){
            listaCampania.remove(eliminar);
        }
    }
    public void mostrarCampania(int idBuscar){
        Campania mostrar = buscarCampania(idBuscar);
        if(mostrar != null){
            System.out.println("ID campania: " + mostrar.getIdCampania());
            System.out.println("Nombre campania: " + mostrar.getNombreCampania());
            System.out.println("Fecha: " + mostrar.getFecha());
        }
    }   
    public void mofificarCampania(int idCampania, String nombreCampania, Date fecha){
        Campania aModificar = buscarCampania(idCampania);
        if(aModificar != null){
            aModificar.setNombreCampania(nombreCampania);
            aModificar.setFecha(fecha);
        }
    }
    


    public static void main(String[] args){
        
    }
}
