package project;

import java.util.ArrayList;
import java.util.Scanner;

public class ClubManager extends Person {
    private static final Scanner INPUT = new Scanner(System.in);
    private static boolean isValidInput;

    private final ArrayList<Actor> ACTORS_LIST = new ArrayList<>();
    private final ArrayList<Producer> PRODUCERS_LIST = new ArrayList<>();
    private final ArrayList<Director> DIRECTORS_LIST = new ArrayList<>();

    private static final ArrayList<Customer> CUSTOMERS_LIST = new ArrayList<>();
    private static final ArrayList<Movie> MOVIES_LIST = new ArrayList<>();
    private static final ArrayList<LendMovies> LENT_MOVIES_LIST = new ArrayList<>();

    {
        Actor actor = new Actor("Mehran Ghafoorian", "Tehran", 1974);
        ACTORS_LIST.add(actor);
        actor = new Actor("Ali Sadeghi", "Tehran", 1980);
        ACTORS_LIST.add(actor);
        actor = new Actor("Mehdi Fakhimzadeh", "Tehran", 1942);
        ACTORS_LIST.add(actor);
        actor = new Actor("Ghodrat Allah Izadi", "Isfahan", 1956);
        ACTORS_LIST.add(actor);
        actor = new Actor("Merila Zarei", "Tehran", 1974);
        ACTORS_LIST.add(actor);

        Producer producer = new Producer("Arman Zarinkoob", "Tehran", 1960);
        PRODUCERS_LIST.add(producer);
        producer = new Producer("Mania Akbari", "Tehran", 1974);
        PRODUCERS_LIST.add(producer);
        producer = new Producer("Mohsen Chegini", "Arawak", 1967);
        PRODUCERS_LIST.add(producer);

        Director director = new Director("Mehran Modiri", "Tehran", 1967);
        DIRECTORS_LIST.add(director);
        director = new Director("Reza Attaran", "Mashhad", 1968);
        DIRECTORS_LIST.add(director);
        director = new Director("Soroush Sehat", "Isfahan", 1965);
        DIRECTORS_LIST.add(director);
    }


    public ClubManager(String name, String lastName, String nationalCode, String phoneNum) {
        super(name, lastName, nationalCode, phoneNum);
    }

    public static ArrayList<Customer> getCUSTOMERS_LIST() {
        return CUSTOMERS_LIST;
    }

    public static ArrayList<LendMovies> getLENT_MOVIES_LIST() {
        return LENT_MOVIES_LIST;
    }


    public void addActor() {
        String fullName;
        if (VideoClubManager.isEnLang) {
            System.out.println("\t\t\t|---> Add New Actor <---|\n");
            System.out.println("Enter Full Name Of Actor : ");
            fullName = INPUT.nextLine();
            while (fullName.isBlank() || fullName.length() < 3) {
                System.out.println("Invalid!\nEnter Full Name Of Actor : ");
                fullName = INPUT.nextLine();
            }
        } else {
            System.out.println("\t\t\t|---> افزودن بازیگر جدید <---|\n");
            System.out.println("نام کامل بازیگر را وارد کنید : ");
            fullName = INPUT.nextLine();
            while (fullName.isBlank() || fullName.length() < 3) {
                System.out.println("نامعتبر!\nنام کامل بازیگر را وارد کنید : ");
                fullName = INPUT.nextLine();
            }
        }

        String birthplace;
        if (VideoClubManager.isEnLang) {
            System.out.println("Enter Birthplace Of Actor : ");
            birthplace = INPUT.nextLine();
            while (birthplace.isBlank() || birthplace.length() < 3) {
                System.out.println("Invalid!\nEnter Birthplace Of Actor : ");
                birthplace = INPUT.nextLine();
            }
        } else {
            System.out.println("زادگاه بازیگر را وارد کنید : ");
            birthplace = INPUT.nextLine();
            while (birthplace.isBlank() || birthplace.length() < 3) {
                System.out.println("نامعتبر!\nزادگاه بازیگر را وارد کنید : ");
                birthplace = INPUT.nextLine();
            }
        }


        int birthYear = -1;
        isValidInput = false;
        if (VideoClubManager.isEnLang) {
            while (!isValidInput) {
                System.out.println("Enter Birth Year Of Actor : ");
                try {
                    birthYear = Integer.parseInt(INPUT.nextLine());
                    if (birthYear >= 1900 && birthYear <= 2022)
                        isValidInput = true;
                    else
                        System.out.println("Invalid Input!\n");
                } catch (Exception e) {
                    System.out.println("Invalid Input!\n");
                }
            }
        } else {
            while (!isValidInput) {
                System.out.println("سال تولد بازیگر را وارد کنید : ");
                try {
                    birthYear = Integer.parseInt(INPUT.nextLine());
                    if (birthYear >= 1900 && birthYear <= 2022)
                        isValidInput = true;
                    else
                        System.out.println("ورودی نامعتبر!\n");
                } catch (Exception e) {
                    System.out.println("ورودی نامعتبر!\n");
                }
            }
        }

        Actor newActor = new Actor(fullName, birthplace, birthYear);

        boolean isAlreadyExist = false;
        for (Actor actor  : ACTORS_LIST) {
            if (actor.equals(newActor)) {
                isAlreadyExist = true;
                break;
            }
        }

        if (isAlreadyExist) {
            if (VideoClubManager.isEnLang)
                System.out.println("Actor Already Exist!\n");
            else
                System.out.println("بازیگر از قبل وجود دارد!\n");
        } else {
            ACTORS_LIST.add(newActor);
            if (VideoClubManager.isEnLang)
                System.out.println("Actor Added!\n");
            else
                System.out.println("بازیگر اضافه شد!\n");
        }
    }

