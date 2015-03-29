package com.example.sergio.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;


public class Lista extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_lista);

        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        fillGeneratedList(message);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista, menu);
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

    private void fillGeneratedList(String text) {

        String final_list = "";
        String[] arr = text.split(",");

        Collections.shuffle(Arrays.asList(arr));

        for (int x=0;x<arr.length;x++){
            final_list = final_list+"\n"+x+"- "+(String)arr[x];
        }
        // Create the text view
        TextView text_lista = new TextView(this);
        text_lista.setText(final_list);

        // Set the text view as the activity layout
        setContentView(text_lista);
    }
}
