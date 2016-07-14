package edu.globant.day3.functional;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

class Student {
	private final String name;
	private final List<Double> gradeList;

	public Student(String name, List<Double> gradeList) {
		this.name = name;
		this.gradeList = Collections.unmodifiableList(gradeList);
	}

	public String getName() {
		return name;
	}

	public List<Double> getGradeList() {
		return gradeList;
	}
}

public class OptionalDemo {

	public static void main(String[] args) {
		Student defaultStudent = new Student("glober", emptyList());
		Optional<Student> studentJimmy = createStudent("Jimmy", asList(15d, 12d, 10d));
		Optional<Student> studentMark = createStudent("Mark", asList(9d, 12d, 4d));
		Optional<Student> studentPoli = createStudent("Poli", emptyList());
		showStudentData(studentJimmy, defaultStudent);
		System.out.println("---------------------------------------------------");
		showStudentData(studentMark, defaultStudent);
		System.out.println("---------------------------------------------------");
		showStudentData(studentPoli, defaultStudent);
	}

	public static Optional<Student> createStudent(String name, List<Double> grade) {
		if (name == null || name.trim().isEmpty()
				|| grade.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(new Student(name.trim(), grade));
	}

	public static void showStudentData(Student student, Student defaultStudent) {
		if (student != null) {
			System.out.println(String.format("Name of Student: %s.", student.getName()));
			if (student.getGradeList() != null) {
				double avg = 0;
				for (Double grade : student.getGradeList()) {
					avg += grade;
				}
				avg = avg / student.getGradeList().size();
				if (avg > 10) {
					System.out.println("His grade is above average.");
				}
			}
		}
	}

	public static void showStudentData(Optional<Student> student, Student defaultStudent) {
		//TODO what if there's no value here?
		student = Optional.of(student.orElse(defaultStudent));
//		student = Optional.of(student.orElseGet( () -> defaultStudent ));

		student.ifPresent(s ->
			System.out.println(String.format("Name of Student: %s.", s.getName()))
		);
		student.filter(s -> s.getGradeList().stream()
				.mapToDouble(g -> g)
				.average().orElseGet(() -> 0d) > 10d)
			.ifPresent(s -> System.out.println("His grade is above average."));
		student.map(s -> s.getGradeList()).ifPresent(gl -> gl.stream().forEach(System.out::println));
	}
}
