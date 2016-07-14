package edu.globant.day3.functional;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class StudentWithTutor {
	private final String name;
	private final List<Double> gradeList;
	private final String tutor;

	public StudentWithTutor(String name, List<Double> gradeList, String tutor) {
		this.name = name;
		this.gradeList = unmodifiableList(gradeList);
		this.tutor = tutor;
	}

	public String getName() {
		return name;
	}

	public List<Double> getGradeList() {
		return gradeList;
	}

	public String getTutor() {
		return tutor;
	}
}

public class StreamsDemo {

	public static void main(String[] args) {
		List<StudentWithTutor> studentList = asList(
			new StudentWithTutor("Jorge", asList(10d, 12d, 14d), "Morgan"),
			new StudentWithTutor("Magnolia", asList(19d, 7d, 2d), "Felipe"),
			new StudentWithTutor("Olinda", asList(3d, 17d, 5d), "Lucrecia"),
			new StudentWithTutor("Mauricio", asList(8d, 16d, 13d), "Adrián"),
			new StudentWithTutor("Paula", asList(12d, 11d, 4d), "Morgan"),
			new StudentWithTutor("Fabricio", asList(5d, 18d, 10d), "Morgan"),
			new StudentWithTutor("Beatriz", asList(9d, 17d, 14d), "Adrián"),
			new StudentWithTutor("Jacob", asList(20d, 2d, 7d), "Felipe")
			);
		showStudents(studentList);
		System.out.println("----------------------------------------------------------");
		List<StudentWithTutor> studentsWithGradeAbove10 =
			studentList.stream()
				.filter(s -> s.getGradeList().stream()
						.mapToDouble(Double::doubleValue)
						.average().orElse(0) > 10)
				.collect(Collectors.toList());
		showStudents(studentsWithGradeAbove10);
		System.out.println("----------------------------------------------------------");
		Map<String, List<StudentWithTutor>> studentsByTutor =
				studentList.stream()
					.collect(Collectors.groupingBy(StudentWithTutor::getTutor));
		studentsByTutor.entrySet().stream()
			.forEach(e -> {
				System.out.println(e.getKey() + "'s students: ");
				showStudents(e.getValue());
			});
		System.out.println("----------------------------------------------------------");
		Map<String, List<StudentWithTutor>> studentsByTutorOrdered =
				studentList.stream()
					.collect(Collectors.groupingBy(
							StudentWithTutor::getTutor,
							LinkedHashMap::new,
							Collectors.toList()));
		studentsByTutorOrdered.entrySet().stream()
			.forEach(e -> {
				System.out.println(e.getKey() + "'s students: ");
				showStudents(e.getValue());
			});
		System.out.println("----------------------------------------------------------");
		Double classAverageGrade = studentList.stream()
			.flatMap(s -> s.getGradeList().stream())
			.mapToDouble(Double::doubleValue)
			.average()
			.orElse(10d);
		System.out.println(String.format("Class average grade is %.2f.", classAverageGrade));
	}

	public static void showStudents(List<StudentWithTutor> studentList) {
		studentList.stream()
			.forEach(s -> System.out.println(String.format("Student %s with grades %s", s.getName(), s.getGradeList())));
	}
}
