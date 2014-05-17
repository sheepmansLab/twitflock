package jp.sheepman.app.twitflock.adapter;

import jp.sheepman.app.twitflock.R;
import jp.sheepman.app.twitflock.async.DownloadImageAsyncTask;
import twitter4j.Status;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TweetAdpter extends ArrayAdapter<Status> {
	private LayoutInflater inflater;
	
	public TweetAdpter(Context context) {
		super(context, android.R.layout.simple_expandable_list_item_1);
		inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//if(convertView != null){
			convertView = inflater.inflate(R.layout.tweet_layout, null);
		//}
		Status item = getItem(position);
		
		TextView name = (TextView)convertView.findViewById(R.id.text_name);
		TextView tweet = (TextView)convertView.findViewById(R.id.text_tweet);
		ImageView icon = (ImageView)convertView.findViewById(R.id.img_prof_icon);
		
		String nameStr = item.getUser().getName()
						+ "(@" + item.getUser().getScreenName() + ")";
		name.setText(nameStr);
		tweet.setText(item.getText());
		
		String imageurl = item.getUser().getProfileImageURL();
		if(imageurl != null){
			DownloadImageAsyncTask task = new DownloadImageAsyncTask(icon);
			task.execute(imageurl);
		}		
		return convertView;
	}

}
