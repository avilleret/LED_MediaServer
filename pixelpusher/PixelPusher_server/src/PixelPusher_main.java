
public class PixelPusher_main {
	public static void main(String[] args) { 
		System.out.println("start PixelPusher_server");
		PixelPusher_server pp = new PixelPusher_server();
		
		pp.setup();
	  
		while(true){
			try {
				Thread.sleep(1000);                 //1000 milliseconds is one second.	
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
	}
}
