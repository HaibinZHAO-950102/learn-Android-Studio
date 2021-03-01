package com.example.uidemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3;
    TextView textView;
    ProgressBar progressBar;
    SeekBar seekBar;
    EditText editText;
    RadioGroup radioGroup;
    ImageView imageView;
    CheckBox box1, box2, box3;
    RatingBar ratingBar;
    String Haibin = "", Mengfan = "", SS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        progressBar = findViewById(R.id.progressBar3);
        editText = findViewById(R.id.editTextNumber);
        radioGroup = findViewById(R.id.radiogroup);
        imageView = findViewById(R.id.imageView);
        box1 = findViewById(R.id.checkBox4);
        box2 = findViewById(R.id.checkBox5);
        box3 = findViewById(R.id.checkBox6);
        ratingBar = findViewById(R.id.ratingBar);
        seekBar = findViewById(R.id.seekBar);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Haibin");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Mengfan");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String percent = editText.getText().toString();
                if (TextUtils.isEmpty(percent)) {
                    percent = "0";
                }
                progressBar.setProgress(Integer.valueOf(percent));
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton2){
                    imageView.setImageResource(R.drawable.google);
                }
                else {
                    imageView.setImageResource(R.drawable.ins);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        box1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Haibin = "Haibin, ";
                }
                else {
                    Haibin = "";
                }
                textView.setText(Haibin + Mengfan + SS);
            }
        });

        box2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Mengfan = "Mengfan, ";
                }
                else {
                    Mengfan = "";
                }
                textView.setText(Haibin + Mengfan + SS);
            }
        });

        box3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SS = "SS";
                }
                else {
                    SS = "";
                }
                textView.setText(Haibin + Mengfan + SS);
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(), String.valueOf(rating),Toast.LENGTH_SHORT).show();
            }
        });
    }
}