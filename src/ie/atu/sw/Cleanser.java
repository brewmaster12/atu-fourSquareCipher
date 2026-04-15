package ie.atu.sw;

public class Cleanser {

	public static String cleanseMessage(String message) throws Exception {
		// Create stringbuilder
		StringBuilder sb = new StringBuilder();

		// Convert message to char array and loop through it
		for (char c : message.toCharArray()) {
			// Convert all chars to uppercase
			char upper = Character.toUpperCase(c);
			// Ignore all non-letters
			if (upper >= 'A' && upper <= 'Z') {
				// Append the letter; if it's a J convert to I
				sb.append(upper == 'J' ? 'I' : upper);
			}
		}

		// Ensure length is even else add 'X'
		if (sb.length() % 2 != 0) {
			sb.append('X');
		}

		// Convert sb to string return
		return sb.toString();
	}

	public static String cleanseKey(String key) throws Exception {
		// Create stringbuilder
		StringBuilder sb = new StringBuilder();

		// Convert message to char array and loop through it
		for (char c : key.toCharArray()) {
			// Convert all chars to uppercase
			char upper = Character.toUpperCase(c);
			// Ignore all non-letters
			if (upper >= 'A' && upper <= 'Z') {
				// Append the letter; if it's a J convert to I
				sb.append(upper == 'J' ? 'I' : upper);
			}
		}

		// If inputed key is blank after processing, return default key
		if (sb.toString().isBlank()) {
			String defaultKey = "ZGPTFOIHMUWDRCNYKEQAXVSBLMFNBDCRHSAXYOGVITUEWLQZKP";
			return defaultKey;
		} else { // Else send for more processing
			return expandKey(sb.toString());
		}

	}

	private static String expandKey(String keyFragment) {
		// Create stringbuilder
		StringBuilder sb = new StringBuilder();

		// Remove repeat letters
		for (int i = 0; i < keyFragment.length(); i++) {
			char currentChar = keyFragment.charAt(i);

			// Check if this character is already in the result
			if (sb.indexOf(String.valueOf(currentChar)) == -1) {
				sb.append(currentChar);
			}
		}

		// Fill remaining 25 chars with unused letters
		String alphabet = "PQOWIEURYTLAKSHDGFMZNXBCV"; // Letters of alphabet except J
		for (int i = 0; i < alphabet.length(); i++) {
			char currentChar = alphabet.charAt(i);

			// Check if this character is already in the result
			if (sb.indexOf(String.valueOf(currentChar)) == -1) {
				sb.append(currentChar);
			}
		}

		// Jumble the chars to make the second part of the key
		// **I do this instead of a randomiser so custom user keys give consistent
		// results across different instances**
		String jumbled = sb.substring(5) + sb.substring(0, 5);
		sb.append(jumbled);

		// Return
		return sb.toString();
	}
}
