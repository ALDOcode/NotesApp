package com.aldov.notesapp;

/**
 * Created by Aldo V. on 07/07/13.
 */
public class Notes {

    int id;
    String title;
    String content;

    public Notes(int _id,String _title,String _content){
        this.id=_id;
        this.title=_title;
        this.content=_content;
    }

    public Notes(String _title,String _content){
        this.title=_title;
        this.content=_content;
    }

    public int getID(){
        return this.id;
    }

    public String getTitle(){
        return this.title;

    }

    public String getContent(){

        return this.content;
    }


}
