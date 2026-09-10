
package gestorcampania.herramientas;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ValidadorCamposDeVentana {
    
    public ValidadorCamposDeVentana(){
        
    }
    
    public boolean esNumInt(String texto){
        
        
        if(texto == null ){
            return false;
        }
        try{
            Integer.parseInt(texto);
            return true;
        }
        catch(NumberFormatException e){
            
            return false;
        }
    }
    
    public boolean esFecha(String texto){
        if(texto == null){
            return false;
        }
        try{
            LocalDate.parse(texto);
            return true;
        }
        catch(DateTimeParseException e){
            return false;
        }
    }
    
    public boolean esTexto(String texto){
        if(texto == null || texto.equals("")){
            return false;
        }else if(esNumInt(texto) == true){
            return false;
        }else{
            return true;
        }
    }
}
