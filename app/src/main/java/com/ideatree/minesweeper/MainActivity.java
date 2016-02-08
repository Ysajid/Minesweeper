package com.ideatree.minesweeper;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    GameUtils newGame;
    int gridSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gameGrid);


        gridSize = 8;
        newGame = new GameUtils(this, gridView, gridSize);
        gridView.setNumColumns(gridSize);
        gridView.setAdapter(new GridAdapter());
//        newGame.setGridSize(10);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(view.getVisibility() != View.GONE) {
                    if(newGame.clearField(position) == 1) Toast.makeText(MainActivity.this, "There is a bomb", Toast.LENGTH_LONG).show();
                }
            }
        });
        newGame.setupGrid();
    }


    //    int main() {
//        int check = 1;
//
//        welcomeScreen();
//        setupGrid();
//
//        while (check) {
//            printUpdatedGrid();
//            check = getAction();
//        }
//        return 0;
//    }

    public class GridAdapter extends BaseAdapter {
        final LayoutInflater inflater = getLayoutInflater();


//        DuaHolder holder;

        public GridAdapter() {
        }

        @Override
        public int getCount() {
            return gridSize*gridSize;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.grid_row, parent, false);

            } else {
                Log.d("catgetview " + position, "recycle ");
            }

            TextView view = (TextView) convertView.findViewById(R.id.gridText);
            view.setText(""+position);

            return convertView;
        }
    }

}