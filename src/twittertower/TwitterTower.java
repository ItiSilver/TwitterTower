/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twittertower;

import static java.lang.System.exit;
import java.util.Scanner;

public class TwitterTower {

    static Scanner in = new Scanner(System.in);

    public static double perimeter(double height, double width) {
        double result = Math.sqrt((Math.pow(width / 2, 2) + Math.pow(height, 2))) * 2 + width;
        return result;
    }

    public static void printTriangle(double height, double width) {
        int res = 0, cnt = (int)width;
        int oddNums = (int) ((width - 2) / 2);
        double rows = (height - 2) / oddNums;
        if (rows % 10 != 0) {
            res = (int) ((height - 2) % oddNums);
        }
        rows = (int) (rows);
        int k, j;
        while(cnt>0){
            System.out.print(" ");
            cnt--;
        }
        System.out.println(" *");
        for (int i = 1; i < height - 1; i++) {
            if (res != 0 && i == 1) {
                j = -res;
            } else {
                j = 0;
            }
            for (; j < rows; j++) {
                if (i % 2 == 0) {
                    continue;
                } else {
                    k = i + 2;
                }
                if (k >= width) {
                    break;
                }
                for (; k > 0; k--) {
                    System.out.print("*");
                }
                System.out.println("");

            }

        }
        while (width > 0) {
            System.out.print("*");
            width--;
        }

    }

    public static void main(String[] args) {
        String choice = " ";
        double height, width;

        while (true) {
            System.out.println("Please choose a tower");
            System.out.println("=====================");
            System.out.println("1. To select a rectangular tower please press 1");
            System.out.println("2. To select a triangle tower please press 2");
            System.out.println("3. To exit please press 3");
            System.out.println("=====================");
            switch (in.nextInt()) {
                case 1 ->
                    choice = "rectangle";
                case 2 ->
                    choice = "triangle";
                case 3 ->
                    choice = "none";
            }

            if (choice.equals("none")) {
                System.out.println("The program is over");
                exit(0);
            } else {
                do {
                    System.out.println("Please enter the height of the tower");
                    height = in.nextInt();
                } while (height < 2);
                System.out.println("Please enter the width of the tower");
                width = in.nextInt();
                if (choice.equals("rectangle")) {
                    if (height > width + 5 || width > height + 5) {
                        System.out.println("The area of the rectangle is: " + height * width);
                    } else {
                        System.out.println("The perimeter of the rectangle is: " + (height + width) * 2);
                    }
                } else {
                    System.out.println("=========================================");
                    System.out.println("1. In order to calculate the perimeter of the triangle please click 1");
                    System.out.println("2. To print the triangle please press 2");
                    System.out.println("=========================================");
                    switch (in.nextInt()) {
                        case 1 ->
                            System.out.println("The perimeter of the triangle is: " + perimeter(height, width));
                        case 2 -> {
                            if (width % 2 == 0 || width > height * 2) {
                                System.out.println("Sorry, but the triangle cannot be printed");
                            } //לבדוק האם צריך להיות גם אי זוגי וגם קצר או מספיק רק תנאי אחד
                            else {
                                printTriangle(height, width);
                            }
                        }

                    }
                }

                
            }
            System.out.println(" ");
        }
    }
}
