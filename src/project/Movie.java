package project;

import java.util.Objects;

public class Movie {
    private String name;
    private double imdbScore;
    private int productionYear;
    private final Actor[] ACTORS = new Actor[3];
    private Producer producer;
    private Director director;
    private final ClubManager ADDER;

    public Movie(String name, double imdbScore, int productionYear, Actor[] ACTORS, Producer producer, Director director, ClubManager ADDER) {
        this.name = name;
        this.imdbScore = imdbScore;
        this.productionYear = productionYear;
        System.arraycopy(ACTORS, 0, this.ACTORS, 0, 3);
        this.producer = producer;
        this.director = director;
        this.ADDER = ADDER;
    }

    @Override
    public String toString() {
        if (VideoClubManager.isEnLang) {
            return
                    "|---> Name : " + name +
                            " | IMDB Score : " + imdbScore +
                            " | Production Year : " + productionYear +
                            " | ACTORS : " + ACTORS[0].getFullName() + ", " + ACTORS[1].getFullName() + ", " + ACTORS[2].getFullName() +
                            " | Producer : " + producer.getFullName() +
                            " | Director : " + director.getFullName() +
                            " | Adder : " + ADDER.getName() + " <---|"
                    ;
        } else {
            return
                    "|---> نام : " + name +
                            " | امتیاز آی ام بی دی : " + imdbScore +
                            " | سال تولید : " + productionYear +
                            " | بازیگران : " + ACTORS[0].getFullName() + ", " + ACTORS[1].getFullName() + ", " + ACTORS[2].getFullName() +
                            " | تهیه کننده : " + producer.getFullName() +
                            " | کارگردان : " + director.getFullName() +
                            " | اضافه کننده : " + ADDER.getName() + " <---|"
                    ;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        return Double.compare(movie.imdbScore, imdbScore) == 0 && productionYear == movie.productionYear && name.equals(movie.name) && producer.equals(movie.producer) && director.equals(movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, imdbScore, productionYear, producer, director);
    }

    public ClubManager getADDER() {
        return ADDER;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(double imdbScore) {
        this.imdbScore = imdbScore;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public Actor[] getACTORS() {
        return ACTORS;
    }

    public void setACTORS(Actor[] ACTORS) {
        System.arraycopy(ACTORS, 0, this.ACTORS, 0, 3);
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
