package com.jom.sushi;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.jom.sushi.listsutils.AdapterListCategory;
import com.jom.sushi.listsutils.EditingMode;

public class DetailCategory extends Activity implements EditingMode{

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
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail_category, menu);
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
	public void onClickEdit(int index) {		
		Intent intent = new Intent(this, EditProduct.class);
		startActivity(intent);
	}
	
	@Override
	public void onClickAdd(int index) {
		finish();
	}
}
