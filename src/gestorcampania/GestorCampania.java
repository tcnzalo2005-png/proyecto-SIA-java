package gestorcampania;
import gestorcampania.Vent.MenuVentana;
import java.util.*;
import java.time.LocalDate;
import gestorcampania.consola.MenuConsola;

/*clase principal para gestionar las campañas y los donantes*/
public class GestorCampania { 
    private ArrayList<Campania> listaCampanias;/*Arraylist para guardar cualquier tipo de campaña*/
     
    /*Constructor*/
    public GestorCampania(){ 
        listaCampanias = new ArrayList<>(); 
    } 

    /*METODO MALO CAMBIARLO CUANDO SE TERMINE DE ARREGLAR EL CVS*/
    public ArrayList<Campania> getListaCampanias(){
        return listaCampanias;
    }
 
    /*Metodo para calcular el total de sangre donada */
    public int totalSangreDonada() { 
        int totalSangre = 0; 
        for(int i = 0 ; i < listaCampanias.size(); i++) { 
           Campania campania = listaCampanias.get(i); 
           totalSangre += campania.totalSangre(); 
        } 
        return totalSangre; 
    }

    /*Metodo para calcular el total de donantes*/
    public int totalDonadores(){
        int totalPersonas = 0;

        for(int i = 0; i < listaCampanias.size(); i++){
            Campania campania = listaCampanias.get(i);
            totalPersonas += campania.totalDonadotres();
        }

        return totalPersonas;
    }

    /*Metodo para calcular el total de sangre donada de un tipo*/
    public int totalSangreDonadaPorTipo(Sangre tipoSangre) {
        int totalPorTipo = 0;
        
        for (int i = 0; i < listaCampanias.size(); i++) {
            Campania campania = listaCampanias.get(i);
            totalPorTipo += campania.totalSangre(tipoSangre);
        }
    
        return totalPorTipo;
    }
    
    /*Metodos crear campaña con sobrecarga de metodos para poner fechas actual o uno dado por el usuario*/
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

    /*Metodo para buscar una campaña especifica*/
    public Campania buscarCampania(int idBuscar){
        for(Campania i : listaCampanias){
            if(i.getIdCampania() == idBuscar){
                return i;
            }
        }
        return null;
    }
    
    /*Metodo para eliminar una compaña en especifica*/
    public void eliminarCampania(int idBuscar){
        Campania eliminar = buscarCampania(idBuscar);
        if(eliminar != null){
            listaCampanias.remove(eliminar);
        }
    }
    
    /*metodo para guardar toda la informacion de las campañas en un String para ser usado en la consola y ventanas*/
    public String mostrarCampania(){
        String cosa = "";
        for(Campania c : listaCampanias){
            cosa += c.mostrarCampania();
            cosa += "\n------------------------------\n";
        }
        return cosa;
    }   
    
    /*Metodo modificar campañas con sobreCarga para modificar una campaña en especifica y si se ingreso una fecha por el usuario o el sistema 
    le da la fecha actual*/
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
        /*Devuelve todas las campañas y sus donantes en formato CSV (sin encabezado)*/
    public String exportarCSV(){
        StringBuilder datos = new StringBuilder();
        for(Campania c : listaCampanias){
            datos.append(c.lineasCSV());
        }
        return datos.toString();
    }
   
public static void main(String[] args){

    GestorCampania gestor = new GestorCampania();   /*Crea el gestor*/
    Scanner scanner = new Scanner(System.in);   /*crea el scanner*/

    CSV csv = new CSV("campanias.csv");

    csv.cargarCSV(gestor);/*Carga la informacion del CSV*/

    System.out.println("Ventana o consola");
    System.out.println("1.-Consola");
    System.out.println("2.-Ventana");

    int opcion = scanner.nextInt();

    if(opcion == 1){

        System.out.println("ingreso a consola...\n");

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
