#check if the wpa_suppicant is already running
#if it does, stop it.
StationRunning=`ps | grep -c wpa_supplicant`
if [ $StationRunning -eq 2 ]; then
        killall wpa_supplicant
fi

# start the application
$*
