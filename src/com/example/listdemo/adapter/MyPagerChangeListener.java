package com.example.listdemo.adapter;

import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.example.listdemo.widget.IndicatorView;

public class MyPagerChangeListener implements OnPageChangeListener {

	IndicatorView mIndicatorView = null;
	
	public MyPagerChangeListener( IndicatorView indicatorView) {
		mIndicatorView = indicatorView;
	}
	
	@Override
	public void onPageSelected(int position) {
		// Toast.makeText(context, "position=" + position, 1).show();
		mIndicatorView.setSelectIndex(position);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}
}