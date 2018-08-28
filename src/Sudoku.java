//Bijay Ranabhat
//Project 4: Sudoku Solver
//CSC330
//Spring 2018

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sudoku {
	
	public static final int N = 9;
	public static int[][] matrix= new int[9][9];
	
	public static void main(String [] args) throws FileNotFoundException {
		//Reading as an arraylist of arraylist of integers
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		Scanner in = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = in.nextLine();
		Scanner input = new Scanner(new File(filename));
		
		while(input.hasNextLine())
		{
		    Scanner colReader = new Scanner(input.nextLine());
		    ArrayList col = new ArrayList();
		    while(colReader.hasNextInt())
		    		{
		        col.add(colReader.nextInt());
		    		}
		    a.add(col);
		}
		
		//storing the data in a 9x9 2-D array of integers
		for (int r=0; r<9; r++) {
			for(int c=0;c<9;c++) {
			matrix[r][c]=a.get(r).get(c);
			}
		}
		System.out.println("Unsolved Puzzle:");
		printSudoku();
		System.out.println();
		
		
		System.out.println("Solved Output:");
		if(Solver()) {
			printSudoku();
		}
		else
			System.out.println("I can't solve this.");
	}
	
	
	//Method to print the Sudoku(solved or unsolved)
	
	public static void printSudoku() {
		
		for (int r=0; r<N; r++) {
			for(int c=0;c<N;c++) {
				System.out.print(matrix[r][c]+"\t");
			}
			System.out.println();
		}
	}
	
	
	//Method to check if all cells are assigned or not
	//changes the value of row and column if unassigned
	public static int[] Uassigned(int row, int col) {
		int numberAssign = 0;
		for (int r=0; r<N; r++) {
			for(int c=0;c<N;c++) {
				if (matrix[r][c]==0){
					//change values of row and column
					row =r;
					col =c;
					//since there is one or more unassigned cells
					numberAssign = 1;
					int [] arr= {numberAssign,row, col};
					return arr;
				}
			}
		}
		int [] arr= {numberAssign,-1, -1};
		return arr;
	}
	
	
	//Method to check if we can put a value in a particular cell
	public static boolean goodVal(int num, int row, int col) {
		
		//check row
		for(int r=0; r<N;r++) {
			if(matrix[row][r]==num)
				return false;
		}
		
		//check column
		for(int c=0; c<N;c++) {
			if(matrix[c][col]==num)
				return false;
		}
		
		//check 3*3 sub-matrix
		int r= (row/3)*3;
		int c= (col/3)*3;
		
		for (int i= r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				if(matrix[i][j]==num)
					return false;
			}
		}
		return true;
	}
	
	
	//Method to solve Sudoku
	public static boolean Solver() {
		
		int row=0;
		int col=0;
		
		int [] arr=Uassigned(row,col);
		
		if(arr[0]==0)
			return true;
		row=arr[1];
		col=arr[2];
		
		for(int i = 1; i<=N;i++) {
			
			//testing if we can assign value i 
			//to the cell matrix[row][col]
			
			if(goodVal(i,row,col)) {
				matrix[row][col]=i;
				
				if(Solver())
					return true;
				//reassign the cell value to 0 if this
				//solution is not viable
				matrix[row][col]=0;
			}
		}
		return false;
	}
}
