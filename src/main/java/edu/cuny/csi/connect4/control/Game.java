/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuny.csi.connect4.control;

import java.util.List;
import javafx.animation.PathTransition;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import edu.cuny.csi.connect4.model.Coordinates;
import edu.cuny.csi.connect4.model.Dimen;
import edu.cuny.csi.connect4.view.Cursor;
import javafx.util.Duration;


/**
 *
 * @author yomis
 */
public final class Game {
    
    private double x1;
    private double y1;
    private Pane background;
    private StackPane stack;
    private ObservableList children;
    private Pane foreground;
    private Record record;
    private Cursor cursor;
    
    public Game(){
        this.x1 = Cursor.X;
        this.y1 = Cursor.Y;
        {
            this.background = new Pane();
            List list = this.background.getChildren();
            for(int row = 1; row < 7; row++){
                for(int column = 0; column < Dimen.COLUMN_SIZE; column++){
                    final Circle circle = new Circle(Dimen.RADIUS);
                    circle.setFill(Dimen.OPEN_SLOT_COLOR);
                    Coordinates coord = Dimen.getCoordinates(row, column);
                    circle.setCenterX(coord.getX());
                    circle.setCenterY(coord.getY());
                    list.add(circle);
                }
            }
        }
        this.stack = new StackPane();
        this.children = this.stack.getChildren();
        this.children.add(this.background);
        this.reset();
    }
    
    public final void reset(){
        if(this.children.size() > 1){
            this.children.remove(1);
        }
        this.foreground = new Pane();
        final ObservableList list = this.foreground.getChildren();
        this.record = new Record();
        this.cursor = new Cursor(this.record.nextPiece());
        {
            for(int column = 0; column < Dimen.COLUMN_SIZE; column++){
                Circle circle = new Circle(Dimen.RADIUS);
                circle.setFill(Dimen.BUTTON_COLOR);
                Coordinates coord = Dimen.getCoordinates(0, column);
                final double x2 = coord.getX();
                final double y2 = coord.getY();
                circle.setCenterX(x2);
                circle.setCenterY(y2);
                list.add(circle);
                circle.setOnMouseClicked((event) -> {
                    if(this.cursor != null){
                        final PathTransition animation = new PathTransition();
                        animation.setNode(this.cursor);
                        final Line line = new Line(this.x1, this.y1, x2, y2);
                        this.x1 = x2;
                        this.y1 = y2;
                        animation.setPath(line);
                        animation.setDuration(Duration.millis(Dimen.HORIZONTAL_DURATION));
                        animation.play();
                    }
                });
            }
        }
        list.add(this.cursor);
        this.children.add(this.foreground);
    }
    
    public final Pane getPane(){
        return this.stack;
    }
    
    
    
}
