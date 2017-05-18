package com.sardinecorp.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    private int[] mCurrentQuestion;
    private RadioButton mCorrectChoice;

    @BindView(R.id.textLeftAdder) TextView mLeftAdder;
    @BindView(R.id.textSign) TextView mSign;
    @BindView(R.id.textRightAdder) TextView mRightAdder;
    @BindView(R.id.radioGroup) RadioGroup mOptions;
    @BindView(R.id.radioOption1) RadioButton mOption1;
    @BindView(R.id.radioOption2) RadioButton mOption2;
    @BindView(R.id.radioOption3) RadioButton mOption3;
    @BindView(R.id.buttonSubmit) Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSign.setText("+");

        createNewQuestion();

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mOption1.isChecked() && !mOption2.isChecked() && !mOption3.isChecked()) {
                    Toast.makeText(MainActivity.this, "Please Select An Answer", Toast.LENGTH_SHORT).show();
                } else {
                    if (mCorrectChoice.isChecked()) {
                        Toast.makeText(MainActivity.this, "Correct!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                    }
                    createNewQuestion();
                }
            }
        });


    }

    private void createNewQuestion() {

        mOptions.clearCheck();

        int[] question = Question.getQuestion();

        mLeftAdder.setText(""+question[0]);
        mRightAdder.setText(""+question[1]);

        List<Integer> options = new ArrayList<>();
        options.add(question[2]);
        options.add(question[3]);
        options.add(question[4]);
        Collections.shuffle(options);

        setNumbers(mOption1, options, question);
        setNumbers(mOption2, options, question);
        setNumbers(mOption3, options, question);
    }

    private void setNumbers(RadioButton rb, List<Integer> options, int[] question) {
        int num = options.get(0);
        rb.setText(""+num);
        if (num == question[2]) {
            mCorrectChoice = rb;
        }
        options.remove(0);
    }
}
