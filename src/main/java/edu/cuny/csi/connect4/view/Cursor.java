/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuny.csi.connect4.view;

import edu.cuny.csi.connect4.model.Coordinates;
import edu.cuny.csi.connect4.model.Dimen;
import edu.cuny.csi.connect4.model.Piece;

/**
 *
 * @author yomis
 */
public class Cursor extends Disc{
    
    public final static double X;
    public final static double Y;
    private final Piece piece;
    private int column;
    
    static{
        Coordinates coord = Dimen.getCoordinates(0, 0);
        X = coord.getX();
        Y = coord.getY();
    }
    
    public Cursor(final Piece piece){
        super(Cursor.X, Cursor.Y);
        this.piece = piece;
        switch(this.piece){
            case HEAD:
                this.setFill(Dimen.HEAD_COLOR);
                break;
            case TAIL:
                this.setFill(Dimen.TAIL_COLOR);
                break;
        }
        this.column = 0;
    }
    
    public final Piece getPiece(){
        return this.piece;
    }
    
    public final void setColumn(int column){
        this.column = column;
    }
    
    public final int getColumn(){
        return this.column;
    }
    
}
