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
client.connect( ('10.42.0.11', 9003) )

while True:
        tmpGreen = (GPIO.input(pinGreen) == 0 )
        tmpRed = (GPIO.input(pinRed) == 0 )
	if ( tmpGreen != btnGreen ):
		btnGreen = tmpGreen
		# print("Green %d " % btnGreen)
        	try:
			msgGreen = OSC.OSCMessage()
			msgGreen.setAddress("/green")
			msgGreen.append(str(tmpGreen))
                	client.send(msgGreen)
		except:
			print("can't connect to OSC")
	if ( tmpRed != btnRed ):
		btnRed  = tmpRed
		# print("Red %d" % btnRed)
       		try:
			msgRed = OSC.OSCMessage()
			msgRed.setAddress("/red")
			msgRed.append(str(tmpRed))
			client.send(msgRed)
		except:
			print("can't connect to OSC")
