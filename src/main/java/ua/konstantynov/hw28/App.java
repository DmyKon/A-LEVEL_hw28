//This home task contains 3 items:
//1. Create cloud Linux machine, upload your previous home task which was about creation bash-script and
// ensure that your functionality is working properly on Heroku
//2. Create a java application which is able to calculate the main trigonometric functions,
// deploy your application to Heroku and ensure that the application is working properly.
//3. Create a podcast which describes the main principles of working with Heroku.
package ua.konstantynov.hw28;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("<<< Trigonometric functions calculator >>>");
        System.out.println("Type 'help' for help\nType 'exit' for exit\n");
        String input;
        while (true) {
            System.out.println("Enter function:");
            input = new Scanner(System.in).nextLine();
            if (input.trim().equals("exit")) {
                break;
            }
            if (input.trim().equals("help")) {
                System.out.println("--------help--------");
                System.out.println("Avaible functions:\n" +
                        "sin, cos, tan, sec, cosec, ctan, asin, acos, atan, sinh, cosh, tanh\n" +
                        "\nIf your value is in degrees, type 'deg' in the end\n" +
                        "e.g. 'sin 30 deg' 'cos(60) deg' 'tan 10,5' 'sec(40.25)'");
                System.out.println("--------/help--------\n");
                continue;
            }
            try {
                double value = Double.parseDouble(input
                        .replaceAll(",+", ".")
                        .replaceAll("[^.0-9]", " "));
                if (input.trim().toLowerCase().endsWith("deg")) {
                    value = Math.toRadians(value);
                }
                if (input.toLowerCase().startsWith("sin")) {
                    System.out.printf("= %.9f\n", Math.sin(value));
                } else if (input.toLowerCase().startsWith("sec")) {
                    System.out.printf("= %.9f\n", 1 / Math.cos(value));
                } else if (input.toLowerCase().startsWith("cos")) {
                    System.out.printf("= %.9f\n", Math.cos(value));
                } else if (input.toLowerCase().startsWith("cosec")) {
                    System.out.printf("= %.9f\n", 1 / Math.sin(value));
                } else if (input.toLowerCase().startsWith("tan")) {
                    System.out.printf("= %.9f\n", Math.tan(value));
                } else if (input.toLowerCase().startsWith("ctan")) {
                    System.out.printf("= %.9f\n", 1 / Math.tan(value));
                } else if (input.toLowerCase().startsWith("asin")) {
                    System.out.printf("= %.9f\n", Math.asin(value));
                } else if (input.toLowerCase().startsWith("acos")) {
                    System.out.printf("= %.9f\n", Math.acos(value));
                } else if (input.toLowerCase().startsWith("atan")) {
                    System.out.printf("= %.9f\n", Math.atan(value));
                } else if (input.toLowerCase().startsWith("sinh")) {
                    System.out.printf("= %.9f\n", Math.sinh(value));
                } else if (input.toLowerCase().startsWith("cosh")) {
                    System.out.printf("= %.9f\n", Math.cosh(value));
                } else if (input.toLowerCase().startsWith("tanh")) {
                    System.out.printf("= %.9f\n", Math.tanh(value));
                } else {
                    System.out.println("--------error--------");
                    System.out.println("Error: unknown function\nType 'exit' for exit");
                    System.out.println("--------/error--------\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("--------error--------");
                System.out.println("Error: incorrect value\nType 'exit' for exit");
                System.out.println("--------/error--------\n");
            }
        }
    }
}