import java.net.URL;
import java.util.*;

public class SetVisited implements VisitedPages{
	Set<URL> visited = new HashSet<URL>();

	public void addVisitedPage(URL pageURL){
		visited.add(pageURL);
	}
	public boolean pageAlreadyVisited(java.net.URL pageURL) {
		return visited.contains(pageURL);
	}

}
