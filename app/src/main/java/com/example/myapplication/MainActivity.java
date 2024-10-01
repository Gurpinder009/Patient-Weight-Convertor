package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    public EditText edText ;
    public RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
//            getSupportActionBar().setLogo(R.mipmap.ic_launcher_round);
//            getSupportActionBar().setDisplayUseLogoEnabled(true);
//        }
//
        edText = findViewById(R.id.input_box);
        radioGroup = findViewById(R.id.radioGroup1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void convert(View view){
        if(checkInputData()){
            double result;

            double input = Double.parseDouble( edText.getText().toString());
            RadioButton selectedButton = findViewById(radioGroup.getCheckedRadioButtonId());
            if(selectedButton.getText().toString().equalsIgnoreCase("Convert pounds to kilogram")){
                result = input /2.2;
            }else{
                result = input*2.2;
            }
            LinearLayout linearLayout = findViewById(R.id.linearLayout);
            TextView resultTxtView = new TextView(MainActivity.this);

            resultTxtView.setText(String.valueOf(result));
            resultTxtView.setTextSize(34);
            resultTxtView.setTextColor(getResources().getColor(R.color.sky_blue,getTheme()));
            linearLayout.addView(resultTxtView);

            Toast.makeText(this, "GENERATED RESULT!", Toast.LENGTH_LONG).show();

        } else{
            Toast.makeText(this, "Input is Wrong", Toast.LENGTH_LONG).show();
        }

    }



    public boolean checkInputData(){
        return edText.getText().length() > 0;
    }
}