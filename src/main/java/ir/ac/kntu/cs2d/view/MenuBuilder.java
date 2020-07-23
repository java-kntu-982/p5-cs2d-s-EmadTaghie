package ir.ac.kntu.cs2d.view;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class MenuBuilder {
    private List<Label> labels;
    private Group root;

    public static class Builder {
        private List<Label> labels;
        private Group root;
        private double yPos;

        private final double sideGap;
        private final int fontSize;
        private final Color fontColor;
        private final Color underLineColor;

        public Builder(int fontSize, Color fontColor){
            labels = new ArrayList<>();
            root = new Group();
            sideGap = 20 + fontSize;
            yPos = sideGap;
            this.fontSize = fontSize;
            this.fontColor = fontColor;
            underLineColor = Color.BLUE;
        }

        public Builder addLabel(String text) {
            Label label = makeLabel(text);
            Line line = makeUnderLine(label);
            root.getChildren().add(line);
            labels.add(label);
            yPos += sideGap;
            return this;
        }

        private Line makeUnderLine(Label label) {
            Line line = new Line(sideGap, yPos + 2*sideGap/3, 4*sideGap, yPos + 2*sideGap/3);
            line.setFill(underLineColor);
            line.setStroke(underLineColor);
            line.setVisible(false);
            label.setOnMouseEntered(event -> {
                line.setVisible(true);
            });
            label.setOnMouseExited(event -> {
                line.setVisible(false);
            });
            return line;
        }

        private Label makeLabel(String text) {
            Label label = new Label(text);
            label.setTranslateX(sideGap);
            label.setTranslateY(yPos);
            label.setTextFill(fontColor);
            label.setFont(Font.font(fontSize));
            return label;
        }

        public MenuBuilder build(){
            root.getChildren().addAll(labels);
            return new MenuBuilder(this);
        }
    }

    public MenuBuilder(Builder builder){
        this.labels = builder.labels;
        this.root = builder.root;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public Group getRoot() {
        return root;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public void setRoot(Group root) {
        this.root.getChildren().setAll(root);
    }

    public void changeMenu(MenuBuilder menuBuilder) {
        setRoot(menuBuilder.getRoot());
        setLabels(menuBuilder.getLabels());
    }
}
