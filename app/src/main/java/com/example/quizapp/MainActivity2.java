package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView textView1, textView2;
    Button a, b, c, d, next;

    public static final String EXTRA = "extra";
    public static final String EXTRA2 = "extra2";
    public static final int SCORE = 12345;

//    private String[] nos = {"Question 1", "Question 2", "Question 3", "Question 4", "Question 5"};
//    private String[] questions = {"India is called Golden Bird in ancient times?", "World War I started in 1939?",
//                                  "America and Russia are friends?", "Subhash Chandra Bose is a great leader?" ,
//                                  "Pakistan is terrorist country?"};
//    private boolean[] answers = {true, false, false, true, true};
    int index = 0, score = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        a = findViewById(R.id.a);
        b= findViewById(R.id.b);
        c= findViewById(R.id.c);
        d= findViewById(R.id.d);
        next = findViewById(R.id.next);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);


        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        next.setOnClickListener(this);



        newQuestion();


//        textView1.setText(nos[index]);
//        textView2.setText(questions[index]);
//
//
//        yes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(index < questions.length){
//
//                    if(answers[index] == true){
//                        score++;
//                    }
//                    index++;
//                    if(index < questions.length){
//
//                        textView1.setText(nos[index]);
//                        textView2.setText(questions[index]);
//
//                    }
//                    else{
//
//                        next.setText("View Score");
//                        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
//                        intent.putExtra(EXTRA, score);
//                        startActivity(intent);
//                    }
//                }
//
//            }
//        });
//
//        no.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                if(index < questions.length){
//
//                    if(answers[index] == false){
//                        score++;
//                    }
//                    index++;
//                    if(index < questions.length){
//
//                        textView1.setText(nos[index]);
//                        textView2.setText(questions[index]);
//
//                    }
//                    else{
//
//                        next.setText("View Score");
//                        Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
//                        intent.putExtra(EXTRA, score);
//                        startActivity(intent);
//                    }
//                }
//
//            }
//        });



    }
    @Override
    public void onClick(View view) {

        a.setBackgroundColor(Color.WHITE);
        b.setBackgroundColor(Color.WHITE);
        c.setBackgroundColor(Color.WHITE);
        d.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;


        if (clickedButton.getId() == R.id.next) {

            if(selectedAnswer.isEmpty()) {
                Toast.makeText(this, "Please select any one option!", Toast.LENGTH_SHORT).show();
            }


            else if (selectedAnswer.equals(Queans.correctAnswers[index])) {
                score++;
            }

            index++;
            newQuestion();




        } else {
            //choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.CYAN);

        }

    }


    public void newQuestion(){



        if(index == Queans.question.length ){

            String name = getIntent().getStringExtra("EXTRA1");

//            Toast.makeText(this, score, Toast.LENGTH_SHORT).show();
            next.setText("View Score");
            Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
            intent.putExtra("EXTRA2", name);
            intent.putExtra("EXTRA", score);
            startActivity(intent);


        }


        textView1.setText(Queans.nos[index]);
        textView2.setText(Queans.question[index]);
        a.setText(Queans.choices[index][0]);
        b.setText(Queans.choices[index][1]);
        c.setText(Queans.choices[index][2]);
        d.setText(Queans.choices[index][3]);

    }

}

