package com.jom.sushi.listsutils;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.jom.sushi.R;

public class AdapterListCategory extends ArrayAdapter<String>{

	private Context context;
	private List<String> values;
	private EditingMode callbackAction;
	
	public AdapterListCategory(Context context, List<String> objects, EditingMode callback) {
		super(context, R.layout.detail_category_cell , objects);
		this.context = context;
		this.values = objects;
		this.callbackAction = callback;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return super.getItemId(position);
	}
	
	@Override
	public int getCount() {
		return values.size();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View rowView = convertView;
		
		if( rowView == null ){
			LayoutInflater inflater = (LayoutInflater) context
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
		    rowView = inflater.inflate(R.layout.detail_category_cell, parent, false);
			ViewHolder viewH = new ViewHolder();
			viewH.text = (TextView) rowView.findViewById(R.id.textView1);
			viewH.editAction = (Button) rowView.findViewById(R.id.button1);
			viewH.addAction = (Button) rowView.findViewById(R.id.button2);
			rowView.setTag(viewH);			    
			    
		}
		
		ViewHolder viewHolder = (ViewHolder) rowView.getTag();
		viewHolder.text.setText(values.get(position));
		final int index = position;
		viewHolder.editAction.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(callbackAction != null){
					callbackAction.onClickEdit(index);
				}
			}
		});
		viewHolder.addAction.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(callbackAction != null){
					callbackAction.onClickAdd(index);
				}
			}
		});
		
	    return rowView;
	}
	
	class ViewHolder {
		public TextView text;
		public Button editAction;
		public Button addAction;
	}
	
}
