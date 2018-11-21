import Classes.Glove;
import Classes.Pair;
import Classes.Sock;

public class Main {

    public static void main(String[] args) {

        Sock blueSock = new Sock(10, "blue");
        Sock redSock = new Sock(10, "red");

        Glove yellowGlove = new Glove(15, "yellow");
        Glove bigYellowGlove = new Glove(17, "yellow");

        Sock left = new Sock(10, "green");
        Sock right = new Sock(10, "green");
        Pair<Sock> socksPair = new Pair<>(left, right);

        System.out.println(left.getColor() + " " + left.getSize());
    }
}
