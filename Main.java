import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b.");
        System.out.println("Калькулятор умеет работать как с арабскими (1,2,3,4,5...), так и с римскими (I,II,III,IV,V...) числами.");
        System.out.println("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");
        System.out.println("Калькулятор умеет работать только с целыми числами.");
        System.out.println("Калькулятор умеет работать только с арабскими или римскими цифрами одновременно.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = calc(input);
        System.out.println(output);
        scanner.close();
    }

    public static String calc(String input) {
        short operator = 0;
        int operatorIndex = 0;
        short result = 0;
        short valueA = 0;
        short valueB = 0;
        short index = 0;
        if (input.indexOf(43) > -1) {
            operator = 1;
            operatorIndex = input.indexOf(43);
        } else if (input.indexOf(45) > -1) {
            operator = 2;
            operatorIndex = input.indexOf(45);
        } else if (input.indexOf(42) > -1) {
            operator = 3;
            operatorIndex = input.indexOf(42);
        } else if (input.indexOf(47) > -1) {
            operator = 4;
            operatorIndex = input.indexOf(47);
        } else try {
            throw new IOException();
        } catch (IOException e) {
            System.out.println("Введенная пользователем строка, не соответствует одной из вышеописанных арифметических операций");
            System.exit(0);
        }
        String valueAString = input.substring(0, operatorIndex);
        String valueBString = input.substring((operatorIndex + 1));
        valueAString = valueAString.trim();
        valueBString = valueBString.trim();
        if ((valueAString.equals("I") || valueAString.equals("II") || valueAString.equals("III")
                || valueAString.equals("IV") || valueAString.equals("V") || valueAString.equals("VI")
                || valueAString.equals("VII") || valueAString.equals("VIII") || valueAString.equals("IX")
                || valueAString.equals("X")) && (valueBString.equals("I") || valueBString.equals("II")
                || valueBString.equals("III") || valueBString.equals("IV") || valueBString.equals("V")
                || valueBString.equals("VI") || valueBString.equals("VII") || valueBString.equals("VIII")
                || valueBString.equals("IX") || valueBString.equals("X"))) {
            switch (valueAString) {
                case "I" -> valueA = 1;
                case "II" -> valueA = 2;
                case "III" -> valueA = 3;
                case "IV" -> valueA = 4;
                case "V" -> valueA = 5;
                case "VI" -> valueA = 6;
                case "VII" -> valueA = 7;
                case "VIII" -> valueA = 8;
                case "IX" -> valueA = 9;
                case "X" -> valueA = 10;
            }
            switch (valueBString) {
                case "I" -> valueB = 1;
                case "II" -> valueB = 2;
                case "III" -> valueB = 3;
                case "IV" -> valueB = 4;
                case "V" -> valueB = 5;
                case "VI" -> valueB = 6;
                case "VII" -> valueB = 7;
                case "VIII" -> valueB = 8;
                case "IX" -> valueB = 9;
                case "X" -> valueB = 10;
            }
            index = 1;
        }
            else if ((valueAString.equals("1") || valueAString.equals("2") || valueAString.equals("3")
                    || valueAString.equals("4") || valueAString.equals("5") || valueAString.equals("6")
                    || valueAString.equals("7") || valueAString.equals("8") || valueAString.equals("9")
                    || valueAString.equals("10")) && (valueBString.equals("1") || valueBString.equals("2")
                    || valueBString.equals("3") || valueBString.equals("4") || valueBString.equals("5")
                    || valueBString.equals("6") || valueBString.equals("7") || valueBString.equals("8")
                    || valueBString.equals("9") || valueBString.equals("10"))) {
                valueA = Short.parseShort(valueAString);
                valueB = Short.parseShort(valueBString);
            }
            else try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Введены неподходящие числа");
                System.exit(0);
            }
        switch (operator) {
                case 1 -> result = (short) (valueA + valueB);
                case 2 -> result = (short) (valueA - valueB);
                case 3 -> result = (short) (valueA * valueB);
                case 4 -> result = (short) (valueA / valueB);
            }
            if ((index == 1) && result >= 0) {
                switch (result/10) {
                    case 0 -> valueAString = "";
                    case 1 -> valueAString = "X";
                    case 2 -> valueAString = "XX";
                    case 3 -> valueAString = "XXX";
                    case 4 -> valueAString = "XL";
                    case 5 -> valueAString = "L";
                    case 6 -> valueAString = "LX";
                    case 7 -> valueAString = "LXX";
                    case 8 -> valueAString = "LXXX";
                    case 9 -> valueAString = "XC";
                    case 10 -> valueAString = "C";
                }
                switch (result%10) {
                    case 0 -> valueBString = "";
                    case 1 -> valueBString = "I";
                    case 2 -> valueBString = "II";
                    case 3 -> valueBString = "III";
                    case 4 -> valueBString = "IV";
                    case 5 -> valueBString = "V";
                    case 6 -> valueBString = "VI";
                    case 7 -> valueBString = "VII";
                    case 8 -> valueBString = "VIII";
                    case 9 -> valueBString = "IX";
                }
                valueAString = valueAString + valueBString;
            } else if (index == 0) {
                valueAString = Short.toString(result);
            }
            else try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
                    System.exit(0);
                }
        return valueAString;
        }
    }