    public void addDirector() {
        String fullName;
        if (VideoClubManager.isEnLang) {
            System.out.println("\t\t\t|---> Add New Director <---|\n");
            System.out.println("Enter Full Name Of Director : ");
            fullName = INPUT.nextLine();
            while (fullName.isBlank() || fullName.length() < 3) {
                System.out.println("Invalid!\nEnter Full Name Of Director : ");
                fullName = INPUT.nextLine();
            }
        } else {
            System.out.println("\t\t\t|---> افزودن کارگردان جدید <---|\n");
            System.out.println("نام کامل کارگردان را وارد کنید : ");
            fullName = INPUT.nextLine();
            while (fullName.isBlank() || fullName.length() < 3) {
                System.out.println("نامعتبر!\nنام کامل کارگردان را وارد کنید : ");
                fullName = INPUT.nextLine();
            }
        }

        String birthplace;
        if (VideoClubManager.isEnLang) {
            System.out.println("Enter Birthplace Of Director : ");
            birthplace = INPUT.nextLine();
            while (birthplace.isBlank() || birthplace.length() < 3) {
                System.out.println("Invalid!\nEnter Birthplace Of Director : ");
                birthplace = INPUT.nextLine();
            }
        } else {
            System.out.println("زادگاه کارگردان را وارد کنید : ");
            birthplace = INPUT.nextLine();
            while (birthplace.isBlank() || birthplace.length() < 3) {
                System.out.println("نامعتبر!\nزادگاه کارگردان را وارد کنید : ");
                birthplace = INPUT.nextLine();
            }
        }


        int birthYear = -1;
        isValidInput = false;
        if (VideoClubManager.isEnLang) {
            while (!isValidInput) {
                System.out.println("Enter Birth Year Of Director : ");
                try {
                    birthYear = Integer.parseInt(INPUT.nextLine());
                    if (birthYear >= 1900 && birthYear <= 2022)
                        isValidInput = true;
                    else
                        System.out.println("Invalid Input!\n");
                } catch (Exception e) {
                    System.out.println("Invalid Input!\n");
                }
            }
        } else {
            while (!isValidInput) {
                System.out.println("سال تولد کارگردان را وارد کنید : ");
                try {
                    birthYear = Integer.parseInt(INPUT.nextLine());
                    if (birthYear >= 1900 && birthYear <= 2022)
                        isValidInput = true;
                    else
                        System.out.println("ورودی نامعتبر!\n");
                } catch (Exception e) {
                    System.out.println("ورودی نامعتبر!\n");
                }
            }
        }


        Director newDirector = new Director(fullName, birthplace, birthYear);

        boolean isAlreadyExist = false;
        for (Director director  : DIRECTORS_LIST) {
            if (director.equals(newDirector)) {
                isAlreadyExist = true;
                break;
            }
        }

        if (isAlreadyExist) {
            if (VideoClubManager.isEnLang)
                System.out.println("Director Already Exist!\n");
            else
                System.out.println("کارگردان از قبل وجود دارد!\n");
        } else {
            DIRECTORS_LIST.add(newDirector);
            if (VideoClubManager.isEnLang)
                System.out.println("Director Added!\n");
            else
                System.out.println("کارگردان اضافه شد!\n");
        }
    }

    public void addProducer() {
        String fullName;
        if (VideoClubManager.isEnLang) {
            System.out.println("\t\t\t|---> Add New Producer <---|\n");
            System.out.println("Enter Full Name Of Producer : ");
            fullName = INPUT.nextLine();
            while (fullName.isBlank() || fullName.length() < 3) {
                System.out.println("Invalid!\nEnter Full Name Of Producer : ");
                fullName = INPUT.nextLine();
            }
        } else {
            System.out.println("\t\t\t|---> افزودن تهیه کننده جدید <---|\n");
            System.out.println("نام کامل تهیه کننده را وارد کنید : ");
            fullName = INPUT.nextLine();
            while (fullName.isBlank() || fullName.length() < 3) {
                System.out.println("نامعتبر!\nنام کامل تهیه کننده را وارد کنید : ");
                fullName = INPUT.nextLine();
            }
        }

        String birthplace;
        if (VideoClubManager.isEnLang) {
            System.out.println("Enter Birthplace Of Producer : ");
            birthplace = INPUT.nextLine();
            while (birthplace.isBlank() || birthplace.length() < 3) {
                System.out.println("Invalid!\nEnter Birthplace Of Producer : ");
                birthplace = INPUT.nextLine();
            }
        } else {
            System.out.println("زادگاه تهیه کننده را وارد کنید : ");
            birthplace = INPUT.nextLine();
            while (birthplace.isBlank() || birthplace.length() < 3) {
                System.out.println("نامعتبر!\nزادگاه تهیه کننده را وارد کنید : ");
                birthplace = INPUT.nextLine();
            }
        }


        int birthYear = -1;
        isValidInput = false;
        if (VideoClubManager.isEnLang) {
            while (!isValidInput) {
                System.out.println("Enter Birth Year Of Producer : ");
                try {
                    birthYear = Integer.parseInt(INPUT.nextLine());
                    if (birthYear >= 1900 && birthYear <= 2022)
                        isValidInput = true;
                    else
                        System.out.println("Invalid Input!\n");
                } catch (Exception e) {
                    System.out.println("Invalid Input!\n");
                }
            }
        } else {
            while (!isValidInput) {
                System.out.println("سال تولد تهیه کننده را وارد کنید : ");
                try {
                    birthYear = Integer.parseInt(INPUT.nextLine());
                    if (birthYear >= 1900 && birthYear <= 2022)
                        isValidInput = true;
                    else
                        System.out.println("ورودی نامعتبر!\n");
                } catch (Exception e) {
                    System.out.println("ورودی نامعتبر!\n");
                }
            }
        }


        Producer newProducer = new Producer(fullName, birthplace, birthYear);

        boolean isAlreadyExist = false;
        for (Producer producer  : PRODUCERS_LIST) {
            if (producer.equals(newProducer)) {
                isAlreadyExist = true;
                break;
            }
        }

        if (isAlreadyExist) {
            if (VideoClubManager.isEnLang)
                System.out.println("Producer Already Exist!\n");
            else
                System.out.println("تهیه کننده از قبل وجود دارد!\n");
        } else {
            PRODUCERS_LIST.add(newProducer);
            if (VideoClubManager.isEnLang)
                System.out.println("Producer Added!\n");
            else
                System.out.println("تهیه کننده اضافه شد!\n");
        }
    }

