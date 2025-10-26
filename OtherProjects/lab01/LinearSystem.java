import javax.swing.JOptionPane;
public class LinearSystem {
    public static void main(String[] args) {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a11"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a12"));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b1"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a21"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a22"));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b2"));
        double det = a11 * a22 - a21 * a12;
        double det1 = b1 * a22 - b2 * a12;
        double det2 = a11 * b2 - a21 * b1;

        if (det == 0) {
            if (det1 == 0 && det2 == 0) {
                JOptionPane.showMessageDialog(null, "The system has infinitely many solutions.");
            }
            else {
                JOptionPane.showMessageDialog(null, "The system has no solution.");
            }
        }
        else {
            double ans1 = det1 / det;
            double ans2 = det2 / det;
            JOptionPane.showMessageDialog(null, "The system has solutions x1 = " + ans1 +", x2 = " + ans2); 
        }
    }
}
