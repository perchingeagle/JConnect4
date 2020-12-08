/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuny.csi.connect4.model;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author yomis
 */
public class Dimen {
    
    public final static double RADIUS = 25.0; // value must not be changed
        
    public final static double PADDING_TOP = 0.0;
    public final static double PADDING_LEFT = 25.0;
    
    public final static Paint OPEN_SLOT_COLOR = Color.LAVENDER;
    public final static Paint BUTTON_COLOR = Color.BEIGE;
    public final static Paint HEAD_COLOR = Color.BLUE;
    public final static Paint TAIL_COLOR = Color.GREEN;
    
    public final static double HORIZONTAL_DURATION = 100.0;
    public final static double VERTICAL_DURATION = 100.0;
        
    public final static int ROW_SIZE = 6;
    public final static int COLUMN_SIZE = 7;
    
    public final static double[][] pointX = {
    {30.0, 90.0, 150.0, 210.0, 270.0, 330.0, 390.0},
    {30.0, 90.0, 150.0, 210.0, 270.0, 330.0, 390.0},
    {30.0, 90.0, 150.0, 210.0, 270.0, 330.0, 390.0},
    {30.0, 90.0, 150.0, 210.0, 270.0, 330.0, 390.0},
    {30.0, 90.0, 150.0, 210.0, 270.0, 330.0, 390.0},
    {30.0, 90.0, 150.0, 210.0, 270.0, 330.0, 390.0},
    {30.0, 90.0, 150.0, 210.0, 270.0, 330.0, 390.0}
    };
    
    public final static double [][] pointY = {
    {30.0, 30.0, 30.0, 30.0, 30.0, 30.0, 30.0},
    {90.0, 90.0, 90.0, 90.0, 90.0, 90.0, 90.0},
    {150.0, 150.0, 150.0, 150.0, 150.0, 150.0, 150.0},
    {210.0, 210.0, 210.0, 210.0, 210.0, 210.0, 210.0},
    {270.0, 270.0, 270.0, 270.0, 270.0, 270.0, 270.0},
    {330.0, 330.0, 330.0, 330.0, 330.0, 330.0, 330.0},
    {390.0, 390.0, 390.0, 390.0, 390.0, 390.0, 390.0}
    };
    
    
    public static Coordinates getCoordinates(final int row, final int column){
        if(row > 6 || column > 6) return null;
        double x = pointX[row][column];
        x += Dimen.PADDING_LEFT;  // column
        double y = pointY[row][column];
        y += Dimen.PADDING_TOP;  // row
        return new Coordinates(x , y);
    }
    
    private Dimen(){}
}
