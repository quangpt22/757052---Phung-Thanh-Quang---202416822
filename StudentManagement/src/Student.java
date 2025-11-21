public class Student {
	private static int shortId = 1;
    private String studentId;
    private String fullName;
    private int admissionYear;
    private String major;
    private double gpa;
    private static Student[] studentArray = new Student[100];
    private static int studentCount = 0;
    
    public String getStudentId() {
    	return studentId;
    }
    
    public String getFullName() {
    	return fullName;
    }
    
    public int getAdmissionYear() {
    	return admissionYear;
    }
    
    public String getMajor() {
    	return major;
    }
    
    public double getGpa() {
    	return gpa;
    }
    
    public Student(String fullName, int admissionYear, String major, double gpa) {
        this.studentId = String.format("%08d", shortId); 
        this.fullName = fullName;
        this.admissionYear = admissionYear;
        this.major = major;
        this.gpa = gpa;
        studentArray[studentCount++] = this;
        shortId++;
    }
    
    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Full name: " + fullName);
        System.out.println("Year of admission: " + admissionYear);
        System.out.println("Major: " + major);
        System.out.printf("GPA: %.2f\n", gpa);
        System.out.println("---------------------------------");
    }
    
    public static void displayAll() {
        for (int i = 0; i < studentCount; i++) {
            studentArray[i].displayInfo();
        }
    }

    public static double averageGpa() {
    	double sum = 0;
    	for (int i = 0; i < studentCount; i++) {
    		sum += studentArray[i].getGpa();
    	}
    	return sum / studentCount;
    }
    
    public static void swap(int i, int j) {
        Student temp = studentArray[i];
        studentArray[i] = studentArray[j];
        studentArray[j] = temp;
    }
    
    public static void bubbleSortGpa() {
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - i - 1; j++) {
                if (studentArray[j].getGpa() < studentArray[j + 1].getGpa()) {
                    swap(j, j + 1);
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	Student s1 = new Student("Nguyen Van A", 2021, "Computer Science", 3.5);
        Student s2 = new Student("Le Thi B", 2020, "Business", 3.9);
        Student s3 = new Student("Tran Van C", 2022, "Mathematics", 2.6);
        Student s4 = new Student("Ngo Duy D", 2025, "Law", 3.1);
        Student s5 = new Student("Ha Van E", 2024, "Engineering", 2.9);
        System.out.println("Average GPA: " + averageGpa());
        System.out.println("-----------BEFORE SORT-----------");
        displayAll();
        System.out.println("------------AFTER SORT-----------");
        bubbleSortGpa();
        displayAll();
    }
}
