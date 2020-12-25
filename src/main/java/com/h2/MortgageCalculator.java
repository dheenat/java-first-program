package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator
{

    private long loanAmount ;
    private int termInYears;
    private float annualRate;
    private double monthlyPayment ;

    public static void main( String[] args )
    {
        long loanAmount = Long.parseLong(args[0]);
        int termInYears = Integer.parseInt(args[1]);
        float annualRate  = Float.parseFloat(args[2]);

        MortgageCalculator mortgageCalc = new MortgageCalculator(loanAmount,termInYears,annualRate);
        mortgageCalc.calculateMonthlyPayment();
        System.out.println(mortgageCalc.toString());
    }
    public MortgageCalculator(long loanAmount , int termInYears,float annualRate){
    this.loanAmount= loanAmount;
    this.termInYears= termInYears;
    this.annualRate=annualRate;
    }

    private int getNumberOfPayments(){
        return 12*termInYears ;
    }

    private float getMonthlyInterestRate() {
        float interestRate = annualRate / 100;
        return interestRate / 12;
    }
    public void calculateMonthlyPayment(){

        //M = P(r(1+r)^n/(((1+r)^n)-1)
        long p = loanAmount;
        float r = getMonthlyInterestRate();
        int n = getNumberOfPayments();

        this.monthlyPayment =  p * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1));
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("####0.00");

        return "monthlyPayment: " + df.format(monthlyPayment);
    }
}
