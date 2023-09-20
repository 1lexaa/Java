package step.learning.basics;

import java.util.ArrayList;
import java.util.List;

public class BasicsDemo {



    public void run() {
        System.out.println("Java basics");


        byte b = 10;
        short s = 1000;
        int i = 10000000;
        long l = 1000000000L;
        // Reference-аналоги для этих типов
        // Эти типы упаковки ( boxing) работают за value-семантикой
        Byte rb =  10;
        Short rs = 1000;
        Integer ri = 1000000;
        Long rl = 10000000000L;



        int[][] arr2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };


        for(int[] row : arr2) {
            for(int element : row) {
                System.out.print(element+" ");
            }
            System.out.println();
        }


        List<Integer> list = new ArrayList<>();
    }


//
}
