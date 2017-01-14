package Utils;
import javafx.scene.control.Alert;

public class Popup {
    public static void warning(String title,String message){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("WARNING!");
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static void error(String title,String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR!");
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static void inform(String title,String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
