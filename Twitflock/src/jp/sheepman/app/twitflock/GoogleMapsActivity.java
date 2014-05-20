package jp.sheepman.app.twitflock;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

public class GoogleMapsActivity extends FragmentActivity {
	static final LatLng TOKYO_STATION = new LatLng(35.681588,139.76608); //東京駅の緯度経度
	
	private GoogleMap map;
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(arg0);
		setContentView(R.layout.activity_google_maps);
	}
	
}
