package ir.ac.kntu.cs2d.model.map;

import ir.ac.kntu.cs2d.model.GameSide;
import ir.ac.kntu.cs2d.model.person.Person;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileCacheImageInputStream;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Map {
    private HashMap<GameSide, Person> agents;
    private HashMap<Person, BufferedImage> image;
    private BufferedImage bufferedImage;

    public Map(){
        try {
            bufferedImage = ImageIO.read(new File("src/main/resources/images/dust2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAgent(Person person){

    }
}
