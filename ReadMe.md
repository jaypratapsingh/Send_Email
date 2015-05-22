*************Cordova : Send Email From App*****************

By using this plugin you can send email get the returned value for performing task one by one.


Install this plugin using:

cordova plugin add com.jp.plugin.send_email



Remove Plugins :

cordova plugin remove com.jp.plugin.send_email



Put the below code in your javascript code to get the ip address: 

send_email.open_email_app(
	function(success)
	{
            console.log(success);
        }, 
	function(error)
	{
            console.log(error);
        },
	to, cc, subject, body, file_path
    );


GitHub URL:   https://github.com/jaypratapsingh/send_email

npm url :     https://www.npmjs.com/package/com.jp.plugin.send_email