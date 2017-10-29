/* Ankita Tank
 * CS 478
  * Project 2
  * Most of the code is from the sample code provided by professor Buy in his example gridUI code  */
package com.example.android.project_2_atank2;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import static android.R.attr.id;
import static com.example.android.project_2_atank2.R.array.BMWaddress;

//This application uses some deprecated methods. 
//See UIViewPager for a more modern version of this application
public class GridLayoutActivity extends Activity {

	protected static final String EXTRA_RES_ID = "POS";
	LinearLayout containerLayout;
	final Context context = this;
	LayoutParams layoutParams;
	private int position;
	PopupWindow window;
	TextView tvMsg;

	//String array to store address and website links from string.xml
	String[] website_Links;
	String[] Audi;
	String[] BMW;
	String[] Lambo;
	String[] Maserati;
	String[] RR;
	String[] Toyota;

	//Required Variables
	LinearLayout mainLayout;
	long idlong;
	String idstring;
	int index=0;


	private ArrayList<String>websitelink=new ArrayList<String>();


	private ArrayList<Integer> mThumbIdsFlowers = new ArrayList<Integer>(
			Arrays.asList(R.drawable.image1, R.drawable.image2,
					R.drawable.image3, R.drawable.image4, R.drawable.image5,
					R.drawable.image6));



	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		GridView gridview = (GridView) findViewById(R.id.gridview);

		//store website string from string.xml
		 website_Links = getResources().getStringArray(R.array.website);


		//get addresses from string.xml file and store then to show them when required according to the index
		Audi=getResources().getStringArray(R.array.Audiaddress);
		BMW = getResources().getStringArray(BMWaddress);
		Lambo=getResources().getStringArray(R.array.Lamboaddress);
		Maserati= getResources().getStringArray(R.array.Maseratiaddress);
		RR=getResources().getStringArray(R.array.RRaddress);
		Toyota=getResources().getStringArray(R.array.Toyotaaddress);


		// Create a new ImageAdapter and set it as the Adapter for this GridView
		gridview.setAdapter(new ImageAdapter(this, mThumbIdsFlowers));
		gridview.setLongClickable(true);
		gridview.setOnItemLongClickListener(gridLongClick);

		containerLayout = new LinearLayout(this);
		mainLayout = new LinearLayout(this);

		//create a popup window to show address content
		window = new PopupWindow(this);

		//load the addresses in the arraylist
		for(int i=0;i<6;i++)
		{
			websitelink.add(website_Links[i]);
		}



		// Set an setOnItemClickListener on the GridView
		gridview.setOnItemClickListener(new OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

				Intent intent = new Intent(GridLayoutActivity.this,
						ImageViewActivity.class);
				intent.putExtra(EXTRA_RES_ID, (int) id);
				startActivity(intent);
			}
		});

		idstring = Long.toString(id);

		//create a context menu for long click
		registerForContextMenu(gridview);


	}

	public GridView.OnItemLongClickListener gridLongClick = new GridView.OnItemLongClickListener()
	{

		@Override
		public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l)
		{
			idlong=l;
			position = i;
			return false;
		}
	};


	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
	{
		super.onCreateContextMenu(menu,v,menuInfo);

		//add the menu items
		menu.setHeaderTitle("Image Options: ");
		menu.add("View Large Image");
		menu.add("Website");
		menu.add("Address");

	}

	public boolean onContextItemSelected(MenuItem item)
	{
		String title = (String)item.getTitle();

		//on select for context menu
		if(title.equals("Website"))
		{
			webiste();
			return true;
		}
		else if(title.equals("Address"))
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(context);

			// show the address string according to the index of the grid 0-5
			switch (position)
			{
				case 0:
					builder.setTitle("Audi Addresses.");
					builder.setMessage(Audi[0]+" \n \n " +Audi[1]+" \n \n " +Audi[2])
							.setCancelable(true)
							.setPositiveButton("OK", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {

								}
							});

					break;

				case 1:
					builder.setTitle("BMW  Addresses.");
					builder.setMessage(BMW[0]+" \n \n " +BMW[1]+" \n \n " +BMW[2])
							.setCancelable(true)
							.setPositiveButton("OK", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {

								}
							});


					break;

				case 2:
				builder.setTitle("Lamborghini Address.");
				builder.setMessage(Lambo[0]+" \n \n " +Lambo[1]+" \n \n " +Lambo[2])
						.setCancelable(true)
						.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {

							}
						});
					break;

				case 3:
					builder.setTitle("Maserati Addresses.");
					builder.setMessage(Maserati[0]+" \n \n " +Maserati[1]+" \n \n " +Maserati[2])
							.setCancelable(true)
							.setPositiveButton("OK", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {

								}
							});
					break;
				case 4:
					builder.setTitle("Rolls Royce Addresses.");
					builder.setMessage(RR[0]+" \n \n " +RR[1]+" \n \n " +RR[2])
							.setCancelable(true)
							.setPositiveButton("OK", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {

								}
							});
					break;
				case 5:
					builder.setTitle("Toyota Addresses.");
					builder.setMessage(Toyota[0] +" \n \n " +Toyota[1]+" \n \n" +Toyota[2])
							.setCancelable(true)
							.setPositiveButton("OK", new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {

								}
							});
					break;


				default:
					break;


			}

			//show the dialogue box
			AlertDialog alertDialog = builder.create();
			alertDialog.show();
			return true;
		}
		else if(title.equals("View Large Image"))
		{
			//same as onclickimageviewlistener;
			Intent intent = new Intent(GridLayoutActivity.this,
					ImageViewActivity.class);
			intent.putExtra(EXTRA_RES_ID, (int)idlong);
			startActivity(intent);
		}
		else
		{
			return false;
		}
		return true;
	}


	//set content pane to a broweser inbuilt to the mobile and set the url
	// with the website strings according to the index
	private void webiste()
	{
		Intent browseIntent = new Intent(Intent.ACTION_VIEW);
		String p=Integer.toString(position);
		browseIntent.setData(Uri.parse(websitelink.get(position)));
		browseIntent.addCategory(Intent.CATEGORY_BROWSABLE);
		startActivity(browseIntent);
	}
}