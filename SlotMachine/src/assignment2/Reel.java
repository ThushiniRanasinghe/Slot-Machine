/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Thushini
 */
public class Reel {

    public ArrayList<Symbol> images = new ArrayList<Symbol>();

    Reel() {

        Symbol bell = new Symbol();
        Symbol cherry = new Symbol();
        Symbol lemon = new Symbol();
        Symbol plum = new Symbol();
        Symbol redseven = new Symbol();
        Symbol watermelon = new Symbol();

        bell.setImage("Images/bell.png");
        cherry.setImage("Images/Cherry.png");
        lemon.setImage("Images/lemon.png");
        plum.setImage("Images/plum.png");
        redseven.setImage("Images/redseven.png");
        watermelon.setImage("Images/redseven.png");

        bell.setValue(6);
        cherry.setValue(2);
        lemon.setValue(3);
        plum.setValue(4);
        redseven.setValue(7);
        watermelon.setValue(5);

        images.add(bell);
        images.add(cherry);
        images.add(lemon);
        images.add(plum);
        images.add(redseven);
        images.add(watermelon);

    }

    public ArrayList spin(ArrayList random) {
        for (int i = 0; i < 6; i++) {
            Random rand = new Random();
            int r = rand.nextInt(6);
            random.add(images.get(r));
        }
        return random;
    }

}
