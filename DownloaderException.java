public class DownloaderException extends Exception {
	String message  = "cos posz�o nie tak z sci�ganiem";
	 public DownloaderException(String message) {
	        super(message);
	        System.out.println(message);
	    }
}
class AddException extends Exception{
	String message  = "dodawanie do kolejki sie nie powiod�o";
	 public AddException() {
	        System.out.println(message);
	    }
}
