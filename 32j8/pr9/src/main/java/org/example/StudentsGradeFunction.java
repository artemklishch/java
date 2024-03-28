package org.example;

import java.util.function.Function;

public class StudentsGradeFunction implements Function<Integer, String> {
    @Override
    public String apply(Integer mark) {
        if (mark >= 95) {
            return "A";
        }
        if (mark >= 85) {
            return "B";
        }
        if (mark >= 75) {
            return "C";
        }
        if (mark >= 65) {
            return "E";
        }
        return "F";
    }
}
