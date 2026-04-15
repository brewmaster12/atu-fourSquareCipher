package ie.atu.sw;

public class FourSquareCipher {

	// Create plaintext square
	private char[][] plaintextSquare = { { 'A', 'B', 'C', 'D', 'E' }, { 'F', 'G', 'H', 'I', 'K' },
			{ 'L', 'M', 'N', 'O', 'P' }, { 'Q', 'R', 'S', 'T', 'U' }, { 'V', 'W', 'X', 'Y', 'Z' } };

	// Initalise ciphertext squares
	private char[][] topRightSquare = new char[5][5];
	private char[][] bottomLeftSquare = new char[5][5];

	// Constructor
	public FourSquareCipher(String key) throws Exception {
		// Cleanse key
		key = Cleanser.cleanseKey(key);
		// Populate squares with key
		populateSquares(key);
	}

	private void populateSquares(String key) {
		// Split key into two 25-char arrays
		char[] key1 = key.substring(0, 25).toCharArray();
		char[] key2 = key.substring(25, 50).toCharArray();

		// Populate squares with keys
		int index = 0;
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				topRightSquare[row][col] = key1[index];
				bottomLeftSquare[row][col] = key2[index];
				index++;
			}
		}
	}

	public String encrypt(String plainText) throws Exception {
		return doCipher(plainText, true);
	}

	public String decrypt(String cipherText) throws Exception {
		return doCipher(cipherText, false);
	}

	private String doCipher(String message, boolean encrypt) throws Exception {
		// Cleanse message
		message = Cleanser.cleanseMessage(message);

		// Initalise StringBuilder for encrypted message
		StringBuilder sb = new StringBuilder();

		// Break message into an array bigrams
		String[] bigrams = bigramify(message);

		// Find coordinates for each letter in bigram
		for (String bigram : bigrams) {
			char letter1 = bigram.charAt(0);
			char letter2 = bigram.charAt(1);

			// Encrypt or Decrypt
			if (encrypt == true) {
				// Find coordinates of letters in bigram
				int[] firstLetterCoordinates = plaintextCoordinates(letter1);
				int[] secondLetterCoordinates = plaintextCoordinates(letter2);

				char c;
				char p;
				// Find letter in cipher squares that match coordinates
				c = topRightSquare[firstLetterCoordinates[0]][secondLetterCoordinates[1]];
				p = bottomLeftSquare[secondLetterCoordinates[0]][firstLetterCoordinates[1]];
				// Append encrypted letters to stringbuilder
				sb.append(c);
				sb.append(p);

			} else if (encrypt == false) {
				int[] firstLetterCoordinates = topRightCoordinates(letter1);
				int[] secondLetterCoordinates = bottomLeftCoordinates(letter2);

				char c;
				char p;
				// Find letter in cipher squares that match coordinates
				c = plaintextSquare[firstLetterCoordinates[0]][secondLetterCoordinates[1]];
				p = plaintextSquare[secondLetterCoordinates[0]][firstLetterCoordinates[1]];
				// Append encrypted letters to stringbuilder
				sb.append(c);
				sb.append(p);
			}
		}
		return sb.toString();
	}

	private int[] plaintextCoordinates(char letter) {
		// Loop through plaintext square
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				// If the letter from the bigram is found, return square coordinates as int
				// array
				if (plaintextSquare[row][col] == letter) {
					int[] coordinates = new int[2];
					coordinates[0] = row;
					coordinates[1] = col;
					return coordinates;
				} else
					continue;
			}
		}
		return null;
	}

	private int[] topRightCoordinates(char letter) {
		// Loop through plaintext square
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				// If the letter from the bigram is found, return square coordinates as int
				// array
				if (topRightSquare[row][col] == letter) {
					int[] coordinates = new int[2];
					coordinates[0] = row;
					coordinates[1] = col;
					return coordinates;
				} else
					continue;
			}
		}
		return null;
	}

	private int[] bottomLeftCoordinates(char letter) {
		// Loop through plaintext square
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				// If the letter from the bigram is found, return square coordinates as int
				// array
				if (bottomLeftSquare[row][col] == letter) {
					int[] coordinates = new int[2];
					coordinates[0] = row;
					coordinates[1] = col;
					return coordinates;
				} else
					continue;
			}
		}
		return null;
	}

	private String[] bigramify(String message) {
		// Initalise an array to store bigrams as strings
		int bigramsLength = (message.length()) / 2;
		String[] bigrams = new String[bigramsLength];

		// Break string into bigrams and push into the array
		int index = 0;
		for (int i = 0; i < message.length(); i += 2) {
			String bigram = message.substring(i, i + 2);
			bigrams[index] = bigram;
			index++;
		}

		return bigrams;
	}
}
