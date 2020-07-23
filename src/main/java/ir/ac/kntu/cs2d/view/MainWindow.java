package ir.ac.kntu.cs2d.view;

import ir.ac.kntu.cs2d.control.client.ClientController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application {
    private Scene scene;
    private Group root;
    private ClientController clientController;
    private MenuFactory menuFactory;

    @Override
    public void init() throws Exception {
        super.init();
        setRoot(new Group());
        setScene(new Scene(root, 800, 600));
        setClientController(new ClientController());
        setMenuFactory(new MenuFactory(getClientController()));
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(getScene());
        stage.setTitle("CS2D");
        changeRoot(MenuFactory.GetMenus.startUp().getRoot());
        stage.show();
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Group getRoot() {
        return new Group(root.getChildren());
    }

    public void setRoot(Group root) {
        this.root = root;
    }

    public void changeRoot(Group root){
        this.root.getChildren().removeAll(this.root.getChildren());
        this.root.getChildren().addAll(root);
    }

    public static void main(String[] args) throws InterruptedException{
        MainWindow.launch();
    }

    public ClientController getClientController() {
        return clientController;
    }

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    public MenuFactory getMenuFactory() {
        return menuFactory;
    }

    public void setMenuFactory(MenuFactory menuFactory) {
        this.menuFactory = menuFactory;
    }
}
