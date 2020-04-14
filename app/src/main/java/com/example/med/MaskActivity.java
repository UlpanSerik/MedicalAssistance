package com.example.med;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MaskActivity extends AppCompatActivity {

    Spinner spinner;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mask);

        getSupportActionBar().setTitle("АДРЕСА АПТЕК");

        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);
        final String str[] = {"Астана","Алматы", "Атырау", "Актау", "Актобе", "Караганда", "Кокшетау", "Уральск", "Усть-Каменогорск", "Павлодар", "Петропавловск", "Шымкент" };
        ArrayAdapter arrayAdapter = new ArrayAdapter(MaskActivity.this, android.R.layout.simple_dropdown_item_1line, str);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                if (str[0].equals(spinner.getItemAtPosition(i).toString()))
                { imageView.setImageResource(R.drawable.astana); }
                else  if (str[1].equals(spinner.getItemAtPosition(i).toString()))
                { imageView.setImageResource(R.drawable.almaty); }
                else  if (str[2].equals(spinner.getItemAtPosition(i).toString()))
                { imageView.setImageResource(R.drawable.atyrau); }
                else  if (str[3].equals(spinner.getItemAtPosition(i).toString()))
                { imageView.setImageResource(R.drawable.aktau); }
                else  if (str[4].equals(spinner.getItemAtPosition(i).toString()))
                { imageView.setImageResource(R.drawable.aktobe); }
                else  if (str[5].equals(spinner.getItemAtPosition(i).toString()))
                { imageView.setImageResource(R.drawable.karaganda); }
                else  if (str[6].equals(spinner.getItemAtPosition(i).toString()))
                { imageView.setImageResource(R.drawable.kokshetau); }
                else  if (str[7].equals(spinner.getItemAtPosition(i).toString()))
                { imageView.setImageResource(R.drawable.uralsk); }
                else  if (str[8].equals(spinner.getItemAtPosition(i).toString()))
                { imageView.setImageResource(R.drawable.ustkaman); }
                else  if (str[9].equals(spinner.getItemAtPosition(i).toString()))
                { imageView.setImageResource(R.drawable.pavlodar); }
                else  if (str[10].equals(spinner.getItemAtPosition(i).toString()))
                { imageView.setImageResource(R.drawable.petropavl); }
                else  if (str[11].equals(spinner.getItemAtPosition(i).toString()))
                { imageView.setImageResource(R.drawable.shymkent); }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
