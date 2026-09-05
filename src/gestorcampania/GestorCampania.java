package gestorcampania;
import gestorcampania.Vent.MenuVentana;
import java.util.*;
import java.time.LocalDate;

public class GestorCampania {
    private ArrayList<Campania> listaCampanias;
    
    public GestorCampania(){
        listaCampanias = new ArrayList<>();
    }
    public int totalSangreDonada() {
        int totalSangre = 0;
       for(int i = 0 ; i < listaCampanias.size(); i++) {
           Campania campania = listaCampanias.get(i);
           ArrayList<Donante> listaDonantes = new ArrayList<>(campania.getDonantesPorRut().values());
           for (int j = 0; j < listaDonantes.size(); j++) {
               Donante donante = listaDonantes.get(j);
               totalSangre = totalSangre + donante.getDonacion();
           }

        }
        return totalSangre;
    }
    
    public int totalDonadores(){
        int totalPersonas = 0 ;

        for(int i = 0; i < listaCampanias.size(); i++){
            Campania campania = listaCampanias.get(i);

            totalPersonas = totalPersonas + campania.getDonantes().size();
        }

        return totalPersonas;

    }

    public int totalSangreDonadaPorTipo(Sangre tipoSangre) {
    int totalPorTipo = 0;
    
    for (int i = 0; i < listaCampanias.size(); i++) {
        Campania campania = listaCampanias.get(i);
        ArrayList<Donante> listaDonantes = new ArrayList<>(campania.getDonantes().values());
        
        for (int j = 0; j < listaDonantes.size(); j++) {
            Donante donante = listaDonantes.get(j);
            if (donante.getTipoSangre() == tipoSangre) {
                totalPorTipo = totalPorTipo + donante.getDonacion();
            }
        }
    }
    
    return totalPorTipo;
}
    
    public void crearCampaniaFija(int idCampania, String nombreCampania, LocalDate fecha, String ubicacion){
        CampaniaFija nuevo = new CampaniaFija(idCampania, nombreCampania, fecha, ubicacion);
        if(nuevo != null){
            listaCampanias.add(nuevo);
        }
    }
    public void crearCampaniaFija(int idCampania, String nombreCampania, String ubicacion){
        CampaniaFija nuevo = new CampaniaFija(idCampania, nombreCampania, LocalDate.now(), ubicacion);
        listaCampanias.add(nuevo);
    }
    public void crearCampaniaMovil(int idCampania, String nombreCampania, LocalDate fecha, String ubicacion){
        CampaniaMovil nuevo = new CampaniaMovil(idCampania, nombreCampania, fecha, ubicacion);
        if(nuevo != null){
            listaCampanias.add(nuevo);
        }
    }
    public void crearCampaniaMovil(int idCampania, String nombreCampania, String ubicacion){
        CampaniaMovil nuevo = new CampaniaMovil(idCampania, nombreCampania, LocalDate.now(), ubicacion);
        listaCampanias.add(nuevo);
    }

    public Campania buscarCampania(int idBuscar){
        for(Campania i : listaCampanias){
            if(i.getIdCampania() == idBuscar){
                return i;
            }
        }
        return null;
    }
    public void eliminarCampania(int idBuscar){
        Campania eliminar = buscarCampania(idBuscar);
        if(eliminar != null){
            listaCampanias.remove(eliminar);
        }
    }
    public String mostrarCampania(){
        String cosa = "";
        for(Campania c : listaCampanias){
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
        Scanner scanner = new Scanner(System.in);
        int opcion;
        /* Crear datos de ejemplo */
        gestor.listaCampanias.add(DatosEjemplo.poblar());
        
        System.out.println("Ventana o consola");
        System.out.println("1.-Consola");
        System.out.println("2.-Ventana");
        opcion = scanner.nextInt();
        
        if(opcion == 1){
            System.out.println("ingreso a consola...");
        }else if(opcion == 2){
            MenuVentana vent = new MenuVentana(gestor);
            vent.setVisible(true);
            vent.setLocationRelativeTo(null);
        }
        
        
        scanner.close();
    }
}
