package com.example.to_do_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class viewListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        Intent intent = getIntent();
        String list = intent.getStringExtra(MainActivity.LIST);

        int temp = 0, count = 0;
        for(int i=0; i<5; i++) {
            String work = list.substring(temp, list.indexOf('|', temp));
            temp = list.indexOf('|', temp)+1;
            String checkBoxID = "checkBox" + (count+1);
            CheckBox checkbox = findViewById(getResources().getIdentifier(checkBoxID, "id", getPackageName()));
            if(work.length() != 0) {
                checkbox.setText(work);
                checkbox.setVisibility(View.VISIBLE);
                count++;
            }
        }

    }

    public void boxCheck(View view) {
        CheckBox checkbox = (CheckBox) view;
        boolean checked = checkbox.isChecked();
        if(checked) {
            checkbox.setPaintFlags(checkbox.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            checkbox.setTypeface(null, Typeface.ITALIC);
        }
        else {
            checkbox.setPaintFlags(checkbox.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            checkbox.setTypeface(null, Typeface.NORMAL);
        }
    }
}