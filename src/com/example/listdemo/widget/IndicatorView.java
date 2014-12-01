package com.example.listdemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.listdemo.R;

/**
 * 类说明：	可以左右滑动的图片指示控件 常用于启动页or多图滚动
 * 
 * @date 	2014-9-13
 * @version 1.0
 */
public class IndicatorView extends LinearLayout {

	private Context mContext = null;

	private LinearLayout mViewGroup = null;
	private ImageView[] mImages = null;

	private int mDefaultSel, mCounter = 0;
	private float mPadding, mSize;
	private int mImageFocused, mImageNormal;

	public IndicatorView(Context context) {
		super(context);
	}

	public IndicatorView(Context context, AttributeSet attrs) {
		super(context, attrs);

		mContext = context;
		
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IndicatorView);

		mDefaultSel = typedArray.getInt(R.styleable.IndicatorView_indicator_default_sel, 0);
		mCounter = typedArray.getInt(R.styleable.IndicatorView_indicator_counter, mCounter);
		mPadding = typedArray.getDimension(R.styleable.IndicatorView_indicator_padding, 0);
		mSize = typedArray.getDimension(R.styleable.IndicatorView_indicator_size, 0);
		
		mImageFocused = typedArray.getResourceId(R.styleable.IndicatorView_indicator_img_focused, R.drawable.guide_indicator_focused);
		mImageNormal = typedArray.getResourceId(R.styleable.IndicatorView_indicator_img_normal, R.drawable.guide_indicator);

		typedArray.recycle();
	}

	public void setUpView() {
		setUpView(mCounter);
	}
	
	/**
	 * 设置View
	 * 
	 * @param counter
	 */
	public void setUpView(int counter) {

		this.mCounter = counter;
		this.removeAllViews();
		
		mImages = new ImageView[mCounter];
		
		mViewGroup = new LinearLayout(mContext);
		mViewGroup.setOrientation(LinearLayout.HORIZONTAL);
		
		addView(mViewGroup);
		
		int width = Math.round(mSize);
		int height = Math.round(mSize);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);

		ImageView imageView = null;

		for (int i = 0; i < mCounter; i++) {
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(params);
			
			params.setMargins(Math.round(mPadding), Math.round(mPadding), Math.round(mPadding), Math.round(mPadding));

			mImages[i] = imageView;
			mImages[i].setBackgroundResource(i == mDefaultSel ? mImageFocused : mImageNormal);
			
			mViewGroup.addView(mImages[i]);
		}
		
		mViewGroup.setVisibility(mCounter > 1 ? View.VISIBLE : View.GONE);
	}
	
	/**
	 * 设置所选中的项
	 * 
	 * @param index
	 */
	public void setSelectIndex(int index) {
		if (index < 0) {
			index = 0;
		} else if (index >= mCounter) {
			index = mCounter - 1;
		}

		mDefaultSel = index;

		if (mImages != null && mImages.length != 0) {
			for (int i = 0; i < mCounter; i++) {
				mImages[i].setBackgroundResource(i == mDefaultSel ? mImageFocused : mImageNormal);
			}
		}
	}
}