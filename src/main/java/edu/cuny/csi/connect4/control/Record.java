/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cuny.csi.connect4.control;

import java.util.Arrays;
import edu.cuny.csi.connect4.model.Dimen;
import edu.cuny.csi.connect4.model.Piece;

/**
 *
 * @author yomis
 */
public class Record {
    
    private final static int EMPTY = 0;
    private final Piece[][] grid;
    private final int[] slots;
    private boolean tail;
    
    public Record(){
        this.grid = new Piece[Dimen.ROW_SIZE][Dimen.COLUMN_SIZE];
        this.slots = new int[Dimen.COLUMN_SIZE];
        Arrays.fill(this.slots, Dimen.ROW_SIZE);
    }
    
    public final boolean isAvailable(int column){
        return this.slots[column] > Record.EMPTY;
    }
    
    public final void add(Piece piece, int column) throws ArrayIndexOutOfBoundsException{
        final int row = this.slots[column];
        this.grid[row][column] = piece;
        this.slots[column] = row - 1;
    }
    
    public final Piece nextPiece(){
        // flips the value of this.tail each time the method is called
        this.tail ^= true;
        return (this.tail)? Piece.TAIL : Piece.HEAD;
    }
    
    
    
}
