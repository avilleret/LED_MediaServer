#!/bin/bash
for i in $1*.txt $1*.c $1*.h $1*.conf $1*.sh
do
    if [ -e $i ]
    then
        echo $1
        tail -n 50 $i
        sleep 0.3
    fi
done

for i in $1*/
do
    if [ -d "$i" ]
    then
        # echo $i
        ./tail_sub.sh $i
    fi
done


