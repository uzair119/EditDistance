/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editdistance;

import java.util.Scanner;

/**
 *
 * @author Uzair
 */
public class EditDistance {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    static Path path(String a, String b)
    {
        Path [][]matrix = new Path[a.length() + 1][b.length() + 1];
        for(int i = 0; i < matrix.length; i++)
            matrix[i][0] = new Path(i,0,i*2);
        for(int j = 0; j < matrix[0].length; j++)
            matrix[0][j] = new Path(0,j,j*2);
        
        for(int i = 1; i < matrix.length;i++)
            for(int j = 1; j < matrix[i].length;j++)
            {
                if(a.charAt(i-1) == b.charAt(j-1))
                {
                    matrix[i][j] = new Path(i,j,matrix[i-1][j-1].cost,matrix[i-1][j-1]);
                    matrix[i][j].a = a.charAt(i-1);
                    matrix[i][j].b = a.charAt(i-1);
                }
                else
                {
                    int sub = matrix[i-1][j-1].cost + 1;
                    int ins = matrix[i-1][j].cost + 2;
                    int del = matrix[i][j-1].cost + 2;
                    Path p;
                    int c;
                    char c1;
                    char c2;
                    if(sub <= ins)
                    {
                        if(sub <= del)
                        {
                            p = matrix[i-1][j-1];
                            c = sub;
                            c1 = a.charAt(i-1);
                            c2 = b.charAt(j-1);
                        }
                        else
                        {
                            p = matrix[i][j-1];
                            c = del;
                            c1 = '-';
                            c2 = b.charAt(j-1);
                        }
                    }
                    else
                    {
                        if(ins <= del)
                        {
                            p = matrix[i-1][j];
                            c = ins;
                            c1 = a.charAt(i-1);
                            c2 = '-';
                        }
                        else
                        {
                            p = matrix[i][j-1];
                            c = del;
                            c1 = '-';
                            c2 = b.charAt(j-1);
                        }
                    }
                    matrix[i][j] = new Path(i,j,c,p);
                    matrix[i][j].a = c1;
                    matrix[i][j].b = c2;
                }
            }
       /* for(int i = 0; i <= a.length(); i++)
        {
            for(int j = 0; j <=b.length(); j++)
                System.out.print(matrix[i][j].cost + " ");
            System.out.println("");
        }*/
        return matrix[a.length()][b.length()];
    }
    
