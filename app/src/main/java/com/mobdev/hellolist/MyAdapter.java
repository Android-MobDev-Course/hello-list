package com.mobdev.hellolist;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Marco Picone (picone.m@gmail.com) 12/03/2020
 * Android example of RecyclerView Adapter
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

	private ArrayList<Double> mDataset;

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder
	public class ViewHolder extends RecyclerView.ViewHolder {

		private View v = null;

		public ViewHolder(View v) {
			super(v);
			this.v = v;
			
			v.setOnLongClickListener(new OnLongClickListener() {

				@Override
				public boolean onLongClick(View v) {
				int position = getAdapterPosition();
				NumberManager.getInstance().removeNumber(position);
				notifyItemRemoved(position);
				return false;
				}
			});
		}

		public void setText(String text){
			TextView tView = (TextView)v.findViewById(R.id.myTextView);
			tView.setText(text);
		}
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public MyAdapter(ArrayList<Double> myDataset) {
		mDataset = myDataset;
	}

	// Create new views (invoked by the layout manager)
	@Override
	public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

		// create a new view
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_element, parent, false);
		// set the view's size, margins, paddings and layout parameters

		ViewHolder vh = new ViewHolder(v);

		return vh;
	}

	// Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(ViewHolder holder, final int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element
		holder.setText(Double.toString(mDataset.get(position)));
	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return mDataset.size();
	}

}