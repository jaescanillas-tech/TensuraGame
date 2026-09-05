package dev.game.modelo.enums;

public enum RangoEnemigos {
    COMUN("Comun", 1.0, 1.0, 1.0,  0.0),
    RARO("Raro", 1.2, 1.2, 1.2,  0.2),
    MUTADO("Mutado", 1.5, 1.5, 1.5,  0.5),
    LIDER("Lider", 1.8, 1.8, 1.8,  0.8);

    private final String etiqueta;
    private final double multVida;
    private final double multAtaque;
    private final double multDefensa;
    private  final double bonoDrop;

    RangoEnemigos(String etiqueta, double multVida, double multAtaque, double multDefensa, double bonoDrop) {
        this.etiqueta = etiqueta;
        this.multVida = multVida;
        this.multAtaque = multAtaque;
        this.multDefensa = multDefensa;
        this.bonoDrop = bonoDrop;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public double getMultVida() {
        return multVida;
    }

    public double getMultAtaque() {
        return multAtaque;
    }

    public double getMultDefensa() {
        return multDefensa;
    }

    public double getBonoDrop() {
        return bonoDrop;
    }
}
