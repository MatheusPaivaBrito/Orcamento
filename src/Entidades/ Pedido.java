package Entidades;

import Interfaces.Imprimivel;

public class Pedido implements Imprimivel {
    private String descricao;
    private float valor;

    public Pedido(String descricao, float valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public void imprimir() {
        System.out.println("Pedido - Descrição: " + descricao + ", Valor: " + valor);
    }
}
