
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class main{

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 1 for student list 1.txt , 2 for student list 2.txt"); // asks which file we want to read
		
		int f = input.nextInt();//We want the user int value for the student list
		File file = null;
		if(f==1) {
			file = new File("student list 1.txt");// if we type 1 opens the 1st list
		}else if(f==2) {
			file = new File("student list 2.txt");// if we type 2 opens the 2nd list
		}else {
			System.out.println("File can not be found!");
			file = new File("notFound");
		}
		Scanner fileReader = new Scanner(file);//read a text file
		Student [] students = new Student[100];//create a student array
		int countGrades = Integer.parseInt(fileReader.nextLine());//how many grades each student has
		while(fileReader.hasNextLine()) { // to read each line
			String temp = fileReader.nextLine(); //Keeping the lines we read in "string temp"
			String [] arr = temp.split(" ");//When we see spaces between 2 words or characters, we assign them to "arr" arrays
			String name = arr[0];//Since we know that the first element of our array is a name, we take the names in this way.
			int [] grades = new int[countGrades];//we open "grade" array until we held "count grades" 
			for (int i = 0;i<grades.length;i++) {
				grades[i]=Integer.parseInt(arr[i+1]); //We go through the "grades" array and assign the values ​​of "arr [i+1]" to the "grades array"
			}
			Student s = new Student(name,grades);//creating student object
			int k = 0;
			while(students[k]!=null) { //Find out how many students are in the student array
				k++;
			}
			students[k]=s;
		}
		int studentCount = 0;
		while(students[studentCount]!=null) {
			studentCount++;
		}
		Student[] studentList = new Student[studentCount];
		for(int i = 0;i<studentList.length;i++) {
			studentList[i] = students[i];
		}
		
		System.out.println("Do you want to sort the list? 0(no)/1(yes)");
		int asksort = input.nextInt();//get value from user for sort
		if(asksort==1) {
			selectionSort(studentList);//call a sort method
		}
		StdDraw.setCanvasSize(1280,720); // size of screen
		StdDraw.setScale(0,1);
		double y = 0.95;//first y coordinate
		double x = 0.05;//first x coordinate
		double rectHeight = 0.9/studentList.length;//height of a rectangle 
		double fullWidth = 0.85;//The width of the rectangle that will appear if 100 points are obtained 
		for(int i=0;i<studentList.length;i++) {
			x = 0.05;//start
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(x, y, studentList[i].getName());
			x+=0.09;
			for(int j=0;j<studentList[i].grades.length;j++) { //We cycle through the grades of the student list
				Random rand = new Random();    //create a random generator:
				float r = rand.nextFloat();    //As colours are separated into red green and blue 
				float g = rand.nextFloat();    //you can create a new random colour
				float b = rand.nextFloat();    //by creating random primary colours:
				Color randomColor = new Color(r,g,b); //Then to finally create the colour, pass the primary colours into the constructor:
				StdDraw.setPenColor(randomColor);
				double rectWidth = (fullWidth/100)*studentList[i].grades[j];//If 100 is taken, the ratio of the width to the note
				StdDraw.filledRectangle(x+rectWidth/2, y, rectWidth/2, rectHeight/2);//coordinate and size adjustment according to center, rectangle drawing
				x+=rectWidth;//rectangular scroll
			}
			x+=0.01;
			String totalGrade = studentList[i].getTotalGrade()+"";//we converted the total note to string
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(x, y,totalGrade);// call total grade
			y-=rectHeight;//scrolling to avoid graphic overlap
		}
		 StdDraw.show();
	}

		


	

	private static void selectionSort(Student[] students) { 
		Student temp;  // for swapping student
		for (int i = 0; i < students.length - 1; i++) {
			// find the minimum in the totalgrade of student[i..student.length-1]
			int currentMin = students[i].getTotalGrade();
			int currentMinIndex = i;
			for (int j = i + 1; j < students.length; j++) {
				if (currentMin > students[j].getTotalGrade()) {
					currentMin = students[j].getTotalGrade();
					currentMinIndex = j;
				}
			}
			 // swap products[i] with products[currentMinIndex] if necessary 
	        if (currentMinIndex != i) {
	          temp = students[currentMinIndex];
	          students[currentMinIndex] = students[i];
	          students[i] = temp;
	        }
		}

	
}
}