    public void showActors() {
        if (VideoClubManager.isEnLang)
            System.out.println("\t\t\t|---> Actors List <---|\n");
        else
            System.out.println("\t\t\t|---> لیست بازیگران <---|\n");
        int i = 1;
        for (Actor actor : ACTORS_LIST)
            System.out.println("" + i++ + ")" + actor.toString());
        System.out.println();
    }

    public void showProducers() {
        if (VideoClubManager.isEnLang)
            System.out.println("\t\t\t|---> Producer List <---|\n");
        else
            System.out.println("\t\t\t|---> لیست تهیه کنندگان <---|\n");
        int i = 1;
        for (Producer producer : PRODUCERS_LIST)
            System.out.println("" + i++ + ")" + producer.toString());
        System.out.println();
    }

    public void showDirectors() {
        if (VideoClubManager.isEnLang)
            System.out.println("\t\t\t|---> Director List <---|\n");
        else
            System.out.println("\t\t\t|---> لیست کارگردان ها <---|\n");
        int i = 1;
        for (Director director : DIRECTORS_LIST)
            System.out.println("" + i++ + ")" + director.toString());
        System.out.println();
    }

    public void lendingMovie() {
        if (VideoClubManager.isEnLang) {
            System.out.println("\t\t\t|---> Lending Movie <---|\n");
            System.out.println("Select Movie :");
        } else {
            System.out.println("\t\t\t|---> امانت دادن فیلم <---|\n");
            System.out.println("فیلم را انتخاب کنید :");
        }

        final ArrayList<Movie> AVAILABLE_MOVIES_LIST = new ArrayList<>(MOVIES_LIST);
        for (LendMovies lendMovies : LENT_MOVIES_LIST){
            AVAILABLE_MOVIES_LIST.remove(lendMovies.getMovie());
        }

        if (VideoClubManager.isEnLang)
            System.out.println("\t\t\t|---> Available Movies List <---|\n");
        else
            System.out.println("\t\t\t|---> لیست فیلم های دردسترس <---|\n");
        int i = 1;
        for (Movie movie : AVAILABLE_MOVIES_LIST)
            System.out.println("" + i++ + ")" + movie.toString());
        System.out.println();

        Movie selectedMovie = null;
        isValidInput = false;
        while (!isValidInput) {
            if (VideoClubManager.isEnLang)
                System.out.println("\n0.Back");
            else
                System.out.println("\nبازگشت.0");

            String selectedNum = INPUT.nextLine();
            if (selectedNum.equals("0")) {
                isValidInput = true;
                return;  // back
            } else {
                try {
                    selectedMovie = AVAILABLE_MOVIES_LIST.get(Integer.parseInt(selectedNum) - 1);
                    isValidInput = true;
                } catch (Exception e) {
                    if (VideoClubManager.isEnLang)
                        System.out.println("Invalid Input!\n");
                    else
                        System.out.println("ورودی نامعتبر!\n");
                }
            }
        }

        if (VideoClubManager.isEnLang) {
            System.out.println("Select Customer :");
        } else {
            System.out.println("مشتری را انتخاب کنید :");
        }
        Customer selectedCustomer = null;
        ClubManager.showCustomers();
        isValidInput = false;
        while (!isValidInput) {
            if (VideoClubManager.isEnLang)
                System.out.println("\n0.Back");
            else
                System.out.println("\nبازگشت.0");

            String selectedNum = INPUT.nextLine();
            if (selectedNum.equals("0")) {
                isValidInput = true;
                return;  // back
            } else {
                try {
                    selectedCustomer = CUSTOMERS_LIST.get(Integer.parseInt(selectedNum) - 1);
                    isValidInput = true;
                } catch (Exception e) {
                    if (VideoClubManager.isEnLang)
                        System.out.println("Invalid Input!\n");
                    else
                        System.out.println("ورودی نامعتبر!\n");
                }
            }
        }

        LendMovies lendMovies = new LendMovies(selectedMovie, this, selectedCustomer);
        LENT_MOVIES_LIST.add(lendMovies);
        if (VideoClubManager.isEnLang)
            System.out.println("Added To Lent Movies List!\n");
        else
            System.out.println("به لیست فیلم های امانت داده شده اضافه شد!\n");
    }

    public static void showLentMovies() {
        if (VideoClubManager.isEnLang)
            System.out.println("\t\t\t|---> Lent Movies List <---|\n");
        else
            System.out.println("\t\t\t|---> لیست فیلم های امانت داده شده <---|\n");
        int i = 1;
        for (LendMovies lendMovies : LENT_MOVIES_LIST)
            System.out.println("" + i++ + ")" + lendMovies.toString());
        System.out.println();
    }

