package com.example.med;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class MedicineActivity extends AppCompatActivity {

    static ArrayList<String> notes = new ArrayList<>();
    static ArrayAdapter arrayAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.add_note) {
            Intent intent = new Intent(getApplicationContext(), HealthActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        getSupportActionBar().setTitle("ВРЕМЯ ПРИЕМА ЛЕКАРСТВ");

        ListView listView = findViewById(R.id.listView);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.med", Context.MODE_PRIVATE);
        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("notes", null);

        if (set == null) {
            notes.add("");
        } else {
            notes = new ArrayList(set);
        }
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), HealthActivity.class);
                intent.putExtra("noteid", i);
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int i, long l) {
                new AlertDialog.Builder(MedicineActivity.this).setMessage("Вы действительно хотите удалить?").setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        notes.remove(i);
                        arrayAdapter.notifyDataSetChanged();

                        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.med", Context.MODE_PRIVATE);
                        HashSet<String> set = new HashSet(MedicineActivity.notes);
                        sharedPreferences.edit().putStringSet("notes", set).apply();
                    }
                }).setNegativeButton("Нет", null).show();

                return true;
            }
        });


    }
}
