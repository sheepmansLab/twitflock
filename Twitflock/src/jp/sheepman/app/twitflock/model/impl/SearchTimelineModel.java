package jp.sheepman.app.twitflock.model.impl;

import java.util.ArrayList;
import java.util.List;

import jp.sheepman.app.twitflock.model.BaseModel;
import jp.sheepman.app.twitflock.util.TwitterUtil;
import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import android.util.Log;

public class SearchTimelineModel extends BaseModel {
	
	public List<Status> searchTimeline(){
		List<Status> ret = new ArrayList<Status>();;
		List<Status> list = null;
		Twitter twitter = TwitterUtil.getTwitterInstance();
		Query q = TwitterUtil.getDefaultQuery();
		
		try{
			GeoLocation location = new GeoLocation(35.631889, 139.880973);
			q.setGeoCode(location, 5, Query.KILOMETERS);
			q.setCount(100);
			
			QueryResult qr = twitter.search(q);
			list = qr.getTweets();
			
			for(Status s:list){
				if(s.getGeoLocation() != null){
					ret.add(s);
				}
			}
		}catch(Exception e){
			//TODO Exceptionèàóù
		}
		Log.d("test", "åèêîÅF"+ret.size());
		return ret;
	}
}
