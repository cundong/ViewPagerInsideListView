package com.example.listdemo.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.listdemo.Constants;
import com.example.listdemo.R;

public class MyPagerAdapter extends PagerAdapter {

	private Context mContext;
	private int mCounter = 4;

	public MyPagerAdapter() {
	}

	public MyPagerAdapter(Context context, int counter) {
		mContext = context;
		mCounter = counter;
	}

	public void setCounter(int counter) {
		mCounter = counter;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((View) object);
	}

	@Override
	public int getCount() {
		return mCounter;
	}

	@Override
	public Parcelable saveState() {
		return null;
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView((View) object);
	}

	@Override
	public Object instantiateItem(View container, int position) {

		View view = LayoutInflater.from(mContext).inflate(R.layout.viwepager_view, null);
		
		final int index = position;
		
		Button button1 = (Button)view.findViewById(R.id.button1);
		button1.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(mContext, "position:"+index, Toast.LENGTH_SHORT).show();
			}
		});
		
		int imageSize = Constants.IMAGES.length;
		
		if (position < imageSize) {
			view.setBackgroundResource(Constants.IMAGES[position]);
		} else {
			view.setBackgroundResource(Constants.IMAGES[0]);
		}

		((ViewPager) container).addView(view);
		
		return view;
	}
}