#!/bin/sh
# Force Nvidia Powermizer to Performance instead of adaptive mode
nvidia-settings -a [gpu:0]/GPUPowerMizerMode=1
nvidia-settings -a [gpu:1]/GPUPowerMizerMode=1
s
