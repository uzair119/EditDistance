/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editdistance;

/**
 *
 * @author Uzair
 */
public class Path {
    public int row, col;
    public int cost;
    public Path next;
    public char a;
    public char b;
    
    Path(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    Path(int row, int col,int cost)
    {
        this.row = row;
        this.col = col;
        this.cost = cost;
    }
    Path(int row, int col,int cost, Path next)
    {
        this.row = row;
        this.col = col;
        this.cost = cost;
        this.next = next;
    }
}
