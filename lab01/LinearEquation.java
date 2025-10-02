import javax.swing.JOptionPane;
public class LinearEquation {
    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a"));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b"));
        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions.");
            }
            else {
                JOptionPane.showMessageDialog(null, "The equation has no solution.");
            }
        }
        else {
            double ans = -b/a;
            JOptionPane.showMessageDialog(null, "Solution: x = " + ans);
        }
    }
}
