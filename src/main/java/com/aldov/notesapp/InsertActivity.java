package com.aldov.notesapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InsertActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        Button b =(Button)findViewById(R.id.insertButton);

        final DatabaseHandler db = new DatabaseHandler(this);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title;
                String content;
                TextView t=(TextView)findViewById(R.id.title);
                TextView c=(TextView)findViewById(R.id.content);
                title = t.getText().toString();
                content = c.getText().toString();


                db.insert(new Notes(title,content));

                Intent i = new Intent(InsertActivity.this,MainActivity.class);
                startActivity(i);



            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.insert, menu);
        return true;
    }



}
