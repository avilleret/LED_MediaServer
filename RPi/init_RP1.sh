#!/bin/sh

sudo mount -o remount,rw /

sudo rm /etc/init.d/codi
sudo ln -s init.d/codi_1 /etc/init.d/codi

sudo rm read_button.py
sudo ln -s read_button_1.py read_button.py

sudo rm /etc/network/interfaces
sudo ln -s network/interface_1 /etc/network/interfaces
