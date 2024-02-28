package Controllers;

import Entities.Product;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.io.ByteArrayInputStream;

public class ImageViewTableCellFactory<T> implements Callback<TableColumn<Product, T>, TableCell<Product, T>> {

    @Override
    public TableCell<Product, T> call(TableColumn<Product, T> param) {
        return new TableCell<Product, T>() {
            private final ImageView imageView = new ImageView();

            {
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);
                setGraphic(imageView);
            }

            @Override
            protected void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || getTableRow() == null || getTableRow().getItem() == null) {
                    setGraphic(null);
                } else {
                    Product rowData = (Product) getTableRow().getItem();
                    if (rowData.getBlobImage() != null) {
                        Image image = new Image(new ByteArrayInputStream(rowData.getBlobImage()));
                        imageView.setImage(image);
                    } else {
                        imageView.setImage(null);
                    }
                }
            }
        };
    }
}