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
	EditText HPIV, AttIV, DefIV, SpAIV, SpDIV, SpeIV, HPBase,
			 AttBase, DefBase, SpABase, SpDBase, SpeBase;
	TextView HPIVText, HPBaseText, AttIVText, AttBasetext;
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
				}
			}
		});
		
		g2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch(checkedId) {
				case R.id.radioButton5:
			        b2.setTag("10");
			        Toast.makeText(MainActivity.this, "You've selected: " + b2.getTag(), Toast.LENGTH_LONG).show();
			        break;
				case R.id.radioButton4:
			        b2.setTag("11");
			        Toast.makeText(MainActivity.this, "You've selected: " + b2.getTag(), Toast.LENGTH_LONG).show();
			        break;
				case R.id.radioButton3:
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
	    		AttIV = (EditText) findViewById(R.id.editTextAtt100);
	    		
	    		HPIVText = (TextView) findViewById(R.id.textViewTitle1);
	    		AttIVText = (TextView) findViewById(R.id.textViewTitle2);
	    		
	    		HPBase = (EditText) findViewById(R.id.editTextHPStat);
	    		AttBase = (EditText) findViewById(R.id.editTextAttStat);
	    		
	    		String hpVal1 = HPIV.getText().toString().trim();
	    		String hpVal2 = HPBase.getText().toString().trim();
	    		
	    		String attVal1 = AttIV.getText().toString().trim();
	    		String attVal2 = AttBase.getText().toString().trim();

                if (!hpVal1.equals("")) {
                    float hpValAt100 = Integer.parseInt(hpVal1);
                    float hpValAtBase = Integer.parseInt(hpVal2);
                    float hpFinalVal = (float) Math.ceil(((hpValAt100 * 10) / Integer.parseInt(b2.getTag().toString())));
                    float hpFinalVal2 = (float) hpFinalVal - ((2 * hpValAtBase) + Integer.parseInt(b1.getTag().toString()));
                    
                    HPIVText.setText("HP IV: " + hpFinalVal2);
                }
                if (!attVal1.equals("")) {
                	float attValAt100 = Integer.parseInt(attVal1);
                    float attValAtBase = Integer.parseInt(attVal2);
                    float attFinalVal = (float) Math.ceil(((attValAt100 * 10) / Integer.parseInt(b2.getTag().toString())));
                    float attFinalVal2 = (float) attFinalVal - ((2 * attValAtBase) + Integer.parseInt(b1.getTag().toString()));
                    
                    AttIVText.setText("Att IV: " + attFinalVal2);
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
