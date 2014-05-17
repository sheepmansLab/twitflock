package jp.sheepman.app.twitflock;

import java.util.List;

import jp.sheepman.app.twitflock.adapter.TweetAdpter;
import jp.sheepman.app.twitflock.async.SearchTimelineAsyncTask;
import twitter4j.Status;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends BaseActivity<Status>{

	private TweetAdpter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		this.adapter = new TweetAdpter(this);
		
		ListView lv = new ListView(this);
		lv.setAdapter(adapter);
		
		addContentView(lv, new LayoutParams(W_C, W_C));
		
		SearchTimelineAsyncTask task = new SearchTimelineAsyncTask(this);
		task.execute();
	}

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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	@Override
	public void callback(List<Status> list) {
		for(Status status:list){
			adapter.add(status);
		}
	}
}
