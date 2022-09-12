package com.example.quizapp;

import static com.example.quizapp.MainActivity.EXTRA1;
import static com.example.quizapp.MainActivity2.EXTRA;
import static com.example.quizapp.MainActivity2.SCORE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView textView5,textView4;
    Button share, restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textView5 = findViewById(R.id.textView5);
        textView4 = findViewById(R.id.textView4);
        share = findViewById(R.id.share);
        restart = findViewById(R.id.restart);


        String name = getIntent().getStringExtra("EXTRA2");
        textView4.setText("Congratulations, "+ name);

        int score = getIntent().getIntExtra("EXTRA", SCORE);
        textView5.setText(score +  " / "  + Queans.question.length);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "\nI got marks "+score+" out of 5 in History Quiz Application\n"+"\nYou can also try...\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}