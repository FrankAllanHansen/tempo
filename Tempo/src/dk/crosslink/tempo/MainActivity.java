package dk.crosslink.tempo;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout.PanelSlideListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnMenuItemClickListener {
	SlidingPaneLayout mSlidingPaneLayout;
	Spinner mSpinnerUnits;
	ImageButton mImageButtonDistance;
	EditText mEditTextDistance;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mSlidingPaneLayout = (SlidingPaneLayout)findViewById(R.id.slidingpanelayout);
        mSlidingPaneLayout.setShadowResource(R.drawable.drawer_shadow);
        
        mSlidingPaneLayout.setPanelSlideListener(new PanelSlideListener() {
			@Override
			public void onPanelSlide(View arg0, float arg1) {
				// TODO Auto-generated method stub
				Log.i("", "Sliding");
			}
			
			@Override
			public void onPanelOpened(View arg0) {
				// TODO Auto-generated method stub
				Log.i("", "Opened");
			}
			
			@Override
			public void onPanelClosed(View arg0) {
				Log.i("", "Closed");
			}
		});
        
        mSpinnerUnits = (Spinner)findViewById(R.id.spinner_units);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.distance_unit_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mSpinnerUnits.setAdapter(adapter);
        
        mEditTextDistance = (EditText)findViewById(R.id.editTextDistance);
        mEditTextDistance.requestFocus();
        
        mImageButtonDistance = (ImageButton)findViewById(R.id.imageButton_distance);
        
        mSlidingPaneLayout.openPane();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void showDistancePopup(View v) {
    	PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_distance, popup.getMenu());
        popup.show();
    }
    
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.distance_5:
                return true;
            default:
                return false;
        }
    }
}
