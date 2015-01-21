package com.jom.sushi;

import java.util.ArrayList;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.jom.sushi.listsutils.AdapterCartList;

public class Cart extends Activity {

	
	private ListView cartList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart);
		
		cartList = (ListView) findViewById(R.id.cart_list);
		
		ArrayList<JSONObject> lista = new ArrayList<>();
		
		cartList.setAdapter(new AdapterCartList(this, lista));
		
	}

}
