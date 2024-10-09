package com.example.lifegreenproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private TextView textQuestion;
    private RadioGroup radioGroup;
    private RadioButton radioOption1, radioOption2, radioOption3, radioOption4;
    private int currentQuestionIndex = 0;

    private String[] questions = {
            "Question 1: Which of the following is a renewable energy source?",
            "Question 2: What can be recycled?",
            "Question 3: Which practice contributes to a greener environment?",
            "Question 4: How long does it take for a plastic bottle to decompose?",
            "Question 5: Which gas is most responsible for global warming?",
            "Question 6: What is composting?",
            "Question 7: Which material is biodegradable?",
            "Question 8: What is the primary benefit of recycling?",
            "Question 9: What is upcycling?",
            "Question 10: How can individuals reduce their carbon footprint?"
    };

    private String[][] options = {
            {"Solar energy", "Coal", "Oil", "Natural gas"},
            {"Glass", "Plastic", "Paper", "All of the above"},
            {"Using public transport", "Throwing away food", "Wasting water", "Using single-use plastics"},
            {"10 years", "50 years", "450 years", "1000 years"},
            {"Carbon dioxide", "Oxygen", "Helium", "Nitrogen"},
            {"The process of turning organic waste into fertilizer", "A type of plastic", "A new form of energy", "The process of recycling metals"},
            {"Plastic", "Glass", "Paper", "Styrofoam"},
            {"Reducing waste", "Conserving natural resources", "Saving energy", "All of the above"},
            {"The process of turning waste materials into new products of better quality", "A method of disposal", "A way to burn waste", "A type of recycling plant"},
            {"Walking or cycling", "Using plastic bags", "Driving a large SUV", "Using disposable products"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textQuestion = findViewById(R.id.text_question);
        radioGroup = findViewById(R.id.radio_group);
        radioOption1 = findViewById(R.id.radio_option1);
        radioOption2 = findViewById(R.id.radio_option2);
        radioOption3 = findViewById(R.id.radio_option3);
        radioOption4 = findViewById(R.id.radio_option4);

        loadQuestion();
    }

    public void goHome(View view) {
        Intent intent = new Intent(QuizActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void goBack(View view) {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            loadQuestion();
        } else {
            Toast.makeText(this, "You are at the first question!", Toast.LENGTH_SHORT).show();
        }
    }

    public void nextQuestion(View view) {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select an answer!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (currentQuestionIndex < questions.length - 1) {
            currentQuestionIndex++;
            loadQuestion();
        } else {
            Toast.makeText(this, "You have reached the end of the quiz!", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadQuestion() {
        if (currentQuestionIndex < questions.length) {
            textQuestion.setText(questions[currentQuestionIndex]);
            radioOption1.setText(options[currentQuestionIndex][0]);
            radioOption2.setText(options[currentQuestionIndex][1]);
            radioOption3.setText(options[currentQuestionIndex][2]);
            radioOption4.setText(options[currentQuestionIndex][3]);
            radioGroup.clearCheck();
        }
    }
}
