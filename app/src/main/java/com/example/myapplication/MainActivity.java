package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    TextView mResultTV;
    String res,RHS,LHS,operator = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultTV = findViewById(R.id.resultTV);
    }

    public void onDigitClick(View view) {
        Button myBtn  = ((Button) view);
        String myTxt = myBtn.getText().toString();
        mResultTV.setText(myTxt);
    }

    public void onEqualClick(View view) {
        RHS = mResultTV.getText().toString();
        res = calculate(LHS,RHS,operator);
        mResultTV.setText(res);
        LHS = "";
        operator = "";
    }

    public void onOperatorClick(View view) {
        Button operatorBtn  = ((Button) view);
        if (operator.isEmpty()){
            LHS = mResultTV.getText().toString();
            operator = operatorBtn.getText().toString();
        }else {
            RHS = mResultTV.getText().toString();
            res = calculate(LHS,RHS,operator);
            LHS = res;
            operator = operatorBtn.getText().toString();


        }
        mResultTV.setText("");
    }

    public String calculate(String LHS,String RHS, String operator){
        double n1 = Double.parseDouble(LHS);
        double n2 = Double.parseDouble(RHS);
        double res = 0;
        if (operator.equals("+")){
            res = n1+n2;
        }else if (operator.equals("-")){
            res = n1-n2;
        }else if (operator.equals("*")){
            res = n1*n2;
        }else if (operator.equals("/")){
            res = n1/n2;
        }
        return res +"";

    }
}
