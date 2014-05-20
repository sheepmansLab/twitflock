package jp.sheepman.app.twitflock.util;

import java.util.HashMap;

import android.graphics.drawable.Drawable;

public class ImageChacheUtil {
	private static HashMap<String, Drawable> cache;
	
	public static Drawable getImage(String url){
		if(cache.containsKey(url)){
			return cache.get(url);
		}
		return null;
	}
	
	public static void addImage(String url, Drawable image){
		if(!cache.containsKey(url)){
			cache.put(url, image);
		}
	}
	
	public static void clear(){
		cache.clear();
	}
}
