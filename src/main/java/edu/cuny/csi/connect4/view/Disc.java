/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuny.csi.connect4.view;

import javafx.scene.shape.Circle;
import edu.cuny.csi.connect4.model.Coordinates;
import edu.cuny.csi.connect4.model.Dimen;

/**
 *
 * @author yomis
 */
public class Disc extends AbstractDisc{
    
    public Disc(final int row, final int column){
        super();
        this.setFill(Dimen.OPEN_SLOT_COLOR);
        Coordinates coord = Dimen.getCoordinates(row, column);
        this.setCenterX(coord.getX());
        this.setCenterY(coord.getY());
    }
    
    public Disc(double x, double y){
        super();
        this.setCenterX(x);
        this.setCenterY(y);
    }
    
}
