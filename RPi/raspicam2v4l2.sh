xterm -title "camera 1" -e "gst-launch-0.10 -v udpsrc port=5001 ! application/x-rtp, payload=96 ! rtph264depay ! ffdec_h264 ! ffmpegcolorspace ! v4l2sink device=/dev/video1" &
xterm -title "camera 2" -e "gst-launch-0.10 -v udpsrc port=5002 ! application/x-rtp, payload=96 ! rtph264depay ! ffdec_h264 ! ffmpegcolorspace ! v4l2sink device=/dev/video2" &
xterm -title "camera 3" -e "gst-launch-0.10 -v udpsrc port=5003 ! application/x-rtp, payload=96 ! rtph264depay ! ffdec_h264 ! ffmpegcolorspace ! v4l2sink device=/dev/video3" &

