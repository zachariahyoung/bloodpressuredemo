package com.demo.bloodpressure;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class BpList extends ListActivity {
	private BPData bpData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dplist);
		bpData = new BPData(this);
		
		String[] cursor = bpData.list();
		
		setListAdapter(new ArrayAdapter<String>(this,
	            android.R.layout.simple_list_item_1, cursor));		
		
	}	

}