    public void gettingBackMovie() {
        if (VideoClubManager.isEnLang) {
            System.out.println("\t\t\t|---> Getting Back Movie <---|\n");
            System.out.println("Select :");
        } else {
            System.out.println("\t\t\t|---> تحویل گرفتن فیلم <---|\n");
            System.out.println("انتخاب کنید :");
        }
        LendMovies selectedLendMovies = null;
        ClubManager.showLentMovies();
        isValidInput = false;
        while (!isValidInput) {
            if (VideoClubManager.isEnLang)
                System.out.println("\n0.Back");
            else
                System.out.println("\nبازگشت.0");

            String selectedNum = INPUT.nextLine();
            if (selectedNum.equals("0")) {
                isValidInput = true;
                return;  // back
            } else {
                try {
                    selectedLendMovies = LENT_MOVIES_LIST.get(Integer.parseInt(selectedNum) - 1);
                    isValidInput = true;
                } catch (Exception e) {
                    if (VideoClubManager.isEnLang)
                        System.out.println("Invalid Input!\n");
                    else
                        System.out.println("ورودی نامعتبر!\n");
                }
            }
        }

        LENT_MOVIES_LIST.remove(selectedLendMovies);
        if (VideoClubManager.isEnLang)
            System.out.println("Removed From Lent Movies List!\n");
        else
            System.out.println("از لیست فیلم های امانت داده شده حذف شد!\n");
    }

    public void addMovie() {
        String name;
        if (VideoClubManager.isEnLang) {
            System.out.println("\t\t\t|---> Add New Movie <---|\n");
            System.out.println("Enter Name Of Movie : ");
            name = INPUT.nextLine();
            while (name.isBlank()) {
                System.out.println("Invalid!\nEnter Name Of Movie : ");
                name = INPUT.nextLine();
            }
        } else {
            System.out.println("\t\t\t|---> افزودن فیلم جدید <---|\n");
            System.out.println("نام فیلم را وارد کنید : ");
            name = INPUT.nextLine();
            while (name.isBlank()) {
                System.out.println("نامعتبر!\nنام فیلم را وارد کنید : ");
                name = INPUT.nextLine();
            }
        }

        double imdbScore = -1;
        isValidInput = false;
        if (VideoClubManager.isEnLang) {
            while (!isValidInput) {
                System.out.println("Enter IMDB Score : ");
                try {
                    imdbScore = Double.parseDouble(INPUT.nextLine());
                    if (imdbScore >= 0 && imdbScore <= 10)
                        isValidInput = true;
                    else
                        System.out.println("Invalid Input!\n");
                } catch (Exception e) {
                    System.out.println("Invalid Input!\n");
                }
            }
        } else {
            while (!isValidInput) {
                System.out.println("نمره IMDB را وارد کنید : ");
                try {
                    imdbScore = Double.parseDouble(INPUT.nextLine());
                    if (imdbScore >= 0 && imdbScore <= 10)
                        isValidInput = true;
                    else
                        System.out.println("ورودی نامعتبر!\n");
                } catch (Exception e) {
                    System.out.println("ورودی نامعتبر!\n");
                }
            }
        }

        int productionYear = -1;
        isValidInput = false;
        if (VideoClubManager.isEnLang) {
            while (!isValidInput) {
                System.out.println("Enter Production Year : ");
                try {
                    productionYear = Integer.parseInt(INPUT.nextLine());
                    if (productionYear >= 1500 && productionYear <= 2022)
                        isValidInput = true;
                    else
                        System.out.println("Invalid Input!\n");
                } catch (Exception e) {
                    System.out.println("Invalid Input!\n");
                }
            }
        } else {
            while (!isValidInput) {
                System.out.println("سال تولید را وارد کنید : ");
                try {
                    productionYear = Integer.parseInt(INPUT.nextLine());
                    if (productionYear >= 1500 && productionYear <= 2022)
                        isValidInput = true;
                    else
                        System.out.println("ورودی نامعتبر!\n");
                } catch (Exception e) {
                    System.out.println("ورودی نامعتبر!\n");
                }
            }
        }


        if (VideoClubManager.isEnLang) {
            System.out.println("Select 3 Actors :");
        } else {
            System.out.println("سه بازیگر انتخاب کنید :");
        }
        final Actor[] ACTORS = new Actor[3];
        for (int index = 0; index <= 2; index++) {
            if (VideoClubManager.isEnLang) {
                System.out.printf("Actor %d :\n", index + 1);
            } else {
                System.out.printf("بازیگر %d :\n", index + 1);
            }
            this.showActors();

            isValidInput = false;
            while (!isValidInput) {
                if (VideoClubManager.isEnLang)
                    System.out.println("\n0.Back");
                else
                    System.out.println("\nبازگشت.0");

                String selectedNum = INPUT.nextLine();
                if (selectedNum.equals("0")) {
                    isValidInput = true;
                    return;  // back
                } else {
                    Actor selectedActor;
                    try {
                        selectedActor = ACTORS_LIST.get(Integer.parseInt(selectedNum) - 1);

                        boolean isAlreadyExistActor = false;
                        for (int i = 0; i < index; i++) {
                            if (ACTORS[i].equals(selectedActor)) {
                                isAlreadyExistActor = true;
                                break;
                            }
                        }

                        if (isAlreadyExistActor) {
                            if (VideoClubManager.isEnLang)
                                System.out.println("Selected Actor Already Exist!\n");
                            else
                                System.out.println("بازیگر انتخاب شده از قبل وجود دارد!\n");
                        } else {
                            isValidInput = true;
                            ACTORS[index] = selectedActor;
                        }
                    } catch (Exception e) {
                        if (VideoClubManager.isEnLang)
                            System.out.println("Invalid Input!\n");
                        else
                            System.out.println("ورودی نامعتبر!\n");
                    }
                }
            }
        }


        if (VideoClubManager.isEnLang) {
            System.out.println("Select Producer :");
        } else {
            System.out.println("تهیه کننده را انتخاب کنید :");
        }
        Producer selectedProducer = null;
        this.showProducers();

        isValidInput = false;
        while (!isValidInput) {
            if (VideoClubManager.isEnLang)
                System.out.println("\n0.Back");
            else
                System.out.println("\nبازگشت.0");

            String selectedNum = INPUT.nextLine();
            if (selectedNum.equals("0")) {
                isValidInput = true;
                return;  // back
            } else {
                try {
                    selectedProducer = PRODUCERS_LIST.get(Integer.parseInt(selectedNum) - 1);
                    isValidInput = true;
                } catch (Exception e) {
                    if (VideoClubManager.isEnLang)
                        System.out.println("Invalid Input!\n");
                    else
                        System.out.println("ورودی نامعتبر!\n");
                }
            }
        }


        if (VideoClubManager.isEnLang) {
            System.out.println("Select Director :");
        } else {
            System.out.println("کارگردان را انتخاب کنید :");
        }
        Director selectedDirector = null;
        this.showDirectors();

        isValidInput = false;
        while (!isValidInput) {
            if (VideoClubManager.isEnLang)
                System.out.println("\n0.Back");
            else
                System.out.println("\nبازگشت.0");

            String selectedNum = INPUT.nextLine();
            if (selectedNum.equals("0")) {
                isValidInput = true;
                return;  // back
            } else {
                try {
                    selectedDirector = DIRECTORS_LIST.get(Integer.parseInt(selectedNum) - 1);
                    isValidInput = true;
                } catch (Exception e) {
                    if (VideoClubManager.isEnLang)
                        System.out.println("Invalid Input!\n");
                    else
                        System.out.println("ورودی نامعتبر!\n");
                }
            }
        }

        Movie newMovie = new Movie(name, imdbScore, productionYear, ACTORS, selectedProducer, selectedDirector, this);

        boolean isAlreadyExist = false;
        for (Movie movie : MOVIES_LIST) {
            if (movie.equals(newMovie)) {
                isAlreadyExist = true;
                break;
            }
        }

        if (isAlreadyExist) {
            if (VideoClubManager.isEnLang)
                System.out.println("Movie Already Exist!\n");
            else
                System.out.println("فیلم از قبل وجود دارد!\n");
        } else {
            MOVIES_LIST.add(newMovie);
            if (VideoClubManager.isEnLang)
                System.out.println("Movie Added!\n");
            else
                System.out.println("فیلم اضافه شد!\n");
        }
    }

