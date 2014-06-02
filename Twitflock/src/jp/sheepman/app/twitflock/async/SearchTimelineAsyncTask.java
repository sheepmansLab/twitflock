package jp.sheepman.app.twitflock.async;

import java.util.List;

import com.google.android.gms.maps.model.LatLng;

import jp.sheepman.app.twitflock.BaseActivity;
import jp.sheepman.app.twitflock.model.impl.SearchTimelineModel;
import android.location.Location;
import android.os.AsyncTask;

public class SearchTimelineAsyncTask extends AsyncTask<LatLng, Void, List<twitter4j.Status>> {
	private BaseActivity<twitter4j.Status> activity;
	
	public SearchTimelineAsyncTask(BaseActivity<twitter4j.Status> activity) {
		this.activity = activity;
	}
	
	@Override
	protected List<twitter4j.Status> doInBackground(LatLng... params) {
		List<twitter4j.Status> list = null;
		SearchTimelineModel model = new SearchTimelineModel();
		list = model.searchTimeline(params[0]);
		return list;
	}
	
	@Override
	protected void onPostExecute(List<twitter4j.Status> result) {
		activity.callback(result);
	}
}
