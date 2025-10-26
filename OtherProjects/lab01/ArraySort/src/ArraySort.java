import java.util.Arrays;
import javax.swing.JOptionPane;
public class ArraySort {
	public static void main(String[] args) {
		int size = Integer.parseInt(JOptionPane.showInputDialog("Input array size"));
		double arr[] = new double [size];
		for (int i = 0; i < size; i++) {
			double input = Double.parseDouble(JOptionPane.showInputDialog("Input array size"));
			arr[i] = input;
		}
		Arrays.sort(arr);
		JOptionPane.showMessageDialog(null, "Sorted array: " + Arrays.toString(arr));
	}

}