    public static void showMovies() {
        if (VideoClubManager.isEnLang)
            System.out.println("\t\t\t|---> Movies List <---|\n");
        else
            System.out.println("\t\t\t|---> لیست فیلم ها <---|\n");
        int i = 1;
        for (Movie movie : MOVIES_LIST)
            System.out.println("" + i++ + ")" + movie.toString());
        System.out.println();
    }

    public void addCustomer() {
        String name;
        if (VideoClubManager.isEnLang) {
            System.out.println("\t\t\t|---> Add New Customer <---|\n");
            System.out.println("Enter Name Of Customer : ");
            name = INPUT.nextLine();
            while (name.isBlank() || name.length() < 2) {
                System.out.println("Invalid!\nEnter Name Of Customer : ");
                name = INPUT.nextLine();
            }
        } else {
            System.out.println("\t\t\t|---> افزودن مشتری جدید <---|\n");
            System.out.println("نام مشتری را وارد کنید : ");
            name = INPUT.nextLine();
            while (name.isBlank() || name.length() < 2) {
                System.out.println("نامعتبر!\nنام مشتری را وارد کنید : ");
                name = INPUT.nextLine();
            }
        }

        String lastName;
        if (VideoClubManager.isEnLang) {
            System.out.println("Enter Last Name Of Customer : ");
            lastName = INPUT.nextLine();
            while (lastName.isBlank() || lastName.length() < 2) {
                System.out.println("Invalid!\nEnter Last Name Of Customer : ");
                lastName = INPUT.nextLine();
            }
        } else {
            System.out.println("نام خانوادگی مشتری را وارد کنید : ");
            lastName = INPUT.nextLine();
            while (lastName.isBlank() || lastName.length() < 2) {
                System.out.println("نامعتبر!\nنام خانوادگی مشتری را وارد کنید : ");
                lastName = INPUT.nextLine();
            }
        }

        String nationalCode;
        if (VideoClubManager.isEnLang) {
            System.out.println("Enter National Code Of Customer (Ten digits) : ");
            nationalCode = INPUT.nextLine();
            while (!nationalCode.matches("\\d{10}")) {
                System.out.println("Invalid!\nEnter National Code Of Customer (Ten digits) : ");
                nationalCode = INPUT.nextLine();
            }
        } else {
            System.out.println("کد ملی مشتری را وارد کنید (ده رقمی) : ");
            nationalCode = INPUT.nextLine();
            while (!nationalCode.matches("\\d{10}")) {
                System.out.println("نامعتبر!\nکد ملی مشتری را وارد کنید (ده رقمی) : ");
                nationalCode = INPUT.nextLine();
            }
        }

        String phoneNum;
        if (VideoClubManager.isEnLang) {
            System.out.println("Enter Phone Number Of Customer (Start with 09) : ");
            phoneNum = INPUT.nextLine();
            while (!phoneNum.matches("\\d{11}") || !phoneNum.startsWith("09")) {
                System.out.println("Invalid!\nEnter Phone Number Of Customer (Start with 09) : ");
                phoneNum = INPUT.nextLine();
            }
        } else {
            System.out.println("شماره تلفن مشتری را وارد کنید (شروع با 09) : ");
            phoneNum = INPUT.nextLine();
            while (!phoneNum.matches("\\d{11}") || !phoneNum.startsWith("09")) {
                System.out.println("نامعتبر!\nشماره تلفن مشتری را وارد کنید (شروع با 09) : ");
                phoneNum = INPUT.nextLine();
            }
        }

        Customer newCustomer = new Customer(name, lastName, nationalCode, phoneNum, this);

        boolean isAlreadyExist = false;
        for (Customer customer : CUSTOMERS_LIST) {
            if (customer.equals(newCustomer)) {
                isAlreadyExist = true;
                break;
            }
        }

        if (isAlreadyExist) {
            if (VideoClubManager.isEnLang)
                System.out.println("Customer Already Exist!\n");
            else
                System.out.println("مشتری از قبل وجود دارد!\n");
        } else {
            CUSTOMERS_LIST.add(newCustomer);
            if (VideoClubManager.isEnLang)
                System.out.println("Customer Added!\n");
            else
                System.out.println("مشتری اضافه شد!\n");
        }
    }

