package sandbox.patterns.factorymethod;

public class FactoryMethodApp {

    private final Blacksmith blacksmith;

    /**
     * Creates an instance of <code>App</code> which will use <code>blacksmith</code> to manufacture
     * the weapons for war.
     * <code>App</code> is unaware which concrete implementation of {@link Blacksmith} it is using.
     * The decision of which blacksmith implementation to use may depend on configuration, or
     * the type of rival in war.
     * @param blacksmith a non-null implementation of blacksmith
     */
    public FactoryMethodApp(Blacksmith blacksmith) {
        this.blacksmith = blacksmith;
    }

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(String[] args) {
//        // Lets go to war with Orc weapons
//        App app = new App(new OrcBlacksmith());
//        app.manufactureWeapons();
//
//        // Lets go to war with Elf weapons
//        app = new App(new ElfBlacksmith());
//        app.manufactureWeapons();
    }

    private void manufactureWeapons() {
        Weapon weapon;
        weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
        System.out.println(weapon.toString());
        weapon = blacksmith.manufactureWeapon(WeaponType.AXE);
        System.out.println(weapon.toString());
    }
}
