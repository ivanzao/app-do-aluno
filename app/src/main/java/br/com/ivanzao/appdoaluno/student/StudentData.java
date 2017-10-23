package br.com.ivanzao.appdoaluno.student;


import java.util.List;

public class StudentData {

    private String ra;
    private String name;
    private Program program;
    private List<CourseData> courses;

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public List<CourseData> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseData> courses) {
        this.courses = courses;
    }
}