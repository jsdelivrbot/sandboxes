package sandbox.patterns.decorator;

public class DecoratorApp {

    public static void execute() {
        // simple troll
        System.out.println("A simple looking troll approaches.");
        Troll troll = new SimpleTroll();
        troll.attack();
        troll.fleeBattle();
        System.out.println("Simple troll power: " + troll.getAttackPower());

        // change the behavior of the simple troll by adding a decorator
        System.out.println("A troll with huge club surprises you.");
        Troll clubbed = new ClubbedTroll(troll);
        clubbed.attack();
        clubbed.fleeBattle();
        System.out.println("Clubbed troll power: " + clubbed.getAttackPower());
    }
}
