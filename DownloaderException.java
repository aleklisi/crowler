public class DownloaderException extends Exception {
	String message  = "cos posz³o nie tak z sci¹ganiem";
	 public DownloaderException(String message) {
	        super(message);
	        System.out.println(message);
	    }
}
class AddException extends Exception{
	String message  = "dodawanie do kolejki sie nie powiod³o";
	 public AddException() {
	        System.out.println(message);
	    }
}
