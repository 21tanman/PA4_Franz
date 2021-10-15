/*
Author: Tanner Franz
Class: CPSC 312-02
Assignment: PA4
Last Edited: 10/15/2021
Description: GradeCalculator class is used to calculate the grades
calculateFinalGrade() returns a double that represents the percentage needed on final exam
 */

package com.example.pa4_franz;

public class GradeCalculator {

    double minimumAverage, currentAverage, finalPercent;

    GradeCalculator(double minAverage, double curAverage, double finPercent){
      minimumAverage=minAverage;
      currentAverage=curAverage;
      finalPercent = finPercent;
    }

    public double getMinimumAverage() {
        return minimumAverage;
    }

    public void setMinimumAverage(double minimumAverage) {
        this.minimumAverage = minimumAverage;
    }

    public double getCurrentAverage() {
        return currentAverage;
    }

    public void setCurrentAverage(double currentAverage) {
        this.currentAverage = currentAverage;
    }

    public double getFinalPercent() {
        return finalPercent;
    }

    public void setFinalPercent(double finalPercent) {
        this.finalPercent = finalPercent;
    }

    /**
     * returns a double that represents the percentage needed on final exam
     * @return double total, percentage needed on final exam
     */
    double calculateFinalGrade(){
        double total = (getMinimumAverage()-((getCurrentAverage()*((100-getFinalPercent())/100))))/getFinalPercent();
        total=total*100;
        System.out.println("the needed percentage is: " + total);
        return total; //final grade needed to achieve letter grade
    }

}
