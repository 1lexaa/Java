package step.learning.files;


import java.io.File;
import java.util.Scanner;

public class DirDemo {
/*
Робота з файлами поділяються на дві групи задач :
- робота з файловою системою ,,,,
 */

    public void run() {
        System.out.println("Directories demo");
        String path = "./";
        File dir = new File(path); // File - основа роботи з файлами
        // нового File не чинить ніякого впливу на файлову систему лише створює Java об'єкт
        // який відповідає за вказаний шлях

        if (dir.exists()) {
            System.out.printf("Object '%s' does exists  @ real path '%s' and it is '%s' %n \n", path, dir.getAbsolutePath(), dir.isFile() ? "file" : "directory");

        } else {
            System.out.printf("Object '%s' does not exists\n", path);
        }

        String subPath = "./upload";
        File subDir = new File(subPath);
        if (subDir.exists()) {
            System.out.printf("Dir '%s' already exists\n", subPath);

        } else {
            System.out.printf("Dir '%s' does not exists\n", subPath);
            subDir.mkdir(); // mkdir - створює директорію
            System.out.printf("Dir '%s' created\n", subPath);
        }

        // Вивести повідомлення "Delete object? (y/n) "
        // обробити відповідь - якщо Y то видаляємо та створюємо інакше ні.
        Scanner scann = new Scanner(System.in);
        System.out.print("Delete object? (y/n) ");
        String answer = scann.nextLine();
        if(answer.equalsIgnoreCase("y"))
        {
            subDir.delete();
            System.out.printf("Dir '%s' deleted\n", subPath);
            subDir.mkdir();
            System.out.printf("Dir '%s' created\n", subPath);
        }
        else
        {
            System.out.printf("Dir '%s' not deleted\n", subPath);
        }







    }

}
