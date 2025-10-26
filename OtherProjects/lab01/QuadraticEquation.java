import javax.swing.JOptionPane;
public class QuadraticEquation {
    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a"));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b"));
        double c = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter c"));
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The equation has no solutions");
                } 
            }
            else {
                double ans = - c / b;
                JOptionPane.showMessageDialog(null, "The equation has 1 solution x = " + ans);
            }
        }
        else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                JOptionPane.showMessageDialog(null, "The equation has no real solutions");
            }
            else if (delta == 0) {
                double ans = - b / (2 * a);
                JOptionPane.showMessageDialog(null, "The equation has 1 solution x = " + ans);
            }
            else {
                double x1 = (- b + Math.sqrt(delta)) / (2 * a);
                double x2= (- b -Math.sqrt(delta)) / (2 * a);
                JOptionPane.showMessageDialog(null, "The equation has 2 solutions x1 = " + x1 + " and x2 = " + x2);
            }
        }
    }
}
