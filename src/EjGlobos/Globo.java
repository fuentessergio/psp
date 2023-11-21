package EjGlobos;

public class Globo {
    enum Color {BLANCO,ROJO,VERDE,AZUL,AMARILLO};

    private Color color;

    public Globo(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "Globo de color "+ color;
    }
}
