package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {

    private float[] credits;
    private float[] debits;

    public SavingsCalculator(float[] credits,  float[] debits){
        this.credits=credits;
        this.debits= debits;
    }
    public static void main( String[] args )
    {
        String[] creditsAsString = args[0].split(",")  ;
        String[] debitsAsString = args[1].split(",")  ;
      float[] credits =  convertToFloatArray(creditsAsString);
        float[] debits =  convertToFloatArray(debitsAsString);

        SavingsCalculator savingsCalculator = new SavingsCalculator(credits,debits);
        float netSavings = savingsCalculator.calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }

    private static float[] convertToFloatArray(String[] asStr){
        float[] floatArr = new float[asStr.length]  ;

        for(int i=0; i<asStr.length; i++){
            floatArr[i] =   Float.parseFloat( asStr[i] );
        }
        return  floatArr;
    }

    public float calculate(){
        return sumOfCredits() - sumOfDebits() ;
    }

    private  float sumOfCredits( ){
    float sum = 0;
    for(float credit : credits){
        sum +=credit;
    }
        return sum ;
    }

    private  float sumOfDebits( ){
        float sum = 0;
        for(float debit : debits){
            sum +=debit;
        }
        return sum ;
    }

    private static int remainingDaysInMonth(LocalDate date){
        YearMonth yearMonth = YearMonth.of(date.getYear(),date.getMonth());
            int totalDaysInMonth = yearMonth.lengthOfMonth();
            int remainingDays = totalDaysInMonth -  date.getDayOfMonth() ;
        return remainingDays ;
    }

}
