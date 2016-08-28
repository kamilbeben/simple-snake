package com.beben.simplesnake;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.beben.simplesnake.SnakeGame;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class AndroidLauncher extends AndroidApplication implements AdHandler
{
	private static final String TAG = "AndroidLauncher";
	private static final String adUnitId = "ca-app-pub-4207211050901100/6931104674";
	private static final String testDevice = "544763AA7ED59BA07B569CEB067DA71B";
	protected AdView adView;
	private final int SHOW_ADS = 1;
	private final int HIDE_ADS = 0;

	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch(msg.what) {
				case SHOW_ADS:
					adView.setVisibility(View.VISIBLE);
					break;
				case HIDE_ADS:
					adView.setVisibility(View.GONE);
					break;
			}
		}
	};

	@Override
	public void showAds() {
		handler.sendEmptyMessage(SHOW_ADS);
	}

	@Override
	public void hideAds() {
		handler.sendEmptyMessage(HIDE_ADS);
	}

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RelativeLayout layout = new RelativeLayout(this);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		View gameView = initializeForView(new SnakeGame(this), config);
		layout.addView(gameView);


		RelativeLayout.LayoutParams adParams = initializeAdParams();
		AdRequest.Builder builder = initializeBuilder();

		initializeAdView();

		layout.addView(adView, adParams);

		adView.loadAd(builder.build());

		setContentView(layout);

	}

	private void initializeAdView() {
		adView = new AdView(this);
		adView.setAdListener(new AdListener() {
			@Override
			public void onAdLoaded() {
				int visibility = adView.getVisibility();
				adView.setVisibility(AdView.GONE);
				adView.setVisibility(visibility);
				Log.i(TAG, "Ad loaded");
			}
		});
		adView.setAdSize(AdSize.SMART_BANNER);
		adView.setAdUnitId(adUnitId);
	}

	private AdRequest.Builder initializeBuilder() {
		AdRequest.Builder builder;
		builder = new AdRequest.Builder();
		builder.addTestDevice(testDevice);
		return builder;
	}

	private RelativeLayout.LayoutParams initializeAdParams() {
		RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT
		);
		adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		return adParams;
	}
}
