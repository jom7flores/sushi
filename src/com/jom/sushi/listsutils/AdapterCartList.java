package com.jom.sushi.listsutils;

import java.util.List;

import org.json.JSONObject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.jom.sushi.R;

public class AdapterCartList extends ArrayAdapter<JSONObject>{

	
	private Context context;
	private List<JSONObject> values;
	
	public AdapterCartList(Context context, List<JSONObject> objects) {
		super(context, R.layout.detail_category_cell , objects);
		this.context = context;
		this.values = objects;
	}
	
	@Override
	public int getCount() {
		return 10;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View rowView = convertView;
		
		if( rowView == null ){
			LayoutInflater inflater = (LayoutInflater) context
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
		    rowView = inflater.inflate(R.layout.cart_cell, parent, false);
			ViewHolder viewH = new ViewHolder();
			
			//viewH.text = (TextView) rowView.findViewById(R.id.textView1);
			
			rowView.setTag(viewH);			    
			    
		}
		
		ViewHolder viewHolder = (ViewHolder) rowView.getTag();
		//viewHolder.text.setText(values.get(position));

		return rowView;
	}
	
	class ViewHolder {
		
	}
}
