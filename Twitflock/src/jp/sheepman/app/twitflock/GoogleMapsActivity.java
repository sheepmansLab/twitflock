package jp.sheepman.app.twitflock;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class GoogleMapsActivity extends FragmentActivity {
	static final LatLng TOKYO_STATION = new LatLng(35.681588,139.76608); //東京駅の緯度経度
	static final LatLng TOKYO_STATION2 = new LatLng(35.681488,139.76608); //東京駅の緯度経度
	
	private GoogleMap map;
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(arg0);
		setContentView(R.layout.activity_google_maps);		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		map = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
		if(map != null){
			CameraPosition camerapos = new CameraPosition(TOKYO_STATION, 16, 0, 0);
			CameraUpdate camera = CameraUpdateFactory.newCameraPosition(camerapos);
			map.moveCamera(camera);
			
			MarkerOptions opt1 = new MarkerOptions().position(TOKYO_STATION);
			MarkerOptions opt2 = new MarkerOptions().position(TOKYO_STATION2);

			Marker mark1 = map.addMarker(opt1);
			Marker mark2 = map.addMarker(opt2);
			
			PolylineOptions line = new PolylineOptions().add(TOKYO_STATION, TOKYO_STATION2).geodesic(false);
			map.addPolyline(line);
			
		}
		
	}
	
}
