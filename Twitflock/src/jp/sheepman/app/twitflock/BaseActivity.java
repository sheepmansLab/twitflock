package jp.sheepman.app.twitflock;

import java.util.List;

import android.app.Activity;
import android.view.ViewGroup.LayoutParams;

public abstract class BaseActivity<E> extends Activity {
	public final int M_P = LayoutParams.MATCH_PARENT;
	public final int W_C = LayoutParams.WRAP_CONTENT;
	
	public abstract void callback(List<E> list);
}
