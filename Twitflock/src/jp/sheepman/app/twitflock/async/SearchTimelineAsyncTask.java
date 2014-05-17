package jp.sheepman.app.twitflock.async;

import java.util.List;

import jp.sheepman.app.twitflock.BaseActivity;
import jp.sheepman.app.twitflock.model.impl.SearchTimelineModel;
import android.os.AsyncTask;

public class SearchTimelineAsyncTask extends AsyncTask<Void, Void, List<twitter4j.Status>> {
	private BaseActivity<twitter4j.Status> activity;
	
	public SearchTimelineAsyncTask(BaseActivity<twitter4j.Status> activity) {
		this.activity = activity;
	}
	
	@Override
	protected List<twitter4j.Status> doInBackground(Void... params) {
		List<twitter4j.Status> list = null;
		SearchTimelineModel model = new SearchTimelineModel();
		list = model.searchTimeline();
		return list;
	}
	
	@Override
	protected void onPostExecute(List<twitter4j.Status> result) {
		activity.callback(result);
	}
}
