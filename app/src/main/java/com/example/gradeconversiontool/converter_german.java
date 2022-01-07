package com.example.gradeconversiontool;

public class converter_german {
    public static double convert(double max,double min,double cg){
        if(max<min||max<cg||cg<min||cg>max||max<=0||min<=0||cg<=0){
            double c=-1;
            return c;
        }
        double result=(((max-cg)/(max-min))*3)+1;
        return result;
    }
}
