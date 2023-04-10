package com.example.basicjava;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ClassObject {

        String name;  // data member
        int age;


        public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, CloneNotSupportedException {

            System.out.println("Hello Darshan");
            ClassObject darshan = new ClassObject();
            ClassObject obj1 = (ClassObject) Class.forName("com.example.androidstudiogitempty.ClassObject").newInstance();
            ClassObject obj2 = (ClassObject) obj1.clone();
            obj2 = new ClassObject();
            System.out.println(darshan.age);
            System.out.println(darshan.name);
            darshan.age = 21;
            darshan.name = "Darshan";
            System.out.println(darshan.age);
            System.out.println(darshan.name);

        }
    }

    class EmptyClass {
    }

//ClassObject cobj = new ClassObject();


    class Vehicle {
        public void isCar() {
            System.out.println("This is a car");
        }
    }

    class Car extends Vehicle {
        void speed() {
            System.out.println("This car speed is 240 km/h");
        }

        public static void main(String[] args) {
            Car car = new Car();
            car.isCar();
            car.speed();
        }
    }

    // multi level A -> B -> C
    class Bmw extends Car {
        void price() {
            System.out.println("Bmw car price is 45 lakhs and above");
        }

        public static void main(String[] args) {
            Bmw bmw = new Bmw();
            bmw.isCar();
            bmw.speed();
            bmw.price();
        }
    }

// Hierarchical A -> B and A -> C

    class RolsRoyce extends Car {
        void price() {
            System.out.println("RR car price is above 4 crorer");
        }

        public static void main(String[] args) {
            RolsRoyce rolsRoyce = new RolsRoyce();
            rolsRoyce.isCar();
            rolsRoyce.speed();
            rolsRoyce.price();
        }
    }

// Multiple is not supported in java c -> A, B
// error: class can not extends multiple classes

// Hybrid is not supported in java

// Aggregation in java

    class Student {
        String name;
        int age;
        Mark mark;

        Student(String name, int age, Mark mark) {
            this.name = name;
            this.age = age;
            this.mark = mark;
        }

//    Mark markStd = new Mark(85, 90, 95);

        public static void main(String[] args) {
            //Mark mark = new Mark(85, 90, 95);
            Student student = new Student("Darshan", 21, new Mark(85, 90, 95));
            System.out.println("student name is: " + student.name);
            System.out.println("student age is: " + student.age);
            System.out.println("mark is:" + student.mark.mark1 + "," + student.mark.mark2 + "," + student.mark.mark3);
        }

    }

    class Mark {
        int mark1, mark2, mark3;

        Mark(int mark1, int mark2, int mark3) {
            this.mark1 = mark1;
            this.mark2 = mark2;
            this.mark3 = mark3;
        }
    }

// polymorphism

// runtime (overriding)

    class Bus {
        void price() {
            System.out.println("Bus price is 25 lakhs");
        }
    }

    class Bike extends Bus {
        void price() {
            System.out.println("bike price is 1 lakhs");
        }

        void price(int price) {
            System.out.println("price is" + price);
        }

        public static void main(String[] args) {
            Bus b = new Bike(); // upcasting
            b.price();
            b.price();
            Bus bus = new Bus();
            bus.price();
            Bike bike = new Bike();
            bike.price();
//        Bike bike1 = new Bus();
//        bike1.price(); // error:
        }
    }

    class CarV extends Bus {
        @Override
        void price() {
            System.out.println("Car price is depends on car and car compny");
        }

        public static void main(String[] args) {
            Bus carV = new CarV();
            carV.price();
        }

    }

// overloading

    class Area {
        int area(int num1, int num2) {
            return num1 * num2;
        }

        int area(int num1, int num2, int num3) {
            return num1 + num2 + num3;
        }

        int rectangle(int num1, int num2) {
            return num1 * num2;
        }

        public static void main(String[] args) {
            Area areaM = new Area();
            System.out.println(areaM.area(5, 10));
            System.out.println(areaM.area(5, 2, 3));
            System.out.println(areaM.rectangle(6, 8));
        }

    }

// Abstract

    abstract class Shape {
        abstract void area();
    }

    class Circle extends Shape {
        void area() {
            System.out.println("circle area is used");
        }
    }

    class Rectangle extends Shape {
        void area() {
            System.out.println("Rectangle area is used");
        }
    }

    class ShapeArea {
        public static void main(String[] args) {
            Shape rectangle = new Rectangle();
            rectangle.area();
            Shape circle = new Circle();
            circle.area();
        }
    }


    abstract class Mobile {

        abstract void display();
        // abstract method can not have body

        void call() {
            System.out.println("non abstract method use");
        }

        String name;

        Mobile(String name) {
            this.name = name;
        }

        public static void main(String[] args) {
            Mobile mb = new Mobile("iphone 14") {
                @Override
                void display() {
                    System.out.println("abstract class override");
                }
            };

        }
    }

    class User extends Mobile {
        User(String name) {
            super(name);
        }

        void display() {
            System.out.println("without abstract use");
        }

        public static void main(String[] args) {
            Mobile mobile = new User("iphone");
            mobile.display();
            mobile.call();
            System.out.println(mobile.name);
        }
    }

// constructor in abstract class

    abstract class Msg {
        Msg() {
            System.out.println("Constructor is used in abstract class");
        }

        abstract void info();

        public static void main(String[] args) {
            Msg msg = new Msg() {
                @Override
                void info() {
                    System.out.println("info method use in abstrct class");
                }
            };
            msg.info();
        }
    }

// encapsulation

    class School {
        private int mark;

        public int getMark() {
            return mark;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }
    }

    class StudentofSchool {
        public static void main(String[] args) {
            School school = new School();
            school.setMark(85);
            System.out.println(school.getMark());
        }
    }

