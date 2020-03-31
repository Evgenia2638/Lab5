package Lab5;
/**
 * @autor Jonny
 * version 2.1
 */

import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main{
    /**
     * Метод дающий доступ к командам
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            File file = new File("C:\\\\\\\\Users\\\\\\\\User\\\\\\\\Desktop\\\\\\\\testcsv.csv");
            ///home/s263879/5/testcsv.csv////
                    //"C:\\\\Users\\\\Andreyl\\\\Desktop\\\\fucking potato\\\\testcsv.csv");//
            // File file1 = new File("C:\\Users\\Andreyl\\Desktop\\fucking potato\\2.txt");
            PriorityQueue<Product> productPriorityQueue = MakerColl.CSVtoCollection(file);

            boolean exit = true;
            while (exit) {
                System.out.println();
                System.out.println("Введите команду");

                String num = scanner.nextLine();
                String[] word = num.split(" ");
                switch (word[0].toLowerCase()) {
                    case ("add"):
                        try {
                            Comands.add(productPriorityQueue);
                            Comands.check(productPriorityQueue);
                            // System.out.println("Элемент успешно дабавлен");
                        } catch (Exception e) {
                            System.out.println("Что-то пошло не так и элемент не добавлен");
                        }
                        break;
                    case ("info"):
                        Comands.info(productPriorityQueue);
                        break;

                    case ("show"):
                        if (productPriorityQueue.size() > 0) {
                            Comands.show(productPriorityQueue);

                        } else {
                            System.out.println("Коллекция пуста");
                        }
                        break;
                    case ("remove_first"):
                       // try {
                        Comands.remove_first(productPriorityQueue);
                        System.out.println("Объект удален");
                        /*} catch (NoSuchElementException e) {
                            System.err.println("Коллекция пустая");
                        }*/
                        break;
                    case ("help"):
                        System.out.println("Информация о доступных командах:" +
                                "\ninfo: вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)" +
                                "\nadd: добавить новый элемент в коллекцию" +
                                "\nshow: вывести в стандартный поток вывода все элементы коллекции в строковом представлении" +
                                "\nclear: удалить из коллекции все элементы" +
                                "\nremove_first: удалить первый элемент из коллекции" +
                                "\nremove_by_id: удалить значение элемента по его id" +
                                "\nupdate_id:  обновить значение элемента коллекции, id которого равен заданному" +
                                "\nsave: сохранить коллекцию в файл" +
                                "\nsave_and_exit: сохранить изменения и выйти из порграммы" +
                                "\nfilter_greater_than_price: вывести элементы, значение поля price которых больше заданного" +
                                "\ncount_less_than_price: вывести количество элементов, значение поля price которых меньше заданного" +
                                "\ncount_greater_than_owner: вывести количество элементов, значение поля owner которых больше заданного" +
                                "\nadd_if_max: добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции" +
                                "\nremove_greater: удалить из коллекции все элементы, превышающие заданный"+
                                "\nexecute_script: считать и исполнить скрипт из указанного файла."+
                                "\nexit: завершить работу программы");
                        break;
                    case("remove_greater"):
                        Comands.remove_greater(productPriorityQueue);
                        break;
                    case ("add_if_max"):
                        Comands.add_if_max(productPriorityQueue);
                        break;
                    case ("filter_greater_than_price"):
                        try {
                            Comands.filter_greater_than_price(productPriorityQueue);
                        } catch (NumberFormatException e) {
                            System.err.println("Вы не ввели значение price, из-за этого сравнение невозможно");
                        }
                        break;

                    case ("count_less_than_price"):
                        try {
                            Comands.count_less_than_price(productPriorityQueue);
                        } catch (NumberFormatException e) {
                            System.err.println("Вы не ввели значение price, из-за этого сравнение невозможно");
                        }
                        break;
                    case ("clear"):
                        Comands.clear(productPriorityQueue);
                        System.out.println("Все элементы успешно удалены");
                        break;
                    case ("remove_by_id"):
                        try {
                            Comands.remove_by_id(productPriorityQueue);
                        } catch (Exception e) {
                            System.out.println("Что-то пошло не так и элемент не обновлен");
                        }
                        break;
                    case ("execute_script"):
                        Comands.execute_script(productPriorityQueue);

                        break;
                    case ("update_id"):
                        try {
                            Comands.update_id(productPriorityQueue);
                        } catch (Exception e) {
                            System.out.println("Что-то пошло не так и элемент не обновлен");
                        }
                        break;
                    case ("save"):
                        try {
                            MakerFile.saveFile(file, productPriorityQueue);
                            System.out.println("Файл сохранен");
                        } catch (IOException e) {
                            System.err.println("Мне жаль, но неудалось сохранить файл");
                        }
                        break;
                    case ("exit"):
                        exit = false;
                        break;
                    case ("save_and_exit"):
                        try {
                            MakerFile.saveFile(file, productPriorityQueue);
                            System.out.println("Файл сохранен");
                            exit = false;
                        } catch (IOException e) {
                            System.err.println("Мне жаль, но неудалось сохранить файл");
                        }
                        break;
                    default:
                        System.out.println("Мне жаль, но команда введена не коректно");
                }
            }
        //} catch (FileNotFoundException e) {
            //System.err.println("не могу найти файл");
        } catch (IOException e) {
            System.err.println("Что-то пошло не так и не удалось прочесть файл");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}