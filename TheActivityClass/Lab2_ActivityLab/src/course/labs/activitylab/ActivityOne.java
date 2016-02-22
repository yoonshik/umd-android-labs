package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";

	// Lifecycle counters

	// TODO:
	private Integer mCreate=0, mRestart=0, mStart=0, mResume=0;

	TextView mTvCreate, mTvRestart, mTvStart, mTvResume;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);



		++mCreate;

		mTvCreate = (TextView) findViewById(R.id.create);
		
		final ActivityOne activityOne = this;

		mTvCreate = (TextView) findViewById(R.id.create);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);

		String[] strs = getString(R.string.onCreate).split(" ");
		String str = strs[0] + " " + strs[1] + " " + mCreate;
		mTvCreate.setText(str);

		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {


				Intent intent = new Intent(activityOne, ActivityTwo.class);
				startActivity(intent);
			}
		});

		// Emit LogCat message using the Log.i method
		Log.i("ActivityOne", "create " + mCreate);

	}



	@Override
	public void onStart() {
		super.onStart();
		++mStart;

		String[] strs = getString(R.string.onStart).split(" ");
		String str = strs[0] + " " + strs[1] + " " + mStart;
		mTvStart.setText(str);

		// Emit LogCat message using the Log.i method
		Log.i("ActivityOne", "start " + mStart);
	}

	@Override
	public void onResume() {
        super.onResume();
		++mResume;

		String[] strs = getString(R.string.onResume).split(" ");
		String str = strs[0] + " " + strs[1] + " " + mResume;
		mTvResume.setText(str);


		// Emit LogCat message using the Log.i method
		Log.i("ActivityOne", "resume " + mResume);
	}

	@Override
	public void onPause() {
        super.onPause();
		// Emit LogCat message using the Log.i method
		Log.i("ActivityOne", "pause");
	}

	@Override
	public void onStop() {
        super.onStop();
		// Emit LogCat message using the Log.i method
		Log.i("ActivityOne", "stop");
	}

	@Override
	public void onRestart() {
        super.onRestart();
		++mRestart;

		String[] strs = getString(R.string.onRestart).split(" ");
		String str = strs[0] + " " + strs[1] + " " + mRestart;
		mTvRestart.setText(str);


		// Emit LogCat message using the Log.i method
		Log.i("ActivityOne", "restart " + str);

	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		// Emit LogCat message using the Log.i method
		Log.i("ActivityOne", "destroy");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putInt(RESTART_KEY, mRestart);
		savedInstanceState.putInt(RESUME_KEY, mResume);
		savedInstanceState.putInt(START_KEY, mStart);
		savedInstanceState.putInt(CREATE_KEY, mCreate);
	}


	public void displayCounts() {

	}
}