    public static void traverse(Path p)
    {
        if(p == null || p.next == null) 
            return;
        if(p.next.next == null)
        {
            System.out.println(p.a + " " + p.b + " " + p.cost);
        }
        else
        {
            traverse(p.next);
            System.out.println(p.a + " " + p.b + " " + (p.cost-p.next.cost));
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("String 1: ");
        String str1 = scan.nextLine();
        
        System.out.println("String 2: ");
        String str2 = scan.nextLine();
        
        
        
        String str3 = "ATGATCAAGGCGACGGACAGAAAACTGGTAGTAGGACTGGAGATTGGTACCGCGAAGGTTGCCGCTTTAGTAGGGGAAGTTCTGCCCGACGGTATGGTCAATATCATTGGCGTGGGCAGCTGCCCGTCGCGTGGTATGGATAAAGGCGGGGTGAACGACCTCGAATCCGTGGTCAAGTGCGTACAACGCGCCATTGACCAGGCAGAATTGATGGCAGATTGTCAGATCTCTTCGGTATATCTGGCGCTTTCTGGTAAGCACATCAGCTGCCAGAATGAAATTGGTATGGTGCCTATTTCTGAAGAAGAAGTGACGCAAGAAGATGTGGAAAACGTCGTCCATACCGCGAAATCGGTGCGTGTGCGCGATGAGCATCGTGTGCTGCATGTGATCCCGCAAGAGTATGCGATTGACTATCAGGAAGGGATCAAGAATCCGGTAGGACTTTCGGGCGTGCGGATGCAGGCAAAAGTGCACCTGATCACATGTCACAACGATATGGCGAAAAACATCGTCAAAGCGGTTGAACGTTGTGGGCTGAAAGTTGACCAACTGATATTTGCCGGACTGGCATCAAGTTATTCGGTATTGACGGAAGATGAACGTGAACTGGGTGTCTGCGTCGTCGATATCGGTGGTGGTACAATGGATATCGCCGTTTATACCGGTGGGGCATTGCGCCACACTAAGGTAATTCCTTATGCTGGCAATGTCGTGACCAGTGATATCGCTTACGCCTTTGGCACGCCGCCAAGCGACGCCGAAGCGATTAAAGTTCGCCACGGTTGTGCGCTGGGTTCCATCGTTGGAAAAGATGAGAGCGTGGAAGTGCCGAGCGTAGGTGGTCGTCCGCCACGGAGTCTGCAACGTCAGACACTGGCAGAGGTGATCGAGCCGCGCTATACCGAGCTGCTCAACCTGGTCAACGAAGAGATATTGCAGTTGCAGGAAAAGCTTCGCCAACAAGGGGTTAAACATCACCTGGCGGCAGGCATTGTATTAACCGGTGGCGCAGCGCAGATCGAAGGTCTTGCAGCCTGTGCTCAGCGCGTGTTTCATACGCAAGTGCGTATCGGCGCGCCGCTGAACATTACCGGTTTAACGGATTATGCTCAGGAGCCGTATTATTCGACGGCGGTGGGATTGCTTCACTATGGGAAAGAGTCACATCTTAACGGTGAAGCTGAAGTAGAAAAACGTGTTACAGCATCAGTTGGCTCGTGGATCAAGCGACTCAATAGTTGGCTGCGAAAAGAGTTTTAA";
        String str4 = "GTGCGCCAGCCCGCCATCGCGGCCGTCGATCTGGGCGCGTCGAAGGTGACGTGCTTCATCATGAAGGCTGACGGCGTCCACCGGGATAACCGCACTCTGACGACCGCGGGTGTGGGCTATGTGCAGTCGCGCGGCGTGCGCGGCGGCGCGATCGTCAATCTGGACGAGGCCGCCCAGGCGATCGCCCAGGCCGTGGAGCGCGCCGAGACCGTGGCCGGCGTCAGCGTCCAGGGCGTCAGCGTCTGCACCGCCGGCGGCCAGCTGGCCAGCCACCGCGTGCACACCCAGGTCTCGCTGGGCGCCCGTCCGATCGGCGACGGCGACCTGTCGCGCGCCATCGCCTCGGCCCTGGCCCAGGTCCGCATTCCGGGCCGCAAGCCGATCCACCTCCTGCCCATCGCCTGGTCGGTCGACGGTCAGCGCGGCATCCGTGATCCCCGCGCCATGTTCGGCCGCGCCCTGGGGCTGGAGCTGCTGGTGGTCTCGGTCAACGAGAACATCTTCCACACCCTGGCCCACTGCGTGGAGCGCGCCCACCTGTCGTTCGAGGGGATTGTCGCTGCGCCCTTCGCCTCGGCCCTGGCGGCCCTGGAAGAGGACGAGATGGATCTGGGCGCCGTCTGCATCGACATGGGCGGCGGCTCGACCTCGGTGGCGGTGTTCAACAATGGCGCGCTCTGCCACGTCGACAGCCTGGCCGTCGGCGGCGGTCACGTGACCCAGGACATCGCGCGCGGCCTGCAGACCTCGGTCGTGGGCGCCGAGCGCATCAAGACCCTGCATGGCAGCGCCATCGCCTCGGCCAACGAGGATCGTGAGATGATCGAGGCGCCGCCGCGTGGCGACGATCCGGGCGCGGGTCCGGTGATCGCTCCGCGCAGCTTGCTCAAGGGCATCATCCAGCCGCGCGTCGAAGAGACCCTGGAACTGCTGCGCGAGCGCCTGAAGGCCTCGGGCGCGCCGGTCGAGCCGGGCGCGGGCATCGTGCTGACCGGCGGCGCCAGCCAGCTGGCCGGTGTGCGCGAAGTGGCCGTGCGCGTCTTCGACCGTCCCGTTCGCCTGGGTCGTCCGCGCCGGGTGCCGCATCTGGCCGACGCCGCGTCGGGCCCGGCCTTCTGCGCCGCCGCCGGCGTCCTGCACCGTACCGCCTTTGGCCCGCGCGAGGCGGTCTCGTCCAAGGCCCTGGCCGGCGGCGTGGCTCGCAAGCGTCCCATCGACCCCAACGCCAGCCCGATGGCCAAGGCGGCCGCCTGGCTGCGCGACAATCTCTAA";
        
        Path p = path(str1,str2);
        System.out.println("Edit distance: " + p.cost);
        traverse(p);
    }
    
}
