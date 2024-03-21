package com.unialfa;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TelaPagamento extends JFrame{
    private String tipoPagamento;
    private JButton buttonPagar;

    public void telaPagamento(String pedidoNome, Float pedidoValorTotal) {
        var painel = new JPanel(new GridBagLayout());
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,5,5,5);

        var labelTitulo = new JLabel("Faça o pagamento!");
        constraints.gridx = 1;
        constraints.gridy = 0;
        painel.add(labelTitulo, constraints);

        var labelPedido = new JLabel(pedidoNome);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painel.add(labelPedido, constraints);

        var random = new Random();
        int mesa = random.nextInt(5) + 1;

        var labelMesa = new JLabel(String.valueOf("Pedido na mesa: "+ mesa));
        constraints.gridx = 1;
        constraints.gridy = 2;
        painel.add(labelMesa, constraints);

        JCheckBox checkBoxPix = new JCheckBox("Pix");
        constraints.gridx = 1;
        constraints.gridy = 3;
        painel.add(checkBoxPix,constraints);

        checkBoxPix.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                tipoPagamento = "Pix";
            } else {
                tipoPagamento = "";
            }
        });

        JCheckBox checkBoxCartao = new JCheckBox("Cartão");
        constraints.gridx = 2;
        constraints.gridy = 3;
        painel.add(checkBoxCartao,constraints);

        checkBoxCartao.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                tipoPagamento = "Cartão";
            } else {
                tipoPagamento = "";
            }
        });

        JCheckBox checkBoxDinheiro = new JCheckBox("Dinheiro");
        constraints.gridx = 3;
        constraints.gridy = 3;
        painel.add(checkBoxDinheiro,constraints);

        checkBoxDinheiro.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                tipoPagamento = "Dinheiro";
            } else {
                tipoPagamento = "";
            }
        });


        var labelPedidoValorTotal = new JLabel( "R$: "+ String.valueOf(pedidoValorTotal));
        constraints.gridx = 1;
        constraints.gridy = 4;
        painel.add(labelPedidoValorTotal, constraints);

        buttonPagar = new JButton("Pagar");
        buttonPagar.addActionListener(e -> executarPagamento(pedidoValorTotal));
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridwidth = 4;
        painel.add(buttonPagar,constraints);

        add(painel);

        setVisible(true);
    }
    public void executarPagamento(Float pedidoTotal) {
        var telaNova = new TelaSucesso();
        telaNova.telaSucesso(tipoPagamento, pedidoTotal);
    }
}
