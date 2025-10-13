// Importamos todas las librerias necesarias que vamos a utilizar para la aplicación JavaFx
import javafx.fxml.FXML;
// Libreria necesaria para crear el contenedor principal (Pane)
import javafx.scene.layout.Pane;
// Libreria necesaria para rellenar de color una linea o aplicar color a las figuras
import javafx.scene.paint.Color;
//Libreria necesaria para crear figuras o lineas
import javafx.scene.shape.*;
// Libreria necesaria para agrupar las lineas y las figuras geometricas en un Group
import javafx.scene.Group;
// Esta libreria la importamos por que giraremos las figuras
import javafx.scene.transform.Rotate;


// Creamos la clase Controller para que dentro esten todas las indicaciones de las figuras que vamos a crear con ella
public class Controller {

    // Atributo rootPane de tipo Pane que sera el contenedor principal donde añadiremos todos los grupos de figuras
    @FXML
    private Pane rootPane;

    // LLamamos al metodo initialize() que se ejecuta automáticamente al inicializar el controlador
    // y se encarga de crear las figuras
    @FXML
    public void initialize() {
        // Creamos la linea 1 del grupo delineas y definimos sus coordenadas
        Line linea1 = new Line(50, 50, 200, 50);
        // Personalizamos el color de la linea 1
        linea1.setStroke(Color.RED);
        // Personalizamos el grosor de la línea 1
        linea1.setStrokeWidth(2);

        // Creamos la linea 2 del grupo de lineas con sus coordenadas
        Line linea2 = new Line(50, 100, 200, 100);
        // Personalizamos el color de la linea 2
        linea2.setStroke(Color.GREEN);
        // Personañlizamos el grosor de la linea 2
        linea2.setStrokeWidth(5);

        // Creamos la linea 3 del grupo de lineas con sus coordenadas
        Line linea3 = new Line(50, 150, 200, 150);
        // Personalizamos el color de la linea 3
        linea3.setStroke(Color.BLUE);
        // Personañlizamos la anchura o grosor de la linea 3
        linea3.setStrokeWidth(8);

        // Agrupamos las 3 lineas en un solo objeto
        Group grupoLineas = new Group(linea1, linea2, linea3);
        // Y llamamos al metodo getTransforms() para rotar las lineas un poco
        grupoLineas.getTransforms().add(new Rotate(15, 125, 100));


        // Creamos la figura cuadrado para el Grupo de las figuras geométricas
        Rectangle cuadrado = new Rectangle(300, 50, 80, 80);
        // Personalizamos el relleno del cuadrado en amarillo
        cuadrado.setFill(Color.YELLOW);
        // Personalizamos el borde del cuadrado en negro
        cuadrado.setStroke(Color.BLACK);

        // Creamos la figura circulo para el Grupo de las figuras geométricas
        Circle circulo = new Circle(450, 90, 40);
        //Personalizamos el relleno del circulo en cyan
        circulo.setFill(Color.CYAN);
        // Personalizamos el borde del circulo en azul oscuro
        circulo.setStroke(Color.DARKBLUE);

        // Creamos la figura poligono para el Grupo de las figuras geométricas
        Polygon pentagono = new Polygon();
        // Ponemos las cordenadas para crear el poligono
        pentagono.getPoints().addAll(
                600.0, 50.0,
                650.0, 100.0,
                625.0, 150.0,
                575.0, 150.0,
                550.0, 100.0
        );
        // Personalizamos el relleno del pentagono
        pentagono.setFill(Color.PINK);
        // Personalizamos el borde del pentagono
        pentagono.setStroke(Color.RED);

        // Agrupamos las tres figuras en un grupo
        Group grupoFiguras = new Group(cuadrado, circulo, pentagono);

        // Utilizamos el metodo getTransforms() para rotar las figuras del grupo de figuras
        grupoFiguras.getTransforms().add(new Rotate(30, 500, 100));

        // Desplazamos un poco las figuras en la escena para mejorar su posición en la escena
        grupoFiguras.setLayoutY(150);

        // Añadimos ambos grupos el de las lineas y el de las figuras en el contenedor principal rootPane
        rootPane.getChildren().addAll(grupoLineas, grupoFiguras);
    }
}
