package com.intel.fibnative;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText input;
	TextView output;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		input = (EditText) findViewById(R.id.input);
		output = (TextView) findViewById(R.id.output);
	}

	public void onClick(View v) {
		long n = Long.parseLong( input.getText().toString() );
		
		// Java
		long start = System.currentTimeMillis();
		long resultJ = FibLib.fibJ(n);
		long timeJ = System.currentTimeMillis() - start;
		output.append( String.format("\n fibJ(%d)=%d (%d ms)", n, resultJ, timeJ));
		
		// Native
		start = System.currentTimeMillis();
		long resultN = FibLib.fibN(n);
		long timeN = System.currentTimeMillis() - start;
		output.append( String.format("\n fibN(%d)=%d (%d ms)", n, resultN, timeN));

	}
}
