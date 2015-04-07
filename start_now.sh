#!/bin/bash
killall gst-launch-0.10
killall gst-launch.sh
killall java
killall pd

_DIR=$(dirname $(readlink -f $0))
# sleep 30
xterm -e "java -jar $_DIR/pixelpusher/PixelPusher_server.jar" &
sleep 2
$_DIR/RPi/raspicam2v4l2.sh
cd $_DIR/pd
pd LEDMediaServer_01.pd
