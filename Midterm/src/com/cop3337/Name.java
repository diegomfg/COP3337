package com.cop3337;

public class Name {
    public String first;
    public String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getLastName() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
