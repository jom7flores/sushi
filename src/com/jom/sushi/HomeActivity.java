package com.jom.sushi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity implements OnClickListener{

	private Button[] category; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_home);
		
		category = new Button[7];
		
		category[0] = (Button)findViewById(R.id.button1);
		category[1] = (Button)findViewById(R.id.button2);
		category[2] = (Button)findViewById(R.id.button3);
		category[3] = (Button)findViewById(R.id.button4);
		category[4] = (Button)findViewById(R.id.button5);
		category[5] = (Button)findViewById(R.id.button6);
		category[6] = (Button)findViewById(R.id.button7);
		
		for(int i=0; i<7 ; i++){
			category[i].setText("Categoria "+ (i+1));
			category[i].setOnClickListener(this);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
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
		Intent intent = new Intent(this, DetailCategory.class);
		startActivity(intent);
	}
}
