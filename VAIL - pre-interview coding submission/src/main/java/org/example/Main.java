package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main( String[] args )
    {
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(rotateList(24, numberList));

        System.out.println();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(rotateList(3, numbers)));
    }

    // Rotate numbers using Java Collection Framework
    public static List<Integer> rotateList(int rotate, List<Integer> list) {
        if (rotate > list.size()) {
            do {
                rotate -= list.size();
            }while (rotate > list.size());
        }

        ArrayList<Integer> rotatedNumbers = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 0) {
                throw new IllegalStateException("List cannot contain a negative number! Number " + list.get(i) + " in index " + i);
            }

            if (i < rotate)
                rotatedNumbers.add(list.get(i));
            else {
                numbers.add(list.get(i));
            }
        }
        numbers.addAll(rotatedNumbers);
        return numbers;
    }

    // Rotate numbers using simple Java array
    public static int[] rotateList(int rotate, int[] arrayOfNumbers) {
        if (rotate > arrayOfNumbers.length) {
            do {
                rotate -= arrayOfNumbers.length;
            }while (rotate > arrayOfNumbers.length);
        }

        int[] rotatedNumbers = new int[arrayOfNumbers.length];
        int count = 0;

        for (int i = 0; i < arrayOfNumbers.length; i++) {
            if (arrayOfNumbers[i] < 0) {
                throw new IllegalStateException("Array cannot contain a negative number! Number " + arrayOfNumbers[i] + " found in index " + i);
            }
            if (i < rotate) {
                rotatedNumbers[i + (rotatedNumbers.length - rotate)] = arrayOfNumbers[i];
            }else {
                rotatedNumbers[count] = arrayOfNumbers[i];
                count++;
            }
        }
        return rotatedNumbers;
    }
}
