package com.unialfa;

import javax.swing.*;
import java.awt.*;

public class TelaSucesso extends JFrame {
    public void telaSucesso(String tipoPagamento, Float pedidoTotal) {
        var painel = new JPanel(new GridBagLayout());
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,5,5,5);

        var labelRealizado = new JLabel("Pagamento Realizado!");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painel.add(labelRealizado, constraints);

        var labelPagamento = new JLabel("Forma de Pagamento:  " + tipoPagamento);
        constraints.gridx = 0;
        constraints.gridy = 2;
        painel.add(labelPagamento, constraints);

        var labelValor = new JLabel("Valor Pago: " + pedidoTotal + " reais");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painel.add(labelValor, constraints);

        add(painel);
        setVisible(true);
    }
}
