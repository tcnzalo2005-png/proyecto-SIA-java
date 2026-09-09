package herramientas;

import herramientas.excepciones.ScanException;
import java.util.Scanner;

public class Scan
{
    private Scanner scanner;

    /* ===== CONSTRUCTOR ===== */
    public Scan()
    {
        scanner = new Scanner(System.in);
    }

    /* ===== LEER STRINGS ===== */
    public String Str(String mensaje)
    {
        System.out.print(mensaje);

        return scanner.nextLine();
    }

    public String Str()
    {
        return Str("");
    }

    /* ===== LEER ENTEROS ===== */
    public long Long(String mensaje) throws ScanException
    {
        byte intentos = 3;

        while(intentos > 0)
        {
            try
            {
                return Long.parseLong(Str(mensaje));
            }
            catch(NumberFormatException e)
            {
                intentos--;

                System.out.println("Entrada invalida");
            }
        }

        throw new ScanException("Demasiados intentos");
    }

    public long Long() throws ScanException
    {
        return Long("");
    }

    public int Int(String mensaje) throws ScanException
    {
        long numero = Long(mensaje);

        if(numero < Integer.MIN_VALUE || Integer.MAX_VALUE < numero)
            throw new ScanException("El numero esta fuera del rango: int");

        return (int)numero;
    }

    public int Int() throws ScanException
    {
        return Int("");
    }

    public short Short(String mensaje) throws ScanException
    {
        long numero = Long(mensaje);

        if(numero < Short.MIN_VALUE || Short.MAX_VALUE < numero)
            throw new ScanException("El numero esta fuera del rango: short");

        return (short)numero;
    }

    public short Short() throws ScanException
    {
        return Short("");
    }

    public byte Byte(String mensaje) throws ScanException
    {
        long numero = Long(mensaje);

        if(numero < Byte.MIN_VALUE || Byte.MAX_VALUE < numero)
            throw new ScanException("El numero esta fuera del rango: byte");

        return (byte)numero;
    }

    public byte Byte() throws ScanException
    {
        return Byte("");
    }

    /* ===== LEER FLOTANTES ===== */
    public double Double(String mensaje) throws ScanException
    {
        byte intentos = 3;

        while(intentos > 0)
        {
            try
            {
                return Double.parseDouble(Str(mensaje));
            }
            catch(NumberFormatException e)
            {
                intentos--;

                System.out.println("Entrada invalida");
            }
        }

        throw new ScanException("Demasiados intentos");
    }

    public double Double() throws ScanException
    {
        return Double("");
    }

    public float Float(String mensaje) throws ScanException
    {
        double numero = Float(mensaje);

        if(numero < Float.MIN_VALUE || Float.MAX_VALUE < numero)
            throw new ScanException("El numero esta fuera de rango: float");

        return (float)numero;
    }

    public float Float() throws ScanException
    {
        return Float("");
    }

    /* ===== LEER BOOLEANO ===== */
    public boolean Bool(String mensaje) throws ScanException
    {
        byte intentos = 3;
        String str;

        while(intentos > 0)
        {
            str = Str(mensaje);

            if(str.equalsIgnoreCase("true"))
                return true;

            if(str.equalsIgnoreCase("false"))
                return false;

            intentos--;
            System.out.println("Entrada invalida");
        }

        throw new ScanException("Demasiados intentos");
    }
}