package com.rhythm.testthread;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Handler mHandler = new Handler();
	Button startBtn, showBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ProgressBar mPg = (ProgressBar) findViewById(R.id.progressBar1);
        
        startBtn = (Button) findViewById(R.id.start_btn);
        startBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mPg.getProgress() == 0) {				
					new Thread(new Runnable() {
		
						@Override
						public void run() {
							// TODO Auto-generated method stub
							Calendar begin = Calendar.getInstance();
							do {
								Calendar now = Calendar.getInstance();
								final int iDiff = 60 * (now.get(Calendar.MINUTE) - begin.get(Calendar.MINUTE)) +
										now.get(Calendar.SECOND) - begin.get(Calendar.SECOND);
								if (iDiff * 2 > 100) {
									mHandler.post(new Runnable() {
		
										@Override
										public void run() {
											// TODO Auto-generated method stub
											mPg.setProgress(100);
										}
										
									});
									break;
								}
								mHandler.post(new Runnable() {
		
									@Override
									public void run() {
										// TODO Auto-generated method stub
										mPg.setProgress(iDiff * 2); 
									}
									
								});
								
							}while(true);
						}
						
					}).start();;
				}else {
					Toast.makeText(MainActivity.this, "Processing", Toast.LENGTH_SHORT).show();
				}
			}
		});
        showBtn = (Button) findViewById(R.id.show_btn);
        showBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "Message", Toast.LENGTH_SHORT).show();
			}
		});
    }
}
