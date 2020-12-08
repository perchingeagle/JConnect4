/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuny.csi.connect4.control;

import java.util.List;
import javafx.animation.PathTransition;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
//import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import edu.cuny.csi.connect4.model.Coordinates;
import edu.cuny.csi.connect4.model.Dimen;
import edu.cuny.csi.connect4.model.Piece;
import edu.cuny.csi.connect4.view.Button;
import edu.cuny.csi.connect4.view.Cursor;
import edu.cuny.csi.connect4.view.Disc;



/**
 *
 * @author yomis
 */
public final class Game {
    
    private int cursorColumn;
    private double x1;
    private double y1;
    private final Pane background;
    private final StackPane stack;
    private final ObservableList children;
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
                    final Disc circle = new Disc(row, column);
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
        this.cursor = this.nextCursor();
        {
            for(int column = 0; column < Dimen.COLUMN_SIZE; column++){
                final Button button = new Button(column);
                list.add(button);
                button.setOnMouseClicked((event) -> {
                    if(true){
                    //if((this.cursor != null) && (this.x1 != x2)){
                        final PathTransition animation = new PathTransition();
                        animation.setNode(this.cursor);
                        final Line line = new Line(this.x1, this.y1, button.x2, button.y2);
                        this.x1 = button.x2;
                        this.y1 = button.y2;
                        this.cursorColumn = button.column;
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
    
    private Cursor nextCursor(){
        var list = this.foreground.getChildren();
        final Piece piece = this.record.nextPiece();
        final Cursor node = new Cursor(piece);
        EventHandler<MouseEvent> handler = (event) -> {
            final int column = this.cursorColumn;
            final int row = record.add(piece, column);
            if(row != 0){
                final PathTransition animation = new PathTransition();
                animation.setNode(this.cursor);
                Coordinates end = Dimen.getCoordinates(row, column);
                final Line line = new Line(this.x1, this.y1, end.getX(), end.getY());
                String data = String.format("row = %d , column = %d", row, column);
                System.out.println(data);
                animation.setPath(line);
                animation.setDuration(Duration.millis(Dimen.VERTICAL_DURATION));
                animation.setOnFinished((eh) -> {
                    var h = this.cursor.getOnMouseClicked();
                    this.cursor.removeEventHandler(MouseEvent.MOUSE_CLICKED, h);
                    this.cursor = null;
                    this.cursor = nextCursor();
                    list.add(this.cursor);
                    this.cursorColumn = 0;
                });
                animation.play();
            }
           // 
        };
        node.setOnMouseClicked(handler);
        return node;
    }
    
    public final Pane getPane(){
        return this.stack;
    }
    
    
    
}
