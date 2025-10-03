import java.util.Arrays;
import java.util.Scanner;
public class MatrixAddition {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        sc.nextLine(); 

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] res = new int[rows][cols];
		
        System.out.println("Enter the matrix row by row (numbers separated by spaces):");
        for (int i = 1; i <= 2; i++) {
        	System.out.println("Matrix " + i + ":");
        	for (int j = 0; j < rows; j++) {
        		String[] rowInput = sc.nextLine().trim().split(" "); // split by spaces
        		for (int k = 0; k < cols; k++) {
        			if (i == 1) {
        				matrix1[j][k] = Integer.parseInt(rowInput[k]);
        			}
        			else {
        				matrix2[j][k] = Integer.parseInt(rowInput[k]);
        			}
        		}
        	}
        }

        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		res[i][j] = matrix1[i][j] + matrix2[i][j];
        	}
        }
        
        for (int i = 0; i < rows; i++) {
        	System.out.println(Arrays.toString(res[i]));
        }
        sc.close();
	}

}
