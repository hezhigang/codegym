/*
author: hezhigang
date: 12/22/20
time: 10:07 AM
*/
package codegym.classicalalgorithms;

/**
 * longest common subsequence (LCS)
 */
public class LCS {

    public static int longestCommonSubsequence(String text1, String text2) {
        final int LEN1 = text1.length(), LEN2 = text2.length();
        return huntSzymanski_lcs(text1.toCharArray(), text2.toCharArray(), LEN1, LEN2);
    }

    /**
     * Hunt-Szymanski Algorithm(Match-List, 1977)
     * http://par.cse.nsysu.edu.tw/~lcs/Hunt-Szymanski%20Algorithm.php
     * @param stringA
     * @param stringB
     * @param m
     * @param n
     * @return
     */
    private static int huntSzymanski_lcs(char[] stringA, char[] stringB, int m, int n) {
        final int alphabet_size = 256;
        int i, j, k, LCS, high, low, mid;
        int[][] matchlist = new int[alphabet_size][];
        int[] L;
        for (i = 0; i < alphabet_size; i++) {
            matchlist[i] = new int[n + 2];
        }
        L = new int[n + 1];

        // make the matchlist
        for (i = 0; i < m; i++) {
            if (matchlist[stringA[i]][0] == 0) {
                matchlist[stringA[i]][0] = 0;

                for (k = 1, j = n - 1; j >= 0; j--) {
                    if (stringA[i] == stringB[j]) {
                        matchlist[stringA[i]][k] = j + 1;
                        k++;
                    }
                    matchlist[stringA[i]][k] = -1;
                }
            }
        }

        // finding the LCS
        for (LCS = 0, i = 0; i < m; i++) {
            for (j = 0; matchlist[stringA[i]][j] != -1; j++) {
                // if the number bigger then the biggest number in the L, LCS + 1
                if (matchlist[stringA[i]][j] > L[LCS]) {
                    LCS++;
                    L[LCS] = matchlist[stringA[i]][j];
                }
                // else, do the binary search to find the place to insert the number
                else {
                    high = LCS;
                    low = 0;
                    k = 0;
                    while (true) {
                        mid = low + ((high - low) / 2);
                        if (L[mid] == matchlist[stringA[i]][j]) {
                            k = 1;
                            break;
                        }
                        if (high - low <= 1) {
                            mid = high;
                            break;
                        }
                        if (L[mid] > matchlist[stringA[i]][j]) {
                            high = mid;
                        } else if (L[mid] < matchlist[stringA[i]][j]) {
                            low = mid;
                        }
                    }
                    if (k == 0) {
                        L[mid] = matchlist[stringA[i]][j];
                    }
                }
            }
        }
        return LCS;
    }

    /**
     * Dynamic Programming
     * bottom-up approach
     * Longest Common Subsequence
     * https://www.programiz.com/dsa/longest-common-subsequence
     * @param S1
     * @param S2
     * @param m
     * @param n
     */
    static void lcs(String S1, String S2, int m, int n) {
        int[][] LCS_table = new int[m + 1][n + 1];

        // Building the mtrix in bottom-up way
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    LCS_table[i][j] = 0;
                else if (S1.charAt(i - 1) == S2.charAt(j - 1))
                    LCS_table[i][j] = LCS_table[i - 1][j - 1] + 1;
                else
                    LCS_table[i][j] = Math.max(LCS_table[i - 1][j], LCS_table[i][j - 1]);
            }
        }

        int index = LCS_table[m][n];
        int temp = index;

        char[] lcs = new char[index + 1];
        lcs[index] = '\0';

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                lcs[index - 1] = S1.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (LCS_table[i - 1][j] > LCS_table[i][j - 1])
                i--;
            else
                j--;
        }

        // Printing the sub sequences
        System.out.printf("S1 : %s\nS2 : %s\nLCS: ", S1, S2);
        for (int k = 0; k <= temp; k++)
            System.out.print(lcs[k]);
        System.out.println();
    }

    public static void main(String[] args) {
//        String S1 = "ACADB";
//        String S2 = "CBDA";
        String S1 = "abcde";
        String S2 = "ace";
//        String S1 = "abcdefg";
//        String S2 = "dfh";
//        String S1 = "abc";
//        String S2 = "abc";
//        String S1 = "abc";
//        String S2 = "def";
//        String S1 = "bl";
//        String S2 = "yby";
//        String S1 = "psnw";
//        String S2 = "vozsh";
//        String S1 = "bsbininm";
//        String S2 = "jmjkbkjkv";
//        String S1 = "pmjghexybyrgzczy";
//        String S2 = "hafcdqbgncrcbihkd";

        int lcs_len = longestCommonSubsequence(S1, S2);
        int m = S1.length();
        int n = S2.length();
        lcs(S1, S2, m, n);
        System.out.printf("the length of LCS = %d", lcs_len);
    }
}