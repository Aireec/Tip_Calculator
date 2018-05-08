package com.example.user.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Billa;
    private TextView TipPercentage;
    private SeekBar percentage;
    private Button Calculate;
    private TextView result;
    private  int Tip;
    private Float EnteredBill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Billa = (EditText) findViewById(R.id.BillAmountid);
        TipPercentage = (TextView) findViewById(R.id.tipPercentageid);
        percentage = (SeekBar) findViewById(R.id.PercentageSB);

        percentage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TipPercentage.setText(String.valueOf(percentage.getProgress()) + " % ");
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Tip = percentage.getProgress();

            }
        });
        result = (TextView) findViewById(R.id.Resultid);
        Calculate = (Button) findViewById(R.id.CalculateBtn);
        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();

            }
        });}

        public void calculate() {
        float resultf = 0.0f;
            if(!Billa.getText().toString().equals("")) {
                EnteredBill = Float.parseFloat(Billa.getText().toString());
                resultf = EnteredBill * Tip / 100;
                result.setText("Your tip will be R" + String.valueOf(resultf) + "\n" +
                "Your total bill will be R " + String.valueOf(EnteredBill + resultf));
            }else {
                Toast.makeText(MainActivity.this, "Please enter a valid amount", Toast.LENGTH_LONG).show();
            }
    }

    }

