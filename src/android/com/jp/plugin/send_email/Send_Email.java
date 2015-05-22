package com.jp.plugin.send_email;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.io.File;

public class Send_Email extends CordovaPlugin {

    String mime_type="";

	@Override
	public boolean execute(String actionString, JSONArray dataString, CallbackContext callbackContext){
		try
		{
			if(actionString.equalsIgnoreCase("send_email")){

				JSONObject json_object = dataString.getJSONObject(0);

				String to = json_object.getString("to");
				String subject = json_object.getString("subject");
                String body = json_object.getString("body");
                String file_path = json_object.getString("file_path");
                String cc = json_object.getString("cc");

				final Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, body);

                if(cc.length()>0) {
                    email.putExtra(Intent.EXTRA_CC, new String[]{cc});
                }

                if(file_path.length()>0) {
                    email.setType("text/calendar");
                    email.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(file_path)));
                }
                else
                {
                    email.setType("text/html");
                }

				cordova.getActivity().startActivity(email);
                callbackContext.success("email_apps_launched");
				return true;
			}
			else{
				callbackContext.error("Invalid");
				return false;
			}
		}
		catch(Exception e)
		{
			Log.e(null, "SMS:Plugin:Exception "+e);
			callbackContext.error(""+e);
			return false;
		}
	}
}
