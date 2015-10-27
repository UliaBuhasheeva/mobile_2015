package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MyActivity extends Activity implements View.OnClickListener {

    private EditText textField;

    private int x;
    private int op = 1;
    private boolean opSelected = false;
    private boolean resetNumber = true;
    private boolean opNeeded = false;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);

        this.textField = (EditText) this.findViewById(R.id.editText);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String text = this.getText();
        int d;
        try {
            d = Integer.parseInt(text);
        } catch (NumberFormatException exc) {
            d = 0;
        }

        switch (id) {
            case R.id.button0:
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
                Button button = (Button) this.findViewById(id);
                String buttonText = button.getText().toString();
                if (this.resetNumber || d == 0) {
                    this.setText(buttonText);
                } else {
                    this.setText(text + buttonText);
                }
                this.opSelected = false;
                this.resetNumber = false;
                break;

            case R.id.buttonC:
                this.clear();
                this.setText("0");
                break;

            case R.id.buttonEqual: // равно
                if (this.check(d)) {
                    this.setText("ERROR!");
                } else {
                    this.doOperation(d);
                    this.setText(String.valueOf(this.x));
                }
                // сброс
                this.clear();
                break;

            case R.id.buttonPlus:
                if (this.check(d)) {
                    this.setText("ERROR!");
                    this.clear();
                } else {
                    if (this.opSelected) {
                        this.op = 1;
                        this.opNeeded = true;
                    } else {
                        this.doOperation(d);
                        this.op = 1;
                        if (this.opNeeded) {
                            this.setText(String.valueOf(this.x));
                        }
                        this.opNeeded = true;
                        this.resetNumber = true;
                        this.opSelected = true;
                    }
                }
                break;

            case R.id.buttonMinus:
                if (this.check(d)) {
                    this.setText("ERROR!");
                    this.clear();
                } else {
                    if (this.opSelected) {
                        this.op = 2;
                        this.opNeeded = true;
                    } else {
                        this.doOperation(d);
                        this.op = 2;
                        if (this.opNeeded) {
                            this.setText(String.valueOf(this.x));
                        }
                        this.opNeeded = true;
                        this.resetNumber = true;
                        this.opSelected = true;
                    }
                }
                break;

            case R.id.buttonMult:
                if (this.check(d)) {
                    this.setText("ERROR!");
                    this.clear();
                } else {
                    if (this.opSelected) {
                        this.op = 3;
                        this.opNeeded = true;
                    } else {
                        this.doOperation(d);
                        this.op = 3;
                        if (this.opNeeded) {
                            this.setText(String.valueOf(this.x));
                        }
                        this.opNeeded = true;
                        this.resetNumber = true;
                        this.opSelected = true;
                    }
                }
                break;

            case R.id.buttonDiv:
                if (this.check(d)) {
                    this.setText("ERROR!");
                    this.clear();
                } else {
                    if (this.opSelected) {
                        this.op = 4;
                        this.opNeeded = true;
                    } else {
                        this.doOperation(d);
                        this.op = 4;
                        if (this.opNeeded) {
                            this.setText(String.valueOf(this.x));
                        }
                        this.opNeeded = true;
                        this.resetNumber = true;
                        this.opSelected = true;
                    }
                }
                break;
        }
    }

    private boolean check(double d) {
        return this.op == 4 && d == 0;
    }

    private void doOperation(int d) {
        if (this.op == 1) {
            this.x += d;
        } else if (this.op == 2) {
            this.x -= d;
        } else if (this.op == 3) {
            this.x *= d;
        } else if (this.op == 4) {
            this.x /= d;
        }
    }

    private void clear() {
        this.x = 0;
        this.op = 1;
        this.opSelected = false;
        this.opNeeded = false;
        this.resetNumber = true;
    }

    private String getText() {
        return this.textField.getText().toString();
    }

    private void setText(String text) {
        this.textField.setText(text);
    }
}
