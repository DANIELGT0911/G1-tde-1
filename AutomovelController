package controller;
import java.util.ArrayList;
import java.util.List;

import model.Automovel;
import model.AutomovelRepository;

public class AutomovelController {
    private List<Automovel> automoveis;
    private AutomovelRepository automovelRepository;

    public AutomovelController() {
        this.automovelRepository = new AutomovelRepository();
        this.automoveis = new ArrayList<>(automovelRepository.carregarAutomoveis());
    }

    public List<Automovel> listarAutomoveis() {
        return List.copyOf(automoveis);
    }

    public void adicionarAutomovel(String placa, String modelo, String marca, int ano, double valor) {
        Automovel automovel = new Automovel(placa, modelo, marca, ano, valor);
        automoveis.add(automovel);
        automovelRepository.salvarAutomoveis(automoveis);
    }

    public boolean alterarAutomovel(String placa, String novoModelo, String novaMarca, int novoAno, double novoValor) {
        Automovel automovel = buscarAutomovelPorPlaca(placa);
        if (automovel != null) {
            automovel.setModelo(novoModelo);
            automovel.setMarca(novaMarca);
            automovel.setAno(novoAno);
            automovel.setValor(novoValor);
            automovelRepository.salvarAutomoveis(automoveis);
            return true;
        }
        return false;
    }

    public boolean excluirAutomovel(String placa) {
        Automovel automovel = buscarAutomovelPorPlaca(placa);
        if (automovel != null) {
            automoveis.remove(automovel);
            automovelRepository.salvarAutomoveis(automoveis);
            return true;
        }
        return false;
    }

    public Automovel buscarAutomovelPorPlaca(String placa) {
        return automoveis.stream()
                .filter(a -> a.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }

    public List<Automovel> listarAutomoveisOrdenados() {
        return automoveis.stream()
                .sorted((a1, a2) -> a1.getPlaca().compareToIgnoreCase(a2.getPlaca()))
                .toList();
    }

    public void salvarAutomoveis() {
        automovelRepository.salvarAutomoveis(automoveis);
    }
}

