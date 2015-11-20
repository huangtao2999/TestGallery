package com.huangt.testgallery;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
/**
 * ª≠¿»≤‚ ‘
 * @author tao
 *
 */
public class MainActivity extends Activity {

	private ImageView iv;
	private Gallery gl;
	private List<Integer> list = new ArrayList<Integer>();
	private MyAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list.add(R.drawable.a1);
		list.add(R.drawable.a2);
		list.add(R.drawable.a3);
		list.add(R.drawable.a4);
		list.add(R.drawable.a5);
		mAdapter = new MyAdapter(this, list);
		
		iv = (ImageView) this.findViewById(R.id.imageview01);
		gl = (Gallery) this.findViewById(R.id.gallery01);
		gl.setAdapter(mAdapter);
		gl.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id)
			{
				iv.setImageResource(((ImageView)view).getId());
			}
			
		});
		gl.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				
				Toast.makeText(MainActivity.this, view.getId(), Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	
	private class MyAdapter extends BaseAdapter{
		private Context context;
		private List<Integer> list;
		private int mGalleryItemBackground;
		public MyAdapter(Context context, List<Integer> list)
		{
			this.context = context;
			this.list = list;
			
			TypedArray a = obtainStyledAttributes(R.styleable.HelloGallery);
			mGalleryItemBackground = a.getResourceId(R.styleable.HelloGallery_android_galleryItemBackground, 0);
			a.recycle();
		}

		@Override
		public int getCount()
		{
			return list.size();
		}

		@Override
		public Object getItem(int position)
		{
			return list.get(position);
		}

		@Override
		public long getItemId(int position)
		{
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			ImageView iv = new ImageView(context);
			iv.setImageResource(list.get(position));
			iv.setId(list.get(position));
			iv.setLayoutParams(new Gallery.LayoutParams(120,160));
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			iv.setBackgroundResource(mGalleryItemBackground);
			return iv;
		}
		
	}
}
