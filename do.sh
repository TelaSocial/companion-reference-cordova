#!/bin/bash
cordova create app --name CompanionApp --id com.telasocial.companion

#cordova platform add android

cd app

cordova plugin add https://github.com/EddyVerbruggen/Calendar-PhoneGap-Plugin.git

cordova plugin add https://github.com/Red-Folder/bgs-core

cordova plugin add https://github.com/Red-Folder/bgs-sample

cordova platform add android

#cp ./plugins/nl.x-services.plugins.calendar/www/Calendar.js ../www/Calendar.js

cp -r ../www/* ./www

cp ../MyService.java ./platforms/android/src/com/red_folder/phonegap/plugin/backgroundservice/sample/MyService.java

cordova run

