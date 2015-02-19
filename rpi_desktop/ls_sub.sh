#!/bin/bash
ls $1
sleep 0.3

for i in $1*/
do
    if [ -d $i ]
    then
        echo $i
        ./ls_sub.sh $i
    fi
done


