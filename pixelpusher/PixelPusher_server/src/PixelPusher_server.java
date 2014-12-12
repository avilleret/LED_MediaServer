import com.heroicrobot.dropbit.registry.*;
import com.heroicrobot.dropbit.devices.pixelpusher.Pixel;
import com.heroicrobot.dropbit.devices.pixelpusher.PixelPusher;
import com.heroicrobot.dropbit.devices.pixelpusher.PusherCommand;
import com.heroicrobot.dropbit.devices.pixelpusher.Strip;

import java.util.*;

import oscP5.*;

public class PixelPusher_server {
	class PPObserver implements Observer {
		public boolean hasStrips = false;

		public void update(Observable registry, Object updatedDevice) {
			System.out.println("Registry changed!");
			if (updatedDevice != null) {
				System.out.println("Device change: " + updatedDevice);
			}
			this.hasStrips = true;
		}
	};

	int pixelMap[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
			16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32,
			33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
			50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66,
			67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83,
			167, 166, 165, 164, 163, 162, 161, 160, 159, 158, 157, 156, 155,
			154, 153, 152, 151, 150, 149, 148, 147, 146, 145, 144, 143, 142,
			141, 140, 139, 138, 137, 136, 135, 134, 133, 132, 131, 130, 129,
			128, 127, 126, 125, 124, 123, 122, 121, 120, 119, 118, 117, 116,
			115, 114, 113, 112, 111, 110, 109, 108, 107, 106, 105, 104, 103,
			102, 101, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87,
			86, 85, 84, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178,
			179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191,
			192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204,
			205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217,
			218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230,
			231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243,
			244, 245, 246, 247, 248, 249, 250, 251, 335, 334, 333, 332, 331,
			330, 329, 328, 327, 326, 325, 324, 323, 322, 321, 320, 319, 318,
			317, 316, 315, 314, 313, 312, 311, 310, 309, 308, 307, 306, 305,
			304, 303, 302, 301, 300, 299, 298, 297, 296, 295, 294, 293, 292,
			291, 290, 289, 288, 287, 286, 285, 284, 283, 282, 281, 280, 279,
			278, 277, 276, 275, 274, 273, 272, 271, 270, 269, 268, 267, 266,
			265, 264, 263, 262, 261, 260, 259, 258, 257, 256, 255, 254, 253,
			252, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347,
			348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360,
			361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373,
			374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386,
			387, 388, 389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399,
			400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412,
			413, 414, 415, 416, 417, 418, 419 };

	DeviceRegistry registry;
	PPObserver ppObserver;

	OscP5 oscP5;

	public void setup() {

		registry = new DeviceRegistry();
		ppObserver = new PPObserver();

		registry.addObserver(ppObserver);
		// registry.useOverallBrightnessScale = true;
		registry.setAntiLog(true); // set anti-log level rule for pixels

		oscP5 = new OscP5(this, 10001);
		oscP5.plug(this, "pushBundle", "/pp");
		oscP5.plug(this, "pushStrip", "/s");
		oscP5.plug(this, "setAll", "/all");
		// oscP5.plug(this, "setBrightnessScale", "/brightnessScale", "f");
		oscP5.plug(this, "setBrightness", "/brightness", "i");

		/*
		 * int receiverPort = 10001; OSCPortIn receiver = new
		 * OSCPortIn(receiverPort);
		 * 
		 * OSCListener handler1 = new OSCListener() { public void
		 * acceptMessage(java.util.Date time, OSCMessage message) { // TODO: Put
		 * your code to process a message in here
		 * System.out.println("Handler1 called with address " +
		 * message.getAddress());
		 * 
		 * // Print out values Object[] values = message.getArguments();
		 * System.out.printf("Values: [%s", values[0]); for (int i = 1; i <
		 * values.length; i++) System.out.printf(", %s", values[i]);
		 * System.out.println("]\n"); } };
		 * 
		 * // A second message handler OSCListener handler2 = new OSCListener()
		 * { public void acceptMessage(java.util.Date time, OSCMessage message)
		 * { // TODO: Put your code to process a message in here
		 * System.out.println("Handler2 called with address  " +
		 * message.getAddress());
		 * 
		 * // Print out values Object[] values = message.getArguments();
		 * System.out.printf("Values: [%s", values[0]); for (int i = 1; i <
		 * values.length; i++) System.out.printf(", %s", values[i]);
		 * System.out.println("]\n"); } };
		 * 
		 * // I want handler1 to be called on addresses /a and /b and //
		 * handler2 to be called on /c receiver.addListener("/a", handler1);
		 * receiver.addListener("/b", handler1); receiver.addListener("/c",
		 * handler2);
		 * 
		 * System.out.println("Server is listening on port " + receiverPort +
		 * "..."); receiver.startListening();
		 */
	}

