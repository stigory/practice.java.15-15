package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int convertMinutesToDegree(int min) {
        min = (360/60)*min;
        return min;
    }
    private static float convertHoursToDegree(int min, int hrs){
        System.out.println("Принятое значение мин. " + min);

        float degree;

        if ( hrs > 12 ) {
            hrs = hrs - 12;
            System.out.println("Приводим время к 12-часовому формату");
            System.out.println(hrs);
        }

        if ( hrs == 12 ) {
            hrs = 0;
            System.out.println("приводим 12 часов к 0");
        }

        if ( min == 0 ) {
            degree = (360/12)*hrs;
        }
        else {
            degree = (360/12) * hrs + (float) (min * 0.5);  //Вот тут я не понял почему компилятор потребовал явного приведения типа
        }

        return degree;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Введите часы");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = reader.readLine();
        int hours = Integer.parseInt(inputString);
        System.out.println("Введите минуты");
        inputString = reader.readLine();
        int minutes = Integer.parseInt(inputString);
        System.out.println("Введенное время: "+hours+" ч. "+minutes+" мин.");

        float hrsDegree = convertHoursToDegree(minutes, hours);
        System.out.println("Сконвертированное значение часов: "+hrsDegree);

        int minDegree = convertMinutesToDegree(minutes);
        System.out.println("Сконвертированное значение минут: "+minDegree);

        float angle = minDegree - hrsDegree;

        if (angle < 0) angle = angle * -1;
        System.out.println("Угол между стрелками: " + angle);
    }
}


