public class Actor {

    private String name;
    private Integer age;
    private Prize[] prizes;

    public Actor(String name, Integer age, Prize[] prizes) {
        this.name = name;
        this.age = age;

        this.prizes = new Prize[prizes.length];
        System.arraycopy(prizes, 0, this.prizes, 0, prizes.length);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Prize[] getPrizes() {
        return prizes;
    }
}
