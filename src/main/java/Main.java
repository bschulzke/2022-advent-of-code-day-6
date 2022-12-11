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

  private static String getFourLetters(String input) {
    return readFourLetters(input, 0);
  }

  private static String readFourLetters(String input, int start) {
    if (start != 0) {
      charactersProcessed++;
    }
    String fourLetters =
            ("" + input.charAt(start) + input.charAt(start + 1) + input.charAt(start + 2) + input.charAt(start + 3));
    if (noneRepeat(fourLetters)) {
      return fourLetters;
    } else {
      return readFourLetters(input, start + 1);
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
