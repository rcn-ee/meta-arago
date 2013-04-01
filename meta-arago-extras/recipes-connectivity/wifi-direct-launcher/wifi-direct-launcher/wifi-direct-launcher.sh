#check if the wpa_suppicant is already running
#if it does, stop it.
StationRunning=`ps | grep -c wpa_supplicant`
if [ $StationRunning -eq 2 ]; then
        killall wpa_supplicant
fi

# Correct dbus permission. Incorrect permission causes dbus (wifi direct demos)
# dependent demos to fail. 
chmod u+s /usr/libexec/dbus-daemon-launch-helper

# start the application
$*