    public static void showCustomers() {
        if (VideoClubManager.isEnLang)
            System.out.println("\t\t\t|---> Customers List <---|\n");
        else
            System.out.println("\t\t\t|---> لیست مشتریان <---|\n");
        int i = 1;
        for (Customer customer : CUSTOMERS_LIST)
            System.out.println("" + i++ + ")" + customer.toString());
        System.out.println();
    }

    public static void searchMovies() {
        String textEn = """
                            |---> Search Movies <---|
                1.by Name
                2.by IMDB Score
                3.by Production Year
                4.by Name of an Actor
                5.by Name of Producer
                6.by Name of Director
                7.by National Code of Adder
                                
                0.Back
                """;
        String textFa = """
                            |---> جستجوی فیلم ها <---|
                با نام.1
                با امتیاز (IMDB) آی ام دی بی.2
                با سال تولید.3
                با نام یک بازیگر.4
                با نام تهیه کننده.5
                با نام کارگردان.6
                با کدملی اضافه کننده.7
                                
                بازگشت.0
                """;
        isValidInput = false;
        while (!isValidInput) {
            if (VideoClubManager.isEnLang)
                System.out.println(textEn);
            else
                System.out.println(textFa);
            switch (INPUT.nextLine()) {
                case "1" -> {
                    searchMoviesByName();
                    isValidInput = true;
                }
                case "2" -> {
                    searchMoviesByImdbScore();
                    isValidInput = true;
                }
                case "3" -> {
                    searchMoviesByProductionYear();
                    isValidInput = true;
                }
                case "4" -> {
                    searchMoviesByNameOfAnActor();
                    isValidInput = true;
                }
                case "5" -> {
                    searchMoviesByNameOfProducer();
                    isValidInput = true;
                }
                case "6" -> {
                    searchMoviesByNameOfDirector();
                    isValidInput = true;
                }
                case "7" -> {
                    searchMoviesByNationalCodeOfAdder();
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

    private static void searchMoviesByName() {
        ArrayList<Movie> result = new ArrayList<>();
        String textEn = """
                            |---> Search Movies By Name <---|
                Enter Name Of Movie :
                """;
        String textFa = """
                            |---> جستجوی فیلم ها با نام <---|
                نام فیلم را وارد کنید :
                """;
        if (VideoClubManager.isEnLang)
            System.out.println(textEn);
        else
            System.out.println(textFa);

        String inputName = INPUT.nextLine();
        for (Movie movie : MOVIES_LIST) {
            if (movie.getName().equalsIgnoreCase(inputName))
                result.add(movie);
        }

        if (result.isEmpty()) {
            if (VideoClubManager.isEnLang)
                System.out.println("Not Found!\n");
            else
                System.out.println("\nچیزی پیدا نشد!");
        } else {
            for (Movie movie : result)
                System.out.println(movie);
        }
    }

    private static void searchMoviesByImdbScore() {
        ArrayList<Movie> result = new ArrayList<>();
        String textEn = """
                            |---> Search Movies By IMDB Score <---|
                Enter IMDB Score Of Movie :
                """;
        String textFa = """
                            |---> جستجوی فیلم ها با امتیاز (IMDB) آی ام دی بی <---|
                امتیاز IMDB فیلم را وارد کنید :
                """;
        if (VideoClubManager.isEnLang)
            System.out.println(textEn);
        else
            System.out.println(textFa);

        double inputIMDB;
        try {
            inputIMDB = Double.parseDouble(INPUT.nextLine());
        } catch (Exception e) {
            if (VideoClubManager.isEnLang)
                System.out.println("Invalid!");
            else
                System.out.println("نامعتبر!");
            return;
        }

        for (Movie movie : MOVIES_LIST) {
            if (movie.getImdbScore() == inputIMDB)
                result.add(movie);
        }

        if (result.isEmpty()) {
            if (VideoClubManager.isEnLang)
                System.out.println("Not Found!\n");
            else
                System.out.println("\nچیزی پیدا نشد!");
        } else {
            for (Movie movie : result)
                System.out.println(movie);
        }
    }

    private static void searchMoviesByProductionYear() {
        ArrayList<Movie> result = new ArrayList<>();
        String textEn = """
                            |---> Search Movies By Production Year <---|
                Enter Production Year Of Movie :
                """;
        String textFa = """
                            |---> جستجوی فیلم ها با سال تولید <---|
                سال تولید فیلم را وارد کنید :
                """;
        if (VideoClubManager.isEnLang)
            System.out.println(textEn);
        else
            System.out.println(textFa);

        int inputProductionYear;
        try {
            inputProductionYear = Integer.parseInt(INPUT.nextLine());
        } catch (Exception e) {
            if (VideoClubManager.isEnLang)
                System.out.println("Invalid!");
            else
                System.out.println("نامعتبر!");
            return;
        }

        for (Movie movie : MOVIES_LIST) {
            if (movie.getProductionYear() == inputProductionYear)
                result.add(movie);
        }

        if (result.isEmpty()) {
            if (VideoClubManager.isEnLang)
                System.out.println("Not Found!\n");
            else
                System.out.println("\nچیزی پیدا نشد!");
        } else {
            for (Movie movie : result)
                System.out.println(movie);
        }
    }

    private static void searchMoviesByNameOfAnActor() {
        ArrayList<Movie> result = new ArrayList<>();
        String textEn = """
                            |---> Search Movies By Name of an Actor <---|
                Enter Full Name of an Actor Of Movie :
                """;
        String textFa = """
                            |---> جستجوی فیلم ها با نام یک بازیگر <---|
                نام کامل یک بازیگر فیلم را وارد کنید :
                """;
        if (VideoClubManager.isEnLang)
            System.out.println(textEn);
        else
            System.out.println(textFa);

        String inputName = INPUT.nextLine();
        for (Movie movie : MOVIES_LIST) {
            for (int i = 0; i <= 2; i++) {
                if (movie.getACTORS()[i].getFullName().equalsIgnoreCase(inputName))
                    result.add(movie);
            }
        }

        if (result.isEmpty()) {
            if (VideoClubManager.isEnLang)
                System.out.println("Not Found!\n");
            else
                System.out.println("\nچیزی پیدا نشد!");
        } else {
            for (Movie movie : result)
                System.out.println(movie);
        }
    }

    private static void searchMoviesByNameOfProducer() {
        ArrayList<Movie> result = new ArrayList<>();
        String textEn = """
                            |---> Search Movies By Name of Producer <---|
                Enter Full Name of Producer Of Movie :
                """;
        String textFa = """
                            |---> جستجوی فیلم ها با نام تهیه کننده <---|
                نام کامل تهیه کننده فیلم را وارد کنید :
                """;
        if (VideoClubManager.isEnLang)
            System.out.println(textEn);
        else
            System.out.println(textFa);

        String inputName = INPUT.nextLine();
        for (Movie movie : MOVIES_LIST) {
            if (movie.getProducer().getFullName().equalsIgnoreCase(inputName))
                result.add(movie);
        }

        if (result.isEmpty()) {
            if (VideoClubManager.isEnLang)
                System.out.println("Not Found!\n");
            else
                System.out.println("\nچیزی پیدا نشد!");
        } else {
            for (Movie movie : result)
                System.out.println(movie);
        }
    }

    private static void searchMoviesByNameOfDirector() {
        ArrayList<Movie> result = new ArrayList<>();
        String textEn = """
                            |---> Search Movies By Name of Director <---|
                Enter Full Name of Director Of Movie :
                """;
        String textFa = """
                            |---> جستجوی فیلم ها با نام کارگردان <---|
                نام کامل کارگردان فیلم را وارد کنید :
                """;
        if (VideoClubManager.isEnLang)
            System.out.println(textEn);
        else
            System.out.println(textFa);

        String inputName = INPUT.nextLine();
        for (Movie movie : MOVIES_LIST) {
            if (movie.getDirector().getFullName().equalsIgnoreCase(inputName))
                result.add(movie);
        }

        if (result.isEmpty()) {
            if (VideoClubManager.isEnLang)
                System.out.println("Not Found!\n");
            else
                System.out.println("\nچیزی پیدا نشد!");
        } else {
            for (Movie movie : result)
                System.out.println(movie);
        }
    }

    private static void searchMoviesByNationalCodeOfAdder() {
        ArrayList<Movie> result = new ArrayList<>();
        String textEn = """
                            |---> Search Movies By National Code of Adder <---|
                Enter National Code of Adder :
                """;
        String textFa = """
                            |---> جستجوی فیلم ها با کدملی اضافه کننده <---|
                کدملی اضافه کننده فیلم را وارد کنید :
                """;
        if (VideoClubManager.isEnLang)
            System.out.println(textEn);
        else
            System.out.println(textFa);

        String inputNationalCode = INPUT.nextLine();
        for (Movie movie : MOVIES_LIST) {
            if (movie.getADDER().getNationalCode().equalsIgnoreCase(inputNationalCode))
                result.add(movie);
        }

        if (result.isEmpty()) {
            if (VideoClubManager.isEnLang)
                System.out.println("Not Found!\n");
            else
                System.out.println("\nچیزی پیدا نشد!");
        } else {
            for (Movie movie : result)
                System.out.println(movie);
        }
    }

    public static void searchCustomers() {
        String textEn = """
                            |---> Search Customers <---|
                1.by Name
                2.by Last Name
                3.by National Code
                4.by Phone Number
                5.by National Code of Adder
                                
                0.Back
                """;
        String textFa = """
                            |---> جستجوی فیلم ها <---|
                با نام.1
                با نام خانوادگی.2
                با کدملی.3
                با شماره تلفن.4
                با کدملی اضافه کننده.5
                                
                بازگشت.0
                """;
        isValidInput = false;
        while (!isValidInput) {
            if (VideoClubManager.isEnLang)
                System.out.println(textEn);
            else
                System.out.println(textFa);
            switch (INPUT.nextLine()) {
                case "1" -> {
                    searchCustomersByName();
                    isValidInput = true;
                }
                case "2" -> {
                    searchCustomersByLastName();
                    isValidInput = true;
                }
                case "3" -> {
                    searchCustomersByNationalCode();
                    isValidInput = true;
                }
                case "4" -> {
                    searchCustomersByPhoneNum();
                    isValidInput = true;
                }
                case "5" -> {
                    searchCustomersByNationalCodeOfAdder();
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

    private static void searchCustomersByName() {
        ArrayList<Customer> result = new ArrayList<>();
        String textEn = """
                            |---> Search Customer By Name <---|
                Enter Name Of Customer :
                """;
        String textFa = """
                            |---> جستجوی مشتریان با نام <---|
                نام مشتری را وارد کنید :
                """;
        if (VideoClubManager.isEnLang)
            System.out.println(textEn);
        else
            System.out.println(textFa);

        String inputName = INPUT.nextLine();
        for (Customer customer : CUSTOMERS_LIST) {
            if (customer.getName().equalsIgnoreCase(inputName))
                result.add(customer);
        }

        if (result.isEmpty()) {
            if (VideoClubManager.isEnLang)
                System.out.println("Not Found!\n");
            else
                System.out.println("\nچیزی پیدا نشد!");
        } else {
            for (Customer customer : result)
                System.out.println(customer);
        }
    }

    private static void searchCustomersByLastName() {
        ArrayList<Customer> result = new ArrayList<>();
        String textEn = """
                            |---> Search Customer By Last Name <---|
                Enter Last Name Of Customer :
                """;
        String textFa = """
                            |---> جستجوی مشتریان با نام خانوادگی <---|
                نام خانوادگی مشتری را وارد کنید :
                """;
        if (VideoClubManager.isEnLang)
            System.out.println(textEn);
        else
            System.out.println(textFa);

        String inputName = INPUT.nextLine();
        for (Customer customer : CUSTOMERS_LIST) {
            if (customer.getLastName().equalsIgnoreCase(inputName))
                result.add(customer);
        }

        if (result.isEmpty()) {
            if (VideoClubManager.isEnLang)
                System.out.println("Not Found!\n");
            else
                System.out.println("\nچیزی پیدا نشد!");
        } else {
            for (Customer customer : result)
                System.out.println(customer);
        }
    }

    private static void searchCustomersByNationalCode() {
        ArrayList<Customer> result = new ArrayList<>();
        String textEn = """
                            |---> Search Customer By National Code <---|
                Enter National Code Of Customer :
                """;
        String textFa = """
                            |---> جستجوی مشتریان با کدملی <---|
                کدملی مشتری را وارد کنید :
                """;
        if (VideoClubManager.isEnLang)
            System.out.println(textEn);
        else
            System.out.println(textFa);

        String inputNationalCode = INPUT.nextLine();
        for (Customer customer : CUSTOMERS_LIST) {
            if (customer.getNationalCode().equalsIgnoreCase(inputNationalCode))
                result.add(customer);
        }

        if (result.isEmpty()) {
            if (VideoClubManager.isEnLang)
                System.out.println("Not Found!\n");
            else
                System.out.println("\nچیزی پیدا نشد!");
        } else {
            for (Customer customer : result)
                System.out.println(customer);
        }
    }

    private static void searchCustomersByPhoneNum() {
        ArrayList<Customer> result = new ArrayList<>();
        String textEn = """
                            |---> Search Customer By Phone Number <---|
                Enter Phone Number Of Customer :
                """;
        String textFa = """
                            |---> جستجوی مشتریان با شماره تلفن <---|
                شماره تلفن مشتری را وارد کنید :
                """;
        if (VideoClubManager.isEnLang)
            System.out.println(textEn);
        else
            System.out.println(textFa);

        String inputPhoneNum = INPUT.nextLine();
        for (Customer customer : CUSTOMERS_LIST) {
            if (customer.getPhoneNum().equalsIgnoreCase(inputPhoneNum))
                result.add(customer);
        }

        if (result.isEmpty()) {
            if (VideoClubManager.isEnLang)
                System.out.println("Not Found!\n");
            else
                System.out.println("\nچیزی پیدا نشد!");
        } else {
            for (Customer customer : result)
                System.out.println(customer);
        }
    }

    private static void searchCustomersByNationalCodeOfAdder() {
        ArrayList<Customer> result = new ArrayList<>();
        String textEn = """
                            |---> Search Customer By National Code Of Adder <---|
                Enter National Code Of Adder Of Customer :
                """;
        String textFa = """
                            |---> جستجوی مشتریان با کدملی اضافه کننده <---|
                کدملی اضافه کننده مشتری را وارد کنید :
                """;
        if (VideoClubManager.isEnLang)
            System.out.println(textEn);
        else
            System.out.println(textFa);

        String inputNationalCode = INPUT.nextLine();
        for (Customer customer : CUSTOMERS_LIST) {
            if (customer.getADDER().getNationalCode().equalsIgnoreCase(inputNationalCode))
                result.add(customer);
        }

        if (result.isEmpty()) {
            if (VideoClubManager.isEnLang)
                System.out.println("Not Found!\n");
            else
                System.out.println("\nچیزی پیدا نشد!");
        } else {
            for (Customer customer : result)
                System.out.println(customer);
        }
    }
}
