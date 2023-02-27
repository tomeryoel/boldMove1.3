package model;

import java.util.List;

public class UrlEndPointObject {

    public String nationalId;
    public int year;
    public String broadcast;

    public List<String> files;
    public int summary;

    @Override
    public String toString() {
        return "UrlEndPointObject{" +
                "nationalId='" + nationalId + '\'' +
                ", year=" + year +
                ", broadcast='" + broadcast + '\'' +
                ", files=" + files +
                ", summary=" + summary +
                '}';
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    public int getSummary() {
        return summary;
    }

    public void setSummary(int summary) {
        this.summary = summary;
    }

    public UrlEndPointObject(String nationalId, int year, String broadcast, List<String> files, int summary) {
        this.nationalId = nationalId;
        this.year = year;
        this.broadcast = broadcast;
        this.files = files;
        this.summary = summary;
    }
}