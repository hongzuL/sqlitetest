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
	private Button updateDatabaseButton = null;  
	private Button insertButton = null;
    private Button updateButton = null;  
    private Button selectButton = null;  
    private Button deleteButton = null;  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		createDatabaseButton = (Button) findViewById(R.id.createDatabase);
		updateDatabaseButton = (Button) findViewById(R.id.updateDatabase);  
        insertButton = (Button) findViewById(R.id.insert);
        updateButton = (Button) findViewById(R.id.update);  
        selectButton = (Button) findViewById(R.id.select);  
        deleteButton = (Button) findViewById(R.id.delete);
        
        updateDatabaseButton.setOnClickListener(new UpdateDatabaseOnClickListener());  
        insertButton.setOnClickListener(new InsertOnClickListener());
		createDatabaseButton.setOnClickListener(new CreateDatabaseOnClickListener()); 
        updateButton.setOnClickListener(new UpdateOnClickListener());  
        selectButton.setOnClickListener(new SelectOnClickListener());  
        deleteButton.setOnClickListener(new DeleteOnClickListener());
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
	 // updateDatabaseButton����¼�������  
    class UpdateDatabaseOnClickListener implements OnClickListener {  
        public void onClick(View v) {  
            // TODO Auto-generated method stub  
            DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this,  
                    "test_db", 2);  
            // �õ�һ��ֻ����SQLiteDatabase����  
            SQLiteDatabase sqliteDatabase = dbHelper.getReadableDatabase();  
        }  
  
    }
    // insertButton����¼�������  
    class InsertOnClickListener implements OnClickListener {  
        public void onClick(View v) {  
            // ����ContentValues����  
            ContentValues values = new ContentValues();  
            // ��ö����в����ֵ�ԣ����м���������ֵ��ϣ�����뵽��һ�е�ֵ��ֵ��������ݿ⵱�е���������һ��  
            values.put("id", 1);  
            values.put("name", "yangyz");  
            // ����DatabaseHelper����  
            DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this,  
                    "test_db", 2);  
            // �õ�һ����д��SQLiteDatabase����  
            SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();  
            // ����insert�������Ϳ��Խ����ݲ��뵽���ݿ⵱��  
            // ��һ������:������  
            // �ڶ���������SQl������һ�����У����ContentValues�ǿյģ���ô��һ�б���ȷ��ָ��ΪNULLֵ  
            // ������������ContentValues����  
            sqliteDatabase.insert("user", null, values);  
        }  
    } 
    // updateButton����¼�������  
    class UpdateOnClickListener implements OnClickListener {  
        public void onClick(View v) {  
            // ����һ��DatabaseHelper����  
            DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this,  
                    "test_db", 2);  
            // �õ�һ����д��SQLiteDatabase����  
            SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();  
            // ����һ��ContentValues����  
            ContentValues values = new ContentValues();  
            values.put("name", "zhangsan");  
            // ����update����  
            // ��һ������String������  
            // �ڶ�������ContentValues��ContentValues����  
            // ����������String��where�־䣬�൱��sql���where�������䣬������ռλ��  
            // ���ĸ�����String[]��ռλ����ֵ  
            sqliteDatabase.update("user", values, "id=?", new String[] { "1" });  
            System.out.println("-----------update------------");  
        }  
    }  
  
    // selectButton����¼�������  
    class SelectOnClickListener implements OnClickListener {  
        public void onClick(View v) {  
            String id = null;  
            String name = null;  
            //����DatabaseHelper����  
            DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this,  
                    "test_db", 2);  
            // �õ�һ��ֻ����SQLiteDatabase����  
            SQLiteDatabase sqliteDatabase = dbHelper.getReadableDatabase();  
            // ����SQLiteDatabase�����query�������в�ѯ������һ��Cursor���������ݿ��ѯ���صĽ��������  
            // ��һ������String������  
            // �ڶ�������String[]:Ҫ��ѯ������  
            // ����������String����ѯ����  
            // ���ĸ�����String[]����ѯ�����Ĳ���  
            // ���������String:�Բ�ѯ�Ľ�����з���  
            // ����������String���Է���Ľ����������  
            // ���߸�����String���Բ�ѯ�Ľ����������  
            Cursor cursor = sqliteDatabase.query("user", new String[] { "id",  
                    "name" }, "id=?", new String[] { "1" }, null, null, null);  
            // ������ƶ�����һ�У��Ӷ��жϸý�����Ƿ�����һ�����ݣ�������򷵻�true��û���򷵻�false  
            while (cursor.moveToNext()) {  
                id = cursor.getString(cursor.getColumnIndex("id"));  
                name = cursor.getString(cursor.getColumnIndex("name"));  
            }  
            System.out.println("-------------select------------");  
            System.out.println("id: "+id);  
            System.out.println("name: "+name);  
        }  
    }  
  
    // deleteButton����¼�������  
    class DeleteOnClickListener implements OnClickListener {  
        public void onClick(View v) {  
            //����DatabaseHelper����  
            DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this,"test_db",2);  
            //��ÿ�д��SQLiteDatabase����  
            SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();  
            //����SQLiteDatabase�����delete��������ɾ������  
            //��һ������String������  
            //�ڶ�������String���������  
            //����������String[]������ֵ  
            sqliteDatabase.delete("user", "id=?", new String[]{"1"});  
            System.out.println("----------delete----------");  
        }  
    } 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
