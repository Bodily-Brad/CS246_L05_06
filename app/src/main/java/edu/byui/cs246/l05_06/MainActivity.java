package edu.byui.cs246.l05_06;

import android.content.Intent;
import android.widget.EditText;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // This acts just like clicking the share button
                sendMessage(findViewById(R.id.button_share));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Sends the message to the displayMessage activity
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        // We will pass the reference as a prebuilt string, for now
        String message = "";

        // Get our editTexts
        EditText editText;

        // Book editText
        editText = (EditText) findViewById(R.id.edit_book);
        message += editText.getText().toString();
        message += " ";

        // Chapter editText
        editText = (EditText) findViewById(R.id.edit_chapter);
        message += editText.getText().toString();
        message += ":";

        // Verse editText
        editText = (EditText) findViewById(R.id.edit_verse);
        message += editText.getText().toString();

        // Save message as extra
        intent.putExtra(EXTRA_MESSAGE, message);

        // Start the display message activity
        startActivity(intent);
    }
}
