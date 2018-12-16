public class Fish extends Animal {

    public Fish() {
        super(0);
    }

    @Override
    public void eat() {
        System.out.println("A fish is eating");
    }

    @Override
    public void walk() {
        System.out.println("Fish can't walk");
    }
}
