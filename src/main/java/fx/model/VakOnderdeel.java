package main.java.fx.model;

/**
 * Class om informatie van een moduleonderdeel te kunnen beschrijven.
 */
public class VakOnderdeel {
    private String title;
    private String description;

    public VakOnderdeel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
