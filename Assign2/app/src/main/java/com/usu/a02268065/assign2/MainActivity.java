package com.usu.a02268065.assign2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout topLayout = new LinearLayout(this);

        AppCompatButton backButton = new AppCompatButton(this);
        backButton.setText("<");
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(100, ViewGroup.LayoutParams.WRAP_CONTENT);
        backButton.setLayoutParams(buttonParams);


        AppCompatButton forwardButton = new AppCompatButton(this);
        forwardButton.setText(">");
        forwardButton.setLayoutParams(buttonParams);


        AppCompatEditText addressBar = new AppCompatEditText(this);
        LinearLayout.LayoutParams addressBarParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addressBarParams.weight = 1.0f;
        addressBar.setLayoutParams(addressBarParams);

        WebHistory history = new WebHistory();

        WebView webView = new WebView(this);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().getJavaScriptEnabled();

        AppCompatButton goButton = new AppCompatButton(this);
        goButton.setText("Go");
        LinearLayout.LayoutParams goButtonParams = new LinearLayout.LayoutParams(125, ViewGroup.LayoutParams.WRAP_CONTENT);
        goButton.setLayoutParams(goButtonParams);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history.insert(addressBar.getText().toString());
                webView.loadUrl(addressBar.getText().toString());
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = history.back();
                addressBar.setText(url);
                webView.loadUrl(url);
            }
        });
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = history.forward();
                addressBar.setText(url);
                webView.loadUrl(url);
            }
        });

        topLayout.addView(backButton);
        topLayout.addView(forwardButton);
        topLayout.addView(addressBar);
        topLayout.addView(goButton);

        mainLayout.addView(topLayout);
        mainLayout.addView(webView);
        setContentView(mainLayout);
    }
}