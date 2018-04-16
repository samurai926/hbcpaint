package hbc.paint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EntryPoint {

	public static void main(String[] args) {
		// allowed values are: debug|{file}
		if (args==null || args.length==0) {
			System.err.println("[ERROR] invalid args.  Allowd values are debug and {file}");
			System.exit(1);
		}
		boolean debug = false;
		String input = "";
		for (String s: args) {
            if (s.equalsIgnoreCase("debug")) {
            	debug = true;
            } else {
            	input = LoadInputFile(s);
            }
        }
		
		if (input==null || "".equals(input)) {
			System.err.println("[ERROR] sorry we had some problem mapping the file contents to a string");
			System.exit(1);
		}
		App app = new App(input, debug);
		app.solve();
		
	}
	
	protected static String LoadInputFile(String theFile) {
		String input = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(theFile))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				input += line;
				input += "\n";
			}
		} catch (IOException e) {
			System.err.println("[ERROR] App.LoadInputFile " + e.getMessage());
			input = "";
		}
		return input;
	}

}
