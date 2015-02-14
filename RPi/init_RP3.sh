#!/bin/sh

sudo mount -o remount,rw /

sudo rm /etc/init.d/codi
sudo ln -s /home/pi/Corps_Diplomatique/RPi/init.d/codi_3 /etc/init.d/codi

sudo rm read_button.py
sudo ln -s read_button_3.py read_button.py

sudo rm /etc/network/interfaces
sudo ln -s /home/pi/Corps_Diplomatique/RPi/network/interfaces_3 /etc/network/interfaces
