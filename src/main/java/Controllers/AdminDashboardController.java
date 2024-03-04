package Controllers;

import Entities.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class AdminDashboardController {
    @FXML
    private Label adminNameLabel;

    public void initialize() {
        GuiLoginController guilogin = new GuiLoginController();
        String name="Bienvenue "+guilogin.user.getName()+"!";
        adminNameLabel.setText(name);
    }
    public void goToLogn(MouseEvent mouseEvent) {
        RouterController.navigate("/fxml/Login/Login.fxml");
    }

    public void goToNavigate(ActionEvent actionEvent) {
        RouterController.navigate("/fxml/AdminDashboard.fxml");
    }

    public void goToUsers(MouseEvent mouseEvent) {

        RouterController router=new RouterController();
        router.navigate("/fxml/ProductOrdreCRUD.fxml");
    }

    public void goToActivities(MouseEvent mouseEvent) {
        RouterController router=new RouterController();
        router.navigate("/fxml/ProductCRUD.fxml");
    }

    public void goToCommands(MouseEvent mouseEvent) {
    }

    public void goToReclamations(MouseEvent mouseEvent) {
    }

    public void goToEvent(MouseEvent mouseEvent) {
    }

    public void goToLivraisons(MouseEvent mouseEvent) {
    }

    public void openstats(ActionEvent event) {
        RouterController.navigate("/fxml/StatsProduct.fxml");
    }
}
