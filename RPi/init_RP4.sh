#!/bin/sh

sudo mount -o remount,rw /

sudo rm /etc/init.d/codi
sudo ln -s /home/pi/Corps_Diplomatique/RPi/init.d/codi_4 /etc/init.d/codi

sudo rm /etc/network/interfaces
sudo ln -s /home/pi/Corps_Diplomatique/RPi/network/interfaces_4 /etc/network/interfaces
