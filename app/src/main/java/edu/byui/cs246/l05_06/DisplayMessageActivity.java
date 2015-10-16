package edu.byui.cs246.l05_06;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get intent
        Intent intent = getIntent();

        // Get passed message
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Set content
        setContentView(R.layout.activity_display_message);

        // Get our output text view
        TextView textView = (TextView) findViewById(R.id.display_message);

        // Set the message
        textView.setText(message);
    }
}
