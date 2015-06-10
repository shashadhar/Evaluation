package com.interview.evaluationproject.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.interview.evaluationproject.interfaces.ImageLoaderListener;
import com.interview.evaluationproject.utils.ImageLoader;

public class CustomImageView extends ImageView implements ImageLoaderListener {

	public CustomImageView(Context context) {
		super(context);
	}
	
	public CustomImageView(Context context, AttributeSet attributeSet){
		super(context, attributeSet);
	}
	public CustomImageView(Context context, AttributeSet attributeSet, int defStyle){
		super(context, attributeSet, defStyle);
	}
	@Override
	public void imageLoaded(Bitmap bitmap) {
		this.setImageBitmap(bitmap);

	}
	
	public void loadImage(String url){
		Bitmap bitmap = new ImageLoader().loadImage(url, this);
		if(bitmap != null){
			this.setImageBitmap(bitmap);
		}
	}
	
	public void loadImage(String url, int width, int height){
		Bitmap bitmap = new ImageLoader().loadImage(url, this, width, height);
		if(bitmap != null){
			this.setImageBitmap(bitmap);
		}
	}

}
