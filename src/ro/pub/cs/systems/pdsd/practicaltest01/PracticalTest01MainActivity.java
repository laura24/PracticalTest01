package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends Activity {
	
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	
	private class ButtonClickListener implements Button.OnClickListener {
		 
	    @Override
	    public void onClick(View view) {
	    	switch(view.getId()) {
	        case R.id.checkBox1:
	        	CheckBox check = (CheckBox)findViewById(R.id.checkBox1);
	        	if(check.isChecked()){
	        		EditText textbox = (EditText)findViewById(R.id.editText1);
	        		textbox.setEnabled(true);
	        	} else {
	        		EditText textbox = (EditText)findViewById(R.id.editText1);
	        		textbox.setEnabled(false);
	        	}
	          break;
	        case R.id.checkBox2:
	        	CheckBox check2 = (CheckBox)findViewById(R.id.checkBox2);
	        	if(check2.isChecked()){
	        		EditText textbox = (EditText)findViewById(R.id.editText2);
	        		textbox.setEnabled(true);
	        	} else {
	        		EditText textbox = (EditText)findViewById(R.id.editText2);
	        		textbox.setEnabled(false);
	        	}
	          break;
	        case R.id.button1:
	        	Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01SecondaryActivity");
	        	EditText textbox = (EditText)findViewById(R.id.editText1);
	        	EditText textbox2 = (EditText)findViewById(R.id.editText2);
	            intent.putExtra("FirstText",textbox.getText().toString());
	            intent.putExtra("SecondText",textbox2.getText().toString());
	            startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
	            break;
	      }
	    }
	  }  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		
		CheckBox textbox1 = (CheckBox)findViewById(R.id.checkBox1);
		textbox1.setOnClickListener(buttonClickListener);
		CheckBox textbox2 = (CheckBox)findViewById(R.id.checkBox2);
		textbox2.setOnClickListener(buttonClickListener);
		EditText FirstText = (EditText)findViewById(R.id.editText1);
		EditText SecondText = (EditText)findViewById(R.id.editText2);
		Button buton = (Button)findViewById(R.id.button1);
		buton.setOnClickListener(buttonClickListener);
		
		if (savedInstanceState != null) {
			String FirstTextbox = savedInstanceState.getString("FirstText");
		      if (FirstTextbox != null) {
		        FirstText.setText(FirstTextbox);
		      }
		      String SecondTextbox = savedInstanceState.getString("SecondText");
		      if(SecondTextbox != null) {
		    	  SecondText.setText(SecondTextbox);
		      }
		      
		      Boolean FirstCheckbox = savedInstanceState.getBoolean("FirstCheck");
		      if(FirstCheckbox)
		    	  textbox1.setChecked(true);
		      
		      Boolean SecondCheckbox = savedInstanceState.getBoolean("SecondCheck");
		      if(SecondCheckbox)
		    	  textbox2.setChecked(true);
		      
		}	
	}
	
	@Override
	  protected void onSaveInstanceState(Bundle savedInstanceState) {
	    EditText FirstText = (EditText)findViewById(R.id.editText1);
	    EditText SecondText = (EditText)findViewById(R.id.editText2);
	    CheckBox FirstCheck = (CheckBox)findViewById(R.id.checkBox1);
	    CheckBox SecondCheck = (CheckBox)findViewById(R.id.checkBox2);
	    
	    savedInstanceState.putString("FirstText", FirstText.getText().toString());
	    savedInstanceState.putString("SecondText", SecondText.getText().toString());
	    if(FirstCheck.isChecked()) {
	    	savedInstanceState.putBoolean("FirstCheck", true);
	    }
	    else {
	    	savedInstanceState.putBoolean("FirstCheck", false);
	    }
	    
	    if(SecondCheck.isChecked()) {
	    	savedInstanceState.putBoolean("SecondCheck", true);
	    }
	    else {
	    	savedInstanceState.putBoolean("SecondCheck", false);
	    }
	    
	  }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
	
	@Override
	  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    Toast.makeText(this, "The activity returned with result "+resultCode, Toast.LENGTH_LONG).show();
	  }
}
