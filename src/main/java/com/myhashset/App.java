package com.myhashset;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

//Пример работы MyHashSet на элементах Integer!

public class App
{
    private static MyHashSet<Integer> mySet = new MyHashSet<>();
    private static int choise = -1;
    private static Scanner in = new Scanner(System.in);

    public static void main( String[] args )
    {
        while (choise != 0) {
            menu();

            try {
                choise = in.nextInt();
                int element = 0;

                System.out.println("Ваш выбор: " + choise);

                switch(choise){
                    case 0:
                        break;
                    case 1:
                        System.out.println("Метод -> add");
                        System.out.println("Введите число типа Integer!");
                        element = in.nextInt();
                        System.out.println("Элемент добавлен: " + mySet.add(element));
                        System.out.print("Множество после добавления: ");
                        System.out.println(Arrays.toString(mySet.toArray()));
                        break;
                    case 2:
                        System.out.println(Arrays.toString(mySet.toArray()));
                        System.out.println("Метод -> remove");
                        System.out.println("Введите число типа Integer, которое вы хотите удалить из множества");
                        element = in.nextInt();
                        System.out.println("Удалено: " + mySet.remove(element));
                        System.out.print("Множество после удаления: ");
                        System.out.println(Arrays.toString(mySet.toArray()));
                        break;
                    case 3:
                        System.out.println("Метод -> getSize");
                        System.out.println("Текущий размер множества: " + mySet.getSize());
                        break;
                    case 4:
                        System.out.println("Метод -> contains");
                        System.out.println("Введите число типа Integer!");
                        element = in.nextInt();
                        System.out.println("Содержится во множестве: " + mySet.contains(element));
                        break;
                    case 5:
                        System.out.println("Метод -> clear");
                        mySet.clear();
                        System.out.print("Множество после очистки: ");
                        System.out.println(Arrays.toString(mySet.toArray()));
                        break;
                    case 6:
                        System.out.print("Текущее множество: ");
                        System.out.println(Arrays.toString(mySet.toArray()));
                        break;
                    case 7:
                        System.out.println("Метод -> isEmpty");
                        System.out.println("Множество пусто: " + mySet.isEmpty());
                        break;
                    default:
                        System.out.println("Нет такого пункта меню");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Нужно ввести целое число");
                in.nextLine();
            } catch (IndexOutOfBoundsException | NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void menu(){
        System.out.println();
        System.out.println("=======Методы класса MyHashSet=======");
        System.out.println("0 -> Выход!");
        System.out.println("1 -> add (Добавление элемента во множество)");
        System.out.println("2 -> remove (Удаление элемента)");
        System.out.println("3 -> getSize (Получение текущего размера множества)");
        System.out.println("4 -> contains (Проверка наличия элемента)");
        System.out.println("5 -> clear (Очистка всего множества)");
        System.out.println("6 -> Показать всё текущее множество");
        System.out.println("7 -> isEmpty (Проверка на пустоту)");
    }
}
