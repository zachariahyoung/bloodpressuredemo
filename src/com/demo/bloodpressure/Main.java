package com.demo.bloodpressure;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class Main extends Activity {
    /** Called when the activity is first created. */
	private BPData bpData;
	
	EditText systolic, diastolic, heartRate;
	Button buttonSave, buttonList;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bpData = new BPData(this);
        this.findView();
        this.setListeners();
    }

	private void setListeners() {
		buttonSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				bpData.create(systolic.getText().toString(), diastolic.getText().toString(), heartRate.getText().toString());
				
			}
		});
		
		buttonList.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), BpList.class);
				startActivity(intent);
			}
		});
		
	}

	private void findView() {
		systolic = (EditText) findViewById(R.id.EditTextSystolic);
		diastolic = (EditText) findViewById(R.id.EditTextDiastolic);
		heartRate = (EditText) findViewById(R.id.EditTextHeartRate);
		
		buttonSave = (Button) findViewById(R.id.ButtonSave);
		buttonList = (Button)findViewById(R.id.ButtonList);
	}
}