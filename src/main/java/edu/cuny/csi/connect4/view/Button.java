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
public class Button extends AbstractDisc{
    
    public final int row;
    public final int column;
    public final double x2;
    public final double y2;
    
    public Button(final int column){
        super();
        this.setFill(Dimen.BUTTON_COLOR);
        this.row = 0;
        this.column = column;
        Coordinates coord = Dimen.getCoordinates(this.row, column);
        this.x2 = coord.getX();
        this.y2 = coord.getY();
        this.setCenterX(this.x2);
        this.setCenterY(this.y2);
    }
    
}
