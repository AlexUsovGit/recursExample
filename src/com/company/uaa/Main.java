package com.company.uaa;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private int[] arr;
    private Scanner scanner;
    private Random random;

    public Main() {
        random = new Random(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        initAnArray(readTheNumber("введите длину массива:"));
        fillAnArray(readTheNumber("введите верхнюю границу значений:") + 1);
        printAnArray();
        printArrayElement();
    }

    private void printArrayElement() {
        int index = readTheNumber("введите индекс элемента массива:");
        if (index >= 0 && index < arr.length) {
            System.out.println("элемент массива = " + arr[index]);
            getYesOrNo();
            return;
        }

        System.out.println("вы ввели не верное значение!!!");
        printArrayElement();
    }

    private void getYesOrNo() {
        int answ = readTheNumber("Хотите продолжить? Введите 1 - если да, 0 - если нет)");
        switch (answ) {
            case 0:
                System.out.println("Выходим...");
                break;
            case 1:
                getMenuItems();
                break;
            default:
                System.out.println("Вы ввели  не корректное значение.");
                getYesOrNo();
        }
    }
    private void getMenuItems() {
        int menuItem = readTheNumber("Введите 2 - Создать массив заново; \nВведите 3 - Выбрать другой элемент в массиве.");
        switch (menuItem) {
            case 2:
                System.out.println("Запускаем заново");
                run();
                break;
            case 3:
                System.out.println("Выбираем другой элемент.");
                printArrayElement();
                break;
            default:
                System.out.println("Вы ввели  не корректное значение.");
                getMenuItems();
        }
    }

    private void initAnArray(int length) {
        arr = new int[length == 0 ? 1 : length];
    }

    private void fillAnArray(int bounds) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(bounds);
        }
    }

    private void printAnArray() {
        System.out.println("ваш массив: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private int readTheNumber(String message) {
        System.out.println(message);
        scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }

        return readTheNumber("введите именно число!");
    }
}