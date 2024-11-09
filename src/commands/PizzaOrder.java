package commands;

import model.Kitchen;

public class PizzaOrder implements OrderCommand {
    private Kitchen kitchen;
    private String lastAction = "";

    public PizzaOrder(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public void execute() {
        kitchen.prepararPizza();
        lastAction = "executado";
    }

    @Override
    public void undo() {
        System.out.println("Cancelando pedido de pizza");
        lastAction = "cancelado";
    }
}