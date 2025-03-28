abstract class Figura {
    public abstract void exibirDetalhes(); 
}


interface FiguraPlana {
    double calcularArea();
    double calcularPerimetro();
}


interface FiguraEspacial {
    double calcularVolume();
}


class Circulo extends Figura implements FiguraPlana {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() { return raio; }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Círculo - Raio: " + raio +
                           ", Área: " + calcularArea() +
                           ", Perímetro: " + calcularPerimetro());
    }
}


class Retangulo extends Figura implements FiguraPlana {
    private double largura, altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (largura + altura);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Retângulo - Largura: " + largura + ", Altura: " + altura +
                           ", Área: " + calcularArea() +
                           ", Perímetro: " + calcularPerimetro());
    }
}


class Triangulo extends Figura implements FiguraPlana {
    private double lado1, lado2, lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    @Override
    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2; // Semiperímetro
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3)); // Fórmula de Heron
    }

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Triângulo - Lados: " + lado1 + ", " + lado2 + ", " + lado3 +
                           ", Área: " + calcularArea() +
                           ", Perímetro: " + calcularPerimetro());
    }
}


class Esfera extends Figura implements FiguraEspacial {
    private double raio;

    public Esfera(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(raio, 3);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Esfera - Raio: " + raio +
                           ", Volume: " + calcularVolume());
    }
}


class Cubo extends Figura implements FiguraEspacial {
    private double lado;

    public Cubo(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularVolume() {
        return Math.pow(lado, 3);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Cubo - Lado: " + lado +
                           ", Volume: " + calcularVolume());
    }
}


class Cone extends Figura implements FiguraEspacial {
    private double raio, altura;

    public Cone(double raio, double altura) {
        this.raio = raio;
        this.altura = altura;
    }

    @Override
    public double calcularVolume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(raio, 2) * altura;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Cone - Raio: " + raio + ", Altura: " + altura +
                           ", Volume: " + calcularVolume());
    }
}


public class Main {
    public static void main(String[] args) {
        
        Circulo circulo = new Circulo(5);
        Retangulo retangulo = new Retangulo(4, 7);
        Triangulo triangulo = new Triangulo(3, 4, 5);
        Esfera esfera = new Esfera(6);
        Cubo cubo = new Cubo(3);
        Cone cone = new Cone(4, 9);

        
        System.out.println("Detalhes das Figuras Geométricas:\n");
        circulo.exibirDetalhes();
        retangulo.exibirDetalhes();
        triangulo.exibirDetalhes();
        esfera.exibirDetalhes();
        cubo.exibirDetalhes();
        cone.exibirDetalhes();
    }
}