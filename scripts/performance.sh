#!/bin/bash
while true
do
	for i in `seq 0 7`; do sudo cpufreq-selector -c $i --governor performance; done
	sleep 5
done
