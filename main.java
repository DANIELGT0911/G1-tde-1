package main;

import controller.AutomovelController;
import view.AutomovelView;

public class Main {
    public static void main(String[] args) {
        AutomovelController controller = new AutomovelController();
        AutomovelView view = new AutomovelView(controller);
        view.exibirMenu();
    }
}
