package step.learning.oop;

public class Gun extends Weapon{

public Gun(String name, int catridge) {
    super.setName(name);
    this.setCatridge(catridge);
}

    private  int catridge;

    public int getCatridge() {
        return catridge;
    }

    public  void setCatridge(int catridge) {
        this.catridge = catridge;
    }
    @Override
    public String getCard() {
        return String.format("Gun: %s, Catridge: %d", super.getName(), this.getCatridge());
    }
}
