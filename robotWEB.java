import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

class czytaczStrony {
    List<String> kolekcja = new ArrayList<String>();
    Set<String> odwiedzone = new HashSet<String>();

    czytaczStrony(String poczatek) {
        kolekcja.add(poczatek);
    }

    void dzialaj() {
        String nowaStrona = kolekcja.get(0);
        kolekcja.remove(nowaStrona);
        odwiedzone.add(nowaStrona);
        if(odwiedzone.contains(nowaStrona) ){
        linki(read(nowaStrona));
        }
    }

    void linki(String strona) {
        System.out.println(strona);
        String wzor = "<[aA] [^>]*[hH][rR][eE][fF]=\"([^\"]+)\"";
        Pattern p = Pattern.compile(wzor);
        Matcher m = p.matcher(strona);
        int count = 0;
        while (m.find()) {
            count++;
            // System.out.println("found: " + count + " : " + m.group(1));

            kolekcja.add(m.group(1));
        }

    }

    static String read(String link) {
        StringBuilder wynik = new StringBuilder();
        try {
            System.out.println("1");
            URL oracle = new URL(link);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                wynik.append(inputLine);
            // System.out.println(inputLine);
            in.close();

        } catch (Exception e) {
            System.out.println("nie nawiaza³em");
        }

        return wynik.toString();
    }
}

public class robotWEB {
    public static void main(String[] args)  {
        /*czytaczStrony cz = new czytaczStrony("http://www.kis.agh.edu.pl/");
        for (int i = 1; i < 10; i++) {
            cz.dzialaj();
            System.out.println(cz.kolekcja.toArray().length);
        }*/
    	WWWPageDownloader pobieracz = new Downloader();
    	try {
			pobieracz.downloadPage("http://www.kis.agh.edu.pl/");
		} catch (DownloaderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
