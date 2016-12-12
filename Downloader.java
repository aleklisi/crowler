import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Downloader implements WWWPageDownloader {
	public String downloadPage(String pageURL) throws DownloaderException{
		 StringBuilder wynik = new StringBuilder();
	        try {
	            System.out.println("1");
	            URL oracle = new URL(pageURL);
	            URLConnection yc = oracle.openConnection();
	            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	            String inputLine;
	            while ((inputLine = in.readLine()) != null){
	                wynik.append(inputLine);
	            System.out.println(inputLine);}
	            in.close();

	        } catch (Exception e) {
	        	e = new DownloaderException("wczytanie strony sie nie powiod³o");
	        }

	        return wynik.toString();
	}
}
