package gestorcampania;
import java.util.*;
import java.time.LocalDate;

public class GestorCampania {
    private ArrayList<Campania> listaCampania;
    
    public GestorCampania(){
        this.listaCampania = new ArrayList<>();
    }
    public void crearCampania(int idCampania, String nombreCampania, LocalDate fecha){
        CampaniaFija nuevo = new CampaniaFija(idCampania, nombreCampania, fecha);
        listaCampania.add(nuevo);
    }
    public void crearCampania(int idCampania, String nombreCampania){
        CampaniaFija nuevo = new CampaniaFija(idCampania, nombreCampania, LocalDate.now());
        listaCampania.add(nuevo);
    }
    public void crearCampania(int idCampania, String nombreCampania, LocalDate fecha, String ubicacion){
        CampaniaMovil nuevo = new CampaniaMovil(idCampania, nombreCampania, fecha, ubicacion);
        listaCampania.add(nuevo);
    }
    public void crearCampania(int idCampania, String nombreCampania, String ubicacion){
        CampaniaMovil nuevo = new CampaniaMovil(idCampania, nombreCampania, LocalDate.now(), ubicacion);
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
    public void mostrarCampania(){
        for(Campania c : listaCampania){
            c.mostrarCampania();
            System.out.println("------------------------------");
        }
    }   
    public void modificarCampania(int idCampania, String nombreCampania, LocalDate fecha){
        Campania aModificar = buscarCampania(idCampania);
        if(aModificar != null){
            if(aModificar instanceof CampaniaFija){
                ((CampaniaFija)aModificar).modificarCampania(nombreCampania, fecha);
            }
        }
    }
    public void agregarUbiCampaniaMovil(int idCampania, String ubicacion){
        Campania aux = buscarCampania(idCampania);
        if(aux != null){
            if(aux instanceof CampaniaMovil){
                ((CampaniaMovil)aux).setUbicacion(ubicacion);
            }
        }
    }
    
    


    public static void main(String[] args){
        
    }
}
