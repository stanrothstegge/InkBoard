package main.java.fx.model;

/**
 * Class om informatie van een zoekresultaat te kunnen organiseren.
 */
public class SearchResult {
    private String couseName;
    private String courseFaculty;
    private String lastUpdated;

    public SearchResult(String couseName, String courseFaculty, String lastUpdated) {
        this.couseName = couseName;
        this.courseFaculty = courseFaculty;
        this.lastUpdated = lastUpdated;
    }

    public String getCouseName() {
        return couseName;
    }

    public String getCourseFaculty() {
        return courseFaculty;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }
}
