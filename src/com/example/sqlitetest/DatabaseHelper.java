package com.example.sqlitetest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.Menu;

/**
 * SQLiteOpenHelper is a helper class to manage database creation and version management
 */
public class DatabaseHelper extends SQLiteOpenHelper { 
	private static final int VERSION = 1;
	/**
	 * 
	 * @param context
	 * @param name
	 * @param cursorFactory
	 * @param version
	 */
	public DatabaseHelper(Context context, String name, CursorFactory cursorFactory, int version) 
	  { 
		 //must use super() to use parent function 
	     super(context, name, cursorFactory, version);     
	     } 
	
	public DatabaseHelper(Context context, String name, int version){
		this(context,name,null,version);
	}
	
	public DatabaseHelper(Context context, String name){
		this(context,name,VERSION);
	}
	
	//This function is used for first creation of the database
	@Override
	public void onCreate(SQLiteDatabase db) {     
	    // TODO 
		System.out.println("create a database");
		//execSQL to execute sql statement
		db.execSQL("create table user(id int,name varchar(20))"); 
	}     
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {     
	    // TODO
		System.out.println("upgrade a database");
	}     
	
	@Override
	public void onOpen(SQLiteDatabase db) {     
	         super.onOpen(db);       
	         // TODO     
	     }     
	 }

