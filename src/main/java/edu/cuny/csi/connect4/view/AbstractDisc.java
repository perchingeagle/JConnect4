/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuny.csi.connect4.view;

import edu.cuny.csi.connect4.model.Dimen;
import javafx.scene.shape.Circle;

/**
 *
 * @author yomis
 */
public abstract class AbstractDisc extends Circle{
    
    public AbstractDisc(){
        super(Dimen.RADIUS);
    }
    
}
