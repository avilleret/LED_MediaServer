#/bin/bash

rm -rf font/
mkdir font

for i in 0 1 2 3 4 5 6 7 8 9 A B C D E F
do 
    for j in 0 1 2 3 4 5 6 7 8 9 A B C D E F
    do 
        tmp=\\x$i$j
        echo -e $tmp | convert  -size 12x16 -background white -depth 8 -type TrueColor -font Command-Prompt-12x16/Command-Prompt-12x16.ttf  -pointsize 16 label:@- -quality 99 font/$i$j.jpg
    done
done

cd font

montage *.jpg -tile 255x1 -geometry 12x16+0+0  -quality 99 ../all.jpg
