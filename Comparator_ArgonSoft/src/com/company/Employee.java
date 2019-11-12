package com.company;

import java.util.Comparator;

public class Employee implements Comparable {
    private String name;
    private int height;
    private int weight;
    private String noSpaceName;


    public Employee() {
    }

    public Employee(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getNoSpaceName() {
        return noSpaceName;
    }

    public void setNoSpaceName(String noSpaceName) {
        this.noSpaceName = noSpaceName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
// Ez kiirtja a noSpaceName-t is.
/*
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", noSpaceName='" + noSpaceName + '\'' +
                '}';
    }
*/


        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    ", weight=" + weight +
                    '}';
        }

    // Ha implementáljuk a Comparable interfészt.
    @Override
    public int compareTo(Object o) {
        int compareHeight = ((Employee) o).getHeight();
        int compareWeight = ((Employee) o).getWeight();
        String compareName = ((Employee) o).getNoSpaceName();

        int c;
        c = compareHeight -this.height;
        if (c == 0) c = this.weight - compareWeight;
        if (c == 0) c = compareName.length() - this.noSpaceName.length();
        return c;

    }
//--------------A feladat megoldásához ez a rész nem kell. De egyébb Compare trükökk vannak itt ------------------
/*
// Ha implementáljuk a Comparable interfészt.
    @Override
    public int compareTo(Object o) {
        int compareHeight = ((Employee) o).getHeight();
        return compareHeight - this.height;
    }
 */

/*
    //Nem kell implementálni semmit. Ezzel a módszerrel akármennyi Comperatort lehet definiálni.
    public static Comparator<Employee> NameComperator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<Employee> HeightComperator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getHeight(),o2.getHeight());
        }
    };

    public static Comparator<Employee> WeightComperator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Integer.compare(o1.getWeight(),o2.getWeight());
        }
    };
*/



}
