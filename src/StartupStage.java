import Constants.Data;
import Constants.ListConstants;
import Utils.Writer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Account;
import model.Root;


public class StartupStage extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Writer writer = new Writer(Root.class, Account.class);
        ListConstants.accountlist = (Root<Account>)   writer.read(Data.account);
        Parent root = FXMLLoader.load(getClass().getResource("fxml/view/login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
