public class Film {

    private Integer releaseYear;
    private String name;
    private Actor[] actors;

    public Film(Integer releaseYear, String name, Actor[] actors) {
        this.releaseYear = releaseYear;
        this.name = name;

        this.actors = new Actor[actors.length];
        System.arraycopy(actors, 0, this.actors, 0, actors.length);
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public String getName() {
        return name;
    }

    public Actor[] getActors() {
        return actors;
    }

    public boolean ageAbove(int age) {

        for (Actor actor : actors) {
            if (actor.getAge() > age)
                return true;
        }

        return false;
    }
}
