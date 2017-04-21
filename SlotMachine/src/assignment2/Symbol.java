/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Thushini
 */
public class Symbol implements ISymbol {

    private String imagePath;
    private int value;

    @Override
    public String getImage() {
        return this.imagePath;
    }

    @Override
    public void setImage(String image) {
        this.imagePath = image;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public void setValue(int v) {
        this.value = v;
    }

}
