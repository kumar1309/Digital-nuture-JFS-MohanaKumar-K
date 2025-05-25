// Interface
interface Playable {
    void play();
}

// Class implementing Playable
class Guitar implements Playable {
    public void play() {
        System.out.println("Playing the guitar");
    }
}

// Another class implementing Playable
class Piano implements Playable {
    public void play() {
        System.out.println("Playing the piano");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();

        guitar.play();
        piano.play();
    }
}
