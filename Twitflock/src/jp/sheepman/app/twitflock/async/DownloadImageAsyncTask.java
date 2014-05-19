package jp.sheepman.app.twitflock.async;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import jp.sheepman.app.twitflock.R;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

public class DownloadImageAsyncTask extends AsyncTask<String, Void, Drawable> {

	private ImageView view;
	
	public DownloadImageAsyncTask(ImageView view) {
		this.view = view;
	}
	
	@Override
	protected Drawable doInBackground(String... params) {
		try{
			if(params[0] != null){
				URL url = new URL(params[0]);
				return Drawable.createFromStream(url.openStream(), "");
			}
		} catch (MalformedURLException me) {
			me.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return null;
	}
	@Override
	protected void onPostExecute(Drawable result) {
		if(view != null){
			view.setImageDrawable(result);
		}
	}
}
