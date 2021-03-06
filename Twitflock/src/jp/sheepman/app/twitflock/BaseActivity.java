package jp.sheepman.app.twitflock;

import java.util.List;

import jp.sheepman.app.twitflock.util.CommonConst;
import android.app.Activity;
import android.view.ViewGroup.LayoutParams;

public abstract class BaseActivity<E> extends Activity {
	/** LayoutParams MATCH_PARENT */
	public final int M_P = CommonConst.M_P;
	/** LayoutParams WRAP_CONTENT */
	public final int W_C = CommonConst.W_C;
	
	/**
	 * Adapterクラスの結果をACtivityに反映する
	 * @param list 処理結果のList<E>
	 */
	public abstract void callback(List<E> list);
}
