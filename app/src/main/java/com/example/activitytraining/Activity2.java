package com.example.activitytraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity implements View.OnClickListener{
    Button green, blue,red;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        green = (Button)findViewById(R.id.green);
        red = (Button)findViewById(R.id.red);
        blue = (Button)findViewById(R.id.blue);

        green.setOnClickListener(this);
        red.setOnClickListener(this);
        blue.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.green:
                intent.putExtra("color", Color.GREEN);
                break;
            case R.id.blue:
                intent.putExtra("color", Color.BLUE);
                break;
            case R.id.red:
                intent.putExtra("color", Color.RED);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();

    }
}
