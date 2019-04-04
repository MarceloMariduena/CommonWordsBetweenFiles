import java.util.*;
import java.io.*;

public class CommonWordsMarceloMariduena {
//  Description: Write a Java program that reads words from a file called words1.txt,
//  stores them into a collection and then displays the list sorted alphabetically. 
//  It should do the same thing with the second file called words2.txt; 
//  The program will finally display the common words between the two lists sorted alphabetically. 
  
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter first file: ");
    String fileName1 = input.nextLine();
    File tempFile1 = new File(fileName1);
    
    System.out.print("Enter second file: ");
    String fileName2 = input.nextLine();
    File tempFile2 = new File(fileName2);
    
    try {
      /* Part 1: creates an list of a word lists of the input files */
      Scanner firstScan = new Scanner(tempFile1); // scans the tempFile
      ArrayList<String> words1 = new ArrayList<String>(); 
      while (firstScan.hasNext()){ words1.add(firstScan.next().toLowerCase().replaceAll("[^a-z]", "")); }
      firstScan.close();
      
      Scanner secondScan = new Scanner(tempFile2); // scans the tempFile
      ArrayList<String> words2 = new ArrayList<String>(); 
      while (secondScan.hasNext()){ words2.add(secondScan.next().toLowerCase().replaceAll("[^a-z]", "")); }
      secondScan.close();
      
      /* Part 2: sorts the list of words in alphabetical order */
      Collections.sort(words1, new Comparator<String>() {
        @Override
        public int compare(String word1, String word2) {
          return word1.compareTo(word2);
        }
      });
      System.out.println(fileName1 + " in alphabetical order: " + words1 + "\n");
      
      Collections.sort(words2, new Comparator<String>() {
        @Override
        public int compare(String word1, String word2) {
          return word1.compareTo(word2);
        }
      });
      System.out.println(fileName2 + " in alphabetical order: " + words2 + "\n");
      
      /* Part 3: compares the words lists  */
      words1.retainAll(words2);
      System.out.println("Common words: " + words1);
      
    } catch (FileNotFoundException E ){
      System.out.println("File not found.");
    }
    input.close();
  }
}
