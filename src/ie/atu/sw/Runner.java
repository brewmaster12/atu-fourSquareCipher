package ie.atu.sw;

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		String inputFile;
		String outputFile;
		String key;
		boolean encrypt;

		Scanner scanner = new Scanner(System.in);

		System.out.println("************************************************************");
		System.out.println("*     ATU - Dept. of Computer Science & Applied Physics    *");
		System.out.println("*                                                          *");
		System.out.println("*       Encrypting Files with a Four Square Cipher         *");
		System.out.println("*                                                          *");
		System.out.println("************************************************************");

		// Prompt user for input file
		while (true) {
			System.out.println("(1) Specify text tile to Encrypt or Decrypt (must be .txt file)");
			inputFile = scanner.nextLine();

			if (inputFile.endsWith(".txt")) {
				break;
			} else {
				System.out.println("Invalid input! Input file must be a .txt file (ends with '.txt)'");
			}
		}
		;

		// Prompt user for encrypt or decrypt
		while (true) {
			System.out.println("(2) Encrypt or Decrypt this file? (Enter 'E' for Encrypt or 'D' for Decrypt)");
			String ed = scanner.nextLine().trim().toUpperCase();

			if (ed.equals("E")) {
				encrypt = true;
				break;
			} else if (ed.equals("D")) {
				encrypt = false;
				break;
			} else {
				System.out.println("Invalid input! Please enter 'E' for Encrypt or 'D' for Decrypt.");
			}
		}

		// Prompt user for output file
		while (true) {
			System.out.println("(3) Specify output file (must end in .txt)");
			outputFile = scanner.nextLine();

			if (outputFile.endsWith(".txt")) {
				break;
			} else {
				System.out.println("Invalid input! Output file name must end in '.txt)'");
			}
		}

		// Prompt user for custom cipher key
		while (true) {
			System.out.println(
					"(4) Enter key for cipher (must contain 25 non-repeating letters; leave blank to use default key)");
			key = scanner.nextLine();
			break;
		}

		// Send inputs to the parser
		Parser parser = new Parser();
		try {
			parser.parse(inputFile, outputFile, encrypt, key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}
}