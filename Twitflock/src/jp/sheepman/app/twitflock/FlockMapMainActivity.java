package jp.sheepman.app.twitflock;

import java.util.ArrayList;
import java.util.List;

import jp.sheepman.app.twitflock.async.SearchTimelineAsyncTask;
import twitter4j.Status;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class FlockMapMainActivity extends BaseActivity<Status> {

	static final LatLng PLACE = new LatLng(35.631889, 139.880973);
	
	private BaseActivity<Status> activity;
	private List<Marker> markList = new ArrayList<Marker>();
	private GoogleMap map;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flock_map_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		//イベントハンドラからの参照用に保存
		activity = this;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.flock_map_main, menu);
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

	@Override
	protected void onResume() {
		super.onResume();
		//mapがない場合取得する
		if(map == null){
			getGoogleMap();			
		}
		
		//ツイートを検索する
		new SearchTimelineAsyncTask(activity).execute();
	}
	
	/**
	 * Mapオブジェクトを取得する
	 */
	private void getGoogleMap(){
		Fragment base = getFragmentManager().findFragmentById(R.id.container);
		map = ((MapFragment)base.getFragmentManager().findFragmentById(R.id.map)).getMap();
		if(map != null){
			moveCamera(PLACE);
		}
	}
	
	/**
	 * カメラを指定座標に移動する
	 * @param location 座標
	 */
	private void moveCamera(LatLng location){
		CameraPosition pos = new CameraPosition(location, 14, 0, 0);
		CameraUpdate camera = CameraUpdateFactory.newCameraPosition(pos);
		map.moveCamera(camera);
	}
	
	
	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_flock_map_main,
					container, false);
			return rootView;
		}
	}

	/**
	 * Tweetの位置情報の検索結果をマップ上にポイントする
	 * @param list 位置情報を持ったStatus
	 */
	@Override
	public void callback(List<Status> list) {
		if(map != null){
			for(Status status:list){
				double latitude = status.getGeoLocation().getLatitude();
				double longitude = status.getGeoLocation().getLongitude();
				LatLng pos = new LatLng(latitude, longitude);
				Marker marker = map.addMarker(new MarkerOptions().position(pos));
				marker.setTitle(status.getUser().getName());
				marker.setSnippet(status.getText());
				markList.add(marker);
			}
		}
	}

}
