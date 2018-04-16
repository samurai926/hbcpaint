package hbc.paint;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private List<String[]> colorPrefs;	
	
	/**
	 * @param custRow 1 M 3 G 5 G
	 * <br>converts to { [1,M],[3,G],[5,G] }
	 */
	public Customer(String custRow) {
		colorPrefs = new ArrayList<String[]>();
		String[] pref = null;
		String[] matPref = null;
		boolean isColor = true;
		for (String s : custRow.split(" ")) {
			if (isColor) {
				pref = new String[] {s,""};
				isColor = false;
			} else {
				isColor = true;
				pref[1] = s;
				if (s.equals("M")) {
					matPref = pref;
				} else {
					colorPrefs.add(pref);
				}
			}
		}
		
		// append matte to the end so we always try to find gloss match first
		if (matPref!=null) {
			colorPrefs.add(matPref);
		}
	}
	
	public List<String[]> getColorPrefs() {
		return colorPrefs;
	}

	@Override
	public String toString() {
		String s = "{ ";
		int i = 0;
		for(String[] pref : colorPrefs) {
			i++;
			s += "[color: " + pref[0] + ", finish: " + pref[1] + "]";
			s += (i<colorPrefs.size() ? "," : "");
		}
		s += " }";
		return s;
	}
	
}
