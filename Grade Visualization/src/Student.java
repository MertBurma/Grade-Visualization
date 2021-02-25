/*
 * Mert Burma
 * 041701033
 * 4.12.2019
 * Summary
 */
public class Student {

	
	
	private String name;
	public int[] grades;
	
	public Student(String name, int[] grades) {
		this.name=name;
		this.grades=grades;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int[] getGrades() {
		return grades;
	}
	public void setGrades(int[] grades) {
		this.grades = grades;
	}
	
	public int getTotalGrade() {
		int total = 0;
		for(int i = 0;i<grades.length;i++) {
			total = total + grades[i];
		}
		return total;
	}

	
}
