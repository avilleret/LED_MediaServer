#!/bin/bash
_DIR=$(dirname $(readlink -f $0))
sleep 30
xterm -e i-score &
sleep 1
xterm -e "java -jar $_DIR/pixelpusher/PixelPusher_server.jar" &
sleep 2
cd $_DIR/pd
pd LEDMediaServer_01.pd
