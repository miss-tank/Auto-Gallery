/* Ankita Tank
 * CS 478
  * Project 2
  * Most of the code is from the sample code provided by professor Buy in his example gridUI code  */
package com.example.android.project_2_atank2;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.List;

import static com.example.android.project_2_atank2.GridLayoutActivity.EXTRA_RES_ID;

public class ImageViewActivity extends Activity
{

	private List<Integer> mThumbIds;
	private Context mContext;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the Intent used to start this Activity
		Intent intent = getIntent();
		// Make a new ImageView
		ImageView imageView = new ImageView(getApplicationContext());
		
		// Get the ID of the image to display and set it as the image for this ImageView
		imageView.setImageResource(intent.getIntExtra(EXTRA_RES_ID, 0));

		setContentView(imageView);

	}
}