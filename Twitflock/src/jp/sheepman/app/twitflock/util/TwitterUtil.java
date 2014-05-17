package jp.sheepman.app.twitflock.util;

import twitter4j.Query;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class TwitterUtil {

	public static Twitter getTwitterInstance(){
		return new TwitterFactory().getInstance();
	}
	
	public static Query getDefaultQuery(){
		Query query = new Query();
		
		query.setLang("ja");
		query.setLocale("ja");
		
		return query;
	}
	
}
