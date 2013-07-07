package com.aldov.notesapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aldo V. on 07/07/13.
 */
public class DatabaseHandler extends SQLiteOpenHelper{

    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String CONTENT = "content";

    private static final String DATABASE_NAME = "notebook";
    private static final String TABLE_NAME = "notes";
    private static final int DATABASE_VERSION= 1;

    public void DatabaseHandler(){

    }


    public DatabaseHandler (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY," + TITLE + " TEXT,"
                + CONTENT + " TEXT" + ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public void insert(Notes notes){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE,notes.getTitle());
        values.put(CONTENT,notes.getContent());

        db.insert(TABLE_NAME,null,values);
        db.close();

    }

    public Notes getNotes(int id){

        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] { ID,
                TITLE, CONTENT }, ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Notes notes = new Notes(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        return notes;

    }

    public void deleteNotes(Notes notes) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, ID + " = ?",
                new String[] { String.valueOf(notes.getID()) });
        db.close();
    }

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        String deleteSQL = "DELETE FROM " + TABLE_NAME;

        db.execSQL(deleteSQL);
    }

}
