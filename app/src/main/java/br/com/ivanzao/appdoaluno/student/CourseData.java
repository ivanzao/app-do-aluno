package br.com.ivanzao.appdoaluno.student;

import java.util.List;

public class CourseData {

    private String code;
    private String name;
    private Double partialAverage;
    private Double finalAverage;
    private Integer absencesLimit;
    private Integer absences;
    private List<Grade> grades;
    private List<Grade> edpGrades;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPartialAverage() {
        return partialAverage;
    }

    public void setPartialAverage(Double partialAverage) {
        this.partialAverage = partialAverage;
    }

    public Double getFinalAverage() {
        return finalAverage;
    }

    public void setFinalAverage(Double finalAverage) {
        this.finalAverage = finalAverage;
    }

    public Integer getAbsencesLimit() {
        return absencesLimit;
    }

    public void setAbsencesLimit(Integer absencesLimit) {
        this.absencesLimit = absencesLimit;
    }

    public Integer getAbsences() {
        return absences;
    }

    public void setAbsences(Integer absences) {
        this.absences = absences;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public List<Grade> getEdpGrades() {
        return edpGrades;
    }

    public void setEdpGrades(List<Grade> edpGrades) {
        this.edpGrades = edpGrades;
    }
}