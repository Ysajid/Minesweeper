//package com.ideatree.minesweeper;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.widget.GridView;
//import com.ideatree.minesweeper.GameUtils;
//
//import java.util.Random;
//
///**
// * Created by sajid on 1/20/16.
// */
//
//
//public class GameGrid extends GridView {
//
//    int gridSize;
//    int bombs = 0;
//
//    private final int UP = -gridSize;
//    private final int DOWN = gridSize;
//    private final int LEFT = -1;
//    private final int RIGHT = 1;
//    private final int UP_RIGHT = -gridSize + 1;
//    private final int UP_LEFT = -gridSize - 1;
//    private final int DOWN_RIGHT = gridSize + 1;
//    private final int DOWN_LEFT = gridSize - 1;
//
//
//    short mineGrid[] = new short[gridSize];
//    int adjCells[] = {UP, RIGHT, LEFT, DOWN, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT};
//
//    public GameGrid(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    public void setGridSize(int gridSize) {
//        this.gridSize = gridSize;
//    }
//
//    public int getGridSize() {
//        return gridSize;
//    }
//
//    void clearField(int pos) {
//        int adjCell;
//        for (int i = 0; i < 8; i++) {
//            adjCell = pos + adjCells[i];
//            if (adjCell >= gridSize*gridSize || adjCell < 0) continue;
////            if (gridView[adjY][adjCell] != '*') continue;
//            if (mineGrid[adjCell] != 1) {
//                if (mineGrid[adjCell] != 0) {
////                    gridView[adjY][adjCell] = mineGrid[adjY][adjCell] + 47;
////                    this.getChildAt(pos).animate();
//                    continue;
//                } else this.getChildAt(pos).setVisibility(GONE);
//            } else continue;
//            clearField(adjCell);
//        }
//    }
//
//    void setupGrid() {
//        Random random = new Random(System.currentTimeMillis());
////        for (int y = gridSize - 1; y >= 0; y--) {
//        for (int x = 0; x < gridSize*gridSize; x++) {
//            int rand = random.nextInt();
//            if (rand % 5 == 0) {
//                mineGrid[x] = 1;
//                bombCount(x);
//                bombs++;
//            } else if (mineGrid[x] != 1) mineGrid[x] = 0;
//        }
////        }
//    }
//
//    void bombCount(int pos) {
//        int adjCell;
//        for (int i = 0; i < 8; i++) {
//            adjCell = pos + adjCells[i];
//            if (pos >= gridSize*gridSize || pos < 0) continue;
//            if (mineGrid[adjCell] == 1) {
//                continue;
//            }
//            if (mineGrid[adjCell] == 0) {
//                mineGrid[adjCell] = 2;
//            } else {
//                mineGrid[adjCell]++;
//            }
////
////            for (int Y = gridSize - 1; Y >= 0; Y--) {
////                for (int X = 0; X < gridSize; X++) {
////                }
////            }
//        }
//    }
//
////    void setFlag(int x, int y) {
////        if (gridView[y][x] == '*') {
////            gridView[y][x] = '#';
////            if (mineGrid[y][x] == 1) {
////                flags++;
////            }
////        } else if (gridView[y][x] == '#') {
////            gridView[y][x] = '*';
////            if (mineGrid[y][x] == 1) {
////                flags--;
////            }
////        }
////        if (flags == bombs) youWon();
////    }
//
//
//
//
//}
