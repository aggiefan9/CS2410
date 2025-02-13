package com.usu.a02268065.assign3;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import java.util.Stack;

public class Popup extends LinearLayout {
    boolean isOpen = false;
    private LinearLayout content;

    public Popup(Context context) {
        super(context);
        setOrientation(VERTICAL);
        setBackgroundColor(Color.argb(0.5f, 0, 0, 0));
        setVisibility(INVISIBLE);
        setPadding(48,48,48,48);
        setGravity(Gravity.CENTER);

        setOnClickListener(view -> {
            close();
        });

        LinearLayout wrapper = new LinearLayout(context);
        wrapper.setOrientation(VERTICAL);
        wrapper.setBackgroundColor(Color.WHITE);
        wrapper.setOnClickListener(view -> {});

        content = new LinearLayout(context);
        content.setOrientation(VERTICAL);

        wrapper.addView(content);
        AppCompatButton closeButton = new AppCompatButton(context);
        closeButton.setText("Close");
        closeButton.setOnClickListener(view -> {
            close();
        });
        wrapper.addView(closeButton);
        addView(wrapper);
    }

    public void display(Stack<String> stack) {
        this.isOpen = true;
        content.removeAllViews();
        setVisibility(VISIBLE);
        while(!stack.isEmpty()) {
            AppCompatTextView textView = new AppCompatTextView(getContext());
            textView.setText(stack.pop());
            content.addView(textView);
        }
    }

    public void close() {
        this.isOpen = false;
        setVisibility(INVISIBLE);
    }

}
