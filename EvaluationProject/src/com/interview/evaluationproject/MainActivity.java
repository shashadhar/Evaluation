package com.interview.evaluationproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.interview.evaluationproject.json.Company;
import com.interview.evaluationproject.json.CompanyDetails;
import com.interview.evaluationproject.manager.AppManager;
import com.interview.evaluationproject.net.NetworkCommunicator;
import com.interview.evaluationproject.utils.CacheReader;
import com.interview.evaluationproject.R;

public class MainActivity extends Activity {
	GoogleMap map;
	boolean syncCompanyFailed = false;
	boolean syncCompanyDetailsFailed = false;
	private ListView companyListView;
	List<Company> allCompanies;
	CompanyDetails compDetails;
	Company company;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AppManager.getInstance().init(getApplicationContext());
		companyListView = (ListView) findViewById(R.id.company_list);
		setUp();
		companyListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.e("Messages fragment",
						"message clicked position:" + String.valueOf(position));
				company = allCompanies.get(position);
				(new SyncCompanyDetails()).execute(company.getId());

			}
		});

	}

	private void setUp() {
		new SyncCompanies().execute();
		// new SyncCompanyDetails().execute();
	}

	private class SyncCompanies extends AsyncTask<Void, Void, List<Company>> {

		@Override
		protected void onPreExecute() {
			// TODO
		}

		@Override
		protected List<Company> doInBackground(Void... params) {
			syncCompanyFailed = false;

			List<Company> companies = new ArrayList<Company>();
			try {
				companies = NetworkCommunicator.GetAllCompaies();
				allCompanies = companies;
			} catch (Exception e) {
				syncCompanyFailed = true;
			}
			Log.e("Companies", String.valueOf(companies.size()));
			return companies;
		}

		@Override
		protected void onPostExecute(List<Company> result) {

			if (result.size() == 0) {
				if (syncCompanyFailed) {
					result = CacheReader.readCachedCompanies();
					allCompanies = result;
				}

			} else {
				try {
					CacheReader.saveCompanies(result);
					updateCompanyDetailsInBackground(allCompanies);

				} catch (Exception e) {
					Log.e("Main activity", "error in saving");
				}

			}
			CompanyAdapter adapter = new CompanyAdapter(MainActivity.this,
					result);
			companyListView.setAdapter(adapter);
		}

	}

	private static void updateCompanyDetailsInBackground(
			final List<Company> companies) {
		new Timer().schedule(new TimerTask() {
			public void run() {
				CacheReader.updateCompanyDetails(companies);

			}
		}, 10);

	}

	private class SyncCompanyDetails extends
			AsyncTask<String, Void, CompanyDetails> {

		@Override
		protected void onPreExecute() {
			// to do
		}

		@Override
		protected CompanyDetails doInBackground(String... params) {
			syncCompanyDetailsFailed = false;
			CompanyDetails companyDetails = null;
			try {
				companyDetails = NetworkCommunicator
						.GetCompanyDetails(params[0]);

			} catch (Exception e) {
				syncCompanyDetailsFailed = true;
			}
			return companyDetails;
		}

		@Override
		protected void onPostExecute(CompanyDetails result) {
			compDetails = result;
			if(result==null)
			{
				
				List<CompanyDetails> allDetails =CacheReader.readCachedCompanyDetails();
				CompanyDetails testDetails=allDetails.get(0);
				Log.e("company details",testDetails.getAddressLine1());
				for (CompanyDetails companyDetails : allDetails) {
					Log.e("company details",companyDetails.getAddressLine1());
					if(companyDetails.getId().equalsIgnoreCase(company.getId()))
					{
						compDetails=companyDetails;
						CompanyInfo.companyDetails = compDetails;
						Intent intent = new Intent();
						intent.setClass(MainActivity.this, CompanyInfo.class);
						intent.putExtra(CompanyInfo.EXTRA_COMPANY, company);
						startActivity(intent);
						break;
					}
					
				}
			}			
			if (result != null) {
				if (syncCompanyDetailsFailed) {
					
				} else {
					CompanyInfo.companyDetails = compDetails;
					Intent intent = new Intent();
					intent.setClass(MainActivity.this, CompanyInfo.class);
					intent.putExtra(CompanyInfo.EXTRA_COMPANY, company);
					startActivity(intent);
				}

			}

		}

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		/*
		 * map = ((MapFragment) getFragmentManager().findFragmentById(
		 * R.id.map)).getMap();
		 * 
		 * if (map == null) { return; }
		 * map.setOnMarkerClickListener(markerClickListener);
		 * map.setOnInfoWindowClickListener(infoWindowClickListener);
		 * map.setOnMapClickListener(mapClickListener);
		 * map.animateCamera(CameraUpdateFactory.zoomIn());
		 * map.setMyLocationEnabled(true);
		 * 
		 * LatLng latLng = new LatLng(13.08, 80.27); CameraUpdate cameraUpdate =
		 * CameraUpdateFactory.newLatLngZoom(latLng, 3);
		 * //cameraUpdate=CameraUpdateFactory.zoomBy(10); //
		 * map.moveCamera(cameraUpdate); CameraUpdate
		 * zoom=CameraUpdateFactory.zoomTo(15); map.moveCamera(cameraUpdate);
		 * map.animateCamera(zoom); if (map != null) { Marker marker =
		 * map.addMarker(new MarkerOptions() .position(latLng).title("SDas")
		 * .snippet("guindy:velachery")); }
		 */
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
					Uri.parse("google.navigation:q=" + "My name" + " "
							+ "456789"));

			startActivity(intent);

			return;
		}

	};

	/*
	 * void placeMarker(com.sequent.wallet.mastercard.Location location,
	 * Merchant merchant) { try { LatLng latLng = new
	 * LatLng(location.getLatitude(), location.getLongitude());
	 * 
	 * if (map != null) { Marker marker = map.addMarker(new MarkerOptions()
	 * .position(latLng).title(merchant.getName())
	 * .snippet(location.getAddress())); } } catch (Throwable t) {
	 * Log.e("PlaceMarker", t.toString() + location.toString(), t);
	 * 
	 * } }
	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
}
