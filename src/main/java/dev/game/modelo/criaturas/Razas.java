package dev.game.modelo.criaturas;

public enum Razas {
    //Nombre, Vida, Estamina, Magicuras, Atc Fisico, Atc Magico, Def Fisica, Def Magica

    Humano(100.0, 120, 50, 12.0, 10.0, 8, 5);

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
