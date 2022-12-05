import java.util.Scanner;
public class LCS {
    public static void lcs(String s1, String s2, int length) {
        
        //stores solutions to previously computed subproblems
        int[][] table = new int[length+1][length+1];

        //fill table in bottom-up approach
        for(int i=0; i <= length; i++)
            for(int j=0; j <= length; j++) {
                if(i == 0 || j == 0)
                    table[i][j] = 0;
                //if current character of 2 strings match
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
        //printing LCS and length of LCS
        if(lcs[0] == 0)
            System.out.print("Sequence 1: " + s1 + "\nSequence 2: " + s2 + "\nLCS: none" + "\nLength of LCS: 0");
        else {
            System.out.print("Sequence 1: " + s1 + "\nSequence 2: " + s2 + "\nLCS: ");
            int cnt = 0;
            for(int k=0; k <= tmp; k++) {
                cnt++;
                System.out.print(lcs[k]);
            }
            System.out.print("\nLength of LCS: " + (cnt-1));
        }
        System.out.println();
    }
    public static void main(String args []) {
        final int SEQUENCE_LENGTH = 6;
        Scanner scanner = new Scanner(System.in);
        String s1, s2;
        System.out.print("Enter a string of length 6: ");
        s1 = scanner.nextLine().toUpperCase();
        System.out.print("Enter a string of length 6: ");
        s2 = scanner.nextLine().toUpperCase();
        scanner.close();
        if(s1.length() != 6 || s2.length() != 6)
            System.out.println("STRING MUST BE LENGTH 6! TRY AGAIN!");
        else
            lcs(s1,s2,SEQUENCE_LENGTH);
    }
}