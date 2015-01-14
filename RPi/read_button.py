#!/usr/bin/python

import time
import RPi.GPIO as GPIO
import OSC


GPIO.setmode(GPIO.BCM)

pinGreen=22
pinRed=23

btnGreen=0
btnRed=0

GPIO.setup(pinGreen,GPIO.IN)
GPIO.setup(pinRed,GPIO.IN)

# setup OSC
client = OSC.OSCClient()
client.connect( ('10.42.0.1', 9002) )
msgGreen = OSC.OSCMessage()
msgGreen.setAddress("/green")
msgGreen.append("b")
msgRed = OSC.OSCMessage()
msgRed.setAddress("/red")
msgRed.append("b")

while True:
        tmpGreen = GPIO.input(pinGreen)
        tmpRed = GPIO.input(pinRed)
	if ( tmpGreen != btnGreen ):
		btnGreen = tmpGreen
                # print("Green %d " % btnGreen)
                try:
                        client.send(msgGreen)
                except:
                        print("can't connect to OSC")
        if ( tmpRed != btnRed ):
		btnRed  = tmpRed
                # print("Red %d" % btnRed)
                try:
                        client.send(msgRed)
                except:
                        print("can't connect to OSC")
