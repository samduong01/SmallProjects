package main;


/**
 * Created by sam on 10/17/17.
 */
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resources {
    public static BufferedImage player1, player1b, crosshair, Beaker, OffFoset, OnFoset;

    public static void load(){
        crosshair = loadImage("crosshair.png");
        Beaker = loadImage("Beaker.png");
        OffFoset = loadImage("OffFoset.png");
        OnFoset = loadImage("OnFoset.png");
    }

    private static BufferedImage loadImage(String filename){
        BufferedImage img = null;
        try {
            img = ImageIO.read(Resources.class.getResourceAsStream("/resources/" + filename));
        }catch (IOException e){
            System.out.println("Error while reading: " + filename);
            e.printStackTrace();
        }
        return img;
    }
}
