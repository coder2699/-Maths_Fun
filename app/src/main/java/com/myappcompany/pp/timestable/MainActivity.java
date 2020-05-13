package com.myappcompany.pp.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    public void generate(int num){
        ArrayList<String> tt= new ArrayList<String>();
        for(int j=1;j<=10;j++){
            tt.add(Integer.toString(num)+"*"+Integer.toString(j)+"   = "+Integer.toString(j*num));
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tt);
        list.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar bar=findViewById(R.id.seekBar);
         list=findViewById(R.id.myList);
        int max=20;
        int startingpos=1;
        bar.setMax(max);
        bar.setProgress(startingpos);
        generate(startingpos);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int num;
                if(i<min)
                {
                    num=min;
                    bar.setProgress(min);
                }else {
                    num=i;
                }
                generate(num);
               }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
