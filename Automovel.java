package model;
public class Automovel {
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private double valor;

    public Automovel(String placa, String modelo, String marca, int ano, double valor) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("Placa não pode ser vazia ou nula.");
        }
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("Modelo não pode ser vazio ou nulo.");
        }
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("Marca não pode ser vazia ou nula.");
        }
        if (ano <= 0) {
            throw new IllegalArgumentException("Ano deve ser positivo.");
        }
        if (valor < 0) {
            throw new IllegalArgumentException("Valor deve ser positivo.");
        }

        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.valor = valor;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    public double getValor() {
        return valor;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("Modelo não pode ser vazio ou nulo.");
        }
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("Marca não pode ser vazia ou nula.");
        }
        this.marca = marca;
    }

    public void setAno(int ano) {
        if (ano <= 0) {
            throw new IllegalArgumentException("Ano deve ser positivo.");
        }
        this.ano = ano;
    }

    public void setValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor deve ser positivo.");
        }
        this.valor = valor;
    }

    // Serializa para salvar em arquivo: placa;modelo;marca;ano;valor
    public String toFileString() {
        return placa + ";" + modelo + ";" + marca + ";" + ano + ";" + valor;
    }

    // Converte a linha do arquivo em um objeto Automovel
    public static Automovel fromFileString(String line) {
        String[] data = line.split(";");
        if (data.length != 5) {
            throw new IllegalArgumentException("Linha de dados inválida para Automovel: " + line);
        }
        try {
            String placa = data[0];
            String modelo = data[1];
            String marca = data[2];
            int ano = Integer.parseInt(data[3]);
            double valor = Double.parseDouble(data[4]);
            return new Automovel(placa, modelo, marca, ano, valor);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Formato numérico inválido em: " + line, e);
        }
    }
}
