# Alarm clock with Twilio

Set the timer to get your wakeup / reminder call from Twilio!

* Download this Java class, and Twilio's Java SDK

* Put both files in the same directory and compile:
  * javac -cp twilio-java-sdk-3.4.2-jar-with-dependencies.jar  TwilioAlarmClock.java

* Run the program with the indicated five parameters:
  * java -cp .:twilio-java-sdk-3.4.2-jar-with-dependencies.jar  TwilioAlarmClock  *Account-SID* *Auth-Token* *From-Phone-Number* *To-Phone-Number* *Time-in-Minutes*

###### For example: to get a call one hour from now, use 60 in the last parameter.
######

