package edu.champlain.pokemonivcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button mButton;
	EditText HPIV;
	TextView HPIVText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		mButton = (Button)findViewById(R.id.buttonSubmit);
	    
	    mButton.setOnClickListener(new View.OnClickListener() {
	    	
	    	@Override
	    	public void onClick(View view) {
	    		
	    		HPIV = (EditText)findViewById(R.id.editTextHP100);
	    		HPIVText = (TextView)findViewById(R.id.textViewTitle1);
	    		
	    		String edtval = HPIV.getText().toString().trim();

                if(!edtval.equals("")) {
                    int val = Integer.parseInt(edtval);
                    int finalval = val - 30;

                    HPIVText.setText("HP IV: " + finalval+"");
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
