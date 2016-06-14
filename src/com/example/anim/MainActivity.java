package com.example.anim;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ImageView plane = (ImageView) findViewById(R.id.air);
		plane.setRotation(45);

		plane.post(new Runnable() {

			@Override
			public void run() {
				int[] location = new int[2];
				plane.getLocationInWindow(location);
				// plane.getLocationOnScreen(location);

				PropertyValuesHolder p = PropertyValuesHolder.ofFloat("x", plane.getLeft() - 100, plane.getLeft());
				PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("y", plane.getBottom(), plane.getTop());
				ObjectAnimator.ofPropertyValuesHolder(plane, p, p1).setDuration(1500).start();
			}
		});

		TextView didi = (TextView) findViewById(R.id.didi);
		didi.setRotation(315);
		didi.setText("di di");

		PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 0f, 1f, 0f, 1f, 0f);
		ObjectAnimator.ofPropertyValuesHolder(didi, pvhX).setDuration(1500).start();

		ImageView rail = (ImageView) findViewById(R.id.rail);

		PropertyValuesHolder x = PropertyValuesHolder.ofFloat("scaleX", 0.1f, 1f);
		PropertyValuesHolder y = PropertyValuesHolder.ofFloat("scaleY", 0.1f, 1f);
		ObjectAnimator.ofPropertyValuesHolder(rail, x, y).setDuration(6000).start();

		ImageView hotel = (ImageView) findViewById(R.id.hotel);
		PropertyValuesHolder hy = PropertyValuesHolder.ofFloat("rotation", 0, 15, 0, -15, 0, 15, 0, -15, 0);
		ObjectAnimator.ofPropertyValuesHolder(hotel, hy).setDuration(1200).start();

		final GifView v = (GifView) findViewById(R.id.gif);
		v.setMovieResource(R.drawable.qie);

		Animation anim = AnimationUtils.loadAnimation(this, R.anim.plane_fly);

		final LinearLayout lin = (LinearLayout) findViewById(R.id.lin);
		lin.startAnimation(anim);
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				lin.setVisibility(View.GONE);
			}
		}, 20000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
