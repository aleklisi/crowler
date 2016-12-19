import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotnaRAM extends Thread {
	List<URL> kolekcja = new ArrayList<URL>();
	Set<URL> odwiedzone = new HashSet<URL>();
	int nrWatku;

	RobotnaRAM(URL poczatek, int nrW) {
		kolekcja.add(poczatek);
		nrWatku = nrW;
	}
	RobotnaRAM(int nrW){
		nrWatku = nrW;
	}
	public void run() {
		List<URL> l = new ArrayList<URL>();
		try {
			l.add(new URL("http://www.kis.agh.edu.pl/"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dodajDoOdwiedzenia(l);
		for (int i = 0; i < 100; i++) {
			dzialaj();
			System.out.println(nrWatku);
		}
	}

	void dzialaj() {
		URL nowaStrona = nowaStronaDoOdwiedzenia();
		System.out.println(nowaStrona);
		if (!odwiedzone.contains(nowaStrona)) {
			List<URL> l = linki(read(nowaStrona));
			dodajDoOdwiedzenia(l);
		}
		dodajOdwiedzone(nowaStrona);
	}

	void dodajDoOdwiedzenia(List<URL> doDodania) {
		synchronized (kolekcja) {
			kolekcja.addAll(doDodania);
		}
	}

	void dodajOdwiedzone(URL doDodania) {
		synchronized (odwiedzone) {
			if (!odwiedzone.contains(doDodania)) {
				odwiedzone.add(doDodania);
			}
		}
	}

	URL nowaStronaDoOdwiedzenia() {
		if (!kolekcja.isEmpty()) {
			synchronized (kolekcja) {
				URL nowaStrona = kolekcja.get(0);
				kolekcja.remove(nowaStrona);
				return nowaStrona;
			}
		} else {
			try {
				sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	List<URL> linki(String strona) {
		List<URL> wynik = new ArrayList<URL>();
		String wzor = "<[aA] [^>]*[hH][rR][eE][fF]=\"([^\"]+)\"";
		Pattern p = Pattern.compile(wzor);
		Matcher m = p.matcher(strona.toString());
		URL pom;
		while (m.find()) {
			try {
				pom = new URL(m.group(1));
				wynik.add(pom);
			} catch (MalformedURLException e) {
				// System.out.println("niepoorawny link");
			}

		}
		return wynik;

	}

	static String read(URL link) {
		StringBuilder wynik = new StringBuilder();
		try {
			// System.out.println("1");
			URL oracle = link;
			URLConnection yc = oracle.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				wynik.append(inputLine);
				// System.out.println(inputLine);
			}
			in.close();

		} catch (Exception e) {
			System.out.println("nie nawiaza³em");
		}

		return wynik.toString();
	}
}
