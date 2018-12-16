import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Prize oscar1990 = new Prize("oscar", 1990);
        Prize oscar2000 = new Prize("oscar", 2000);
        Prize oscar2010 = new Prize("oscar", 2010);
        Prize oscar2018 = new Prize("oscar", 2018);

        Actor actorOscar1990 = new Actor("actor cu 2 oscaruri", 35, new Prize[]{oscar1990, oscar2000});
        Actor actorOscar2010 = new Actor("actor cu oscar din 2000", 55, new Prize[]{oscar2010});
        Actor actorOscar2018 = new Actor("actor cu oscar din 2018", 23, new Prize[]{oscar2018});
        Actor actorFaraPremii01 = new Actor("actor fara oscar 01", 33, new Prize[]{});
        Actor actorFaraPremii02 = new Actor("actor fara oscar 02", 60, new Prize[]{});
        Actor actorFaraPremii03 = new Actor("actor fara oscar 02", 20, new Prize[]{});

        Film film1 = new Film(1990, "film cu actori de oscar", new Actor[]{actorOscar1990, actorFaraPremii01});

        Film film2 = new Film(2010, "film cu actori fara premii2", new Actor[]{actorFaraPremii01, actorFaraPremii02,
                actorFaraPremii03});

        Film film3 = new Film(2010, "film cu actori fara premii3", new Actor[]{actorFaraPremii01, actorFaraPremii02,
                actorFaraPremii03});

        Film film4 = new Film(2018, "film cu actori de oscar", new Actor[]{actorOscar2010, actorOscar2018,
                actorFaraPremii02});

        Film film5 = new Film(2018, "film cu actori fara premii5", new Actor[]{actorFaraPremii02, actorFaraPremii03});

        Studio studio1 = new Studio("MGM", new Film[]{film1, film2});
        Studio studio2 = new Studio("Disney", new Film[]{film3, film4, film5 });

        Studio[] studioDatabase = new Studio[] {studio1, studio2};

        List<String> moreThanTwoMovies = new ArrayList<>();
        List<String> certainActorStudios = new ArrayList<>();
        List<String> ageAbove = new ArrayList<>();

        for (Studio studio : studioDatabase) {

            if (studio.moreThanNMovies(2)) {
                moreThanTwoMovies.add(studio.getName());
            }

            if (studio.isTheActorHere("actor cu 2 oscaruri")) {
                certainActorStudios.add(studio.getName());
            }

            ageAbove.addAll(studio.moviesWithActorsAboveAge(50));
        }

        System.out.println("Studios with more than two movies: " + moreThanTwoMovies.toString());
        System.out.println("Studios with movies with \"Actor cu 2 oscaruri\": " + certainActorStudios.toString());
        System.out.println("Movies with actors aged above 50: " + ageAbove.toString());
    }
}
