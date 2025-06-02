package model;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutomovelRepository {
    private final String arquivoAutomoveis = "automoveis.txt";

    public void salvarAutomoveis(List<Automovel> automoveis) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoAutomoveis))) {
            for (Automovel automovel : automoveis) {
                writer.write(automovel.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar automóveis: " + e.getMessage());
        }
    }

    public List<Automovel> carregarAutomoveis() {
        List<Automovel> automoveis = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoAutomoveis))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                automoveis.add(Automovel.fromFileString(linha));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de automóveis não encontrado. Será criado ao salvar novos automóveis.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar automóveis: " + e.getMessage());
        }
        return Collections.unmodifiableList(automoveis);
    }
}
