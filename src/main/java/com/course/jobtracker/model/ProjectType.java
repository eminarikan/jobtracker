package com.course.jobtracker.model;

public enum ProjectType {
    TYPE_A(Constant.COLOR_A),
    TYPE_B(Constant.COLOR_B),
    TYPE_C(Constant.COLOR_C),
    TYPE_D(Constant.COLOR_D);

    private int color;

    private ProjectType(int color){
        this.color = color;
    }

}
