package com.usu.a02268065.assign3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private ArrayList<CalcButtonData> calcButtonData = new ArrayList<CalcButtonData>() {
        {
            add(new CalcButtonData("1", 1, 0, 1));
            add(new CalcButtonData("2", 1, 1, 1));
            add(new CalcButtonData("3", 1, 2, 1));
            add(new CalcButtonData("4", 2, 0, 1));
            add(new CalcButtonData("5", 2, 1, 1));
            add(new CalcButtonData("6", 2, 2, 1));
            add(new CalcButtonData("7", 3, 0, 1));
            add(new CalcButtonData("8", 3, 1, 1));
            add(new CalcButtonData("9", 3, 2, 1));
            add(new CalcButtonData("0", 4, 0, 2));
            add(new CalcButtonData(".", 4, 2, 1));
            add(new CalcButtonData("+", 1, 3, 1, CalcButtonData.ButtonType.OPERATOR));
            add(new CalcButtonData("-", 2, 3, 1, CalcButtonData.ButtonType.OPERATOR));
            add(new CalcButtonData("*", 3, 3, 1, CalcButtonData.ButtonType.OPERATOR));
            add(new CalcButtonData("/", 4, 3, 1, CalcButtonData.ButtonType.OPERATOR));
            add(new CalcButtonData("=", 5, 2, 2, CalcButtonData.ButtonType.EQUALS));
            add(new CalcButtonData("Dump", 5, 1, 1, CalcButtonData.ButtonType.DUMP));
            add(new CalcButtonData("Undo", 5, 0, 1, CalcButtonData.ButtonType.UNDO));
            add(new CalcButtonData("C", 0, 3, 1, CalcButtonData.ButtonType.CLEAR));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stack<String> stack = new Stack<>();
        FrameLayout mainLayout = new FrameLayout(this);
        GridLayout buttonsLayout = new GridLayout(this);
        buttonsLayout.setColumnCount(4);
        AppCompatTextView textView = new AppCompatTextView(this);
        textView.setTextSize(20);
        textView.setBackgroundColor(getColor(R.color.PanelColor));
        textView.setPadding(12,12,12,12);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(0, 1, 1);
        params.columnSpec = GridLayout.spec(0, 3, 1);
        textView.setLayoutParams(params);
        buttonsLayout.addView(textView);
        mainLayout.addView(buttonsLayout);

        Popup popup = new Popup(this);
        mainLayout.addView(popup);

        for(final CalcButtonData data : calcButtonData) {
            CalcButton button = new CalcButton(this, data, view -> {
                if (data.type == CalcButtonData.ButtonType.NUMBER) {
                    String oldText = (String) textView.getText();
                    String newText = oldText + data.text;
                    textView.setText(newText);
                } else if (data.type == CalcButtonData.ButtonType.OPERATOR) {
                    String oldText = (String) textView.getText();
                    String newText = oldText + " " + data.text + " ";
                    textView.setText(newText);
                } else if (data.type == CalcButtonData.ButtonType.EQUALS) {
                    String oldText = (String) textView.getText();
                    double result = Calculator.evaluate(oldText);
                    String newText = "" + result;
                    textView.setText(newText);
                    stack.push(oldText);
                } else if (data.type == CalcButtonData.ButtonType.UNDO) {
                    if (!stack.isEmpty()) {
                        textView.setText(stack.pop());
                    }
                } else if (data.type == CalcButtonData.ButtonType.CLEAR) {
                    textView.setText("");
                } else {
                    textView.setText("");
                    popup.display(stack);
                }
            });
            buttonsLayout.addView(button);
        }



        setContentView(mainLayout);
    }
}