package minesweepercopy;

import java.util.ArrayList;
import java.util.Random;

public class Minesweeper {
    private ArrayList<String> usedSquares;
    private int[][] table;

    private int widht;
    private int height;

    public Minesweeper(int x, int y, double chance) {
        this.usedSquares = new ArrayList<>();
        this.widht = x;
        this.height = y;
        this.table = new int[height][widht];

        setValues(chance);
    }

    private void setValues(double chance) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < widht; j++) {
                int value = 0;
                if (new Random().nextDouble() < chance) {
                    value = -1;
                }
                table[i][j] = value;
            }
        }
    }

    public int getWidht() {
        return widht;
    }

    public int getHeight() {
        return height;
    }

    public int getValue(int x, int y) {
        return table[y][x];
    }
    
    public int calculateValue(int y, int x) {
        int surroundingBombs = 0;
        
        for (int y1 = -1; y1 <= 1; y1++) {
            for (int x1 = -1; x1 <= 1; x1++) {
                int spotX = x + x1;
                int spotY = y + y1;
                
                if (spotX < 0 || spotX >= widht) {
                    continue;
                }
                
                if (spotY < 0 ||spotY >= height) {
                    continue;
                }
                
                if (table[spotY][spotX] == -1) {
                    surroundingBombs++;
                }
            }
        }
        
        return surroundingBombs;
    }
    
    public ArrayList<String> getSurroundingSquares(int y, int x) {
        ArrayList<String> arr = new ArrayList<>();
        
        for (int y1 = -1; y1 <= 1; y1++) {
            for (int x1 = -1; x1 <= 1; x1++) {
                int spotX = x + x1;
                int spotY = y + y1;
                
                if (spotX < 0 || spotX >= widht) {
                    continue;
                }
                
                if (spotY < 0 ||spotY >= height) {
                    continue;
                }
                
               // if (table[spotY][spotX] == -1) {
                    arr.add(spotY + ":" + spotX);
//                }
            }
        }
        
        return arr;
    }
    
    public void addToUsedSquares(String square) {
        usedSquares.add(square);
    }

    public ArrayList<String> getUsedSquares() {
        return usedSquares;
    }    
}
