package com.interview.evaluationproject;

import java.util.List;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.interview.evaluationproject.json.Company;
import com.interview.evaluationproject.R;

import com.interview.evaluationproject.view.CustomImageView;

public class CompanyAdapter extends BaseAdapter {
	GoogleMap map;
	private List<Company> mCompanies;
	private Context mContext;

	public CompanyAdapter(Context context,
			List<Company> companies) {
		this.mContext = context;
		this.mCompanies = companies;
	}

	@Override
	public int getCount() {
		return mCompanies.size();
	}

	@Override
	public Object getItem(int position) {
		return mCompanies.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v;
		CustomImageView imageView;
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes
			v = inflater.inflate(R.layout.company_layout, null);
		} else {
			v = convertView;
		}
		TextView nameView = (TextView) v.findViewById(R.id.name);
		Company company = mCompanies.get(position);
		nameView.setText(company.getProjectName());
		nameView.setVisibility(View.VISIBLE);
		return v;
	}
}
