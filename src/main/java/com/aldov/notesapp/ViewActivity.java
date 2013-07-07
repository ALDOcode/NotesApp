package com.aldov.notesapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);



        final DatabaseHandler db=new DatabaseHandler(this);
        TextView t = (TextView)findViewById(R.id.viewtitle);
        t.setText(db.getNotes(1).getTitle());
        TextView t2 = (TextView)findViewById(R.id.viewcontent);
        t2.setText(db.getNotes(1).getContent());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view, menu);
        return true;
    }
    
}
