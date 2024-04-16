package com.example.countapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int count =0;
    int step =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_increase = findViewById(R.id.increase_button);
        Button button_decrease = findViewById(R.id.Decrease_button);
        TextView step_count = findViewById(R.id.counter_view);
        EditText step_value = findViewById(R.id.number);
        button_increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count =count+ step;
                step_count.setText(String.valueOf(count));
            }
        });

        button_decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count - step >= 0){
                    count = count- step;

                    step_count.setText(String.valueOf(count));
                }
                else{
                    count = 0;
                    step_count.setText(String.valueOf(count));
                }
            }
        });

        step_value.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0){
                    step = Integer.parseInt(s.toString());
                }
                else{
                    step = 1;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
    }


    }
