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
		getMenuInflater().inflate(R.menu.cart_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_cart) {
			Intent intent = new Intent( this, Cart.class);
			startActivity(intent);
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
