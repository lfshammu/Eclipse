import java.util.Arrays;
import java.util.Scanner;

public class Game {

	private Scanner keyboard = new Scanner(System.in);
	private String sWord;
	private int guessAllowed;
	private int numGuess;
	private int numGuessWrong = 0;
	private String[] hiddenWordArray;
	private String lettersGuessed = "";
	private boolean isGameWon = false;
	private boolean isGameLost = false;
	private boolean running = true;

	public Game() {
		System.out.println("Welcome to Hangman, enter a word!");
		guessAllowed = 10;
		String word = keyboard.nextLine();
		wallOfText();
		sWord = word.toLowerCase();
		hiddenWordArray = new String[sWord.length()];
		initHiddenWordArray();
		mainLoop();

	}

	public void mainLoop() {
		while (running) {
			System.out.println("There are " + sWord.length() + " Letters in the secret word: " + getHiddenWord());
			System.out.println("");
			System.out.println("you have " + getGuessLeft() + " Guesses left");
			System.out.println("");
			System.out.println("Letters Guessed: " + getLettersGuessed());
			System.out.println("");
			System.out.println("Make a guess!");
			System.out.println("");
			String str = keyboard.nextLine();
			char c = str.charAt(0);
			if (makeGuess(c) == true) {
				setLettersGuessed(c);
				setHiddenWordArray(c);

			} else if (makeGuess(c) == false) {
				setNumGuessWrong();
				setLettersGuessed(c);
			}

		}
		if (isGameWon == true) {
			System.out.println("You Won!");
		} else if (isGameLost == true) {
			System.out.println("You lost!");
		}
	}

	public boolean makeGuess(char c) {
		boolean isIt = false;
		for (int i = 0; i < sWord.length(); i++) {
			if (c == sWord.charAt(i)) {
				isIt = true;
				break;

			}

			else if (c != sWord.charAt(i)) {
				isIt = false;
			}
		}
		return isIt;

	}

	private void setLettersGuessed(char c) {
		String guess = Character.toString(c);
		String str = "";
		str = guess + ", ";
		lettersGuessed += str;
	}

	public String getLettersGuessed() {
		return lettersGuessed;
	}

	private void setHiddenWordArray(char c) {
		String correctGuess = Character.toString(c);
		for (int i = 0; i < sWord.length(); i++) {
			if (c == sWord.charAt(i)) {
				hiddenWordArray[i] = correctGuess;
				setNumCorrect();
			} else {
				continue;
			}

		}
	}

	public void initHiddenWordArray() {
		for (int i = 0; i < hiddenWordArray.length; i++) {
			hiddenWordArray[i] = "-";
		}
	}

	public String getHiddenWord() {
		String str = "(";
		for (int i = 0; i < hiddenWordArray.length; i++) {
			str += hiddenWordArray[i];
			str += ",";
		}
		str += ")";
		return str;
	}

	public int getNumGuess() {
		return numGuess;
	}

	public int getNumGuessWrong() {
		return numGuessWrong;
	}

	private void setNumGuessWrong() {
		numGuessWrong += 1;
		if (numGuessWrong == guessAllowed) {
			isGameLost = true;
			running = false;
		}
	}

	private void setNumCorrect() {
		numGuess += 1;
		if (numGuess == sWord.length()) {
			isGameWon = true;
			running = false;
		}
	}

	public int getGuessLeft() {
		return guessAllowed - getNumGuessWrong();
	}

	public void wallOfText() {
		for (int i = 0; i < 300; i++) {
			System.out.println("");
		}
	}

}
