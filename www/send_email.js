var send_email = {
    open_email_app: function(successCallback, errorCallback, to, cc, subject, body, file_path) {
		cordova.exec( successCallback,
		            errorCallback,
					"Send_Email",
					"send_email",
					[{
					 "to":to,"body":body,"subject":subject,"file_path":file_path,
					 "cc":cc
					}]
					);
    }
}

module.exports = send_email;

