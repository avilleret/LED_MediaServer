gst-launch-0.10 -v udpsrc port=5001 ! application/x-rtp, payload=96 ! rtph264depay ! ffdec_h264 ! ffmpegcolorspace ! autovideosink &
gst-launch-0.10 -v udpsrc port=5002 ! application/x-rtp, payload=96 ! rtph264depay ! ffdec_h264 ! ffmpegcolorspace ! autovideosink &
gst-launch-0.10 -v udpsrc port=5003 ! application/x-rtp, payload=96 ! rtph264depay ! ffdec_h264 ! ffmpegcolorspace ! autovideosink &

