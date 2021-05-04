package com.example.to_do_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String LIST = "com.example.to_do_list.LIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addList(View view) {

        Intent intent = new Intent(this, viewListActivity.class);

        EditText edittext1 = findViewById(R.id.task1);
        EditText edittext2 = findViewById(R.id.task2);
        EditText edittext3 = findViewById(R.id.task3);
        EditText edittext4 = findViewById(R.id.task4);
        EditText edittext5 = findViewById(R.id.task5);

        String list = edittext1.getText().toString() + "|" +
                      edittext2.getText().toString() + "|" +
                      edittext3.getText().toString() + "|" +
                      edittext4.getText().toString() + "|" +
                      edittext5.getText().toString() + "|";

        intent.putExtra(LIST, list);

        startActivity(intent);
    }
}