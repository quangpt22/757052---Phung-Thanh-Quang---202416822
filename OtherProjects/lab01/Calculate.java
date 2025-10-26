import javax.swing.JOptionPane;

public class Calculate {
    public static void main(String[] args) {
        String res1 = JOptionPane.showInputDialog("1st num");
        String res2 = JOptionPane.showInputDialog("2nd num");
        double num1 = Double.parseDouble(res1);
        double num2 = Double.parseDouble(res2);
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        if (num2 == 0) {
            JOptionPane.showMessageDialog(null, "Sum: " + sum +"\nDifference: " + difference +"\nProduct: " + product + "\nQuotient: Doesn't exist (Division by 0)");
        }
        else {
            double quotient = num1 / num2;
            JOptionPane.showMessageDialog(null, "Sum: " + sum +"\nDifference: " + difference +"\nProduct: " + product + "\nQuotient: " + quotient);
            System.exit(0);
        }
    }
}
