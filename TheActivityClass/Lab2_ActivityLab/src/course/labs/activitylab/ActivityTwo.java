package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	// Use these as keys when you're saving state between reconfigurations
	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	private Integer mCreate, mRestart, mStart, mResume;

	TextView mTvCreate, mTvRestart, mTvStart, mTvResume;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		mCreate=0; mRestart=0; mStart=0; mResume=0;

		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);

		mTvCreate = (TextView) findViewById(R.id.create);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);

		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO:
				// This function closes Activity Two
				// Hint: use Context's finish() method
				finish();
			}
		});

		// Has previous state been saved?
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			mRestart = (Integer) (savedInstanceState.get(RESTART_KEY)) + 222;
			mResume = (Integer) (savedInstanceState.get(RESUME_KEY));
			mStart = (Integer) (savedInstanceState.get(START_KEY));
			mCreate = (Integer) (savedInstanceState.get(CREATE_KEY));

		} else {
			mRestart = 0;
			mResume = 0;
			mStart = 0;
			mCreate = 0;
		}


		++mCreate;
		String[] strs = getString(R.string.onCreate).split(" ");
		String str = strs[0] + " " + strs[1] + " " + mCreate;
		mTvCreate.setText(str);

		// Emit LogCat message using the Log.i method
		Log.i("ActivityTwo", "create " + mCreate);
	}



	@Override
	public void onStart() {
		super.onStart();
		++mStart;
		String[] strs = getString(R.string.onStart).split(" ");
		String str = strs[0] + " " + strs[1] + " " + mStart;
		mTvStart.setText(str);
		// Emit LogCat message using the Log.i method
		Log.i("ActivityTwo", "start " + mStart);
	}

	@Override
	public void onResume() {
		super.onResume();
		++mResume;
		String[] strs = getString(R.string.onResume).split(" ");
		String str = strs[0] + " " + strs[1] + " " + mResume;
		mTvResume.setText(str);
		// Emit LogCat message using the Log.i method
		Log.i("ActivityTwo", "resume " + mResume);
	}

	@Override
	public void onPause() {
		super.onPause();
		// Emit LogCat message using the Log.i method
		Log.i("ActivityTwo", "pause");
	}

	@Override
	public void onStop() {
		super.onStop();
		// Emit LogCat message using the Log.i method
		Log.i("ActivityTwo", "stop");
	}

	@Override
	public void onRestart() {
		super.onRestart();
		++mRestart;
		String[] strs = getString(R.string.onRestart).split(" ");
		String str = strs[0] + " " + strs[1] + " " + mRestart;
		mTvRestart.setText(str);
		// Emit LogCat message using the Log.i method
		Log.i("ActivityTwo", "restart " + mRestart);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		// Emit LogCat message using the Log.i method
		Log.i("ActivityTwo", "destroy");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putInt(RESTART_KEY, mRestart);
		savedInstanceState.putInt(RESUME_KEY, mResume);
		savedInstanceState.putInt(START_KEY, mStart);
		savedInstanceState.putInt(CREATE_KEY, mCreate);

		super.onSaveInstanceState(savedInstanceState);
	}


	// specified above
	public void displayCounts() {

	
	}
}
