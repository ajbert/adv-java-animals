package us.mattgreen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Creator {
    Scanner input = new Scanner(System.in);
    List list = new ArrayList<>();
    char choice = 'i';

    public Creator(List list) {
        this.list = list;
    }

    public void Create(){

        do {
            System.out.println("What would you like to create? Dog, Cat, Teacher or Exit?");
            choice = input.next().toLowerCase().charAt(0);
            boolean  isFriendly = true;
            String name;

            switch (choice) {
                case 'd' -> {
                    System.out.println("Creating Dog\n");
                    System.out.println("What is the dog's Name?");
                    name = input.next();
                    System.out.printf("Is %s friendly?\n", name);
                    char temp = input.next().toLowerCase().charAt(0);
                    if (temp != 'y')
                        isFriendly = false;
                    list.add(new Dog(isFriendly, name));
                }
                case 'c' -> {
                    int killed = -1;
                    System.out.println("Creating Cat\n");
                    do {
                        System.out.println("What is the cat's Name?");
                        name = input.next();
                        System.out.printf("How many mice has %s killed?\n", name);


                        try {
                            killed = input.nextInt();
                        } catch (InputMismatchException a) {
                            System.out.println("There was an problem with your input, try again!!");
                            input.nextLine();
                        }
                    } while (killed == -1);
                    list.add(new Cat(killed, name));
                }
                case 't' -> {
                    int age = -1;
                    System.out.println("Creating Teacher\n");
                    do {
                        System.out.println("What is the teacher's Name?");
                        name = input.next();
                        System.out.printf("How old is %s?\n", name);

                        try {
                            age = input.nextInt();
                        } catch (InputMismatchException a) {
                            System.out.println("There was an problem with your input, try again!");
                            input.nextLine();
                        }
                    } while (age == -1);
                    list.add(new Teacher(age, name));
                }
                default -> choice = 'e';
            }


        } while (choice != 'e');

    }

}
