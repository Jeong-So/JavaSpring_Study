package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello JUnit!");

        //Main์์ Test ์ํจ
        // Test 1
        Calculator calculator = new Calculator(new KrwCalculator());
        System.out.println(calculator.sum(10,10));

        // Test 2
        MarketApi marketApi = new MarketApi();
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculatorDollar = new Calculator(dollarCalculator);
        System.out.println(calculatorDollar.sum(10,10));

    }
}