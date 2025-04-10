package Model;

import com.google.gson.annotations.SerializedName;

public class Title {
    private String title;
    private String year;
    private String runTime;

    public Title(TitleOmdb titleOmdb) {
        this.title = titleOmdb.title();
        this.year = titleOmdb.year();
        this.runTime = titleOmdb.runtime();
    }

    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", runTime='" + runTime + '\'' +
                '}';
    }

    public Title(String title, String year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }
}
