package com.unialfa;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaInicial extends JFrame{
    private JComboBox<Prato> dropdownPratos;
    private JComboBox<Bebida> dropdownBebidas;
    private JComboBox<Sobremesa> dropdownSobremesas;
    private JButton buttonPedir;
    private String pedidoNome;
    public TelaInicial() {
        setTitle("Cardápio Online");
        setSize(1000,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        var painel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,5,5,5);

        var labelTitulo = new JLabel("Escolha seus pratos suas Bebidas e suas sobremesas");
        constraints.gridx = 1;
        constraints.gridy = 0;
        Font fonteTamanhoNovo = new Font( "Serif", Font.PLAIN, 20);
        labelTitulo.setFont(fonteTamanhoNovo);
        painel.add(labelTitulo, constraints);

        //String[] pratosPrincipais = {"Arroz Carreteiro - R$18,00","Strogonoff - R$21,00","Lasanha - R$24,00","Risoto - R$15,00","Yaksoba - R$19,00","Carne de Panela c/ Arroz - R$29,00"};
        //dropdownPratos.setModel(new DefaultComboBoxModel<String>(listaPratos.toArray(new Prato("Lasanha", 21F))));
        //String[] pratosPrincipais = (String[]) listaPratos.toArray();

        var listaPratos = Arrays.asList(
                new Prato("Strogonoff", 21.99F),
                new Prato("Risoto",15.59F),
                new Prato("Yakisoba",19.39F),
                new Prato("Arroz Carreteiro",18.99F),
                new Prato("Carne de Panela c/ Arroz",29.19F),
                new Prato("Lasanha", 24.99F)
        );

        dropdownPratos = new JComboBox<Prato>();
        listaPratos.forEach(s -> dropdownPratos.addItem(s));
        constraints.gridx = 0;
        constraints.gridy = 1;
        dropdownPratos.setVisible(true);
        painel.add(dropdownPratos,constraints);

        //String[] bebidas = {"Coca-cola - R$ 7,00","Tubaina 1,5L - R$ 10,00"," Guaraná 2L - R$ 13,00"};
        //dropdownBebidas = new JComboBox<String>(bebidas);

        var listaBebidas = Arrays.asList(
                new Bebida("Coca-cola 1L", 7.99F),
                new Bebida("Tubaina 1,5L",9.99F),
                new Bebida("Guaraná 2L",12.99F)
        );

        dropdownBebidas = new JComboBox<Bebida>();
        listaBebidas.forEach(s -> dropdownBebidas.addItem(s));
        constraints.gridx = 1;
        constraints.gridy = 1;
        dropdownBebidas.setVisible(true);
        painel.add(dropdownBebidas,constraints);

        //String[] sobremesas = {"Pudim - R$ 8,00","Mini Pizza Sorvete - R$ 16,00","Gelatina Abacaxi - R$ 5,00","Churros - R$ 7.00","Bolo de vó - R$ 3,00","Petit Gateau - R$ 14,00"};
        //dropdownSobremesas = new JComboBox<String>(sobremesas);

        var listaSobremesas = Arrays.asList(
                new Sobremesa("Pudim", 7.99F),
                new Sobremesa("Mini Pizza Sorvete",15.99F),
                new Sobremesa("Gelatina Abacaxi",4.99F),
                new Sobremesa("Churros",6.99F),
                new Sobremesa("Bolo de vó",3.99F),
                new Sobremesa("Petit Gateau", 13.99F)
        );

        dropdownSobremesas = new JComboBox<Sobremesa>();
        listaSobremesas.forEach(s -> dropdownSobremesas.addItem(s));

        constraints.gridx = 2;
        constraints.gridy = 1;
        dropdownSobremesas.setVisible(true);
        painel.add(dropdownSobremesas,constraints);

        buttonPedir = new JButton("Pedir");
        buttonPedir.addActionListener(e-> executarAcaoBotao());
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 4;
        painel.add(buttonPedir,constraints);

        add(painel);
        setLocationRelativeTo(null);

    }
    public JComboBox<Prato> getDropdownPratos() {
        return dropdownPratos;
    }
    public JComboBox<Bebida> getDropdownBebidas() {
        return dropdownBebidas;
    }
    public JComboBox<Sobremesa> getDropdownSobremesas() {
        return dropdownSobremesas;
    }
    private void executarAcaoBotao() {
        Prato prato = (Prato) dropdownPratos.getSelectedItem();
        Bebida bebida = (Bebida) dropdownBebidas.getSelectedItem();
        Sobremesa sobremesa = (Sobremesa) dropdownSobremesas.getSelectedItem();

        pedidoNome = "Prato: " + prato.getDescricao() + " \nBebida: " + bebida.getDescricao() + " \nSobremesa: " + sobremesa.getDescricao()  + "\n";

        double taxa = 0.1;
        float pedidoValorTotal = prato.getValor() + bebida.getValor() + sobremesa.getValor();

        var telapagamento = new TelaPagamento();


        telapagamento.telaPagamento(pedidoNome, pedidoValorTotal);

        System.out.println(pedidoNome);
        System.out.println(pedidoValorTotal);
    }
}

