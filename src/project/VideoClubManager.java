package project;

import java.util.ArrayList;
import java.util.Scanner;

public class VideoClubManager {
    private static final Scanner INPUT = new Scanner(System.in);
    private static boolean isValidInput;
    static boolean isEnLang;
    private static final ArrayList<ClubManager> CLUB_MANAGERS_LIST = new ArrayList<>();

    static {
        ClubManager clubManager = new ClubManager("Sajjad", "Rahmani", "1273789891", "09134466381");
        CLUB_MANAGERS_LIST.add(clubManager);
        clubManager = new ClubManager("Khayyam", "Salehi", "1110000000", "09030319194");
        CLUB_MANAGERS_LIST.add(clubManager);
    }

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        String intro = """
                                    
                                    
                                    
                                    ***  <--- WELCOME ---> ***
                                 <--- CREATOR : SAJJAD RAHMANI --->
                                 
                                 
                                 
                """;
        System.out.println(intro);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }

        chooseLang();
    }

    private static void chooseLang() {
        String text = """
                Choose Your Language (زبان خود را انتخاب کنید) :
                1.English
                فارسی.2
                """;
        isValidInput = false;
        while (!isValidInput) {
            System.out.println(text);
            switch (INPUT.nextLine()) {
                case "1" -> {
                    isEnLang = true;
                    isValidInput = true;
                }
                case "2" -> {
                    isEnLang = false;
                    isValidInput = true;
                }
                default -> System.out.println("Invalid Input! (ورودی نامعتبر!)\n");
            }
        }
        home();
    }

    private static void home() {
        String textEn = """
                            |---> HOME <---|
                1.Club Management
                2.Club Customers
                3.Change Language
                """;
        String textFa = """
                            |---> خانه <---|
                مدیریت کلوپ.1
                مشتریان کلوپ.2
                تغییر زبان.3
                """;
        isValidInput = false;
        while (!isValidInput) {
            if (isEnLang)
                System.out.println(textEn);
            else
                System.out.println(textFa);
            switch (INPUT.nextLine()) {
                case "1" -> {
                    clubManagement();
                    isValidInput = true;
                }
                case "2" -> {
                    clubCustomers();
                    isValidInput = true;
                }
                case "3" -> {
                    chooseLang();
                    isValidInput = true;
                }
                default -> {
                    if (isEnLang)
                        System.out.println("Invalid Input!\n");
                    else
                        System.out.println("ورودی نامعتبر!\n");
                }
            }
        }
    }

    private static void clubManagement() {
        String textEn = """
                            |---> Club Management <---|
                1.Club Managers
                2.Add New Club Manager
                                
                0.Return HOME
                """;
        String textFa = """
                            |---> مدیریت کلوپ <---|
                مدیران کلوپ.1
                افزودن مدیر کلوپ جدید.2
                                
                بازگشت به خانه.0
                """;
        isValidInput = false;
        while (!isValidInput) {
            if (isEnLang)
                System.out.println(textEn);
            else
                System.out.println(textFa);
            switch (INPUT.nextLine()) {
                case "1" -> {
                    clubManagers();
                    isValidInput = true;
                }
                case "2" -> {
                    addClubManager();
                    isValidInput = true;
                }
                case "0" -> {
                    home();
                    isValidInput = true;
                }
                default -> {
                    if (isEnLang)
                        System.out.println("Invalid Input!\n");
                    else
                        System.out.println("ورودی نامعتبر!\n");
                }
            }
        }

    }

    private static void addClubManager() {
        String name;
        if (isEnLang) {
            System.out.println("\t\t\t|---> Add New Club Manager <---|\n");
            System.out.println("Enter Name Of Manager : ");
            name = INPUT.nextLine();
            while (name.isBlank() || name.length() < 2) {
                System.out.println("Invalid!\nEnter Name Of Manager : ");
                name = INPUT.nextLine();
            }
        } else {
            System.out.println("\t\t\t|---> افزودن مدیر کلوپ جدید <---|\n");
            System.out.println("نام مدیر را وارد کنید : ");
            name = INPUT.nextLine();
            while (name.isBlank() || name.length() < 2) {
                System.out.println("نامعتبر!\nنام مدیر را وارد کنید : ");
                name = INPUT.nextLine();
            }
        }

        String lastName;
        if (isEnLang) {
            System.out.println("Enter Last Name Of Manager : ");
            lastName = INPUT.nextLine();
            while (lastName.isBlank() || lastName.length() < 2) {
                System.out.println("Invalid!\nEnter Last Name Of Manager : ");
                lastName = INPUT.nextLine();
            }
        } else {
            System.out.println("نام خانوادگی مدیر را وارد کنید : ");
            lastName = INPUT.nextLine();
            while (lastName.isBlank() || lastName.length() < 2) {
                System.out.println("نامعتبر!\nنام خانوادگی مدیر را وارد کنید : ");
                lastName = INPUT.nextLine();
            }
        }

        String nationalCode;
        if (isEnLang) {
            System.out.println("Enter National Code Of Manager (Ten digits) : ");
            nationalCode = INPUT.nextLine();
            while (!nationalCode.matches("\\d{10}")) {
                System.out.println("Invalid!\nEnter National Code Of Manager (Ten digits) : ");
                nationalCode = INPUT.nextLine();
            }
        } else {
            System.out.println("کد ملی مدیر را وارد کنید (ده رقمی) : ");
            nationalCode = INPUT.nextLine();
            while (!nationalCode.matches("\\d{10}")) {
                System.out.println("نامعتبر!\nکد ملی مدیر را وارد کنید (ده رقمی) : ");
                nationalCode = INPUT.nextLine();
            }
        }

        String phoneNum;
        if (isEnLang) {
            System.out.println("Enter Phone Number Of Manager (Start with 09) : ");
            phoneNum = INPUT.nextLine();
            while (!phoneNum.matches("\\d{11}") || !phoneNum.startsWith("09")) {
                System.out.println("Invalid!\nEnter Phone Number Of Manager (Start with 09) : ");
                phoneNum = INPUT.nextLine();
            }
        } else {
            System.out.println("شماره تلفن مدیر را وارد کنید (شروع با 09) : ");
            phoneNum = INPUT.nextLine();
            while (!phoneNum.matches("\\d{11}") || !phoneNum.startsWith("09")) {
                System.out.println("نامعتبر!\nشماره تلفن مدیر را وارد کنید (شروع با 09) : ");
                phoneNum = INPUT.nextLine();
            }
        }

        ClubManager newClubManager = new ClubManager(name, lastName, nationalCode, phoneNum);

        boolean isAlreadyExist = false;
        for (ClubManager clubManager : CLUB_MANAGERS_LIST) {
            if (clubManager.equals(newClubManager)) {
                isAlreadyExist = true;
                break;
            }
        }

        if (isAlreadyExist) {
            if (isEnLang)
                System.out.println("Manager Already Exist!\n");
            else
                System.out.println("مدیر از قبل وجود دارد!\n");
        } else {
            CLUB_MANAGERS_LIST.add(newClubManager);
            if (isEnLang)
                System.out.println("Manager Added!\n");
            else
                System.out.println("مدیر اضافه شد!\n");
        }

        clubManagement();
    }

    private static void clubManagers() {
        StringBuilder managers = new StringBuilder();
        int i = 1;
        for (ClubManager clubManager : CLUB_MANAGERS_LIST)
            managers.append(i++).append(")").append(clubManager.toString()).append("\n");
        String textEn = "\t\t\t|---> Club Managers List <---|\n\n\tSelect Your Account :\n" + managers + "\n0.Return HOME";
        String textFa = "\t\t\t|---> لیست مدیران کلوپ <---|\n\n\tاکانت خود را انتخاب کنید :\n" + managers + "\nبازگشت به خانه.0";

        isValidInput = false;
        while (!isValidInput) {
            if (isEnLang)
                System.out.println(textEn);
            else
                System.out.println(textFa);

            String selectedNum = INPUT.nextLine();
            if (selectedNum.equals("0")) {
                isValidInput = true;
                home();
            } else {
                ClubManager selectedClubManager;
                try {
                    selectedClubManager = CLUB_MANAGERS_LIST.get(Integer.parseInt(selectedNum) - 1);
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                } catch (Exception e) {
                    if (isEnLang)
                        System.out.println("Invalid Input!\n");
                    else
                        System.out.println("ورودی نامعتبر!\n");
                }
            }
        }
    }

    private static void clubCustomer(ClubManager selectedClubManager) {
        String textEn = String.format("""
                            |---> Manager Panel (%s) <---|
                *** CURRENT MANAGER ***
                1.Show Actors List
                2.Add New Actor
                3.Show Directors List
                4.Add New Director
                5.Show Producers List
                6.Add New Producer
                                
                *** ALL MANAGERS ***
                7.Lending Movie
                8.Getting Back Movie
                9.Show Movies List
                10.Add New Movie
                11.Show Customers List
                12.Add New Customer
                13.Show Lent Movies List
                14.Search Videos
                15.Search Customers
                                
                                   
                0.Return HOME
                """, selectedClubManager.getName() + " " + selectedClubManager.getLastName());
        String textFa = String.format("""
                            |---> پنل مدیر (%s) <---|
                *** مدیر فعلی ***
                نمایش لیست بازیگران.1
                افزودن بازیگر جدید.2
                نمایش لیست کارگردان ها.3
                افزودن کارگردان جدید.4
                نمایش لیست تهیه کنندگان.5
                افزودن تهیه کننده جدید.6
                                
                *** همه مدیران ***
                امانت دادن فیلم.7
                تحویل گرفتن فیلم.8
                نمایش لیست فیلم ها.9
                افزودن فیلم جدید.10
                نمایش لیست مشتریان.11
                افزودن مشتری جدید.12
                نمایش لیست فیلم های امانت داده شده.13
                جستجوی فیلم ها.14
                جستجوی مشتریان.15
                                
                                
                بازگشت به خانه.0
                """, selectedClubManager.getName() + " " + selectedClubManager.getLastName());

        isValidInput = false;
        while (!isValidInput) {
            if (isEnLang)
                System.out.println(textEn);
            else
                System.out.println(textFa);
            switch (INPUT.nextLine()) {
                case "1" -> {
                    selectedClubManager.showActors();
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                }
                case "2" -> {
                    selectedClubManager.addActor();
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                }
                case "3" -> {
                    selectedClubManager.showDirectors();
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                }
                case "4" -> {
                    selectedClubManager.addDirector();
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                }
                case "5" -> {
                    selectedClubManager.showProducers();
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                }
                case "6" -> {
                    selectedClubManager.addProducer();
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                }
                case "7" -> {
                    selectedClubManager.lendingMovie();
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                }
                case "8" -> {
                    selectedClubManager.gettingBackMovie();
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                }
                case "9" -> {
                    ClubManager.showMovies();
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                }
                case "10" -> {
                    selectedClubManager.addMovie();
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                }
                case "11" -> {
                    ClubManager.showCustomers();
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                }
                case "12" -> {
                    selectedClubManager.addCustomer();
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                }
                case "13" -> {
                    ClubManager.showLentMovies();
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                }
                case "14" -> {
                    ClubManager.searchMovies();
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                }
                case "15" -> {
                    ClubManager.searchCustomers();
                    isValidInput = true;
                    clubCustomer(selectedClubManager);
                }
                case "0" -> {
                    isValidInput = true;
                    home();
                }
                default -> {
                    if (isEnLang)
                        System.out.println("Invalid Input!\n");
                    else
                        System.out.println("ورودی نامعتبر!\n");
                }
            }
        }
    }

    private static void clubCustomers() {
        StringBuilder customers = new StringBuilder();
        int i = 1;
        for (Customer customer : ClubManager.getCUSTOMERS_LIST())
            customers.append(i++).append(")").append(customer.toString(true)).append("\n");
        String textEn = "\t\t\t|---> Club Customers List <---|\n\n\tSelect Your Account (If Doesn't Exist, Ask a Manager to Add You) :\n" + customers + "\n0.Return HOME";
        String textFa = "\t\t\t|---> لیست مشتریان کلوپ <---|\n\n\tاکانت خود را انتخاب کنید (اگر وجود ندارد، از یک مدیر بخواهید که شما را اضافه کند) :\n" + customers + "\nبازگشت به خانه.0";

        isValidInput = false;
        while (!isValidInput) {
            if (isEnLang)
                System.out.println(textEn);
            else
                System.out.println(textFa);

            String selectedNum = INPUT.nextLine();
            if (selectedNum.equals("0")) {
                isValidInput = true;
                home();
            } else {
                Customer selectedClubCustomer;
                try {
                    selectedClubCustomer = ClubManager.getCUSTOMERS_LIST().get(Integer.parseInt(selectedNum) - 1);
                    isValidInput = true;
                    clubCustomer(selectedClubCustomer);
                } catch (Exception e) {
                    if (isEnLang)
                        System.out.println("Invalid Input!\n");
                    else
                        System.out.println("ورودی نامعتبر!\n");
                }
            }
        }
    }

    private static void clubCustomer(Customer selectedClubCustomer) {
        String textEn = String.format("""
                            |---> Customer Panel (%s) <---|
                            
                1.Edit Profile
                2.Search Videos
                3.Show Borrowed Videos
                                   
                0.Return HOME
                """, selectedClubCustomer.getName() + " " + selectedClubCustomer.getLastName());
        String textFa = String.format("""
                            |---> پنل مشتری (%s) <---|
                            
                ویرایش پروفایل.1
                جستجوی فیلم ها.2
                مشاهده فیلم های امانت گرفته شده.3
                             
                بازگشت به خانه.0
                """, selectedClubCustomer.getName() + " " + selectedClubCustomer.getLastName());

        isValidInput = false;
        while (!isValidInput) {
            if (isEnLang)
                System.out.println(textEn);
            else
                System.out.println(textFa);
            switch (INPUT.nextLine()) {
                case "1" -> {
                    selectedClubCustomer.editProfile();
                    isValidInput = true;
                    clubCustomer(selectedClubCustomer);
                }
                case "2" -> {
                    ClubManager.searchMovies();
                    isValidInput = true;
                    clubCustomer(selectedClubCustomer);
                }
                case "3" -> {
                    selectedClubCustomer.showBorrowedVideos();
                    isValidInput = true;
                    clubCustomer(selectedClubCustomer);
                }
                case "0" -> {
                    isValidInput = true;
                    home();
                }
                default -> {
                    if (isEnLang)
                        System.out.println("Invalid Input!\n");
                    else
                        System.out.println("ورودی نامعتبر!\n");
                }
            }
        }
    }
}
