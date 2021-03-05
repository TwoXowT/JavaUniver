// 17ви1 Хамзин Х Хусаинов И
// 8 вариант

package org.lab1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
        public static void main (String[]args){

            System.out.println("Введите количество чисел в массиве: ");
            Scanner input = new Scanner(System.in);
            int n = 0;
            String s;


            // Проверка входного значения n
            do {
                s = input.nextLine();
                if(tryParseInt(s)){
                    n = Integer.parseInt(s);
                    if (n <= 0) {
                        System.err.println("Кол-во чисел должно быть больше 0. Повторите ввод.\n");
                        System.out.println("Введите количество чисел: ");
                        continue;
                    }

                }else{
                    System.err.println("Зпрещено вводить символы");
                    System.out.println("Введите количество чисел: ");
                    continue;
                }

                break;
            } while (true);

            int[] mas = new int[n];
            int i = 0;



            // Проверка массива (не должно быть нулей)
            do{
                System.out.println("Введите " + n + " чисел через Enter:\n");
                while(i < mas.length){
                    int buffer = 0;
                    s = input.nextLine();
                    if(tryParseInt(s)){
                        buffer = Integer.parseInt(s);
                        if (buffer != 0) {
                            mas[i] = buffer;
                            i++;
                            continue;
                        } else{
                            System.err.println("0 не является целым числом. Повторите ввод");
                            i = 0;
                            break;

                        }
                    }else{
                        System.err.println("Запрещено вводить символы");
                        System.out.println(":Повторите ввод ");
                        continue;
                    }

                }

                if(i == mas.length){
                    break;
                }

            }while(true);

            System.out.println("Введенный массив:");
            for (int ma : mas) {
                System.out.println("\t" + ma);
            }

            int firstNum = 0, secondNum = 0;
            float result = 0;
            for (int y = 1; y < mas.length; y++) {
                if (mas[y - 1] > 0 && mas[y] > 0) {
                    firstNum = mas[y - 1];
                    secondNum = mas[y];
                    break;
                }
            }

            // Если таких чисел нет
            if(firstNum == 0 || secondNum == 0){
                System.out.println("В массиве отсутсвют два подряд идущих положительных числа");
                return;
            }

            result = (float) firstNum / (float) secondNum;
            result = result - (int) result;
            System.out.println("Первое число - " + firstNum + "\nВторое число - " + secondNum);
            System.out.println("\nДробная часть от деления " + firstNum + "/" + secondNum + " - "  + result);

    }

    public static boolean tryParseInt(String s){
            try{
                Integer.parseInt(s);
                return true;
            }catch (NumberFormatException e){
                return false;
            }
    }

}
