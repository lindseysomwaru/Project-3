public class LCS {
    public static int lcs(String s1, String s2, int m, int n, int[][] table) {
        if( m == 0 || n == 0)
            return 0;
        else if(table[m][n] != -1)
            return table[m][n];
        else if(s1.charAt(m-1) == s2.charAt(n-1)) {
            table[m][n] = 1 + lcs(s1,s2,m-1,n-1,table);
            return table[m][n];
        }
        else {
            table[m][n] = Math.max(lcs(s1,s2,m,n-1,table),lcs(s1,s2,m-1,n,table));
            return table[m][n];
        }
    }
    public static void main(String args []) {
       String s1 = "AGGTAB";
       String s2 = "GXTXAYB";
       int m = s1.length();
       int n = s2.length();
       int[][] table = new int[m+1][n+1];
       for(int i=0; i < m + 1; i++)
            for(int j=0; j < n + 1; j++)
                table[i][j] = -1;
        System.out.println("Length of LCS is " + lcs(s1,s2,m,n,table));
    }
}