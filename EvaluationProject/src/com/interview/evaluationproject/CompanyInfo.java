package com.interview.evaluationproject;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.interview.evaluationproject.json.Company;
import com.interview.evaluationproject.json.CompanyDetails;
import com.interview.evaluationproject.json.Document;
import com.google.android.gms.maps.MapFragment;
import com.interview.evaluationproject.manager.AppManager;
import com.interview.evaluationproject.view.CustomImageView;
import com.interview.evaluationproject.R;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class CompanyInfo extends Activity {
	Company company;
	GoogleMap map;
	View clickImageLayout;
	Button closeClickImage;
	CustomImageView clickedImage;

	public static final String EXTRA_COMPANY = "message";
	public static CompanyDetails companyDetails = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.store);
		company = getIntent().getParcelableExtra(EXTRA_COMPANY);
		TextView fromText = (TextView) findViewById(R.id.company_text);
		clickImageLayout = findViewById(R.id.image_layout);
		closeClickImage = (Button) findViewById(R.id.close_click_image);
		clickedImage = (CustomImageView) findViewById(R.id.click_card_image);
		TextView address = (TextView) findViewById(R.id.address_txt);
		TextView city = (TextView) findViewById(R.id.city_txt);
		TextView locality = (TextView) findViewById(R.id.locality_txt);
		TextView description = (TextView) findViewById(R.id.description_txt);
		TextView landMark= (TextView) findViewById(R.id.landmark_txt);
		address.setText(companyDetails.getAddressLine1());
		city.setText(companyDetails.getCity());
		locality.setText(companyDetails.getLocality());
		description.setText(companyDetails.getDescription());
		landMark.setText(companyDetails.getLandmark());
		
		fromText.setText(company.getProjectName());
		Button detailsButton=(Button) findViewById(R.id.details);
		detailsButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(CompanyInfo.this, Details.class);
				Details.companyDetails=companyDetails;
				startActivity(intent);
				
			}
		});
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();

		if (map == null) {
			return;
		}
		map.setOnMarkerClickListener(markerClickListener);
		map.setOnInfoWindowClickListener(infoWindowClickListener);
		map.setOnMapClickListener(mapClickListener);
		map.animateCamera(CameraUpdateFactory.zoomIn());
		map.setMyLocationEnabled(true);

		LatLng latLng = new LatLng(company.getLat(), company.getLon());
		CameraUpdate cameraUpdate = CameraUpdateFactory
				.newLatLngZoom(latLng, 3);
		CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
		map.moveCamera(cameraUpdate);
		map.animateCamera(zoom);
		if (map != null) {
			Marker marker = map.addMarker(new MarkerOptions()
					.position(latLng)
					.title(company.getProjectName())
					.snippet(
							companyDetails.getAddressLine1() + ","
									+ companyDetails.getLocality()));
		}
		// --------------------------
		ViewGroup parent = (ViewGroup) findViewById(R.id.store_item_layout);

		TextView comName = (TextView) findViewById(R.id.company_name);
		comName.setText(company.getProjectName());
		parent.removeAllViews();
		for (int docIndex = 0; docIndex < companyDetails.getDocuments().size(); docIndex++) {
			Document compDoc = companyDetails.getDocuments().get(docIndex);
			loadPrepaidCardBrand(compDoc);
		}
		closeClickImage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				clickImageLayout.setVisibility(View.GONE);
			}
		});

	}

	public void loadPrepaidCardBrand(final Document doc) {

		RelativeLayout CreditLayout = (RelativeLayout) findViewById(R.id.store_top);
		CreditLayout.setVisibility(View.VISIBLE);

		ViewGroup parent = (ViewGroup) findViewById(R.id.store_item_layout);
		LayoutInflater inflator = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View view = inflator.inflate(R.layout.store_item, null);
		parent.addView(view);
		TextView textView = (TextView) view.findViewById(R.id.card_name);
		textView.setText(doc.getType());
		CustomImageView imageView = (CustomImageView) view
				.findViewById(R.id.card_image);
		imageView.loadImage(doc.getReference());

		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				clickImageLayout.setVisibility(View.VISIBLE);
				clickedImage.loadImage(doc.getReference());

			}
		});

	}

	OnMapClickListener mapClickListener = new OnMapClickListener() {

		@Override
		public void onMapClick(LatLng arg0) {
			Log.e("map click", "map click");

		}
	};

	OnMarkerClickListener markerClickListener = new OnMarkerClickListener() {

		@Override
		public boolean onMarkerClick(Marker marker) {
			Log.e("marker click", "marker click");
			return false;
		}

	};

	OnInfoWindowClickListener infoWindowClickListener = new OnInfoWindowClickListener() {

		@Override
		public void onInfoWindowClick(Marker marker) {

			Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
					Uri.parse("google.navigation:q="
							+ companyDetails.getLocality()));

			startActivity(intent);

			return;
		}

	};
}
