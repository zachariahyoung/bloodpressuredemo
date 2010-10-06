package com.demo.bloodpressure;

import java.util.Iterator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BPData extends SQLiteOpenHelper {

	
	public BPData(Context context) {
		super(context, "bp.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table bps (_id " +
				"INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"SYSTOLIC TEXT, " +
				"DIASTOLIC TEXT, " +
				"HEARTRATE TEXT, " +
				"BPDATE DATETIME DEFAULT CURRENT_TIMESTAMP);");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS bps");
		onCreate(db);

	}
	
	public void create(String systolic, String diastolic, String heartheart) {
		SQLiteDatabase readableDatabase = getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put("SYSTOLIC", systolic);
		contentValues.put("DIASTOLIC", diastolic);
		contentValues.put("HEARTRATE", heartheart);
		readableDatabase.insert("bps", null, contentValues);
	}
	
	public String[] list() {
		
		Cursor cur = getReadableDatabase().query("bps", new String[] {"_ID","SYSTOLIC","DIASTOLIC","HEARTRATE"}, null, null, null, null, null);
		String[] string = new String[cur.getCount()];
		
		
		int cnt = 0;

		if (cur.getCount() > 0) {
		     while (cur.moveToNext()) {
		         String line = "Systolic: " + cur.getString(1);
		         string[cnt] = line;
		         cnt++;
		     }
	        }
		
		
		
		return string;
	}

}
