package dev.game.modelo.enums;

public enum Razas {
    //Nombre, Vida, Estamina, Magicuras, Atc Fisico, Atc Magico, Def Fisica, Def Magica

    // Razas Principales
    Humano(100.0, 100, 5, 8.0, 0.0, 8, 0),
    Goblin(90.0, 90, 12, 6.0, 2.0, 6, 3),
    Orco(140, 80, 16, 16.0, 2.0, 16, 8),
    Lizzardman(120.0, 110, 25, 10.0, 6.0, 8, 5),
    Ogro(200, 130, 50, 25, 15, 15, 15),
    Slime(5, 150, 10, 1, 2, 5, 5),
    Elfo(110, 100, 60,  7, 14, 8, 16),
    DarkElf(110, 100, 75, 8, 16, 8, 16),
    Enano(120, 120, 65, 12, 8, 14, 12),
    Nomuerto(90, 150, 15, 6, 4, 10, 12),
    treant(150, 140, 100, 4, 20, 6, 30),


    //sub especies Licantropo ( Para player = random sub raze )
    Kobold(100, 105, 16, 10, 2, 8, 1), //perros
    Arpia(100, 112, 18, 10, 2, 10, 2), //arpias
    Neko(100, 105, 16, 10, 2, 8, 1), // felinos
    Rabbitfolk(100, 110, 16, 10, 2, 8, 1), //rabbit
    Saru(100, 105, 16, 10, 1, 8, 1), //monos
    Serpent(100, 112, 16, 10, 3, 10, 2), //serpientes
    Okami(100, 108, 16, 10, 2, 8, 1), //aves

    // Mascotas and enemis
    Cryptid(120, 110, 22, 10, 10, 10, 10),

    //Razas desbloqueables
    Dragon(380, 150, 200, 55, 60, 50, 50),
    Hada(110, 130, 80, 2, 24, 4, 10),
    Demonio(110, 130, 90, 20, 22, 18, 15),
    Caminantes(100, 150, 20, 10, 8, 15, 18),
    Vapiro(110, 110, 70, 15, 18, 15, 15),
    Angel(110, 130, 100, 18, 24, 16, 18),
    Espectro(110, 110, 80, 8, 18, 9999999, 1),
    Siren(120, 120, 50, 12, 10, 14, 16),  //peces

    //Raza no desbloqueable
    Spirit(110, 130, 85, 5, 24, 20, 25);

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
