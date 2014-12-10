package com.rhythm.testthread;

import java.util.Calendar;

import android.os.Handler;
import android.widget.ProgressBar;

public class DoWork extends Thread {
	private Handler mHandler;
	private ProgressBar mProgressBar;
	
	public void run() {
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
						mProgressBar.setProgress(100);
					}
					
				});
				break;
			}
			mHandler.post(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					mProgressBar.setProgress(iDiff * 2); 
				}
				
			});
			
		}while(true);
	}
	
	void setHandler(Handler h) {
		mHandler = h;
	}
	
	void setProgressBar(ProgressBar proBar) {
		mProgressBar = proBar;
	}
}
