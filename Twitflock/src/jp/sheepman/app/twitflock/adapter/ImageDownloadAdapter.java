package jp.sheepman.app.twitflock.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ImageDownloadAdapter extends ArrayAdapter<Drawable> {

	public ImageDownloadAdapter(Context context, int resource) {
		super(context, resource);
		// TODO �����������ꂽ�R���X�g���N�^�[�E�X�^�u
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return super.getView(position, convertView, parent);
	}
}
