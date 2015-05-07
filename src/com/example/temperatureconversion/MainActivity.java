package com.example.temperatureconversion;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {
	private EditText conversionNumber;
	private RadioGroup fromRadioGroup;
	private RadioButton fromCelcius;
	private RadioButton fromKelvin;
	private RadioGroup toRadioGroup;
	private RadioButton toCelcius;
	private RadioButton toKelvin;
	private RadioButton from;
	private RadioButton to;
	private Button displayButton;
	private TextView displayAnswer;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		conversionNumber = (EditText)findViewById(R.id.numberEditText);
		displayAnswer = (TextView)findViewById(R.id.displayAnswer);
		
		
		addListenerOnButton();
	
		
	}
	public void addListenerOnButton() {
		displayButton = (Button)findViewById(R.id.submitButton);
		fromRadioGroup = (RadioGroup) findViewById(R.id.fromRadioGroup);
		int firstID = fromRadioGroup.getCheckedRadioButtonId();
		from = (RadioButton) findViewById(firstID);
		toRadioGroup = (RadioGroup) findViewById(R.id.toRadioGroup);
		int secondID = toRadioGroup.getCheckedRadioButtonId();
		to = (RadioButton) findViewById(secondID);
		
		displayButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				if(from.getText().length() == to.getText().length())
				{
					AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
					builder.setMessage(R.string.noConversion);
					builder.setPositiveButton(R.string.OK, null);
					AlertDialog errorDialog = builder.create();
					errorDialog.show();
				}
				else{
					double number = Double.parseDouble(conversionNumber.getText().toString());
					if(from.getText().length()==7){
						double answer = number + 273.15;
						displayAnswer.setText(String.valueOf(answer));
					}
					else{
							double answer2 = number - 273.15;
							displayAnswer.setText(String.valueOf(answer2));
						}
					}
			}
		});
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
