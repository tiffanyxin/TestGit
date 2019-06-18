package thirdweek.demo0530;

import java.util.Objects;

/**
 * @author Tiffany_xin
 * @time 2019/5/30  21:21
 */
public class Student {
    private String name;
    private int classNumber;
    private double score;

    public Student(String name, int classNumber, double score) {
        this.name = name;
        this.classNumber = classNumber;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classNumber=" + classNumber +
                ", score=" + score +
                '}';
    }
}
