#!/bin/bash
sleep 10;
/home/pi/Corps_Diplomatique/RPi/bin/pd-0.46-4/bin/pd -nogui -noaudio -mididev 0,1,2,3,4 -open /home/pi/Corps_Diplomatique/RPi/MIDI2FUDI.pd

