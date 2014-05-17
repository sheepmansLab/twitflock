package jp.sheepman.app.twitflock.adapter;

import java.net.URL;

import jp.sheepman.app.twitflock.R;
import twitter4j.Status;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
		
		String nameStr = item.getUser().getName()
						+ "(@" + item.getUser().getScreenName() + ")";
		name.setText(nameStr);
		tweet.setText(item.getText());
		try{
			if(item.getUser().getProfileImageURL() != null){
				ImageView icon = (ImageView)convertView.findViewById(R.id.img_prof_icon);
				Bitmap bmp = BitmapFactory.decodeStream(new URL(item.getUser().getProfileImageURL()).openStream());
				icon.setImageBitmap(bmp);
			}
		} catch(Exception e) {
			//TODO Exceptionèàóù
			e.printStackTrace();
		}
		
		return convertView;
	}

}
