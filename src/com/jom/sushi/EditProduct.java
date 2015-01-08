package com.jom.sushi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class EditProduct extends Activity implements OnClickListener, OnCheckedChangeListener{

	private Button cancelButton;
	private Button addButton;
	
	private CheckBox []boxArray;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_product);
		
		cancelButton = (Button) findViewById(R.id.btn_cancel_edit);
		addButton = (Button) findViewById(R.id.btn_add);
		
		boxArray = new CheckBox[3];
		
		boxArray[0] = (CheckBox)findViewById(R.id.checkBox1);
		boxArray[1] = (CheckBox)findViewById(R.id.checkBox2);
		boxArray[2] = (CheckBox)findViewById(R.id.checkBox3);
		
		for (int i = 0; i < boxArray.length; i++) {
			boxArray[i].setOnClickListener(this);
			boxArray[i].setOnCheckedChangeListener(this);
		}
		
		OnClickListener click = new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		};
		
		cancelButton.setOnClickListener(click);
		addButton.setOnClickListener(click);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_product, menu);
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
	public void onClick(View v) {
		final CheckBox cb = (CheckBox) v;
		
		cb.setChecked(state);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle("Choose an Option");
	    String[] options = { "  -  ", "Cangrejo", "Salmón" };
	    builder.setItems(options, new DialogInterface.OnClickListener() {
		    @Override
		    public void onClick(DialogInterface dialog, int which) {
		    	if( which == 0 ){
		    		cb.setChecked(false);
		    	}else{
		    		cb.setChecked(true);
		    	}
		    }
		});
	    builder.setNegativeButton("Cancel", null);
	    AlertDialog actions = builder.create();
	    
	    actions.show();
		
	}

	private boolean state = false; 
	
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		state = !isChecked;
	}
	
}
