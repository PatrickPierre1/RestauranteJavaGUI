package com.unialfa;

public class Sobremesa {
    private String descricao;
    private Float valor;

    public Sobremesa(String descricao, Float valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return descricao + " - R$"+ valor;
    }
}
