package ir.ac.kntu.cs2d.view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;

public class Test extends Application {
    private Scene scene;
    private Group group;
    private WritableImage writableImage;
    private Image image;
    ImageView imageView;

    @Override
    public void start(Stage primaryStage) throws Exception {
        group = new Group();
        scene = new Scene(group, 800, 600);
        image = new Image(new File("src/main/resources/images/dust2.png").toURI().toURL().toExternalForm());
        PixelReader pixelReader = image.getPixelReader();
        writableImage = new WritableImage(200, 200);
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        for(int y = 50; y < 250; y++) {
            for(int x = 50; x < 250; x++) {
                Color color = pixelReader.getColor(x, y);
                pixelWriter.setColor(x-50, y-50, color);
            }
        }
        Image newImage = writableImage;
        imageView = new ImageView(newImage);
        imageView.setFitHeight(scene.getHeight());
        imageView.setFitWidth(scene.getWidth());
//        group.getChildren().add(imageView);
        group.getChildren().add(new Button("emad"));


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void luancher(){
        launch();
    }

    public static void main(String[] args) throws IOException {
        Test test = new Test();
        test.luancher();
    }
}
