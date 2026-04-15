package ie.atu.sw;

import java.io.*;

public class Parser {

	public void parse(String inputFile, String outputFile, boolean encrypt, String key) throws Exception {
		// Create reader and writers
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
		BufferedWriter wr = new BufferedWriter(new FileWriter(outputFile));

		FourSquareCipher cipher = new FourSquareCipher(key);

		String line;
		while ((line = br.readLine()) != null) {
			String cipherLine;
			// Encrypt or decrypt line
			cipherLine = encrypt ? cipher.encrypt(line) : cipher.decrypt(line);

			wr.write(cipherLine);
			wr.newLine();
		}

		br.close();
		wr.close();
		System.out.println("Cipher complete! Result has been sent to " + outputFile);
	}
}
