package hbc.paint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class App {

	private int numColors = 0;
	private List<Customer> customers;
	private Set<String> solutionSet;
	private boolean isDebug = false;
	private String input;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public int getNumColors() {
		return numColors;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public App(String input) {
		this(input, false);
	}
	public App(String input, boolean isDebug) {
		this.isDebug = isDebug;
		this.input = input;
	}
	
	public void solve() {
		createCustomers();		
		buildSolutionSet();
		String result = solveForHappiness(); // :)
		System.out.println(result);
	}
	
	protected void createCustomers() {
		debug("info", "input string: " + input);
		customers = new ArrayList<Customer>();
		try (Scanner scanner = new Scanner(input)) {
			numColors = Integer.parseInt(scanner.nextLine());
			debug("info", "input (" + numColors + " colors): ");
			while (scanner.hasNextLine()) {
				String row = scanner.nextLine();
				debug("info", row);
				customers.add(new Customer(row));
			}
		}
		if (isDebug) {
			int i = 1;
			debug("info", "printing all customer objects...");
			for (Customer c : customers) {
				debug("info", "cust " + i + ": " + c);
				i++;
			}
		}
	}
	
	protected void buildSolutionSet() {
		debug("info", "Building solution set...");
		solutionSet = new TreeSet<String>();
		
		// example, 3 colors has permutations ( 2^3 = 8 )
		// example, 4 colors has 16 permutations ( 2^4 = 16 )
		eachSolutionRec(new char[] { 'G', 'M' }, "", 2, numColors);
	}
	
	private void eachSolutionRec(char set[], String prefix, int n, int k) {
		
		// Base case: k is 0, add this prefix to solution set
		if (k == 0) {
			solutionSet.add(prefix);
			return;
		}

		// One by one add all characters from set and recursively
		// call for k equals to k-1
		for (int i = 0; i < n; ++i) {

			// Next character of input added
			String newPrefix = prefix + set[i];

			// k is decreased, because we have added a new character
			eachSolutionRec(set, newPrefix, n, k - 1);
		}
	}
	
	protected String solveForHappiness() {
		debug("info", "solving...");
		Iterator<String> iterator = solutionSet.iterator();
		boolean happy = false;
		String next = "";
		debug("info", "printing contents of solution matrix...");
		while (iterator.hasNext()) {
			next = iterator.next();
			char[] ch = next.toCharArray();
			debug("info", next);
			happy = false;
			
			// step through each customer to see if everyone is happy
			for (Customer c : customers) {
				for (String[] pref : c.getColorPrefs()) { // { [3,G],[5,G],[1,M] }
					int color = Integer.valueOf(pref[0]);
					char finish = pref[1].charAt(0);
					if (ch[color - 1] == finish) {
						happy = true;
						break;
					} else {
						happy = false;
					}
				}
				if (!happy) {
					break;
				}
			}
			if (happy) {
				return next.replace("", " ").trim();
			}
		}
		return "No solution exists";
	}
	
	private void debug(String prefix, String msg) {
		if (isDebug) {
			System.out.println(dateFormat.format(new Date()) + " [" + prefix.toUpperCase() + "] " + msg);
		}
	}
}
