import java.io.File;
import java.util.Scanner;

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

    String output = getFourLetters(input);
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
    char first = input.charAt(0);
    char second = input.charAt(1);
    char third = input.charAt(2);
    char fourth = input.charAt(3);
    if (first == second || first == third || first == fourth) {
      return false;
    } else if (second == third || second == fourth) {
      return false;
    } else return third != fourth;
  }

}
