package com.example.texteditor1;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity implements OnClickListener {
	private Button red, green, blue, bigger, smaller, bold, italic,moren;
	private TextView testText;
	private int flag=0;
	private EditText content;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		testText=(TextView)findViewById(R.id.testText);
		red = (Button) findViewById(R.id.red);
		green = (Button) findViewById(R.id.green);
		blue = (Button) findViewById(R.id.blue);
		bigger = (Button) findViewById(R.id.bigger);
		smaller = (Button) findViewById(R.id.smaller);
		SizeListener mysizeListener=new SizeListener(testText);
		bigger.setOnClickListener(mysizeListener);
		smaller.setOnClickListener(mysizeListener);		
		ColorListner myColorListner = new ColorListner();
		red.setOnClickListener(myColorListner);
		green.setOnClickListener(myColorListner);
		blue.setOnClickListener(myColorListner);
		testText.setTypeface(Typeface.DEFAULT);
		bold=(Button)findViewById(R.id.bold);
		italic = (Button) findViewById(R.id.italic);
		moren=(Button)findViewById(R.id.moren);
		italic.setOnClickListener(this);
		bold.setOnClickListener(this);
		moren.setOnClickListener(this);
		content = (EditText) findViewById(R.id.content);
		content.setOnEditorActionListener(new OnEditorActionListener() {
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				testText.setText(content.getText().toString());
				return false;
			}
		});
	}
	private class  ColorListner implements OnClickListener{
		public void onClick(View v){
			switch (v.getId()) {
			case R.id.red:
				testText.setTextColor(Color.RED);
				break;
			case R.id.blue:
				testText.setTextColor(Color.BLUE);
				break;
			case R.id.green:
				testText.setTextColor(Color.GREEN);
				break;
			default:
				break;
			}
		}
	}
	public void onClick(View v) {		
		Typeface tf=testText.getTypeface();
		//testText.get
		switch (v.getId()) {
		case R.id.italic:			
			if(flag==2||flag==3){
				testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);
				flag=3;
			}else{
				testText.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC);//б��
				flag=1;
			}			
			break;
		case R.id.bold:
			if(flag==1||flag==3){
				testText.setTypeface(Typeface.MONOSPACE,Typeface.BOLD_ITALIC);//����
				flag=3;
			}else{
				testText.setTypeface(Typeface.DEFAULT_BOLD,Typeface.BOLD);//����
				flag=2;
			}						
			break;
		case R.id.moren:
			testText.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL);
			flag=0;
			break;
		default:
			break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
