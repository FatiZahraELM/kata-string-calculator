package fr.norsys.stringcalculator;

import java.util.ArrayList;

public class Clazz{

    public int add(String numbers) {
        if(numbers.isEmpty())
            return 0;
        String delmiter=",|\n";
        if(numbers.startsWith("//")) {

            delmiter = String.valueOf(numbers.charAt(2));
            numbers=numbers.substring(4);
        }
        int result=0;
        String[]  numbersDevided= numbers.split(delmiter);
        int[] num = new int[numbersDevided.length];
        ArrayList negatives = new ArrayList();


        for(int i=0;i<numbersDevided.length;i++) {

            num[i] = Integer.parseInt(numbersDevided[i]);
            if(num[i]<0){
                negatives.add(num[i]);
            }

            if(num[i]>1000) continue;
            else result += num[i];

        }
        if(!(negatives.isEmpty())){
            throw new RuntimeException("negatives not allowed - "+negatives);
        }
            return result;



    }
}