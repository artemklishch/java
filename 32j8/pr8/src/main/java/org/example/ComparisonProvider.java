package org.example;

public class ComparisonProvider {
    public int compareByName(User a, User b){
        return a.getName().compareTo(b.getName());
    }
}
