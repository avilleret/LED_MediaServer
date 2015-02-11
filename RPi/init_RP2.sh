#!/bin/sh

sudo mount -o remount,rw /

sudo rm /etc/init.d/codi
sudo ln -s init.d/codi_2 /etc/init.d/codi

sudo rm read_button.py
sudo ln -s read_button_2.py read_button.py

sudo rm /etc/network/interfaces
sudo ln -s network/interface_2 /etc/network/interfaces
