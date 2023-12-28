package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadanie_1 {
    public static void main(String[] args) {


        Scanner chooseLanguage = new Scanner(System.in);
        System.out.println("Please choose language for ENG 1 , for POL 2");
        try {


            int language = chooseLanguage.nextInt();


            if (language == 1) {

                langENG();


            } else if (language == 2) {
                langPL();

            } else {
                System.out.println("Please enter correct number ENG- 1 or PL- 2");
            }

            chooseLanguage.close();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a correct number ");

        }
    }


    public static void langENG() {

        Scanner enterMonthENG = new Scanner(System.in);
        System.out.println("Enter number from 1 to 12");
        try {


            int numberMonth = enterMonthENG.nextInt();

            if (numberMonth >= 1 && numberMonth <= 12) {
                MonthPlEng miesiac = MonthPlEng.getMonthByNumber(numberMonth);
                System.out.println("Month : " + miesiac.getAngielski());
            } else {
                System.out.println("Enter number from 1 to 12");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter correct number");
        }

    }

    public static void langPL() {

        Scanner enterMonthPL = new Scanner(System.in);
        System.out.println("Wprowadz numer od 1 do 12");
        try {
            int numberMonth = enterMonthPL.nextInt();

            if (numberMonth >= 1 && numberMonth <= 12) {
                MonthPlEng miesiac = MonthPlEng.getMonthByNumber(numberMonth);
                System.out.println("Miesiac: " + miesiac.getPolski());
            } else {
                System.out.println("Wprowadz numer od 1 do 12");
            }
        }catch (InputMismatchException e){
            System.out.println("Wprowadz prawidlowy numer");
        }

    }
}
