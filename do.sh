#!/bin/bash
cordova create app --name CompanionApp --id com.telasocial.companion

#cordova platform add android

git clone https://github.com/TelaSocial/companion-tests.git

cd app

cordova plugin add https://github.com/EddyVerbruggen/Calendar-PhoneGap-Plugin.git

cordova plugin add https://github.com/Red-Folder/bgs-core

cordova plugin add https://github.com/Red-Folder/bgs-sample

cordova platform add android

#cp ./plugins/nl.x-services.plugins.calendar/www/Calendar.js ../www/Calendar.js

cp config.xml config2.xml 

sed 's/index/parse/g' config2.xml > config.xml

cp -r ../companion-tests/parse-collect/* ./www

cd www

cp ./parse.html ./parse2.html

sed 's/head>/head><script\ type=\"text\/javascript\"\ src=\"cordova\.js\"><\/script><script\ type=\"text\/javascript\"\ src=\"js\/index.js\"><\/script><script\ type=\"text\/javascript\">app\.initialize();<\/script>/g' parse2.html > parse.html 

cordova build 

