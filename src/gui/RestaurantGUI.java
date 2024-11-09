package gui;

import model.Kitchen;
import commands.OrderCommand;
import commands.HamburguerOrder;
import commands.PizzaOrder;
import history.OrderHistory;

import javax.swing.*;
import java.awt.*;

public class RestaurantGUI {
    private Kitchen kitchen;
    private OrderHistory history;
    private JTextArea orderStatus;

    public RestaurantGUI() {
        this.kitchen = new Kitchen();
        this.history = new OrderHistory();

        // Configuração da janela
        JFrame frame = new JFrame("Sistema de Pedidos do Restaurante");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Área de status
        orderStatus = new JTextArea(10, 40);
        orderStatus.setEditable(false);
        orderStatus.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(orderStatus);
        mainPanel.add(scrollPane);

        // Painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton hamburgerButton = new JButton("Pedir Hambúrguer");
        JButton pizzaButton = new JButton("Pedir Pizza");
        JButton undoButton = new JButton("Cancelar Último Pedido");

        // Eventos dos botões
        hamburgerButton.addActionListener(e -> executeOrder(new HamburguerOrder(kitchen)));
        pizzaButton.addActionListener(e -> executeOrder(new PizzaOrder(kitchen)));
        undoButton.addActionListener(e -> undoLastOrder());

        buttonPanel.add(hamburgerButton);
        buttonPanel.add(pizzaButton);
        buttonPanel.add(undoButton);

        mainPanel.add(buttonPanel);

        // Configuração final da janela
        frame.getContentPane().add(mainPanel);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void executeOrder(OrderCommand command) {
        command.execute();
        history.push(command);
        updateStatus("Novo pedido realizado");
    }

    private void undoLastOrder() {
        if (!history.isEmpty()) {
            OrderCommand command = history.pop();
            command.undo();
            updateStatus("Último pedido cancelado");
        } else {
            updateStatus("Não há pedidos para cancelar");
        }
    }

    private void updateStatus(String message) {
        orderStatus.append(message + "\n");
    }
}