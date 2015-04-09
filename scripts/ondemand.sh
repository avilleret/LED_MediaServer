#!/bin/sh
for i in `seq 0 7`; do cpufreq-selector -c $i --governor ondemand; done

