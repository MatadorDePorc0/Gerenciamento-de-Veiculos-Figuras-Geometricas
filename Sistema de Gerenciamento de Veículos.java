
abstract class Veiculo {
   
    private String marca;
    private String modelo;
    private int ano;
    private double preco;

  
    public Veiculo(String marca, String modelo, int ano, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }
    public double getPreco() { return preco; }

    
    public void setPreco(double preco) { this.preco = preco; }

    
    public abstract void exibirDetalhes();
}


interface Desconto {
    void aplicarDesconto(double porcentagem);
}


class Carro extends Veiculo implements Desconto {
    private int numeroPortas; 

   
    public Carro(String marca, String modelo, int ano, double preco, int numeroPortas) {
        super(marca, modelo, ano, preco);
        this.numeroPortas = numeroPortas;
    }

    
    public int getNumeroPortas() { return numeroPortas; }

    
    @Override
    public void exibirDetalhes() {
        System.out.println("Carro: " + getMarca() + " " + getModelo() + " " + getAno() +
                " - Preço: R$" + getPreco() + " - Portas: " + numeroPortas);
    }

    
    @Override
    public void aplicarDesconto(double porcentagem) {
        double novoPreco = getPreco() - (getPreco() * (porcentagem / 100));
        setPreco(novoPreco);
    }
}


class Moto extends Veiculo implements Desconto {
    private int cilindradas; 

    
    public Moto(String marca, String modelo, int ano, double preco, int cilindradas) {
        super(marca, modelo, ano, preco);
        this.cilindradas = cilindradas;
    }

    
    public int getCilindradas() { return cilindradas; }

   
    @Override
    public void exibirDetalhes() {
        System.out.println("Moto: " + getMarca() + " " + getModelo() + " " + getAno() +
                " - Preço: R$" + getPreco() + " - Cilindradas: " + cilindradas);
    }

   
    @Override
    public void aplicarDesconto(double porcentagem) {
        double novoPreco = getPreco() - (getPreco() * (porcentagem / 100));
        setPreco(novoPreco);
    }
}


public class Main {
    public static void main(String[] args) {
        
        Carro carro = new Carro("Toyota", "Corolla", 2022, 120000, 4);
        
        Moto moto = new Moto("Honda", "CB 500", 2023, 35000, 500);

        
        System.out.println("Detalhes antes do desconto:");
        carro.exibirDetalhes();
        moto.exibirDetalhes();

        
        carro.aplicarDesconto(10); 
        moto.aplicarDesconto(5);   
        
        System.out.println("\nApós o desconto:");
        carro.exibirDetalhes();
        moto.exibirDetalhes();
    }
}