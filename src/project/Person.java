package project;

import java.util.Objects;

public class Person {
    private String name;
    private String lastName;
    private String nationalCode;
    private String phoneNum;

    public Person(String name, String lastName, String nationalCode, String phoneNum) {
        this.name = name;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.phoneNum = phoneNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(nationalCode, person.nationalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationalCode);
    }

    @Override
    public String toString() {
        if (VideoClubManager.isEnLang) {
            return
                    "|---> Name : " + name +
                            " | Last Name : " + lastName +
                            " | National Code : " + nationalCode +
                            " | Phone Number : " + phoneNum + " <---|"
                    ;
        } else {
            return
                    "|---> نام : " + name +
                            " | نام خانوادگی : " + lastName +
                            " | کدملی : " + nationalCode +
                            " | شماره تلفن : " + phoneNum + " <---|"
                    ;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
