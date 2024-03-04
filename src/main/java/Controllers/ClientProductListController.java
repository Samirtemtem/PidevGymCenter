package Controllers;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class ClientProductListController {


    public void initialize() {

    }
    public void goToLogn(MouseEvent mouseEvent) {
        RouterController.navigate("/fxml/Login.fxml");
    }

    public void goToNavigate(ActionEvent actionEvent) {
        RouterController.navigate("/fxml/AdminDashboard.fxml");
    }

    public void goToUsers(MouseEvent mouseEvent) {
    }

    public void goToActivities(MouseEvent mouseEvent) {
        RouterController.navigate("../fxml/ProductsList.fxml");
    }



    public void GoToActivitySessions(MouseEvent mouseEvent) {
        RouterController.navigate("../fxml/ActivitySession/ActivitySessionCRUD.fxml");
    }
}

