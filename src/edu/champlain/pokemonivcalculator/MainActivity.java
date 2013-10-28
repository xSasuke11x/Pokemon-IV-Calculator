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
	TextView HPIVText, HPBaseText, AttIVText, AttBasetext, DefIVText, DefBaseText,
			 SpAIVText, SpABaseText, SpDIVText, SpDBasetext, SpeIVText, SpeBaseText;
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
	    		DefIV = (EditText) findViewById(R.id.editTextDef100);
	    		SpAIV = (EditText) findViewById(R.id.editTextSpA100);
	    		SpDIV = (EditText) findViewById(R.id.editTextSpD100);
	    		SpeIV = (EditText) findViewById(R.id.editTextSpe100);
	    		
	    		HPIVText = (TextView) findViewById(R.id.textViewTitle1);
	    		AttIVText = (TextView) findViewById(R.id.textViewTitle2);
	    		DefIVText = (TextView) findViewById(R.id.textViewTitle3);
	    		SpAIVText = (TextView) findViewById(R.id.textViewTitle4);
	    		SpDIVText = (TextView) findViewById(R.id.textViewTitle5);
	    		SpeIVText = (TextView) findViewById(R.id.textViewTitle6);
	    		
	    		HPBase = (EditText) findViewById(R.id.editTextHPStat);
	    		AttBase = (EditText) findViewById(R.id.editTextAttStat);
	    		DefBase = (EditText) findViewById(R.id.editTextDefStat);
	    		SpABase = (EditText) findViewById(R.id.editTextSpAStat);
	    		SpDBase = (EditText) findViewById(R.id.editTextSpDStat);
	    		SpeBase = (EditText) findViewById(R.id.editTextSpeStat);
	    		
	    		String hpVal1 = HPIV.getText().toString().trim();
	    		String hpVal2 = HPBase.getText().toString().trim();
	    		
	    		String attVal1 = AttIV.getText().toString().trim();
	    		String attVal2 = AttBase.getText().toString().trim();
	    		
	    		String defVal1 = DefIV.getText().toString().trim();
	    		String defVal2 = DefBase.getText().toString().trim();
	    		
	    		String spaVal1 = SpAIV.getText().toString().trim();
	    		String spaVal2 = SpABase.getText().toString().trim();
	    		
	    		String spdVal1 = SpDIV.getText().toString().trim();
	    		String spdVal2 = SpDBase.getText().toString().trim();
	    		
	    		String speVal1 = SpeIV.getText().toString().trim();
	    		String speVal2 = SpeBase.getText().toString().trim();

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
                if (!defVal1.equals("")) {
                	float defValAt100 = Integer.parseInt(defVal1);
                    float defValAtBase = Integer.parseInt(defVal2);
                    float defFinalVal = (float) Math.ceil(((defValAt100 * 10) / Integer.parseInt(b2.getTag().toString())));
                    float defFinalVal2 = (float) defFinalVal - ((2 * defValAtBase) + Integer.parseInt(b1.getTag().toString()));
                    
                    DefIVText.setText("Def IV: " + defFinalVal2);
                }
                if (!spaVal1.equals("")) {
                	float spaValAt100 = Integer.parseInt(spaVal1);
                    float spaValAtBase = Integer.parseInt(spaVal2);
                    float spaFinalVal = (float) Math.ceil(((spaValAt100 * 10) / Integer.parseInt(b2.getTag().toString())));
                    float spaFinalVal2 = (float) spaFinalVal - ((2 * spaValAtBase) + Integer.parseInt(b1.getTag().toString()));
                    
                    SpAIVText.setText("SpA IV: " + spaFinalVal2);
                }
                if (!spdVal1.equals("")) {
                	float spdValAt100 = Integer.parseInt(spdVal1);
                    float spdValAtBase = Integer.parseInt(spdVal2);
                    float spdFinalVal = (float) Math.ceil(((spdValAt100 * 10) / Integer.parseInt(b2.getTag().toString())));
                    float spdFinalVal2 = (float) spdFinalVal - ((2 * spdValAtBase) + Integer.parseInt(b1.getTag().toString()));
                    
                    SpDIVText.setText("SpD IV: " + spdFinalVal2);
                }
                if (!speVal1.equals("")) {
                	float speValAt100 = Integer.parseInt(speVal1);
                    float speValAtBase = Integer.parseInt(speVal2);
                    float speFinalVal = (float) Math.ceil(((speValAt100 * 10) / Integer.parseInt(b2.getTag().toString())));
                    float speFinalVal2 = (float) speFinalVal - ((2 * speValAtBase) + Integer.parseInt(b1.getTag().toString()));
                    
                    SpeIVText.setText("Spe IV: " + speFinalVal2);
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

}
