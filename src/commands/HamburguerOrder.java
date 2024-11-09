package commands;

import model.Kitchen;

public class HamburguerOrder implements OrderCommand {
    private Kitchen kitchen;
    private String lastAction = "";

    public HamburguerOrder(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public void execute() {
        kitchen.prepararHamburguer();
        lastAction = "executado";
    }

    @Override
    public void undo() {
        System.out.println("Cancelando pedido de hambúrguer");
        lastAction = "cancelado";
    }
}