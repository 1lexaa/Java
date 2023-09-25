package step.learning.oop;

import java.util.ArrayList;
import java.util.List;

public class Armory {
    private final List<Weapon> weapons;

    public Armory() {
        weapons = new ArrayList<>();
    }

    public void add( Weapon weapon ) {
        weapons.add( weapon ) ;
    }

    public void remove( Weapon weapon ) {
        weapons.remove( weapon ) ;
    }

    public void printAll() {
        for( Weapon weapon : weapons ) {
            System.out.println( weapon.getCard() ) ;
        }
    }
}