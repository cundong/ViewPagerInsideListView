package com.example.listdemo.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.listdemo.R;
import com.example.listdemo.widget.IndicatorView;

public class SimpleAdapter extends SimpleBaseAdapter<String> {
	
	public SimpleAdapter(Context context, ArrayList<String> list) {
		super(context, list);
	}
	
	@Override
	public int getItemResourceId() {
		return R.layout.item_viewpager;
	}

	@Override
	public View getItemView(int position, View convertView, ViewHolder holder) {
		
		ViewPager viewPager = (ViewPager) holder.getView(R.id.viewpager);
		IndicatorView indicatorView = (IndicatorView) holder.getView(R.id.indicator);
		
		int size = position + 1;
		if (size > 10)
			size = 10;
		
		indicatorView.setUpView(size);
		indicatorView.setSelectIndex(0);
		
		MyPagerAdapter pageAdaper = new MyPagerAdapter(mContext, size);
		viewPager.setAdapter(pageAdaper);
		
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new MyPagerChangeListener(indicatorView));
		return convertView;
	}
}