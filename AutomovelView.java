package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.AutomovelController;
import model.Automovel;

public class AutomovelView {
    private AutomovelController controller;
    private Scanner scanner;

    public AutomovelView(AutomovelController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Incluir automóvel");
            System.out.println("2 - Remover automóvel");
            System.out.println("3 - Alterar dados de automóvel");
            System.out.println("4 - Consultar automóvel por placa");
            System.out.println("5 - Listar automóveis (ordenado)");
            System.out.println("6 - Salvar e sair");
            opcao = capturarInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> adicionarAutomovel();
                case 2 -> removerAutomovel();
                case 3 -> alterarAutomovel();
                case 4 -> consultarPorPlaca();
                case 5 -> listarAutomoveisOrdenados();
                case 6 -> {
                    controller.salvarAutomoveis();
                    System.out.println("Automóveis salvos. Encerrando...");
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }

    private void adicionarAutomovel() {
        String placa = capturarString("Placa: ");
        String modelo = capturarString("Modelo: ");
        String marca = capturarString("Marca: ");
        int ano = capturarInteiro("Ano: ");
        double valor = capturarDouble("Valor: ");
        controller.adicionarAutomovel(placa, modelo, marca, ano, valor);
        System.out.println("Automóvel adicionado com sucesso.");
    }

    private void removerAutomovel() {
        String placa = capturarString("Placa do automóvel a remover: ");
        if (controller.excluirAutomovel(placa)) {
            System.out.println("Automóvel removido com sucesso.");
        } else {
            System.out.println("Automóvel não encontrado.");
        }
    }

    private void alterarAutomovel() {
        String placa = capturarString("Placa do automóvel a alterar: ");
        String modelo = capturarString("Novo Modelo: ");
        String marca = capturarString("Nova Marca: ");
        int ano = capturarInteiro("Novo Ano: ");
        double valor = capturarDouble("Novo Valor: ");
        if (controller.alterarAutomovel(placa, modelo, marca, ano, valor)) {
            System.out.println("Automóvel alterado com sucesso.");
        } else {
            System.out.println("Automóvel não encontrado.");
        }
    }

    private void consultarPorPlaca() {
        String placa = capturarString("Digite a placa: ");
        Automovel automovel = controller.buscarAutomovelPorPlaca(placa);
        if (automovel != null) {
            System.out.println("Placa: " + automovel.getPlaca()
                    + ", Modelo: " + automovel.getModelo()
                    + ", Marca: " + automovel.getMarca()
                    + ", Ano: " + automovel.getAno()
                    + ", Valor: R$ " + automovel.getValor());
        } else {
            System.out.println("Automóvel não encontrado.");
        }
    }

    private void listarAutomoveisOrdenados() {
        controller.listarAutomoveisOrdenados().forEach(automovel -> 
            System.out.println("Placa: " + automovel.getPlaca()
                + ", Modelo: " + automovel.getModelo()
                + ", Marca: " + automovel.getMarca()
                + ", Ano: " + automovel.getAno()
                + ", Valor: R$ " + automovel.getValor())
        );
    }

    private int capturarInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Insira um número inteiro.");
                scanner.nextLine();
            }
        }
    }

    private double capturarDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Insira um número decimal.");
                scanner.nextLine();
            }
        }
    }

    private String capturarString(String mensagem) {
        System.out.print(mensagem);
        return scanner.next();
    }
}
