package Controllers;

import javafx.event.ActionEvent;

public class ClientNavbarController {

    public void goToNavigate(ActionEvent actionEvent) {
        RouterController.navigate("../fxml/ProductsList.fxml");
    }


    public void goToActivites(ActionEvent mouseEvent) {
    }



    public void goToProducts(ActionEvent mouseEvent) {
        RouterController.navigate("../fxml/ProductsList.fxml");
    }
}
