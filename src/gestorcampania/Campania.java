    package gestorcampania;

import gestorcampania.herramientas.excepciones.DonarException;
import java.util.*;
import java.time.LocalDate;

    /*Clase abstracta para crear distintas tipos de campañas sin tener que poner denuevo todos los atributos
    y metodos que tienen en comun*/
public abstract class Campania {
    private int idCampania; /*identificador unico*/
    private String nombreCampania;  /*Nombr de la camáña*/
    private LocalDate fecha;    /*Fecha de la campaña*/
    private HashMap<String, Donante> donantesPorRut;    /*Un hashMap para guardar cada uno de los donantes mediante su rut*/
    
    /*constructor*/
    public Campania(int idCampania, String nombreCampania , LocalDate fecha){
        this.idCampania = idCampania;
        this.nombreCampania = nombreCampania;
        this.fecha = fecha;
        this.donantesPorRut = new HashMap<>();
    }
    
    
    public int getIdCampania(){
        return idCampania;
    }
    public String getNombreCampania(){
        return nombreCampania;
    }
    public LocalDate getFecha(){
        return fecha;
    }
   

    public void setNombreCampania(String nombreAGuardar){
        nombreCampania = nombreAGuardar;
    }
    public void setFecha(LocalDate fechaAGuardar){
        fecha = fechaAGuardar;
    }
    
    /*Calcula el tota de la sangre de todos los donantes de una campaña*/
    public int totalSangre(){
        int totalSangre = 0;
        
        for (Donante j : donantesPorRut.values()) {
            
            totalSangre = totalSangre + j.getDonacion();
        }
        return totalSangre;
    }
    /*Se hace sobre carga para calcular el total de la sangre de los donantes pero por su tipo de sangre*/
    public int totalSangre(Sangre tipoSangre){
        int totalSangre = 0;
        for(Donante i : donantesPorRut.values()){
            if(i.getTipoSangre().equals(tipoSangre)){
                totalSangre += i.getDonacion();
            }
        }
        return totalSangre;
    }
    
    /*Calcula la cantidad total de donadores de la campaña*/
    public int totalDonadotres(){
        int total = 0;
        for(Donante i : donantesPorRut.values()){
            total ++;
        }
        return total;
    }
    
    /*En los metodos de crearDonante se usa sobreCarga para poder crear una campaña con una fecha especifica dada por el 
    usuario y otro metodo sin fecha dada para que el sistema mismo lo de de forma automatica (la fecha actual)
    */
    public void crearDonante(String rut, String nombreDonante, Sangre tipoSangre, int donacion){
        if(donantesPorRut.get(rut) != null){
            return;
        }
        Donante nuevo = new Donante(rut, nombreDonante, tipoSangre, donacion);
        donantesPorRut.put(rut , nuevo);
    }
    public void crearDonante(String rut, String nombreDonante, Sangre tipoSangre){
        if(donantesPorRut.get(rut) != null){
            return;
        }
        Donante nuevo = new Donante(rut, nombreDonante, tipoSangre, 0);
        donantesPorRut.put(rut, nuevo);
    }
    
    public void eliminarDonante(String rut){
        donantesPorRut.remove(rut);
    }
    
    
    public Donante buscarDonante(String rut)throws DonarException{
        Donante donante = donantesPorRut.get(rut);
        if(donante == null){
            throw new DonarException("ERROR, no se encontro el donante ");  /*Por si no existe el donante buscado*/
        }
        return donante;
    }
    
    /*Metodo que sirve para mostrar la informacion de los donantes pero todo en un tipo String para que sea usado tanto en 
    ventana como en consola y no romper el principio de encapsulamiento
    */
    public String mostrarDonante(){
        String cosa = "";
        for(Donante i : donantesPorRut.values()){
            cosa += i.mostrar();
            cosa += "\n------------------------------\n";
        }
        return cosa;
    }
    public void modificarDonante(String rut, String nombreDonante, Sangre tipoSangre){
        Donante d = donantesPorRut.get(rut);
        
        if(d != null){
            d.modificarDonante(nombreDonante, tipoSangre);
        }
    }

        /*Devuelve las lineas CSV de la campaña: una por donante, o una sola con los
    campos de donante vacios si no tiene donantes*/
    public String lineasCSV(){
        String base = idCampania + ";" + nombreCampania + ";" + fecha + ";" +
                      getTipoCSV() + ";" + getUbicacionesCSV() + ";";
        StringBuilder lineas = new StringBuilder();

        if(donantesPorRut.isEmpty()){
            lineas.append(base).append(";;;").append("\n");
        } else {
            for(Donante d : donantesPorRut.values()){
                lineas.append(base).append(d.formatoCSV()).append("\n");
            }
        }
        return lineas.toString();
    }
    
    /*Clases abstractas ya que toda campaña si o si implementan estos metodos pero de forma difetentes*/
    public abstract String mostrarCampania();
    public abstract void modificarCampania(String nombreCampania, LocalDate fecha, String ubicacion);

    /*Cada subtipo indica su tipo ("Fija" o "Movil") para el CSV*/
    public abstract String getTipoCSV();

    /*Cada subtipo entrega su(s) ubicacion(es) como texto para el CSV*/
    public abstract String getUbicacionesCSV();
}
