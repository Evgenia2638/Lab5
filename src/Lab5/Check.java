package Lab5;

import java.util.PriorityQueue;

public class Check {
    static int a=0;
    public static void check(PriorityQueue<Product> pq) {
        int h = 0;
        Object[] products = pq.toArray();
        for (Object o : products) {
            Product product = (Product) o;
            if (product.getName() == null) {
                h++;
                pq.remove(product);
            } else {
                if (product.getPrice() <= 0) {
                    h++;
                    pq.remove(product);
                }if (!(h == 0)) {
                    a++;
                    //System.out.println("Ваш элемент не добавлен");
                    //System.out.println("Скорее всего вы ввели некорректные значения");
               // } else {
                   // System.out.println("Ваш элемент успешно добавлен");
                }
            }
        }
    }
    public static void check2(PriorityQueue<Person> pq1){
       int h=0;
        Object[] persons = pq1.toArray();
        for (Object p : persons) {
            Person person = (Person) p;
            if (person.getWeight() <= 0) {
                h++;
                pq1.remove(person);
            }
            if (!(h == 0)) {
                a++;
               // System.out.println("Ваш элемент не добавлен");
                //System.out.println("Скорее всего вы ввели некорректные значения");
           // } else {
                //System.out.println("Ваш элемент успешно добавлен");
            }
        }

    }
}
