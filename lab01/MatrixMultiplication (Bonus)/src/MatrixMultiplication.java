import java.util.Arrays;
import java.util.Scanner;
public class MatrixMultiplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows of 1st matrix: ");
        int rows1 = sc.nextInt();

        System.out.print("Enter number of columns of 1st matrix/rows of 2nd matrix: ");
        int cols1 = sc.nextInt();
        int rows2 = cols1;
        
        System.out.print("Enter number of columns of 2nd matrix: ");
        int cols2 = sc.nextInt();
        sc.nextLine();
        
        int[][] matrix1 = new int[rows1][cols1];
        int[][] matrix2 = new int[rows2][cols2];
        int[][] res = new int[rows1][cols2];
        
        System.out.println("Enter the matrix row by row (numbers separated by spaces) E.g: '10 9 8'");
        System.out.println("Matrix 1:");
        for (int i = 0; i < rows1; i++) {
        	String[] rowInput = sc.nextLine().trim().split(" "); 
        	for (int j = 0; j < cols1; j++) {
        				matrix1[i][j] = Integer.parseInt(rowInput[j]);
        	}
        }
        
        System.out.println("Matrix 2:");
        for (int i = 0; i < rows2; i++) {
        	String[] rowInput = sc.nextLine().trim().split(" "); 
        	for (int j = 0; j < cols2; j++) {
        				matrix2[i][j] = Integer.parseInt(rowInput[j]);
        	}
        }
        
        for (int i = 0; i < rows1; i++) {
        	for (int j = 0; j < cols2; j++) {
        		int temp = 0;
        		for (int k = 0; k < cols1; k++) {
        			temp += matrix1[i][k] * matrix2[k][j];
        		}
        		res[i][j] = temp;
        	}
        }
        
        for (int i = 0; i < rows1; i++) {
        	System.out.println(Arrays.toString(res[i]));
        }
        
        sc.close();
        
	}

}
