cordova create app --name CompanionApp --id com.telasocial.companion

#cordova platform add android

cd app

cordova plugin add https://github.com/EddyVerbruggen/Calendar-PhoneGap-Plugin.git

cordova plugin add https://github.com/Red-Folder/bgs-core

cordova plugin add https://github.com/Red-Folder/bgs-sample

cordova platform add android

cordova build 


