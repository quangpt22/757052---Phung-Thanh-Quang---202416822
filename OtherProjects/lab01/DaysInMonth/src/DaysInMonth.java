import javax.swing.JOptionPane;

public class DaysInMonth {
    public static void main(String[] args) {
        int YEAR = -1;
        int MONTH = 0;
        int DAYS = 0;

        // Month handling
        do {
        	String MONTH_INP = JOptionPane.showInputDialog("Input the month:");
        	if (MONTH_INP.equals("january") || MONTH_INP.equals("jan.") || MONTH_INP.equals("jan") || MONTH_INP.equals("1")) {
        		MONTH = 1;
        	} else if (MONTH_INP.equals("february") || MONTH_INP.equals("feb.") || MONTH_INP.equals("feb") || MONTH_INP.equals("2")) {
        		MONTH = 2;
        	} else if (MONTH_INP.equals("march") || MONTH_INP.equals("mar.") || MONTH_INP.equals("mar") || MONTH_INP.equals("3")) {
        		MONTH = 3;
        	} else if (MONTH_INP.equals("april") || MONTH_INP.equals("apr.") || MONTH_INP.equals("apr") || MONTH_INP.equals("4")) {
        		MONTH = 4;
        	} else if (MONTH_INP.equals("may") || MONTH_INP.equals("5")) {
        		MONTH = 5;
        	} else if (MONTH_INP.equals("june") || MONTH_INP.equals("jun.") || MONTH_INP.equals("jun") || MONTH_INP.equals("6")) {
        		MONTH = 6;
        	} else if (MONTH_INP.equals("july") || MONTH_INP.equals("jul.") || MONTH_INP.equals("jul") || MONTH_INP.equals("7")) {
        		MONTH = 7;
        	} else if (MONTH_INP.equals("august") || MONTH_INP.equals("aug.") || MONTH_INP.equals("aug") || MONTH_INP.equals("8")) {
        		MONTH = 8;
        	} else if (MONTH_INP.equals("september") || MONTH_INP.equals("sept.") || MONTH_INP.equals("sep.") || MONTH_INP.equals("sep") || MONTH_INP.equals("9")) {
        		MONTH = 9;
        	} else if (MONTH_INP.equals("october") || MONTH_INP.equals("oct.") || MONTH_INP.equals("oct") || MONTH_INP.equals("10")) {
        		MONTH = 10;
        	} else if (MONTH_INP.equals("november") || MONTH_INP.equals("nov.") || MONTH_INP.equals("nov") || MONTH_INP.equals("11")) {
        		MONTH = 11;
        	} else if (MONTH_INP.equals("december") || MONTH_INP.equals("dec.") || MONTH_INP.equals("dec") || MONTH_INP.equals("12")) {
        		MONTH = 12;
        	} else {
        		JOptionPane.showMessageDialog(null, "Invalid month input. Please try again");
        		MONTH = 0;
        	}
        } while (MONTH == 0);
        
        // Year handling
        do {
        	try {
        		YEAR = Integer.parseInt(JOptionPane.showInputDialog("Input the year:"));
        		if (YEAR < 0) {
            		JOptionPane.showMessageDialog(null, "Invalid year input. Year must be positve. Please try again");
            		YEAR = -1;
            	}
        	} catch (NumberFormatException e) {
        		JOptionPane.showMessageDialog(null, "Invalid year input. Please try again and enter numbers only");
        		YEAR = -1; 
        	}
        } while (YEAR == -1);

        // Deducing num of days
        if (MONTH == 1 || MONTH == 3 || MONTH == 5 || MONTH == 7 || MONTH == 8 || MONTH == 10 || MONTH == 12) {
            DAYS = 31;
        }
        else if (MONTH == 4 || MONTH == 6 || MONTH == 9 || MONTH == 11) {
            DAYS = 30;
        }
        else if (MONTH == 2) {
            if ((YEAR % 4 == 0 && YEAR % 100 != 0) || YEAR % 400 == 0) {
                DAYS = 29;
            }
            else {
                DAYS = 28;
            }
        }
        
        // Printing result
        JOptionPane.showMessageDialog(null, "Month: " + MONTH + "\nYear: " + YEAR + "\nDays: " + DAYS);
    }
}