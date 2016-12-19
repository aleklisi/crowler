import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;

public class robotWEB {
	public static void main(String[] args) throws Exception {
		List <URL> strt = new ArrayList<URL>();
		strt.add(new URL("http://www.kis.agh.edu.pl/"));
		strt.add(new URL("http://www.onet.pl"));
		strt.add(new URL("http://www.google.pl"));
		for (int i = 0;i<3;i++){
			RobotnaRAM cz = new RobotnaRAM(strt.get(i),i);
		cz.start();
		}

		/*System.out.println(cz.kolekcja.get(0));
		for (int i = 1; i < 100; i++) {
			cz.dzialaj();
			System.out.println(cz.kolekcja.toArray().length+	+cz.odwiedzone.toArray().length);
		}
		for(int i = 0;i<20;i++){
			System.out.println(cz.kolekcja.get(i));
		}*/

	}
}
