package com.ideatree.minesweeper;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by sajid on 12/19/15.
 */


public class GameUtils {

//    pos cPos = new pos(0,0);
//    public final static pos adjCells[] = {new pos(1, 0), new pos(0, 1), new pos(-1, 0), new pos(0, -1), new pos(1, 1), new pos(-1, -1), new pos(1, -1), new pos(-1, 1)};
//    int bombs = 0, flags = 0;

//    int gridSize = 10;
//    int[][] mineGrid;

    private int UP;
    private int DOWN;
    private int LEFT;
    private int RIGHT;
    private int UP_RIGHT;
    private int UP_LEFT;
    private int DOWN_RIGHT;
    private int DOWN_LEFT;


    int gridSize;
    int bombs = 0;
    GridView gridView;
    Context context;


    short mineGrid[];
    int adjCells[];

    public GameUtils(Context context, GridView gridView, int gridSize) {
        this.gridView = gridView;
        this.gridSize = gridSize;
        this.context = context;

        UP = -gridSize;
        DOWN = gridSize;
        LEFT = -1;
        RIGHT = 1;
        UP_RIGHT = -gridSize + 1;
        UP_LEFT = -gridSize - 1;
        DOWN_RIGHT = gridSize + 1;
        DOWN_LEFT = gridSize - 1;

        mineGrid = new short [gridSize * gridSize];
        adjCells = new int[] {UP, RIGHT, LEFT, DOWN, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT, 0};
    }


//    public GameGrid(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
//        mineGrid = new short[gridSize * gridSize];
    }

    public int getGridSize() {
        return gridSize;
    }

    int clearField(int pos) {
        if(mineGrid[pos] == 1) return  1;
        int adjCell;
        Log.d("position", ""+pos);
        for (int i = 0; i < 9; i++) {
            adjCell = pos + adjCells[i];
            if (adjCell >= gridSize*gridSize || adjCell < 0) continue;
            if(pos%gridSize == 0 && adjCell%gridSize == gridSize -1 || adjCell%gridSize == 0 && pos%gridSize == gridSize -1) continue;
            View v = gridView.getChildAt(adjCell);
            Log.d("adj cell", ""+adjCell);
            if(v.getVisibility() == View.GONE) continue;
            TextView textView = (TextView) v.findViewById(R.id.gridText);
//            if (gridView[adjY][adjCell] != '*') continue;
            if (mineGrid[adjCell] != 1) {
                if (mineGrid[adjCell] ==0) {
                    gridView.getChildAt(adjCell).setVisibility(View.GONE);
                    clearField(adjCell);
                }
                else{
                    textView.setText(String.valueOf(mineGrid[adjCell] - 1));
                    textView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
                }
            }
        }
        return 0;
    }

    void setupGrid() {
        Random random = new Random(System.currentTimeMillis());
//        for (int y = gridSize - 1; y >= 0; y--) {
        for (int x = 0; x < gridSize*gridSize; x++) {
            int rand = random.nextInt();
            if (rand % 5 == 0) {
                mineGrid[x] = 1;
                bombs++;
            } else if (mineGrid[x] != 1) mineGrid[x] = 0;
        }
        for (int x = 0; x < gridSize*gridSize; x++) {
            if(mineGrid[x] == 1) bombCount(x);
        }
//        for (int x = 0; x < 100; x++) {
//            Log.d("position", ""+x);
//            View v = gridView.getChildAt(x);
//            TextView textView = (TextView) v.findViewById(R.id.gridText);
//            textView.setText(String.valueOf(mineGrid[x] - 1));
//        }
//        }
    }

    void bombCount(int pos) {
        int adjCell;
        for (int i = 0; i < 8; i++) {
            adjCell = pos + adjCells[i];
            if(adjCell >= gridSize*gridSize || adjCell < 0) continue;
            if(pos%gridSize == 0 && adjCell%gridSize == gridSize -1 || adjCell%gridSize == 0 && pos%gridSize == gridSize -1) continue;
            if (mineGrid[adjCell] != 1) {
                if (mineGrid[adjCell] == 0) {
                    mineGrid[adjCell] = 2;
                } else {
                    mineGrid[adjCell]++;
                }
            }

        }
    }

//    void setFlag(int x, int y) {
//        if (gridView[y][x] == '*') {
//            gridView[y][x] = '#';
//            if (mineGrid[y][x] == 1) {
//                flags++;
//            }
//        } else if (gridView[y][x] == '#') {
//            gridView[y][x] = '*';
//            if (mineGrid[y][x] == 1) {
//                flags--;
//            }
//        }
//        if (flags == bombs) youWon();
//    }




}





//        } else if (ch == enterKey && gridView[cPos.y][cPos.x] == '*') {
//            if (mineGrid[cPos.y][cPos.x] == 1) {
//                clearScreen;
//                gameOver();
//                return 0;
//            } else if (flags == bombs) {
//                youWon();
//            } else {
//                if (mineGrid[cPos.y][cPos.x] != 0)
//                    gridView[cPos.y][cPos.x] = mineGrid[cPos.y][cPos.x] + 47;
//                else gridView[cPos.y][cPos.x] = ' ';
//            }
//            clearField(cPos.x, cPos.y);
//        } else if (ch == -32) {
//            setFlag(cPos.x, cPos.y);
//        }
//
//        clearScreen;
//        return 1;
//    }