// read only class

    class Bank {
        private String accountno = "Darshan369394";

        String getAccountno() {
            return accountno;
        }

        public static void main(String[] args) {
            Bank bank = new Bank();
            System.out.println(bank.getAccountno());
            System.out.println(bank.accountno);
        }
    }

//class Bank {
//    private String accountno;
//    String getAccountno(String accountno) {
//        return accountno;
//    }
//    public static void main(String[] args){
//        Bank bank = new Bank();
//        System.out.println(bank.getAccountno("ftygyay"));
//        System.out.println(bank.accountno);
//    }
//}

    class BankUser {
        public static void main(String[] args) {
            Bank bank = new Bank();
            System.out.println(bank.getAccountno());
        }
    }

// write only class

    class Balance {
        private double balance;

        public void setBalance(double balance) {
            this.balance = balance;
            System.out.println("balance is:" + balance);
        }
    }

    class ShowBalance {
        public static void main(String[] args) {
            Balance balance = new Balance();
            balance.setBalance(50000);
        }
    }

// operator

// Airithmatic operation

    class Airthmatic extends Throwable {
        public static void main(String[] args) {
            int num1 = 50;
            int num2 = 20;

            int add = num1 + num2;
            System.out.println(add);
            int sub = num1 - num2;
            System.out.println(sub);
            int multi = num1 * num2;
            System.out.println(multi);
            int divide = num1 / num2;
            System.out.println(divide);
            int module = num1 % num2;
            System.out.println(module);
            int increment = num1++;
            System.out.println(increment);
            int decrement = num2--;
            System.out.println(decrement);
            int dec = ++num1;
            System.out.println(dec);

        }
    }

// relational operator

    class Relational {
        public static void main(String[] args) {
            int num1 = 50;
            int num2 = 30;

            if (num1 == num2) {
                System.out.println("Both variable are same");
            } else if (num1 > num2) {
                System.out.println("num1 is grater than num2");
            } else if (num1 < num2) {
                System.out.println("num1 is less than num2");
            } else if (num1 != num2) {
                System.out.println("both variable different");
            } else if (num1 >= num2) {
                System.out.println("num1 is grater than or equal to num2");
            } else if (num1 <= num2) {
                System.out.println("mum1 is less than or equal to num2");
            }
        }

    }

// logical operator

    class Logical {
        public static void main(String[] args) {
            boolean value1 = true;
            boolean value2 = false;

            if (value1 && value2) {
                System.out.println("both value true");
            } else if (value1 || value2) {
                System.out.println("any one value true");
            } else if (!(value1 && value2)) {
                System.out.println("use not operator");
            }
        }
    }

// Assignment operator

    class Assignment {
        public static void main(String[] args) {
            int num1 = 10;
            int num2 = 15;

            int num = num1 + num2;
            System.out.println(num);

            num += num1;
            System.out.println(num);

            num -= num2;
            System.out.println(num);

            num1 *= num2;
            System.out.println(num1);

            num1 /= num2;
            System.out.println(num1);

            num2 %= num1;
            System.out.println(num2);

            num1 *= num2;

            num1 <<= num2;
            System.out.println(num1);

            num1 *= num2;

            num1 >>= num2;
            System.out.println(num1);

            num1 &= num2;
            System.out.println(num1);

            num1 ^= num2;
            System.out.println(num1);

            num1 |= num2;
            System.out.println(num1);

        }
    }

// Miscellaneous operator

// conditional or ternary operator

    class Ternary {
        public static void main(String[] args) {
            int age = 21;
            String checkAge = (age > 18) ? "you are eligible for voting" : "you are not eligible for voting";
            System.out.println(checkAge);
        }
    }

// instance of operator

    class Building {
        void isBuilding() {
            System.out.println("yes, this is building");
        }
    }

    class Flat extends Building {
        public static void main(String[] args) {
            Building bl = new Flat();
            boolean flat = bl instanceof Building;
            boolean bul = bl instanceof Flat;
            System.out.println(flat);
            System.out.println(bul);

        }
    }

// Collection

    class Collection {
        public static void main(String[] args) {
            List<Integer> number = new ArrayList<>();

            number.add(7);
            number.add(8);
            System.out.println(number);
            System.out.println(number.lastIndexOf(number));
            System.out.println(number.size());
            System.out.println(number.iterator());

            System.out.println(number.get(1));
            System.out.println(number.remove(1));

            List<Integer> digit = new LinkedList<>();
            digit.add(8);
            digit.add(9);
            digit.add(10);
            digit.add(11);
            digit.add(7);

            System.out.println(digit);

        }
    }

// Decision making

    class DecisionMaking {
        public static void main(String[] args) {
            int age = 21;
            if (age > 18) {
                System.out.println("you are eligible for voting");
            } else {
                System.out.println("you are not eligible for voting");
            }

            // nested if

            age = 55;
            if (age > 0) {
                if (age < 100) {
                    if (age >= 50) {
                        System.out.println("you are sinior citizen");
                    }
                }
            }

            // switch case

            age = 51;
            switch (age) {
                case 19:
                    System.out.println("you are eligible for voting");
                    break;
                case 51:
                    System.out.println("you are sinior citizen");
                    break;
            }
        }
    }

// control flow

// while loop

    class ControlFlow {
        public static void main(String[] args) {
            int count = 0;
            while (count < 5) {
                System.out.println(count);
                count++;
            }

            do {
                System.out.println(count);
                count++;
            } while (count < 11);

            for (int i = 0; i < 5; i++) {
                System.out.println("*");
            }

        }
    }

// Exception Handling

    class Exception {
        public static void main(String[] args) {
            try {
                int num = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println(e);
            }
        }
    }


