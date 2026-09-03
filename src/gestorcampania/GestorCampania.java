package gestorcampania;
import java.util.*;
import java.time.LocalDate;

public class GestorCampania {
    private ArrayList<Campania> listaCampania;
    
    public GestorCampania(){
        listaCampania = new ArrayList<>();
    }
    public int totalSangreDonada() {
       for(int i = 0 ; i < listaCampanias.size(); i++) {
           Campania campania = listaCampanias.get(i);
           ArrayList<Donante> listaDonantes = new ArrayList<>(campania.getDonantes().values());
           for (int j = 0; j < listaDonantes.size(); j++) {
               Donante donante = listaDonantes.get(j);
               totalSangre = totalSangre + donante.getDonacion();
           }

        }
        return totalSangre;
    }

    
    public void crearCampaniaFija(int idCampania, String nombreCampania, LocalDate fecha, String ubicacion){
        CampaniaFija nuevo = new CampaniaFija(idCampania, nombreCampania, fecha, ubicacion);
        listaCampania.add(nuevo);
    }
    public void crearCampaniaFija(int idCampania, String nombreCampania, String ubicacion){
        CampaniaFija nuevo = new CampaniaFija(idCampania, nombreCampania, LocalDate.now(), ubicacion);
        listaCampania.add(nuevo);
    }
    public void crearCampaniaMovil(int idCampania, String nombreCampania, LocalDate fecha, String ubicacion){
        CampaniaMovil nuevo = new CampaniaMovil(idCampania, nombreCampania, fecha, ubicacion);
        listaCampania.add(nuevo);
    }
    public void crearCampaniaMovil(int idCampania, String nombreCampania, String ubicacion){
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
    public String mostrarCampania(){
        String cosa = "";
        for(Campania c : listaCampania){
            cosa += c.mostrarCampania();
            cosa += "\n------------------------------\n";
        }
        return cosa;
    }   
    public void modificarCampanias(int idCampania, String nombreCampania, LocalDate fecha, String ubicacion){
        Campania aModificar = buscarCampania(idCampania);

        if(aModificar != null){
            aModificar.modificarCampania(nombreCampania, fecha, ubicacion);
        }
    }
    
    public static void main(String[] args){
        GestorCampania gestor = new GestorCampania();

        /* Crear datos de ejemplo */
        gestor.listaCampania.add(DatosEjemplo.poblar());
    }
}
