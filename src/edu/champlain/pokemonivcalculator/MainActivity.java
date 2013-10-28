package edu.champlain.pokemonivcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {

	Button mButton;
	EditText HPIV, HPBase;
	TextView HPIVText, HPBaseText;
	RadioButton b1 = null;
	RadioButton b2 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		b1 = (RadioButton)findViewById(R.id.radioButton1);
		b2 = (RadioButton)findViewById(R.id.radioButton2);
		RadioGroup g = (RadioGroup) findViewById(R.id.radioGroup1);
		RadioGroup g2 = (RadioGroup) findViewById(R.id.radioGroup2);
		
		g.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch(checkedId) {
				case R.id.radioButton1:
					b1.setTag("110");
		            Toast.makeText(MainActivity.this, "You've selected: " + b1.getTag(), Toast.LENGTH_LONG).show();
					break;
				case R.id.radioButton2:
					b1.setTag("5");
		            Toast.makeText(MainActivity.this, "You've selected: " + b1.getTag(), Toast.LENGTH_LONG).show();
					break;
				case R.id.radioButton5:
					// Now you can get the text or whatever you want from the "selected" radio button
			        b2.setTag("10");
			        Toast.makeText(MainActivity.this, "You've selected: " + b2.getTag(), Toast.LENGTH_LONG).show();
			        break;
				case R.id.radioButton4:
			        // Now you can get the text or whatever you want from the "selected" radio button
			        b2.setTag("11");
			        Toast.makeText(MainActivity.this, "You've selected: " + b2.getTag(), Toast.LENGTH_LONG).show();
			        break;
				case R.id.radioButton3:
			        // Now you can get the text or whatever you want from the "selected" radio button
			        b2.setTag("9");
			        Toast.makeText(MainActivity.this, "You've selected: " + b2.getTag(), Toast.LENGTH_LONG).show();
			        break;
				}
			}
		});
		
		g2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch(checkedId) {
				case R.id.radioButton5:
					// Now you can get the text or whatever you want from the "selected" radio button
			        b2.setTag("10");
			        Toast.makeText(MainActivity.this, "You've selected: " + b2.getTag(), Toast.LENGTH_LONG).show();
			        break;
				case R.id.radioButton4:
			        // Now you can get the text or whatever you want from the "selected" radio button
			        b2.setTag("11");
			        Toast.makeText(MainActivity.this, "You've selected: " + b2.getTag(), Toast.LENGTH_LONG).show();
			        break;
				case R.id.radioButton3:
			        // Now you can get the text or whatever you want from the "selected" radio button
			        b2.setTag("9");
			        Toast.makeText(MainActivity.this, "You've selected: " + b2.getTag(), Toast.LENGTH_LONG).show();
			        break;
				}
			}
		});
	
		mButton = (Button)findViewById(R.id.buttonSubmit);
	    
	    mButton.setOnClickListener(new View.OnClickListener() {
	    	
	    	@Override
	    	public void onClick(View view) {
	    		
	    		HPIV = (EditText) findViewById(R.id.editTextHP100);
	    		HPIVText = (TextView) findViewById(R.id.textViewTitle1);
	    		HPBase = (EditText) findViewById(R.id.editTextHPStat);
	    		
	    		String edtval = HPIV.getText().toString().trim();
	    		String edtval2 = HPBase.getText().toString().trim();

                if(!edtval.equals("")) {
                    float valAt100 = Integer.parseInt(edtval);
                    float valAtBase = Integer.parseInt(edtval2);
                    float finalVal = (float) Math.ceil(((valAt100 * 10) / Integer.parseInt(b2.getTag().toString())));
                    float finalVal2 = (float) finalVal - ((2 * valAtBase) + Integer.parseInt(b1.getTag().toString()));
                    
                    HPIVText.setText("HP IV: " + finalVal2);
                }
	    		
	    		/*HPIV = (EditText)findViewById(R.id.editTextStats100);
	    		HPIVText = (TextView)findViewById(R.id.textViewTitle1);
	    		HPIVText.setText("HP IV: "+HPIV.getText().toString());
	    		
	    		AttackIV = (EditText)findViewById(R.id.editTextBaseStats);
	    		AttackIVText = (TextView)findViewById(R.id.textViewTitle2);
	    		AttackIVText.setText("Attack IV: "+AttackIV.getText().toString());
	    		
	    		DefenseIV = (EditText)findViewById(R.id.editTextHPStat);
	    		DefenseIVText = (TextView)findViewById(R.id.textViewTitle3);
	    		DefenseIVText.setText("Defense IV: "+DefenseIV.getText().toString());*/
	    	}
	    });
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
