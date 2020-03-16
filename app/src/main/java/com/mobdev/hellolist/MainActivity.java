package com.mobdev.hellolist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * Created by Marco Picone (picone.m@gmail.com) 12/03/2020
 * Main Application Demo Activity
 */
public class MainActivity extends AppCompatActivity {

	public static String TAG = "HelloActionBar";
	private RandomNumberFragment randomFragment = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_fragment_activity);
        
        if (savedInstanceState == null) {
        	
        	randomFragment  = new RandomNumberFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.container, randomFragment).commit();
        }

        Toolbar toolbar = (Toolbar)findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
        
        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null){
            actionBar.setHomeButtonEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

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
        
        if (id == R.id.action_info) {
        	openInfoActivity();
        	return true;
        }
        if (id == R.id.action_history) {
        	openHistoryActivity();
        	return true;
		}
        return super.onOptionsItemSelected(item);
    }
    
    private void openInfoActivity(){
    	Log.d(MainActivity.TAG,"openInfoActivity() called !");
    	
    	int currentRandomNum = 0;
    	
    	if(randomFragment != null)
    		currentRandomNum = randomFragment.getCurrentRandomNum();
    	
    	Bundle bundle = new Bundle();
		bundle.putInt("randomNumber", currentRandomNum);

		Intent newIntent = new Intent(new Intent(this,InfoActivity.class));
		newIntent.putExtras(bundle);
		startActivity(newIntent);
    }
    
    private void openHistoryActivity(){
    	Log.d(MainActivity.TAG,"openHistoryActivity() called !");
		startActivity(new Intent(this,HistoryActivity.class));
    }
    
}
