import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

  private static int charactersProcessed = 4;

  public static void main(String[] args) {


    File myObj = new File("src/main/resources/input.txt");

    String input = null;

    try (Scanner myReader = new Scanner(myObj)) {
      input = myReader.nextLine();
    } catch (Exception e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    if (input == null) {
      System.out.println("An error occurred with the input");
      return;
    }

    getFourLetters(input);
    System.out.println(charactersProcessed);

  }

  private static void getFourLetters(String input) {
    readLetters(input, 0, 4);
  }

  private static String readLetters(String input, int start, int numLetters) {
    if (start != 0) {
      charactersProcessed++;
    }
    StringBuilder fourLetters = new StringBuilder();

    for (int i = 0; i < numLetters; i++) {
      fourLetters.append(input.charAt(start + i));
    }

    if (noneRepeat(fourLetters.toString())) {
      return fourLetters.toString();
    } else {
      return readLetters(input, start + 1, numLetters);
    }
  }

  private static boolean noneRepeat(String input) {
    Set<Character> usedCharacters = new HashSet<>();

    for (int i = 0; i < input.length(); i++) {
      if (usedCharacters.contains(input.charAt(i))) {
        return false;
      } else {
        usedCharacters.add(input.charAt(i));
      }
    }
    return true;
  }

}
