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


public class DatabaseHelper extends SQLiteOpenHelper {     
	  DatabaseHelper(Context context, String name, CursorFactory cursorFactory, int version) 
	  {     
	    super(context, name, cursorFactory, version);     
	     }     
	     
	     public void onCreate(SQLiteDatabase db) {     
	         // TODO 创建数据库后，对数据库的操作     
	     }     
	     
	     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {     
	         // TODO 更改数据库版本的操作     
	     }     
	     
	 public void onOpen(SQLiteDatabase db) {     
	         super.onOpen(db);       
	         // TODO 每次成功打开数据库后首先被执行     
	     }     
	 }

