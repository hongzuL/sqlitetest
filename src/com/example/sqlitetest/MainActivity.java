package com.example.sqlitetest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.content.ContentValues;  
import android.database.Cursor;  
import android.database.sqlite.SQLiteDatabase;  
import android.os.Bundle;  
import android.view.View;  
import android.view.View.OnClickListener;  

public class MainActivity extends Activity {
	private Button createDatabaseButton = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		createDatabaseButton = (Button) findViewById(R.id.createDatabase);
		createDatabaseButton.setOnClickListener(new CreateDatabaseOnClickListener()); 
	}
	
	class CreateDatabaseOnClickListener implements OnClickListener {  
        public void onClick(View v) {  
            // ������һ��DatabaseHelper����ִֻ����仰�ǲ��ᴴ��������ӵ�  
            DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this,  
                    "test_db");  
            // ֻ�е�����DatabaseHelper��getWritableDatabase()��������getReadableDatabase()����֮�󣬲Żᴴ�����һ������  
            SQLiteDatabase sqliteDatabase = dbHelper.getReadableDatabase();  
        }  
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
