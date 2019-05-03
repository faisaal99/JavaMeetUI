package com.faisal.javameetui;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

enum ColorMode {
    BLUE, YELLOW, BLACK
}

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // An int variable to hold a value
    private int value = 0;

    private ColorMode color;

    // A bunch of Buttons and a TextView
    private Button btnAdd;
    private Button btnTake;
    private TextView txtValue;
    private Button btnGrow;
    private Button btnShrink;
    private Button btnReset;
    private Button btnHide;
    private Button btnChangeColor;
    private ConstraintLayout cLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to all the buttons in our UI
        // Match them up to all our Button objects we declared earlier
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnTake = (Button) findViewById(R.id.btnTake);
        btnGrow = (Button) findViewById(R.id.btnGrow);
        btnShrink = (Button) findViewById(R.id.btnShrink);
        btnHide = (Button) findViewById(R.id.btnHide);
        btnReset = (Button) findViewById(R.id.btnReset);
        txtValue = (TextView) findViewById(R.id.txtValue);
        btnChangeColor = (Button) findViewById(R.id.btnChangeColor);
        cLayout = (ConstraintLayout) findViewById(R.id.cLayout);

        // Set the color of the TextView to black as well as the ColorMode
        txtValue.setTextColor(Color.BLACK);
        color = ColorMode.BLACK;

        // Listen to all the button clicks
        btnAdd.setOnClickListener(this);
        btnTake.setOnClickListener(this);
        btnGrow.setOnClickListener(this);
        btnShrink.setOnClickListener(this);
        btnHide.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnChangeColor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        float size;

        switch (view.getId()) {

            case R.id.btnAdd:
                value++;
                txtValue.setText("" + value);
                break;

            case R.id.btnTake:
                value--;
                txtValue.setText("" + value);
                break;

            case R.id.btnReset: // Resets everything
                value = 0;
                txtValue.setText("" + value);
                txtValue.setTextColor(Color.BLACK);
                cLayout.setBackgroundColor(Color.WHITE);
                color = ColorMode.BLACK;

                break;

            case R.id.btnGrow:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size + 1);
                break;

            case R.id.btnShrink:
                if (txtValue.getTextScaleX() != 1f) {
                    size = txtValue.getTextScaleX();
                    txtValue.setTextScaleX(size - 1);
                }
                break;

            case R.id.btnHide:
                if (txtValue.getVisibility() == View.VISIBLE) {
                    txtValue.setVisibility(View.INVISIBLE);
                    btnHide.setText("Show");
                } else {
                    txtValue.setVisibility(View.VISIBLE);
                    btnHide.setText("Hide");
                }
                break;

            case R.id.btnChangeColor:
                if (color == ColorMode.BLUE) { // Set color to yellow
                    txtValue.setTextColor(Color.parseColor("#efec40"));
                    cLayout.setBackgroundColor(Color.parseColor("#cfbce2"));
                    color = ColorMode.YELLOW;

                } else if (color == ColorMode.YELLOW) { // Set color to blue
                    txtValue.setTextColor(Color.parseColor("#719fe8"));
                    cLayout.setBackgroundColor(Color.parseColor("#bee2c8"));
                    color = ColorMode.BLUE;

                } else { // For starters, set color to yellow
                    txtValue.setTextColor(Color.parseColor("#efec40"));
                    cLayout.setBackgroundColor(Color.parseColor("#cfbce2"));
                    color = ColorMode.YELLOW;
                }

        }
    }
}
