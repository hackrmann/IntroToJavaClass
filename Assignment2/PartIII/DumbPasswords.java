import java.util.Scanner;

public class DumbPasswords {
    public static void printDumbPasswords(int m, int n) {
        String password;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < m; j++) {
                for (char k = 'a'; k < (n+(int)('a')); k++) {
                    for (char x = 'a'; x < (n+(int)('a')); x++) {
                        for (int y = Integer.max(i, j) + 1; y <= m; y++) {
                            password = Integer.toString(i) + Integer.toString(j) + k + x
                                    +Integer.toString(y);
                            System.out.print(password+" ");
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int m, n;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter m: ");
        m = in.nextInt();
        System.out.print("Enter m: ");
        n = in.nextInt();
        printDumbPasswords(m,n);
    }
}
