// importamos las librerias necesarias para la lectura del archivo y la gestion de las excepciones
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Clase leerfichero con las indicaciones de lo que hace
public class leeFichero {

    // Metodo leerfichero que recibe la ruta que se quiere leer
    // La ruta se la pasará desde el método main
    public static void leerfichero(String ruta) throws
            FileNotFoundException, IOException {
        // Declaracion de la variable tipo String para guardar ahi las lineas de texto
        // que vamos a ir leyendo del archivo
        String salida="";
        // Declaracion de la variable con un numero entero que marca el numero uno
        // para que inicie el metodo desde la linea 1 del archivo que va a leer y luego ira creciendo conforme
        // se vayan leyendo linea a linea
        int numeroLinea=1;
        // Creamos los objetos para poder leer el archivo
        FileReader fr = new FileReader(ruta);
        BufferedReader br = new BufferedReader(fr);

        //lectura del fichero mediante bucle while para que mientras haya lineas que leer
        // siga contando y mostrando en pantalla las lineas y las cuentas de caracteres
        while((salida = br.readLine())!=null) {
            // Guarda en una variable la cantidad de caracteres que tiene la linea leida
            int cantidadCaracteres = salida.length();
            // Mostrar en pantalla la linea que estamos recorriendo ,
            // con el numero de linea y la cantidad de caracteres que tiene cada linea
            System.out.println("Línea " + numeroLinea + " (" + cantidadCaracteres + " caracteres): " + salida);
            // Incrementa el número de linea en uno para continuar con la siguiente
            numeroLinea++;

        }
        // Cerramos el BufferedReader para liberar recursos y memoria
        br.close();

    }

    // main del programa que ejecuta la lectura de fichero con el metodo leerfichero()
    public static void main(String[] args) throws IOException {
        //Llamo a leerfichero con la ruta donde se encuentra el archivo
        // y ejecuto leerfichero para que haga lo que quiero que haga

        leerfichero("/Users/josechuair/Desktop/prueba.txt");

    }
}