/*
Estimate Pi with x=6/Pi^2
Where x is the probability of 2 random numbers beeing coprime
 */
package piday;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author G
 */
public class PiDay {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        //System.out.println(isCofactor(16,12));
        //System.out.println(generateRandom(8, 2));
        int cofactors = 0;
        int numberOfTries = 100000;
        for (int i = 0; i < numberOfTries; i++) {
            int firstNumber = generateRandom(10000, 0);
            int secoundNumber = generateRandom(10000, 0);
            if (isCofactor(firstNumber, secoundNumber)) {
                cofactors++;
                //System.out.println(cofactors);
            }
        }
        //System.out.println(cofactors);
        double ratio = (double) cofactors / (double) numberOfTries;
        double pi = Math.sqrt(6 / ratio);
        //System.out.println(pi);
        writeToFile(numberOfTries, pi);
    }

    /**
     * Euclid method to find GCD from 2 numbers
     *
     * @param a
     * @param b
     * @return GCD from a and b
     */
    public static int gcd(int a, int b) {
        int t;
        while (b != 0) {
            t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

    /**
     *
     * @param a
     * @param b
     * @return False if a and b have a factor bigger than 1 and True if the GCD
     * is 1
     */
    public static boolean isCofactor(int a, int b) {
        return gcd(a, b) == 1;
    }

    public static int generateRandom(int max, int min) {
        int random = (int) (Math.random() * max + min);
        return random;
    }

    public static void writeToFile(int numberOfTries, double pi) throws IOException {

        //Path target =Paths.get("PI.txt");
        //Charset charset=Charset.forName("US-ASCII");
        FileWriter fw = new FileWriter("PI.txt", true);
        try (BufferedWriter writer = new BufferedWriter(fw)) {
            String s = numberOfTries + "          " + pi;
            writer.append(s);
            writer.newLine();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
