package gestorcampania;
import gestorcampania.Vent.MenuVentana;
import java.util.*;
import java.time.LocalDate;
import gestorcampania.consola.MenuConsola;

public class GestorCampania { 
    private ArrayList<Campania> listaCampanias; 
     
    public GestorCampania(){ 
        listaCampanias = new ArrayList<>(); 
    } 

    public ArrayList<Campania> getListaCampanias(){
        return listaCampanias;
    }
 
    public int totalSangreDonada() { 
        int totalSangre = 0; 
        for(int i = 0 ; i < listaCampanias.size(); i++) { 
           Campania campania = listaCampanias.get(i); 
           totalSangre += campania.totalSangre(); 
        } 
        return totalSangre; 
    }

    public int totalDonadores(){
        int totalPersonas = 0;

        for(int i = 0; i < listaCampanias.size(); i++){
            Campania campania = listaCampanias.get(i);
            totalPersonas += campania.totalDonadotres();
        }

        return totalPersonas;
    }

    public int totalSangreDonadaPorTipo(Sangre tipoSangre) {
        int totalPorTipo = 0;
        
        for (int i = 0; i < listaCampanias.size(); i++) {
            Campania campania = listaCampanias.get(i);
            totalPorTipo += campania.totalSangre(tipoSangre);
        }
    
        return totalPorTipo;
    }
    
    public void crearCampaniaFija(int idCampania, String nombreCampania, LocalDate fecha, String ubicacion){
        if(buscarCampania(idCampania) != null){
            return;
        }
        CampaniaFija nuevo = new CampaniaFija(idCampania, nombreCampania, fecha, ubicacion);
        if(nuevo != null){
            listaCampanias.add(nuevo);
        }
    }
    public void crearCampaniaFija(int idCampania, String nombreCampania, String ubicacion){
        if(buscarCampania(idCampania) != null){
            return;
        }
        CampaniaFija nuevo = new CampaniaFija(idCampania, nombreCampania, LocalDate.now(), ubicacion);
        listaCampanias.add(nuevo);
    }
    public void crearCampaniaMovil(int idCampania, String nombreCampania, LocalDate fecha, String ubicacion){
        if(buscarCampania(idCampania) != null){
            return;
        }
        CampaniaMovil nuevo = new CampaniaMovil(idCampania, nombreCampania, fecha, ubicacion);
        if(nuevo != null){
            listaCampanias.add(nuevo);
        }
    }
    public void crearCampaniaMovil(int idCampania, String nombreCampania, String ubicacion){
        if(buscarCampania(idCampania) != null){
            return;
        }
        CampaniaMovil nuevo = new CampaniaMovil(idCampania, nombreCampania, LocalDate.now(), ubicacion);
        if(nuevo != null){
            listaCampanias.add(nuevo);
        }
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
    public void modificarCampanias(int idCampania, String nombreCampania, String ubicacion){
        Campania aModificar = buscarCampania(idCampania);

        if(aModificar != null){
            aModificar.modificarCampania(nombreCampania, LocalDate.now(), ubicacion);
        }
    }
    
public static void main(String[] args){

    GestorCampania gestor = new GestorCampania();
    Scanner scanner = new Scanner(System.in);

    CSV csv = new CSV("campanias.csv");

    csv.cargarCSV(gestor);

    System.out.println("Ventana o consola");
    System.out.println("1.-Consola");
    System.out.println("2.-Ventana");

    int opcion = scanner.nextInt();

    if(opcion == 1){

        System.out.println("ingreso a consola...");

        MenuConsola consola = new MenuConsola();
        consola.menu(gestor);

        csv.guardarCSV(gestor);

    }else if(opcion == 2){

        MenuVentana vent = new MenuVentana(gestor);
        vent.setVisible(true);
        vent.setLocationRelativeTo(null);

        vent.addWindowListener(new java.awt.event.WindowAdapter(){

            @Override
            public void windowClosing(java.awt.event.WindowEvent e){
                csv.guardarCSV(gestor);
            }
        });
    }

    scanner.close();
}
}
