import java.util.ArrayList;
import java.util.List;

public class Studio {

    private String name;
    private Film[] films;

    public Studio(String name, Film[] films) {
        this.name = name;

        this.films = new Film[films.length];
        System.arraycopy(films, 0, this.films, 0, films.length);
    }

    public String getName() {
        return name;
    }

    public Film[] getFilms() {
        return films;
    }

    public boolean moreThanNMovies(int n) {
        /* This method checks if the studio has more than n movies published */
        if (films.length > 2)
            return true;

        return false;
    }

    public boolean isTheActorHere(String actorName) {

        for (Film film : films) {

            Actor[] actors = film.getActors();
            for (Actor actor : actors) {
                if (actor.getName().equals(actorName))
                    return true;
            }
        }

        return false;
    }

    public List<String> moviesWithActorsAboveAge(int age) {

        List<String> movieNames = new ArrayList<>();

        for (Film film : films) {
            if (film.ageAbove(age)) {
                movieNames.add(film.getName());
            }
        }

        return movieNames;
    }
}
