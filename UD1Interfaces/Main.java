// Importamos las librerías necesarias de JavaFX que usará la aplicación
// para ejecutar la escena correctamente.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


// Creamos la clase Main que extiende Application para poder iniciar la escena.
public class Main extends Application {
    // Aqui sobreescrbimos el metodo start() para configurarlo con nuestros parametros
    @Override

    public void start(Stage stage) throws Exception {
        // Creamos un objeto de la clase FXMLLoader con el archivo vista.fxml,
        // que usaremos después para cargar la escena.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("vista.fxml"));
        // Creamos el objeto scene con los parametros de dimension de la escena
        Scene scene = new Scene(loader.load(), 1000, 500);
        // Llamamos al metodo setTitle con la palabra Figuras para que le ponga
        // un titulo al stage
        stage.setTitle("Figuras");
        // Llamamos al metodo setScene con el objeto scene que creamos anteriormente
        stage.setScene(scene);
        // Cargamos el metodo show para que muestre la ventana en pantalla
        stage.show();
    }

    // Ejecutamos el metodo launch() desde main para iniciar la aplicación JavaFX
    public static void main(String[] args) {
        launch();
    }
}
