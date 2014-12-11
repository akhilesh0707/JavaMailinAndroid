package com.javamail;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class JavaEmail_Activity extends Activity 
{
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email_activity);
		button=(Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				new SendMail().execute();



			}
		});
	}

	class SendMail extends AsyncTask<Void, Void, Void>
	{

		@Override
		protected Void doInBackground(Void... params) 
		{

			try {   

				// email configration 
				Mail m = new Mail("emial id", "password");
				String[] toArr = {"Receiver Email ids"};
				//
				
				m.setTo(toArr); 
				m.setFrom("er.naveen.tamrakar@gmail.com"); 
				m.setSubject("This is an email sent using my Mail JavaMail wrapper from an Android device."); 
				m.setBody("Email body.");
				if(m.send()) 
				{
					System.out.println("Email was sent successfully.");

				} else
				{
					System.out.println("Email was not sent.");

				}
			} catch (Exception e) 
			{   
				Log.e("SendMail", e.getMessage(), e);   
			} 
			return null;
		}

	}

}
