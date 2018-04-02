package sandbox.patterns.decorator;

/**
 * Decorator that adds a club for the troll
 */
public class ClubbedTroll extends TrollDecorator {

    public ClubbedTroll(Troll decorated) {
        super(decorated);
    }

    @Override
    public void attack() {
        super.attack();
        System.out.println("The troll swings at you with a club!");
    }

    @Override
    public int getAttackPower() {
        return super.getAttackPower() + 10;
    }
}
