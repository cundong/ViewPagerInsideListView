package com.example.listdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.listdemo.adapter.MultiAdapter;

public class MainActivity extends Activity {

	private ListView mListView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mListView = (ListView) findViewById(R.id.listView1);

		ArrayList<String> dataList = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			dataList.add("cundong" + i);
		}

		//单type item demo
//		SimpleAdapter adapter = new SimpleAdapter(this, dataList);
//		mListView.setAdapter(adapter);

		//多type item demo
		MultiAdapter adapter = new MultiAdapter(this, dataList);
		mListView.setAdapter(adapter);
	}
}