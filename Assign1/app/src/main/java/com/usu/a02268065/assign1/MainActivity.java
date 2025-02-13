package com.usu.a02268065.assign1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LinearLayout layout = new LinearLayout(this);
        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //First Field
        final AppCompatTextView textView1 = new AppCompatTextView(this);
        textView1.setText("Enter a Plural Noun:");
        textView1.setLayoutParams(params);
        final AppCompatEditText editText1 = new AppCompatEditText(this);
        editText1.setLayoutParams(params);
        layout.addView(textView1);
        layout.addView(editText1);

        //Second Field
        final AppCompatTextView textView2 = new AppCompatTextView(this);
        textView2.setText("Enter a Plural Noun:");
        textView2.setLayoutParams(params);
        final AppCompatEditText editText2 = new AppCompatEditText(this);
        editText2.setLayoutParams(params);
        layout.addView(textView2);
        layout.addView(editText2);

        //Third Field
        final AppCompatTextView textView3 = new AppCompatTextView(this);
        textView3.setText("Enter a Verb:");
        textView3.setLayoutParams(params);
        final AppCompatEditText editText3 = new AppCompatEditText(this);
        editText3.setLayoutParams(params);
        layout.addView(textView3);
        layout.addView(editText3);

        //Fourth Field
        final AppCompatTextView textView4 = new AppCompatTextView(this);
        textView4.setText("Enter a Noun:");
        textView4.setLayoutParams(params);
        final AppCompatEditText editText4 = new AppCompatEditText(this);
        editText4.setLayoutParams(params);
        layout.addView(textView4);
        layout.addView(editText4);

        //Fifth Field
        final AppCompatTextView textView5 = new AppCompatTextView(this);
        textView5.setText("Enter an -ing Verb:");
        textView5.setLayoutParams(params);
        final AppCompatEditText editText5 = new AppCompatEditText(this);
        editText5.setLayoutParams(params);
        layout.addView(textView5);
        layout.addView(editText5);

        //Sixth Field
        final AppCompatTextView textView6 = new AppCompatTextView(this);
        textView6.setText("Enter a Plural Noun:");
        textView6.setLayoutParams(params);
        final AppCompatEditText editText6 = new AppCompatEditText(this);
        editText6.setLayoutParams(params);
        layout.addView(textView6);
        layout.addView(editText6);

        //Seventh Field
        final AppCompatTextView textView7 = new AppCompatTextView(this);
        textView7.setText("Enter a Noun:");
        textView7.setLayoutParams(params);
        final AppCompatEditText editText7 = new AppCompatEditText(this);
        editText7.setLayoutParams(params);
        layout.addView(textView7);
        layout.addView(editText7);

        //Eighth Field
        final AppCompatTextView textView8 = new AppCompatTextView(this);
        textView8.setText("Enter a Plural Noun:");
        textView8.setLayoutParams(params);
        final AppCompatEditText editText8 = new AppCompatEditText(this);
        editText8.setLayoutParams(params);
        layout.addView(textView8);
        layout.addView(editText8);

        //Button
        final AppCompatButton button = new AppCompatButton(this);
        button.setText("Next");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String field1 = editText1.getText().toString();
                String field2 = editText2.getText().toString();
                String field3 = editText3.getText().toString();
                String field4 = editText4.getText().toString();
                String field5 = editText5.getText().toString();
                String field6 = editText6.getText().toString();
                String field7 = editText7.getText().toString();
                String field8 = editText8.getText().toString();
                AppCompatTextView story = new AppCompatTextView(MainActivity.this);
// NOTE: I couldn't come up with an adequate mad lib story, So I googled a MadLibs template and copied
// the story from there. I Don't know if this requires citation or not for legal reasons, but I figured
// I'd err on the side of caution. I don't have a specific citation other than google images. I just figured
// I'd cover my tracks for the sake of Academic Integrity or whatever. So there you go. Hope you enjoy the story.
                story.setText("At The Arcade!\n\n    " +
                        "When I go to the arcade with my " + field1 + " there are lots of " +
                        "games to play. I spend lots of time there with my friends. In the game " +
                        "X-Men you can be different " + field2 + ". The point of the game is to " +
                        field3 + " every robot. You also need to save people. Then you can go to " +
                        "the next level.\n    In the game Star Wars you are Luke Skywalker and you " +
                        "try to destroy every " + field4 + ". In a racing game you need to beat " +
                        "every computerized vehicle that you are " + field5 + " against.\n    " +
                        "There are a whole lot of other cool games. When you play some games you " +
                        "win " + field6 + " for certain scores. Once you're done you can cash in " +
                        "your tickets to get a big " + field7 + ". You can save your " + field8 +
                        " for another time. When I went to this arcade I didn't  believe how much " +
                        "fun it would be. So far I have had a lot of fun every time I've been to " +
                        "this great arcade! ");
                story.setLayoutParams(params);
                setContentView(story);

            }
        });
        layout.addView(button);

        layout.setOrientation(LinearLayout.VERTICAL);

        setContentView(layout);

    }
}