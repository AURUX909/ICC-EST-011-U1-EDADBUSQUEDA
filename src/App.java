import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class App 
{
    public static void main(String[] args) 
    {
        Scanner leer = new Scanner(System.in);
        System.out.println("Bienvenido al programa de búsqueda de personas");
        System.out.print("Ingrese la cantidad de personas en el listado: ");
        int cantidadPersonas = leer.nextInt();
        leer.nextLine(); 
        Persona[] arreglo = new Persona[cantidadPersonas];
        for (int i = 0; i < cantidadPersonas; i++) 
        {
            System.out.println("Ingrese Persona " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = leer.nextLine();
            System.out.print("Edad: ");
            int edad = leer.nextInt();
            leer.nextLine(); 
            arreglo[i] = new Persona(nombre, edad);
        }
        Arrays.sort(arreglo, Comparator.comparingInt(Persona::getEdad));
        System.out.print("Ingrese la edad que desea buscar: ");
        int edadBuscada = leer.nextInt();
        int index = findByEdad(arreglo, edadBuscada);
        if (index != -1) 
        {
            System.out.println("La persona con la edad " + edadBuscada + " es " + arreglo[index].getNombre());
        } 
        else 
        {
            System.out.println("Persona no encontrada con la edad " + edadBuscada);
        }
    }
    public static int findByEdad(Persona[] personas, int edad) 
    {
        int bajo = 0;
        int alto = personas.length - 1;
        while (bajo <= alto) 
        {
            for (int i = bajo; i <= alto; i++) 
            {
                System.out.print(personas[i].getEdad());
                if (i < alto) System.out.print(" | ");
            }
            System.out.println();  
            int centro = bajo + (alto - bajo) / 2;
            int valorCentro = personas[centro].getEdad();
            System.out.print("bajo=" + bajo + " alto=" + alto + " centro=" + centro + " valorCentro=" + valorCentro);
            if (valorCentro == edad) 
            {
                System.out.println(" --> ENCONTRADO");
                return centro;
            } else if (valorCentro < edad) 
            {
                System.out.println(" --> DERECHA");
                bajo = centro + 1;
            } else {
                System.out.println(" --> IZQUIERDA");
                alto = centro - 1;
            }
        }
        return -1; 
    }
}