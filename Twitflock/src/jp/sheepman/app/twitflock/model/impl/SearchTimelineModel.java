package jp.sheepman.app.twitflock.model.impl;

import java.util.List;

import jp.sheepman.app.twitflock.model.BaseModel;
import jp.sheepman.app.twitflock.util.TwitterUtil;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;

public class SearchTimelineModel extends BaseModel {

	public List<Status> searchTimeline(){
		List<Status> list = null;
		Twitter twitter = TwitterUtil.getTwitterInstance();
		Query q = TwitterUtil.getDefaultQuery();
		
		try{
			q.setQuery("ÉeÉXÉg");
			
			QueryResult qr = twitter.search(q);
			list = qr.getTweets();
		}catch(Exception e){
			//TODO Exceptionèàóù
		}
		return list;
	}
}
