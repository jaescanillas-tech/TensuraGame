package dev.game.modelo.enums;

public enum Razas {
    //Nombre, Vida, Estamina, Magicuras, Atc Fisico, Atc Magico, Def Fisica, Def Magica

    // Razas Debiles
    Humano(100.0, 100, 40, 12.0, 10.0, 8, 5),
    Goblin(130.0, 100, 20, 10.0, 8.0, 6, 4);

    private final double vidaBase;
    private final int estaminaBase;
    private final int magicuraBase;
    private final double atcFisicoBase;
    private final double atcMagicoBase;
    private final int defFisicaBase;
    private final int defMagicaBase;

    Razas(double vidaBase, int estaminaBase, int magicuraBase, double atcFisicoBase, double atcMagicoBase, int defFisicaBase, int defMagicaBase) {
        this.vidaBase = vidaBase;
        this.estaminaBase = estaminaBase;
        this.magicuraBase = magicuraBase;
        this.atcFisicoBase = atcFisicoBase;
        this.atcMagicoBase = atcMagicoBase;
        this.defFisicaBase = defFisicaBase;
        this.defMagicaBase = defMagicaBase;
    }

    public double getVidaBase() {
        return vidaBase;
    }

    public int getEstaminaBase() {
        return estaminaBase;
    }

    public int getMagicuraBase() {
        return magicuraBase;
    }

    public double getAtcFisicoBase() {
        return atcFisicoBase;
    }

    public double getAtcMagicoBase() {
        return atcMagicoBase;
    }

    public int getDefFisicaBase() {
        return defFisicaBase;
    }

    public int getDefMagicaBase() {
        return defMagicaBase;
    }
}
