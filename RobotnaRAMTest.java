import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RobotnaRAMTest {

	RobotnaRAM r = new RobotnaRAM(0);

	/*
	 * @Test public void testRun() { try { for (int i = 0; i < 5; i++) {
	 * RobotnaRAM r = new RobotnaRAM(i); r.run(); } } catch (Exception e) {
	 * fail("blad w metodzie run"); } }
	 */

	@Test
	public void testDzialaj() {
		try {
			r.dzialaj();
		} catch (Exception e) {
			fail("blad w metodzie dzialaj");
		}
	}

	@Test
	public void testDodajDoOdwiedzenia() {
		try {
			List<URL> tst = new ArrayList<URL>();
			URL tsst = new URL("http://www.google.pl");
			tst.add(tsst);
			r.dodajDoOdwiedzenia(tst);
			if (!r.kolekcja.contains(tsst)) {
				fail("nie oddaje elementu");
			}
			;
		} catch (MalformedURLException e) {
			fail("cos nie tak z adresem");
		}
	}

	@Test
	public void testDodajOdwiedzone() {
		try {
			URL tst = new URL("http://www.google.pl");
			r.dodajOdwiedzone(tst);
			if (!r.odwiedzone.contains(tst)) {
				fail("nie oddaje elementu");
			}
			;
		} catch (MalformedURLException e) {
			fail("cos nie tak z adresem");
		}
	}

	@Test
	public void testNowaStronaDoOdwiedzenia() {
		try {
			List<URL> tst = new ArrayList<URL>();
			URL tsst = new URL("http://www.google.pl");
			tst.add(tsst);
			r.dodajDoOdwiedzenia(tst);
			if (null == r.nowaStronaDoOdwiedzenia())
				fail("nie dodali elementu");
		} catch (Exception e) {
			fail("b³ad wyrzucenia wyjatku");
		}
	}
	/*
	 * @Test public void testLinki() {
	 * 
	 * fail("Not yet implemented"); }
	 * 
	 * @Test public void testRead() { try { URL a1 = new
	 * URL("http://www.kis.agh.edu.pl/"); URL a2 = new
	 * URL("http://www.onet.pl"); URL a3 = new URL("http://www.google.pl"); }
	 * catch (Exception e) { fail("Not yet implemented"); }
	 * 
	 * }
	 */

}
