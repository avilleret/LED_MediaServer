#!/bin/sh

sudo mount -o remount,rw /

sudo rm /etc/init.d/codi
sudo ln -s /home/pi/Corps_Diplomatique/RPi/init.d/codi_5 /etc/init.d/codi

sudo rm /etc/network/interfaces
sudo ln -s /home/pi/Corps_Diplomatique/RPi/network/interfaces_5 /etc/network/interfaces
