package com.interview.evaluationproject;

import java.util.List;

import com.interview.evaluationproject.json.CompanyDetails;
import com.interview.evaluationproject.json.Summary;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class Details extends Activity {
	public static CompanyDetails companyDetails = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);
		TextView company=(TextView)findViewById(R.id.company_text);
		company.setText(companyDetails.getListingName());
		//Details ------------------------------------
		TextView details_maxArea=(TextView)findViewById(R.id.details_maxArea);
		TextView details_maxPrice=(TextView)findViewById(R.id.details_maxPrice);
		TextView details_maxPricePerSqft=(TextView)findViewById(R.id.details_maxPricePerSqft);
		TextView details_minArea=(TextView)findViewById(R.id.details_minArea);
		TextView details_minPrice=(TextView)findViewById(R.id.details_minPrice);
		TextView details_minPricePerSqft=(TextView)findViewById(R.id.details_minPricePerSqft);
		if(companyDetails!=null)
		{
		details_maxArea.setText(companyDetails.getMaxArea()==null?"null":companyDetails.getMaxArea().toString());
		details_maxPrice.setText(companyDetails.getMaxPrice()==null?"null":companyDetails.getMaxPrice().toString());
		details_maxPricePerSqft.setText(companyDetails.getMaxPricePerSqft()==null?"null":companyDetails.getMaxPricePerSqft().toString());
		details_minArea.setText(companyDetails.getMinArea()==null?"null":companyDetails.getMinArea().toString());
		details_minPrice.setText(companyDetails.getMinPrice()==null?"null":companyDetails.getMinPrice().toString());
		details_minPricePerSqft.setText(companyDetails.getMinPricePerSqft()==null?"null":companyDetails.getMinPricePerSqft().toString());
		}
			
		
		//Summarry---------------------------------------------------------------------
    	TextView summary_area=(TextView)findViewById(R.id.summary_Area);
		TextView summary_bathroom=(TextView)findViewById(R.id.summary_bathroom);
		TextView summary_bedroom=(TextView)findViewById(R.id.summary_bedroom);
		TextView summary_carparking=(TextView)findViewById(R.id.summary_carParking);
		TextView summary_landArea=(TextView)findViewById(R.id.summary_landArea);
		TextView summary_price=(TextView)findViewById(R.id.summary_price);
		TextView summary_projectType=(TextView)findViewById(R.id.summary_projectType);
		if(companyDetails!=null)
		{
		List<Summary> summary=companyDetails.getSummary();
		if(summary.size()>0)
		{
		summary_area.setText(summary.get(0).getArea()==null?"null":summary.get(0).getArea().toString());
		summary_bathroom.setText(summary.get(0).getBathrooms()==null?"null":summary.get(0).getBathrooms().toString());
		summary_bedroom.setText(summary.get(0).getBedroom()==null?"null":summary.get(0).getBedroom().toString());
		summary_carparking.setText(summary.get(0).getCarParking()==null?"null":summary.get(0).getCarParking().toString());
		summary_landArea.setText(summary.get(0).getLandArea()==null?"null":summary.get(0).getLandArea().toString());
		summary_price.setText(summary.get(0).getPrice()==null?"null":summary.get(0).getPrice().toString());
		summary_projectType.setText(summary.get(0).getPropertyType()==null?"null":summary.get(0).getPropertyType().toString());
		}
		}
		//Amenities--------------------------------------------------------------------
		if(companyDetails!=null)
		{
		//todo will do it dynamically
		List<String>amentities=companyDetails.getAmenities();
	    CheckBox amenities_1st=(CheckBox)findViewById(R.id.amenities_1st);
		CheckBox amenities_2nd=(CheckBox)findViewById(R.id.amenities_2nd);
		CheckBox amenities_3rd=(CheckBox)findViewById(R.id.amenities_3rd);
		CheckBox amenities_4th=(CheckBox)findViewById(R.id.amenities_4th);
		CheckBox amenities_5th=(CheckBox)findViewById(R.id.amenities_5th);
		CheckBox amenities_6th=(CheckBox)findViewById(R.id.amenities_6th);
		CheckBox amenities_7th=(CheckBox)findViewById(R.id.amenities_7th);
		CheckBox amenities_8th=(CheckBox)findViewById(R.id.amenities_8th);
		if(amentities.size()>0)
		{
	    	amenities_1st.setText(amentities.get(0).toString());
	    	amenities_1st.setVisibility(View.VISIBLE);
	    	amenities_1st.setChecked(true);
		}
		if(amentities.size()>1)
		{
	    	amenities_2nd.setText(amentities.get(1).toString());
	    	amenities_2nd.setVisibility(View.VISIBLE);
	    	amenities_2nd.setChecked(true);
		}
		if(amentities.size()>2)
		{
	    	amenities_3rd.setText(amentities.get(2).toString());
	    	amenities_3rd.setVisibility(View.VISIBLE);
	    	amenities_3rd.setChecked(true);
		}
		if(amentities.size()>3)
		{
	    	amenities_4th.setText(amentities.get(3).toString());
	    	amenities_4th.setVisibility(View.VISIBLE);
	    	amenities_4th.setChecked(true);
		}
		if(amentities.size()>4)
		{
	    	amenities_5th.setText(amentities.get(4).toString());
	    	amenities_5th.setVisibility(View.VISIBLE);
	    	amenities_5th.setChecked(true);
		}
		if(amentities.size()>5)
		{
	    	amenities_6th.setText(amentities.get(5).toString());
	    	amenities_6th.setVisibility(View.VISIBLE);
	    	amenities_6th.setChecked(true);
		}
		if(amentities.size()>6)
		{
	    	amenities_7th.setText(amentities.get(6).toString());
	    	amenities_7th.setVisibility(View.VISIBLE);
	    	amenities_7th.setChecked(true);
		}
		if(amentities.size()>7)
		{
	    	amenities_8th.setText(amentities.get(7).toString());
	    	amenities_8th.setVisibility(View.VISIBLE);
	    	amenities_8th.setChecked(true);
		}
	
		
		}
		
		
	}
	
	

}
