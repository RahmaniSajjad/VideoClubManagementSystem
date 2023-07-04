package project;

import java.util.Objects;

public class CinematicPerson {
    private String fullName;
    private String birthplace;
    private int birthYear;

    public CinematicPerson(String fullName, String birthplace, int birthYear) {
        this.fullName = fullName;
        this.birthplace = birthplace;
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        if (VideoClubManager.isEnLang) {
            return
                    "|---> Full Name : " + fullName +
                            " | Birthplace : " + birthplace +
                            " | Birth Year : " + birthYear + " <---|"
                    ;
        } else {
            return
                    "|---> نام کامل : " + fullName +
                            " | محل تولد : " + birthplace +
                            " | سال تولد : " + birthYear + " <---|"
                    ;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CinematicPerson that)) return false;
        return birthYear == that.birthYear && Objects.equals(fullName, that.fullName) && Objects.equals(birthplace, that.birthplace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, birthplace, birthYear);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
