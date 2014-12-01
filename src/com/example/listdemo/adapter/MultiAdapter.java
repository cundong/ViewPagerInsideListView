package com.example.listdemo.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.listdemo.R;
import com.example.listdemo.widget.IndicatorView;

public class MultiAdapter extends MultiViewTypeBaseAdapter<String> {

	private static final int TYPE_0 = 0;
	private static final int TYPE_1 = 1;

	public MultiAdapter(Context context, ArrayList<String> list) {
		super(context, list);

	}

	public MultiAdapter(Context context, ArrayList<String> list, int viewTypeCount) {
		super(context, list, viewTypeCount);

	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public int getItemViewType(int position) {

		if (position % 2 == 0) {
			return TYPE_0;
		} else {
			return TYPE_1;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int type = getItemViewType(position);
		ViewHolder holder0 = null;
		ViewHolder holder1 = null;

		switch (type) {
		case TYPE_0: {

			if (convertView == null) {
				convertView = LayoutInflater.from(mContext).inflate(getItemResourceId(type), parent, false);
				holder0 = new ViewHolder(convertView);
				convertView.setTag(holder0);
			} else {
				holder0 = (ViewHolder) convertView.getTag();
			}

			return getItemView(position, convertView, holder0, type);
		}
		case TYPE_1:
		default: {
			if (convertView == null) {
				convertView = LayoutInflater.from(mContext).inflate(getItemResourceId(type), parent, false);
				holder1 = new ViewHolder(convertView);
				convertView.setTag(holder1);
			} else {
				holder1 = (ViewHolder) convertView.getTag();
			}

			return getItemView(position, convertView, holder1, type);
		}
		}
	}

	@Override
	public int getItemResourceId(int type) {
		if (type == TYPE_0) {
			return R.layout.item_viewpager;
		} else {
			return R.layout.item_common;
		}
	}

	@Override
	public View getItemView(int position, View convertView, ViewHolder holder, int type) {
		
		String item = mDataList.get(position);

		switch (type) {
		case TYPE_0: {
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
			break;
		}
		case TYPE_1: {
			TextView textView = (TextView) holder.getView(R.id.textView1);
//			textView.setText(item);

			break;
		}
		}

		return convertView;
	}
}