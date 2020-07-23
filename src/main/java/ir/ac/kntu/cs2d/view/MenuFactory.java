package ir.ac.kntu.cs2d.view;

import ir.ac.kntu.cs2d.control.client.ClientController;
import ir.ac.kntu.cs2d.model.GameSide;
import javafx.scene.paint.Color;

public class MenuFactory {
    private static ClientController clientController;

    public MenuFactory(ClientController clientController) {
        setClientController(clientController);
    }

    private static ClientController getClientController() {
        return clientController;
    }

    public void setClientController(ClientController clientController) {
        this.clientController = clientController;
    }

    public static class GetMenus {
        public static MenuBuilder startUp(){
            MenuBuilder menuBuilder = new MenuBuilder.Builder(20, Color.BLACK).addLabel("Play").addLabel("chooseTeam").build();
            menuBuilder.getLabels().get(1).setOnMouseClicked(event -> {
                menuBuilder.changeMenu(MenuFactory.GetMenus.teamMenu());
            });
            return menuBuilder;
        }

        public static MenuBuilder teamMenu(){
            MenuBuilder menuBuilder = new MenuBuilder.Builder(20, Color.BLACK).addLabel("CT").addLabel("Terror").build();
            for (int i = 0; i < menuBuilder.getLabels().size(); i++){
                final int k = i;
                menuBuilder.getLabels().get(i).setOnMouseClicked(event -> {
                    getClientController().agentReq(k == 0 ? GameSide.CT : GameSide.TERROR);
                    menuBuilder.changeMenu(startUp());
                });
            }

            return menuBuilder;
        }
    }
}