	int current_pixel = 0;

	void oscEvent(OscMessage message) {
		// check if theOscMessage has the address pattern we are looking for.
		if (!message.isPlugged())
			System.out.println("### received an osc message. with address pattern "
					+ message.addrPattern());
	}

	/*
	void setBrightnessScale(float brightnessScale) {
		System.out.println("setOverallBrightnessScale to " + brightnessScale);
		registry.setOverallBrightnessScale(brightnessScale);
	}
	*/

	void setBrightness(int brightness) {
		System.out.println("sendCommand : " + (short) brightness);
		List<PixelPusher> pusherList = registry.getPushers();
		for (PixelPusher pusher : pusherList) {
			List<Strip> strips = pusher.getStrips();
			for (byte i = 0; i < strips.size(); i++) {
				PusherCommand pc = new PusherCommand(
						PusherCommand.STRIPBRIGHTNESS_SET, i,
						(short) brightness);
				pusher.sendCommand(pc);
			}
		}
	}

	void pushBundle(byte[] blob) {
		System.out.println("### received an osc message /pp with " + blob.length
				+ " values");

		if (ppObserver.hasStrips) {
			registry.startPushing();
			int a = 0;
			Pixel px = new Pixel();
			List<Strip> strips = registry.getStrips();

			for (Strip strip : strips) {
				for (int i = 0; i < strip.getLength()
						&& (a + 3 < blob.length / 3); i++) {
					px.red =  blob[a];
					px.green = blob[a+1];
					px.blue  = blob[a+2];
					strip.setPixel(px, i);
					a += 3;
				}
			}
		}

		return;
	}

	void pushStrip(int stripId, byte[] blob) {
		System.out.println("### received an osc blob for strip " + stripId + " with " + blob.length + " values");
		if (ppObserver.hasStrips) {
			registry.startPushing();
			List<Strip> strips = registry.getStrips();
			Strip strip = strips.get(stripId);
			int a = 0;
			Pixel px = new Pixel();
			for (int i = 0; i < strip.getLength(); i++) {
				px.red =  blob[a];
				px.green = blob[a+1];
				px.blue  = blob[a+2];
				strip.setPixel(px, pixelMap[i]);
				a += 3;
			}
		}
		return;
	}

	void setAll(byte[] blob) {
		int r, g, b;
		if (blob.length < 3)
			return;
		r = blob[0] & 0xFF;
		g = blob[1];
		b = blob[2];
		
		System.out.println("### set all LED to : " + r + " " + g + " " + b);
		int a = 0;
		Pixel px = new Pixel();
		px.red =  blob[a];
		px.green = blob[a+1];
		px.blue  = blob[a+2];
		if (ppObserver.hasStrips) {
			registry.startPushing();
			System.out.println("push pixel");

			List<Strip> strips = registry.getStrips();

			for (Strip strip : strips) {
				for (int i = 0; i < strip.getLength(); i++) {
					strip.setPixel(px, i);
					a += 3;
				}
			}
		}

		return;
	}

}
