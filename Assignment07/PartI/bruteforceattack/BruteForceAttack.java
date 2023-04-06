package bruteforceattack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

public class BruteForceAttack implements Runnable {

    static final char startLower = 'a';
    static final char startUpper = 'A';
    static final char startNumber = '0';
    static final char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    char startingChar;

    int numberOfCharsToConsider;
    static Set<String> passwordSet;
    MessageDigest digest;

    public int numberOfFoundPasswords;
    int lengthOfPassword;

    public BruteForceAttack(char startingChar, Set<String> passwordSet, MessageDigest digest, int lengthOfPassword, int numberOfCharsToConsider) {
        this.startingChar = startingChar;
        BruteForceAttack.passwordSet = passwordSet;
        this.digest = digest;
        this.lengthOfPassword = lengthOfPassword;
        this.numberOfFoundPasswords = 0;
        this.numberOfCharsToConsider = numberOfCharsToConsider;
    }

    public static char getChar(int i) {
        return letters[i];

    }

    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static int getInt(char c) {
        if ((c >= 'a') && (c <= 'z')) {
            return c - 'a';
        } else if ((c >= 'A') && (c <= 'Z')) {
            return 26 + (c - 'A');
        } else if ((c >= '0') && (c <= '9')) {
            return 52 + (c - '0');
        } else {
            return 0;
        }
    }

    public static Set<String> hashedpasswords(String filename) {
        Set<String> hashSet = new HashSet<String>();
        try {
            FileReader fr = new FileReader("hashedpassword.txt");
            BufferedReader br = new BufferedReader(fr);
            String inline = br.readLine();
            while (inline != null) {
                hashSet.add(inline);
                inline = br.readLine();
            }
        } catch (Exception e) {

        }
        return hashSet;

    }

    @Override
    public void run() {
        int numfound = 0;
        int len = this.lengthOfPassword;
        double max = Math.pow(26, len - 1);
        byte[] pass = new byte[len];

        for (int i = 0; i < this.numberOfCharsToConsider; i++) {
//            System.out.println(this.startingChar+" "+this.numberOfCharsToConsider);
            pass[0] = (byte) (this.startingChar + i);
            for (int k = 1; k < pass.length; k++) {
                pass[k] = startLower;
            }

            for (long j = 0; j < max; j++) {
                int v = (int) (j % 26L);
                if ((v == 0) && (j != 0)) {

                    pass[1] = startLower;
                    for (int k = 2; k < pass.length; k++) {
                        if (pass[k] == 'z') {
                            if (k != pass.length - 1) {
                                pass[k] = startLower;
                                continue;
                            } else {
                                break;
                            }
                        } else {
                            int val = getInt((char) pass[k]);
                            val++;
                            pass[k] = (byte) letters[val];
                            break;
                        }
                    }
                } else {
                    pass[1] = (byte) letters[v];
                }

                byte[] encodedhash = digest.digest(pass);

                String hashpass = BruteForceAttack.bytesToHex(encodedhash);
                if (passwordSet.contains(hashpass)) {
                    String passString = new String(pass);
//                System.out.println("found password " + passString);
                    numfound++;
                }
                //System.out.println(new String(pass));
            }
        }
        this.numberOfFoundPasswords = numfound;
        System.out.println("found " + numfound + " out of " + passwordSet.size());
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Set<String> passwordSet = hashedpasswords("hashedpassword.txt");
//        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        int NUM_THREADS = 12;       //Also number of starting characters in consideration
        int lengthOfPassword = 6;
        int totalNumberOfPasswordsFound = 0;

        int numberOfStartCharsToProcess, leftoverChars, isOne;
        int letterPos = 0;

        String whichCase = "lowercase";
        int charsToConsider = 0;

        switch (whichCase) {
            case "lowercase":
                charsToConsider = 26;
                break;
            case "uppercase":
                charsToConsider = 52;
                break;
            case "alphanumeric":
                charsToConsider = 62;
                break;
        }
        if (NUM_THREADS > charsToConsider)
            NUM_THREADS = charsToConsider;
        numberOfStartCharsToProcess = charsToConsider / NUM_THREADS;
        leftoverChars = charsToConsider - numberOfStartCharsToProcess * NUM_THREADS;

        Thread[] threads = new Thread[NUM_THREADS];
        BruteForceAttack[] bruteForceAttacks = new BruteForceAttack[NUM_THREADS];

        for (int i = 0; i < NUM_THREADS; i++) {
            if (leftoverChars <= 0) {
                isOne = 0;
                leftoverChars = 0;
            } else {
                isOne = 1;
            }
//            System.out.println(leftoverChars+" "+ letterPos +" "+numberOfStartCharsToProcess+" "+ isOne);
            bruteForceAttacks[i] = new BruteForceAttack(letters[letterPos], passwordSet, MessageDigest.getInstance("SHA-256"), lengthOfPassword, numberOfStartCharsToProcess + isOne);
            threads[i] = new Thread(bruteForceAttacks[i]);
            --leftoverChars;
            letterPos = letterPos + numberOfStartCharsToProcess + isOne;
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i].start();
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            totalNumberOfPasswordsFound += bruteForceAttacks[i].numberOfFoundPasswords;
        }
        long finishTime = System.currentTimeMillis() - startTime;
        double timeTaken = finishTime / (double) 1000;
        System.out.println();
        System.out.println("All threads combined found " + totalNumberOfPasswordsFound + " out of " + passwordSet.size() + " passwords");
        System.out.println("Total time taken: " + timeTaken + " seconds, to find " + whichCase + " passwords");

    }

}
