package com.jom.sushi;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

import com.jom.sushi.listsutils.AdapterListCategory;
import com.jom.sushi.listsutils.EditingMode;

public class DetailCategory extends Activity implements EditingMode, OnClickListener{

	private ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_category);
		
		list = (ListView) findViewById(R.id.listView1);
		
		ArrayList<String> lista = new ArrayList<>();
		
		lista.add("California");
		lista.add("Cubanito");
		lista.add("Cubanito light");
		
		list.setAdapter(new AdapterListCategory(this, lista, this));
		
		
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
	public void onClickEdit(int index) {		
		Intent intent = new Intent(this, EditProduct.class);
		startActivity(intent);
	}
	
	@Override
	public void onClickAdd(int index) {
		finish();
	}

	@Override
	public void onClick(View v) {
	}
}
