import java.net.URL;
import java.util.*;

public class QueueToVisit implements DownloadQueue {
	List<URL> toVisit = new LinkedList<URL>();
     public void addPage(URL pageURL) {
    	 /*if(!toVisit.add(pageURL)){
    		 Exception e = new AddException();
    		 throw e;
    	 }*/
     }

    public boolean isEmpty(){
    	return toVisit.isEmpty();
    }

     public URL getNextPage(){
    	 return ((LinkedList<URL>) toVisit).pollFirst();
     }
}
