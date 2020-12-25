package com.h2;

import java.util.Arrays;
import java.util.Map;

public class Finance {
    public final static String BEST_LOAN_RATES = "bestLoanRates";
    public final static String SAVINGS_CALCULATOR  = "savingsCalculator";
    public final static String MORTGAGE_CALCULATOR  = "mortgageCalculator";

    public final static Map<String, String> commandsToUsage  = Map.of(
            BEST_LOAN_RATES, "usage: bestLoanRates",
            SAVINGS_CALCULATOR, "usage: savingsCalculator <credits separated by ','> <debits separated by ','>",
            MORTGAGE_CALCULATOR, "usage: mortgageCalculator <loanAmount> <termInYears> <annualRate>");

    public static void main( String[] args )
    {
         boolean validationStatus =    validateCommandArguments(args);

         if (validationStatus )
            executeCommand(commandsToUsage.get(args[0]), Arrays.copyOfRange(args,1, args.length));

    }

    private static boolean validateCommandArguments(String[] args){
        String appName = args[0];
        switch (appName){
            case BEST_LOAN_RATES:
            return args.length == 1 ? true:false;
               // break;
            case SAVINGS_CALCULATOR:
                return args.length == 3 ? true:false;
            case MORTGAGE_CALCULATOR:
                return args.length == 4 ? true:false;
            default:
                return  false;
        }
    }
    private static  void executeCommand(String command  , String[] arguments ){
    switch (command){
        case BEST_LOAN_RATES :
            System.out.println("Finding best loan rates ...");
            BestLoanRates.main(arguments);
            return;
        case SAVINGS_CALCULATOR:

            System.out.println("Finding your net savings ...");
            SavingsCalculator.main(arguments);
            return;
         case MORTGAGE_CALCULATOR:
             System.out.println("Finding your monthly payment ...");
             MortgageCalculator.main(arguments);
             return;
    }

    }
}
