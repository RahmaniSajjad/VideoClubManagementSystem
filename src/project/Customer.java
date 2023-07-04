package project;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends Person {
    private int age = 0;
    private String address = "";
    private static final Scanner INPUT = new Scanner(System.in);
    private static boolean isValidInput;
    private final ClubManager ADDER;

    public Customer(String name, String lastName, String nationalCode, String phoneNum, ClubManager ADDER) {
        super(name, lastName, nationalCode, phoneNum);
        this.ADDER = ADDER;
    }

    @Override
    public String toString() {
        if (VideoClubManager.isEnLang) {
            return
                    "|---> Name : " + getName() +
                            " | Last Name : " + getLastName() +
                            " | National Code : " + getNationalCode() +
                            " | Phone Number : " + getPhoneNum() +
                            " | Age : " + this.age +
                            " | Address : " + this.address +
                            " | Adder : " + ADDER.getName() + " <---|"
                    ;
        } else {
            return
                    "|---> نام : " + getName() +
                            " | نام خانوادگی : " + getLastName() +
                            " | کدملی : " + getNationalCode() +
                            " | شماره تلفن : " + getPhoneNum() +
                            " | سن : " + this.age +
                            " | آدرس : " + this.address +
                            " | اضافه کننده : " + ADDER.getName() + " <---|"
                    ;
        }
    }

    public String toString(boolean isPrivate) {
        if (VideoClubManager.isEnLang) {
            return
                    "|---> Name : " + getName() +
                            " | Last Name : " + getLastName() +
                            " | National Code : " + getNationalCode() +
                            " | Adder : " + ADDER.getName() + " <---|"
                    ;
        } else {
            return
                    "|---> نام : " + getName() +
                            " | نام خانوادگی : " + getLastName() +
                            " | کدملی : " + getNationalCode() +
                            " | اضافه کننده : " + ADDER.getName() + " <---|"
                    ;
        }
    }

    public ClubManager getADDER() {
        return ADDER;
    }

    public void showBorrowedVideos() {
        ArrayList<LendMovies> result = new ArrayList<>();
        if (VideoClubManager.isEnLang)
            System.out.println("\t\t\t|---> Show Borrowed Videos <---|\n");
        else
            System.out.println("\t\t\t|---> مشاهده فیلم های امانت گرفته شده <---|\n");

        for (LendMovies lendMovies : ClubManager.getLENT_MOVIES_LIST()) {
            if (lendMovies.getCustomer().equals(this))
                result.add(lendMovies);
        }

        if (result.isEmpty()) {
            if (VideoClubManager.isEnLang)
                System.out.println("Empty!\n");
            else
                System.out.println("\nخالی!");
        } else {
            for (LendMovies lendMovies : result) {
                System.out.println(lendMovies);
            }
            System.out.println();
        }
    }

    public void editProfile() {
        String textEn = String.format("""
                            |---> Edit Profile <---|
                 
                    Name : %s
                    Last Name : %s
                    National Code : %s
                    Phone Number : %s
                    Adder : %s
                    
                    Age : %d
                    Address : %s
                            
                            
                1.Edit Age
                2.Edit Address
                                
                0.Back
                """, getName(), getLastName(), getNationalCode(), getPhoneNum(), getADDER().getName(), this.age, this.address);
        String textFa = String.format("""
                            |---> ویرایش پروفایل <---|
                 
                    نام : %s
                    نام خانوادگی : %s
                    کدملی : %s
                    شماره تلفن : %s
                    اضافه کننده : %s
                    
                    سن : %d
                    آدرس : %s
                            
                            
                ویرایش سن.1
                ویرایش آدرس.2
                                
                بازگشت.0
                """, getName(), getLastName(), getNationalCode(), getPhoneNum(), getADDER().getName(), this.age, this.address);

        isValidInput = false;
        while (!isValidInput) {
            if (VideoClubManager.isEnLang)
                System.out.println(textEn);
            else
                System.out.println(textFa);
            switch (INPUT.nextLine()) {
                case "1" -> {
                    editAge();
                    isValidInput = true;
                }
                case "2" -> {
                    editAddress();
                    isValidInput = true;
                }
                case "0" -> {
                    isValidInput = true;
                    return;
                }
                default -> {
                    if (VideoClubManager.isEnLang)
                        System.out.println("Invalid Input!\n");
                    else
                        System.out.println("ورودی نامعتبر!\n");
                }
            }
        }
    }

    private void editAge() {
        int age = 0;
        isValidInput = false;
        if (VideoClubManager.isEnLang) {
            while (!isValidInput) {
                System.out.println("Enter Your Age (5-150) : ");
                try {
                    age = Integer.parseInt(INPUT.nextLine());
                    if (age >= 5 && age <= 150)
                        isValidInput = true;
                    else
                        System.out.println("Invalid Input!\n");
                } catch (Exception e) {
                    System.out.println("Invalid Input!\n");
                }
            }
        } else {
            while (!isValidInput) {
                System.out.println("سن خود را وارد کنید (5-150) : ");
                try {
                    age = Integer.parseInt(INPUT.nextLine());
                    if (age >= 5 && age <= 150)
                        isValidInput = true;
                    else
                        System.out.println("ورودی نامعتبر!\n");
                } catch (Exception e) {
                    System.out.println("ورودی نامعتبر!\n");
                }
            }
        }

        this.age = age;
        if (VideoClubManager.isEnLang)
            System.out.println("Age Edited!\n");
        else
            System.out.println("سن ویرایش شد!\n");
    }

    private void editAddress() {
        if (VideoClubManager.isEnLang) {
            System.out.println("Enter Your Address :\n");
            this.address = INPUT.nextLine();
            System.out.println("Address Edited!\n");
        } else {
            System.out.println("آدرس خود را وارد کنید :\n");
            this.address = INPUT.nextLine();
            System.out.println("آدرس ویرایش شد!\n");
        }
    }
}
