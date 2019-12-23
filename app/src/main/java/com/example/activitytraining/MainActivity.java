package com.example.activitytraining;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final int REQUEST_CODE_COLOR = 1;
    final int REQUEST_CODE_ALIG = 2;


    TextView textView;
    Button btnColor, btnAlig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        btnColor = (Button)findViewById(R.id.btnColor);
        btnAlig = (Button)findViewById(R.id.btnAlig);

        btnColor.setOnClickListener(this);
        btnAlig.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnColor:
                intent = new Intent(this, Activity2.class);
                startActivityForResult(intent,REQUEST_CODE_COLOR);
                break;
            case R.id.btnAlig:
                intent = new Intent(this, Activity3.class);
                startActivityForResult (intent, REQUEST_CODE_ALIG);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            switch (requestCode){
                case REQUEST_CODE_COLOR:
                    int color = data.getIntExtra("color",Color.WHITE);
                    textView.setTextColor(color);
                    break;
                case  REQUEST_CODE_ALIG:
                    int alignment = data.getIntExtra("alignment", Gravity.LEFT);
                    textView.setGravity(alignment);
                    break;

            }
        }else {
            Toast.makeText(this, "something gone wrong", Toast.LENGTH_SHORT).show();
        }
    }
}
