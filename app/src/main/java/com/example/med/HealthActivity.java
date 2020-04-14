package com.example.med;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.HashSet;

public class HealthActivity extends AppCompatActivity {
    int noteid;
    Button save;
    EditText editText;
    String st;
    TimePicker tp;
    Spinner spinner;
    ArrayList<String> selectedItems = new ArrayList<>();
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        tp = (TimePicker) findViewById(R.id.tp);
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

            }
        });
        save = (Button)findViewById(R.id.save);
        editText = (EditText)findViewById(R.id.editText);
        Intent intent = getIntent();
        noteid = intent.getIntExtra("noteid", -1);
        if (noteid != -1) {
            editText.setText(MedicineActivity.notes.get(noteid));
        } else {
            MedicineActivity.notes.add("");
            noteid = MedicineActivity.notes.size()-1;
            MedicineActivity.arrayAdapter.notifyDataSetChanged();
        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            MedicineActivity.notes.set(noteid, String.valueOf(charSequence));
            MedicineActivity.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.med", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet(MedicineActivity.notes);
                sharedPreferences.edit().putStringSet("notes", set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(HealthActivity.this, MedicineActivity.class);
                startActivity(i);
            }
        });

        ListView dni = (ListView)findViewById(R.id.nedel);
        dni.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String [] items = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.den, items);
        dni.setAdapter(adapter);
        dni.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView)view).getText().toString();
                if (selectedItems.contains(selectedItem)){
                    selectedItems.remove(selectedItem);
                } else selectedItems.add(selectedItem);
            }
        });

        getSupportActionBar().setTitle("ВРЕМЯ ПРИЕМА ЛЕКАРСТВ");
        tp = findViewById(R.id.tp);
        tp.setIs24HourView(true);
        tp.setEnabled(true);

        spinner = findViewById(R.id.spinner);
        final String str[] = {"До еды", "Во время еды", "После еды"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(HealthActivity.this, android.R.layout.simple_dropdown_item_1line, str);
        spinner.setAdapter(arrayAdapter);

    }
}
