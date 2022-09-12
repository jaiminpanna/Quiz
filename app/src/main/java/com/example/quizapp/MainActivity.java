package com.example.quizapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA1 = "extra1";
    Button button;
    ImageView imageView;
    EditText name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        name = findViewById(R.id.name);

        imageView.setClipToOutline(true);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = name.getText().toString();
//                Intent intent1 = new Intent(getApplicationContext(), MainActivity3.class);
//                intent1.putExtra("EXTRA1", s);


                if (s.matches("")) {
                    Toast.makeText(MainActivity.this, "Please Enter Your Name!", Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra("EXTRA1", s);
                    startActivity(intent);
                }


            }
        });


    }


}
