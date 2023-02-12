
public class MyInitials {

    static String GetBigLetter(char initial, int lineNumber) {
        String[] bigLet = {"  ", "  ", "  ", "  ", "  ", "  ", "  "};
        switch (initial) {
            case 'A':
                bigLet[0] = "  A  ";
                bigLet[1] = " A A ";
                bigLet[2] = "A   A";
                bigLet[3] = "AAAAA";
                bigLet[4] = "A   A";
                bigLet[5] = "A   A";
                bigLet[6] = "A   A";
                break;
            case 'B':
                bigLet[0] = "BBBB ";
                bigLet[1] = "B   B";
                bigLet[2] = "B   B";
                bigLet[3] = "BBBB ";
                bigLet[4] = "B   B";
                bigLet[5] = "B   B";
                bigLet[6] = "BBBB ";
                break;
            case 'C':
                bigLet[0] = " CCC ";
                bigLet[1] = "C   C";
                bigLet[2] = "C    ";
                bigLet[3] = "C    ";
                bigLet[4] = "C    ";
                bigLet[5] = "C   C";
                bigLet[6] = " CCC ";
                break;
            case 'D':
                bigLet[0] = "DDDD ";
                bigLet[1] = "D   D";
                bigLet[2] = "D   D";
                bigLet[3] = "D   D";
                bigLet[4] = "D   D";
                bigLet[5] = "D   D";
                bigLet[6] = "DDDD ";
                break;
            case 'E':
                bigLet[0] = "EEEEE";
                bigLet[1] = "E    ";
                bigLet[2] = "E    ";
                bigLet[3] = "EEE  ";
                bigLet[4] = "E    ";
                bigLet[5] = "E    ";
                bigLet[6] = "EEEEE";
                break;
            case 'F':
                bigLet[0] = "FFFFF";
                bigLet[1] = "F    ";
                bigLet[2] = "F    ";
                bigLet[3] = "FFF  ";
                bigLet[4] = "F    ";
                bigLet[5] = "F    ";
                bigLet[6] = "F    ";
                break;
            case 'G':
                bigLet[0] = " GGG ";
                bigLet[1] = "G   G";
                bigLet[2] = "G    ";
                bigLet[3] = "GGGGG";
                bigLet[4] = "G   G";
                bigLet[5] = "G   G";
                bigLet[6] = " GGG ";
                break;
            case 'H':
                bigLet[0] = "H   H";
                bigLet[1] = "H   H";
                bigLet[2] = "H   H";
                bigLet[3] = "HHHHH";
                bigLet[4] = "H   H";
                bigLet[5] = "H   H";
                bigLet[6] = "H   H";
                break;
            case 'I':
                bigLet[0] = "IIIII";
                bigLet[1] = "  I  ";
                bigLet[2] = "  I  ";
                bigLet[3] = "  I  ";
                bigLet[4] = "  I  ";
                bigLet[5] = "  I  ";
                bigLet[6] = "IIIII";
                break;
            case 'J':
                bigLet[0] = "JJJJJ";
                bigLet[1] = "  J  ";
                bigLet[2] = "  J  ";
                bigLet[3] = "  J  ";
                bigLet[4] = "J J  ";
                bigLet[5] = "J J  ";
                bigLet[6] = " JJ  ";
                break;
            case 'K':
                bigLet[0] = "K   K";
                bigLet[1] = "K  K ";
                bigLet[2] = "K K  ";
                bigLet[3] = "KK   ";
                bigLet[4] = "K K  ";
                bigLet[5] = "K  K ";
                bigLet[6] = "K   K";
                break;
            case 'L':
                bigLet[0] = "L     ";
                bigLet[1] = "L     ";
                bigLet[2] = "L     ";
                bigLet[3] = "L     ";
                bigLet[4] = "L     ";
                bigLet[5] = "L     ";
                bigLet[6] = "LLLLL ";
                break;
            case 'M':
                bigLet[0] = "M   M";
                bigLet[1] = "MM MM";
                bigLet[2] = "MM MM";
                bigLet[3] = "M M M";
                bigLet[4] = "M   M";
                bigLet[5] = "M   M";
                bigLet[6] = "M   M";
                break;
            case 'N':
                bigLet[0] = "N   N";
                bigLet[1] = "NN  N";
                bigLet[2] = "N N N";
                bigLet[3] = "N  NN";
                bigLet[4] = "N   N";
                bigLet[5] = "N   N";
                bigLet[6] = "N   N";
                break;
            case 'O':
                bigLet[0] = " OOO ";
                bigLet[1] = "O   O";
                bigLet[2] = "O   O";
                bigLet[3] = "O   O";
                bigLet[4] = "O   O";
                bigLet[5] = "O   O";
                bigLet[6] = " OOO ";
                break;
            case 'P':
                bigLet[0] = "PPPP ";
                bigLet[1] = "P   P";
                bigLet[2] = "P   P";
                bigLet[3] = "PPPP ";
                bigLet[4] = "P    ";
                bigLet[5] = "P    ";
                bigLet[6] = "P    ";
                break;
            case 'Q':
                bigLet[0] = " QQQ ";
                bigLet[1] = "Q   Q";
                bigLet[2] = "Q   Q";
                bigLet[3] = "Q   Q";
                bigLet[4] = "Q   Q";
                bigLet[5] = "Q  Q ";
                bigLet[6] = " QQ Q";
                break;
            case 'R':
                bigLet[0] = "RRRR ";
                bigLet[1] = "R   R";
                bigLet[2] = "R   R";
                bigLet[3] = "RRRR ";
                bigLet[4] = "R R  ";
                bigLet[5] = "R  R ";
                bigLet[6] = "R   R";
                break;
            case 'S':
                bigLet[0] = " SSS ";
                bigLet[1] = "S   S";
                bigLet[2] = "S    ";
                bigLet[3] = " SSS ";
                bigLet[4] = "S   S";
                bigLet[5] = "S   S";
                bigLet[6] = " SSS ";
                break;
            case 'T':
                bigLet[0] = "TTTTT";
                bigLet[1] = "  T  ";
                bigLet[2] = "  T  ";
                bigLet[3] = "  T  ";
                bigLet[4] = "  T  ";
                bigLet[5] = "  T  ";
                bigLet[6] = "  T  ";
                break;
            case 'U':
                bigLet[0] = "U   U";
                bigLet[1] = "U   U";
                bigLet[2] = "U   U";
                bigLet[3] = "U   U";
                bigLet[4] = "U   U";
                bigLet[5] = "U   U";
                bigLet[6] = " UUU ";
                break;
            case 'V':
                bigLet[0] = "V   V";
                bigLet[1] = "V   V";
                bigLet[2] = "V   V";
                bigLet[3] = "V   V";
                bigLet[4] = "V   V";
                bigLet[5] = " V V ";
                bigLet[6] = "  V  ";
                break;
            case 'W':
                bigLet[0] = "W   W";
                bigLet[1] = "W   W";
                bigLet[2] = "W   W";
                bigLet[3] = "W W W";
                bigLet[4] = "WW WW";
                bigLet[5] = "WW WW";
                bigLet[6] = "W   W";
                break;
            case 'X':
                bigLet[0] = "X   X";
                bigLet[1] = "X   X";
                bigLet[2] = " X X ";
                bigLet[3] = "  X  ";
                bigLet[4] = " X X ";
                bigLet[5] = "X   X";
                bigLet[6] = "X   X";
                break;
            case 'Y':
                bigLet[0] = "Y   Y";
                bigLet[1] = " Y Y ";
                bigLet[2] = "  Y  ";
                bigLet[3] = "  Y  ";
                bigLet[4] = "  Y  ";
                bigLet[5] = "  Y  ";
                bigLet[6] = "  Y  ";
                break;
            case 'Z':
                bigLet[0] = "ZZZZZ";
                bigLet[1] = "    Z";
                bigLet[2] = "   Z ";
                bigLet[3] = "  Z  ";
                bigLet[4] = " Z   ";
                bigLet[5] = "Z    ";
                bigLet[6] = "ZZZZZ";
                break;
        }
        return bigLet[lineNumber];
    }

    static String BigLetter(String initials, int lineNumber) {
        String lineToBePrinted = "";
        for (int i = 0; i < initials.length(); i++) {
            lineToBePrinted = lineToBePrinted + "  " + GetBigLetter(initials.charAt(i), lineNumber);
        }
        return lineToBePrinted;
    }

    public static void main(String[] args) {
        String initials = "THR";
        initials = initials.toUpperCase();
        String line;
        for (int i = 0; i < 7; i++) {
            line = BigLetter(initials, i);
            System.out.println(line);
        }
    }
}
