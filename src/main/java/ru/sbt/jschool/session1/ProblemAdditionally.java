package ru.sbt.jschool.session1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class ProblemAdditionally {
    public static void main(String[] args) {
        String b1 = "10111";
        String b2 = "111000111";
        ProblemAdditionally probAdd = new ProblemAdditionally();

        System.out.println("Сумма двух чисел "+b1+" + "+ b2 + " = "+probAdd.binaryToDec(b1)+
                " + " + probAdd.binaryToDec(b2) + " = " + (probAdd.binaryToDec(b1)+probAdd.binaryToDec(b2)));

        System.out.println("Сумма в двоичной системе: " +b1+" + "+ b2 + " = "+ probAdd.sumOfBinary(b1,b2)+
                " = " + probAdd.binaryToDec(probAdd.sumOfBinary(b1,b2)));


        long[] arr1 = new long[50];
        long[] arr2 = new long[100];

        // Заполнение созданных масивов случайными числами в диапозоне от 0 до 99
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = new Random().nextInt(100);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = new Random().nextInt(100);
        }
        //Вывод значений всех совпавших элементов созданных массивов
        System.out.println(Arrays.toString(probAdd.intersection(arr1,arr2)));

    }


    public long binaryToDec(String binary){

        return Long.parseLong(binary,2);

    }

    public String sumOfBinary(String b1,String b2){

        return Long.toBinaryString(Long.parseLong(b1,2)+Long.parseLong(b2,2));

    }


    public long[] intersection(long[] arr1,long[] arr2){
        HashSet<Long> setResult = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i]==arr2[j]){
                    setResult.add(arr1[i]);
                    break;
                }
            }
        }
        long[] result = new long[setResult.size()];
        int i = 0;
        for (Long a : setResult){
            result[i]=a;
            i++;
        }

        return result;
    }
}
