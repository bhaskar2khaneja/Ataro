package edu.gatech.oad.antlab.person;
import java.util.Random;

/**
 *  A simple class for person 2
 *  returns their name and a
 *  modified string
 *
 * @author Fuad Hasbun
 * @version 1.1
 */
public class Person2 {
    /** Holds the persons real name */
    private String name;
	 	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
	 public Person2(String pname) {
	   name = pname;
	 }
	/**
	 * This method should take the string
	 * input and return its characters in
	 * random order.
	 * given "gtg123b" it should return
	 * something like "g3tb1g2".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
        public String calc(String input) {

            String newStr = "";
            String charToAdd = "";
            int size = input.length();
            Random rand = new Random();
            int randNum = 0;

            while (!input.isEmpty()) {
                randNum = rand.nextInt(size);
                charToAdd = input.charAt(randNum) + "";
                newStr += charToAdd;
                if (input.length() == 1) {
                    input = "";
                } else if (randNum == 0) {
                    input = input.substring(randNum + 1);
                } else {
                    input = input.substring(0, randNum) + input.substring(randNum + 1);
                }
                size--;
            }

            return newStr;
        }
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}
}
