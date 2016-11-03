
import java.util.Random;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khant5061
 */
public class Question8 {

    /**
     * @param args the command line arguments
     */
    public static Scanner in = new Scanner(System.in);

    public static int randomRoll() {
        Random r = new Random();
        int ra = r.nextInt(13);
        if (ra == 0) {
            ra = 2;
        }
        return ra;
    }

    public static int checkSpecial(int squareAt) {
        if(squareAt == 54) {
            squareAt = 19;
        } else if (squareAt == 90) {
            squareAt = 48;
        } else if (squareAt == 99) {
            squareAt = 77;
        } else if (squareAt == 9) {
            squareAt = 34;
        } else if (squareAt == 40) {
            squareAt = 64;
        } else if (squareAt == 67) {
            squareAt = 86;
        }
        return squareAt;
    }

    public static void main(String[]args) {
        int squareAt = 1;
        int roll = 1;   
        boolean wantsRandom = false;
        String answer = "";

        System.out.println("Do you want to use random dice rolls? (Y/N)");
        answer = in.nextLine();

        if (answer.toLowerCase().equals("n")) {
            wantsRandom = false;
        } else if (answer.toLowerCase().equals("y")) {
            wantsRandom = true;
            
        } else {
            while (answer.toLowerCase().equals("y") || answer.toLowerCase().equals("n")) {
                System.out.println("Please enter either Y or N");
                answer = in.nextLine();
            }
        }

        while (roll != 0 && squareAt < 100) {
            if (!wantsRandom) {
                System.out.println("Enter roll of dice: ");
                in.nextInt();
                roll = in.nextInt();
                if (roll > 12) {
                    while (roll > 12) {
                        System.out.println("Please choose a number between 0 and 12");
                        roll = in.nextInt();
                    }
                }
            } else {
                System.out.println("Press any key to roll");
                in.nextLine();
                roll = randomRoll(); 
                System.out.println("You rolled " + roll);
            }
            squareAt = squareAt + roll;
            checkSpecial(squareAt);
            System.out.println("You are now on Square " + squareAt);
            System.out.println("\n");
        }

        if (roll == 0) {
            System.out.println("You Quit"); 
        } else if (squareAt >= 100) {
            System.out.println("You Win!");
        } else {
            System.out.println("You Quit!");
        }
    }
}