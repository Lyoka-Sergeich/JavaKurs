package Hwk1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int num1, num2;
        Integer[] arr = new Integer[20];
        //заполним массив
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n;
            n++;
        }
        //поменяем элементы
        num1 = 5;
        num2 = 12;
        replaceEl(arr, num1, num2);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n----------------------------");
        //преобразуем массив в ArrayList
        ArrayList <Integer> arLst = new ArrayList<>();
        arLst = arrToLst(arr);
        System.out.println(arLst);
        System.out.println("----------------------------");
        //создадим 3 коробки
        Box bx1 = new Box<>();
        Box bx2 = new Box<>();
        Box bx3 = new Box<>();
        //заполним 1-ю коробку
        Apple[] arrApple = new Apple[10];
        for (int i = 0; i < arrApple.length; i++) {
            arrApple[i] = new Apple();
        }
        for (int i = 0; i < arrApple.length; i++) {
            bx1.putInBox(arrApple[i]);
        }
        //заполним 2-ю коробку
        Orange[] arrOrange = new Orange[10];
        for (int i = 0; i < arrOrange.length; i++) {
            arrOrange[i] = new Orange();
        }
        for (int i = 0; i < arrOrange.length; i++) {
            bx2.putInBox(arrOrange[i]);
        }
        //сравним по весу
        System.out.println(bx1.compare(bx2));
        System.out.println("----------------------------");

        bx1.putAllInBox(bx2);
        bx1.putAllInBox(bx3);
    }

    public static void replaceEl(Object arr_IN[], int n2, int n1){
        if(n1 > arr_IN.length){
            System.out.println("n1 > length");
            return;
        }
        if(n1 < 0){
            System.out.println("n1 < 0");
            return;
        }
        if(n2 > arr_IN.length){
            System.out.println("n2 > length");
            return;
        }
        if(n2 < 0){
            System.out.println("n2 < 0");
            return;
        }
        Object n = arr_IN[n1];
        arr_IN[n1] = arr_IN[n2];
        arr_IN[n2] = n;
    }

    public static ArrayList arrToLst(Object arr_IN[]){
        ArrayList <Object> lst_Out = new ArrayList<>();
        int n = arr_IN.length;
        for (int i = 0; i < n; i++) {
            lst_Out.add(arr_IN[i]);
        }
        return lst_Out;
    }
}
