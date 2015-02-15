#/bin/bash

rm -rf font/
mkdir font

#font=Command-Prompt-12x16/Command-Prompt-12x16.ttf
#size=16
#geometry=12x16

font=PrintChar21.ttf
size=8
geometry=6x8

for i in 0 1 2 3 4 5 6 7 8 9 A B C D E F
do 
    for j in 0 1 2 3 4 5 6 7 8 9 A B C D E F
    do 
        tmp=\\x$i$j
         echo -e $tmp | convert  -size $geometry -background white -depth 8 -type TrueColor -font $font -pointsize $size label:@- -quality 99 font/$i$j.jpg

    done
done

cd font

montage *.jpg -tile 255x1 -geometry $geometry+0+0  -quality 99 ../all.jpg
