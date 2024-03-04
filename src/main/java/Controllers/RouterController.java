package Controllers;
import Entities.Product;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class RouterController {

    private static Stage primaryStage;
    private static final Duration TRANSITION_DURATION = Duration.seconds(1.0);
    private static Object ModifyProduit;
    private static Controllers.ModifyProduit controller;


    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public static void navigate(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(RouterController.class.getResource(fxmlPath));
            AnchorPane root = loader.load();

            FadeTransition fadeOut = new FadeTransition(TRANSITION_DURATION, primaryStage.getScene().getRoot());
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(event -> {
                primaryStage.setScene(new Scene(root));
                FadeTransition fadeIn = new FadeTransition(TRANSITION_DURATION, root);
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.play();
            });
            fadeOut.play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void navigate(String fxmlPath, Integer Id) {
        try {
            FXMLLoader loader = new FXMLLoader(RouterController.class.getResource(fxmlPath));
            AnchorPane root = loader.load();

            InitializableController controller = loader.getController();


            if (Id != null) {
                controller.init(Id);
            }


            FadeTransition fadeOut = new FadeTransition(TRANSITION_DURATION, primaryStage.getScene().getRoot());
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(event -> {
                primaryStage.setScene(new Scene(root));
                // Fade in animation
                FadeTransition fadeIn = new FadeTransition(TRANSITION_DURATION, root);
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.play();
            });
            fadeOut.play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void navigatepay(String s, Product p) {
        try {
            FXMLLoader loader = new FXMLLoader(RouterController.class.getResource(s));
            AnchorPane root = loader.load();

            GuiPaiementController controller = loader.getController();


            if (p != null) {
                controller.init(p);
            }

            FadeTransition fadeOut = new FadeTransition(TRANSITION_DURATION, primaryStage.getScene().getRoot());
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(event -> {
                primaryStage.setScene(new Scene(root));
                FadeTransition fadeIn = new FadeTransition(TRANSITION_DURATION, root);
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.play();
            });
            fadeOut.play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
