package com.company;
/**
 * Adott egy alkalmazott lista. Rendezze az adott listát sorba:
 * I. A magasságuk szerint csökkenő sorendben.
 * II. Ha a magsságuk megegyezik a súlyuk szerint növekvő sorendben.
 * III. Ha a súlyuk megegyezik az legyen elől, akinek a neve szóköz nélkül hosszabb.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class ComperatorArgonSoft {

    public static void main(String[] args) {
        // write your code here
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Valaki Sanyi", 180, 70) );
        employees.add(new Employee("Bassd Ferike", 180, 80));
        employees.add(new Employee("Aaezaz Laci", 180, 70));
        employees.add(new Employee("AztaPisti", 190, 90));
        employees.add(new Employee("FfftaPisti", 195, 90));
        employees.add(new Employee("RrretaPisti", 160, 90));
        employees.add(new Employee("Wdfsfdfsdfaezaz Laci", 180, 70));

        for (int i=0; i<employees.size(); i++){
           employees.get(i).setNoSpaceName(employees.get(i).getName().replaceAll("\\s", ""));
        }

        Collections.sort(employees);
        employees.forEach(employee -> System.out.println(employee));


        //Comperator módszerhez kellene
        // employees.sort(Employee.WeightComperator);

/*
        //Sorba állitja az employees-t magasság szerint lambda kifezéssel(Java 1.8).
        //Ilyenkor nem kell sem a Comparable sem a Comperator interfész.
        employees.sort((e1, e2) -> e1.getHeight() - e2.getHeight());
 */
    }
}
