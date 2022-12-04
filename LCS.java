import java.util.Scanner;
public class LCS {
    public static void lcs(String s1, String s2, int length) {
        int[][] table = new int[length+1][length+1];
        for(int i=0; i <= length; i++)
            for(int j=0; j <= length; j++) {
                if( i == 0 || j == 0)
                    table[i][j] = 0;
                else if(s1.charAt(i-1) == s2.charAt(j-1))
                    table[i][j] = table[i-1][j-1] + 1;
                else
                    table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
            }
        int index = table[length][length];
        int tmp = index;
        char[] lcs = new char[index+1];
        lcs[index] = '\0';
        int i = length, j = length;
        while( i > 0 && j > 0) {
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                lcs[index-1] = s1.charAt(i-1);
                i--;
                j--;
                index--;
            }
            else if(table[i-1][j] > table[i][j-1])
                i--;
            else
                j--;
        }
        System.out.print("Sequence 1: " + s1 + "\nSequence 2: " + s2 + "\nLCS: ");
        for(int k=0; k <= tmp; k++)
            System.out.print(lcs[k]);
        System.out.println();
    }
    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.print("Enter a string of length 6: ");
        s = scanner.nextLine();
        return s;
    }
    public static void main(String args []) {
        final int SEQUENCE_LENGTH = 6;
        String s1 = getUserInput();
        String s2 = getUserInput();
        lcs(s1,s2,SEQUENCE_LENGTH);
    }
}