//    void gameOver() {
//        printf("             _____ _____ _____ _____    _____ _____ _____ _____ \n");
//        printf("            |   __|  _  |     |   __|  |     |  |  |   __| __  |\n");
//        printf("            |  |  |     | | | |   __|  |  |  |  |  |   __|    -|\n");
//        printf("            |_____|__|__|_|_|_|_____|  |_____| ___/|_____|__|__|\n");
//        if (gridSize == 10) printf("\n                              ");
//        else if (gridSize == 15) printf("\n                        ");
//        else if (gridSize == 20) printf("                    ");
//        for (int i = 0; i < gridSize; i++) {
//            if (i == gridSize - 1) printf("_");
//            else printf("__");
//        }
//        printf("\n\n");
//        for (int y = gridSize - 1; y >= 0; y--) {
//            if (gridSize == 10) printf("                            | ");
//            else if (gridSize == 15) printf("                      | ");
//            else if (gridSize == 20) printf("                  | ");
//            for (int x = 0; x < gridSize; x++) {
//                if (mineGrid[y][x] == 1) {
//                    printf("o");
//                    if (cPos.x == x && cPos.y == y) printf("<");
//                    else printf(" ");
//                } else printf("  ");
//            }
//            printf("|\n");
//        }
//        if (gridSize == 10) printf("                              ");
//        else if (gridSize == 15) printf("                        ");
//        else if (gridSize == 20) printf("                    ");
//
//        for (int i = 0; i < gridSize; i++) {
//            if (i == gridSize - 1) printf("_");
//            else printf("__");
//        }
//        printf("\nWANT TO PLAY AGAIN? y/n\n");
//        char ch = getch();
//        switch (ch) {
//            case 'y':
//                clearScreen;
//                main();
//                break;
//            case 'n':
//                exit(0);
//        }
//    }
//
//    void youWon() {
//        clearScreen;
//        printf("\n\n                    YOU ARE A POFESSIONAL MINESWEEPER\n");
//        printf("            YOU HAVE SWAPED %d BOMBS OUT OF %d X %d GRID SPACE\n\n", flags, gridSize, gridSize);
//        printf("                              CONGRATULATION\n\n", flags, gridSize, gridSize);
//        printf("                  __ __ _____ _____    _ _ _ _____ _____ \n");
//        printf("                 |  |  |     |  |  |  | | | |     |   | |\n");
//        printf("                 |_   _|  |  |  |  |  | | | |  |  | | | |\n");
//        printf("                   |_| |_____|_____|  |_____|_____|_|___|\n");
//        printf("\nWANT TO PLAY AGAIN? y/n\n");
//        char ch = getch();
//        switch (ch) {
//            case 'y':
//                clearScreen;
//                main();
//                break;
//            case 'n':
//                exit(0);
//        }
//    }
//
//
//
//    void showInstruction() {
//        clearScreen;
//        printf("\n\n\n\n\n");
//        printf("            WANT TO BE A PROFESSIONAL MINESWEEPER?\n");
//        printf("            THEN FOLLOW THESE INSTRUCIONS\n\n");
//        printf("            1.MOVE USING THE CURSORS\n");
//        printf("            2.USE 'ENTER' TO CLEAN AN AREA\n");
//        printf("            3.USE 'SPACEBAR' TO FLAG A SPACE AS A MINE\n");
//        printf("            4.FLAG EVERY MINE IN THE FIELD AND YOUR JOB IS DONE\n");
//        getch();
//    }
//
//    void showHighScore() {
//        printf("highscore");
//        getch();
//    }
//
//    int difficulty() {
//        char menu[ 3][50];
//        int temp, nowAt = 0;
//
//        while (nowAt + 1) {
//            strcpy(menu[0], " EASY");
//            strcpy(menu[1], " MEDIUM");
//            strcpy(menu[2], " HARD");
//
//            printf("\n\n\n\n\n\n\n\n");
//            menu[nowAt][0] = '>';
//            printf("                                %s\n                                %s\n                                %s\n", menu[0], menu[1], menu[2]);
//            char ch = -getch();
//            if (ch == downArrow) {
//                if (nowAt != 2) nowAt++;
//            } else if (ch == upArrow) {
//                if (nowAt != 0) nowAt--;
//            } else if (ch == enterKey) {
//                if (nowAt == 0) {
//                    temp = 10;
//                    nowAt = -1;
//                } else if (nowAt == 1) {
//                    temp = 15;
//                    nowAt = -1;
//                } else if (nowAt == 2) {
//                    temp = 20;
//                    nowAt = -1;
//                }
//            }
//            clearScreen;
//        }
//        return temp;
//    }
//
//    void welcomeScreen() {
//
//
//        char menu[ 3][50];
//        int nowAt = 0;
//
//        while (nowAt + 1) {
//            strcpy(menu[0], " START GAME");
//            strcpy(menu[1], " INSTRUCTIONS");
//
//            printf("\n\n");
//            printf("        _____ _____ _____ _____ _____ _ _ _ _____ _____ _____ _____ _____ \n");
//            printf("       |     |     |   | |   __|   __| | | |   __|   __|  _  |   __| __  |\n");
//            printf("       | | | |-   -| | | |   __|__   | | | |   __|   __|   __|   __|    -|\n");
//            printf("       |_|_|_|_____|_|___|_____|_____|_____|_____|_____|__|  |_____|__|__|\n\n\n");
//            menu[nowAt][0] = '>';
//            printf("                                %s\n                                %s\n", menu[0], menu[1]);
//            char ch = -getch();
//            if (ch == downArrow) {
//                if (nowAt != 1) nowAt++;
//            } else if (ch == upArrow) {
//                if (nowAt != 0) nowAt--;
//            } else if (ch == enterKey) {
//                if (nowAt == 0) {
//                    system("clear");
//                    gridSize = difficulty();
//                    nowAt = -1;
//                } else if (nowAt == 1) {
//                    showInstruction();
//                } else if (nowAt == 2) {
//                    showHighScore();
//                }
//            }
//            clearScreen;
//        }
//
//    }
