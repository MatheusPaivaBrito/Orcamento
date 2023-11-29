// Orcamento.java
package Entidades;

import Interfaces.Imprimivel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Orcamento extends Documento implements Imprimivel {
    private LocalDate dataCriacao;
    private int garantia;
    private int prazo;
    private float pagamento;
    private Cliente cliente;
    private List<ItemOrcamento> itens;

    public Orcamento(LocalDate dataCriacao, int garantia, int prazo, float pagamento, Cliente cliente) {
        super(cliente.getNome());
        this.dataCriacao = dataCriacao;
        this.garantia = garantia;
        this.prazo = prazo;
        this.pagamento = pagamento;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public float getPagamento() {
        return pagamento;
    }

    public void setPagamento(float pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemOrcamento> getItens() {
        return itens;
    }

    public void adicionarItem(ItemOrcamento item) {
        itens.add(item);
    }

    public double calcularValorTotal() {
        return itens.stream().mapToDouble(item -> item.getPedido().getValor()).sum();
    }

    public double calcularTotalOrcamento() {
        double valorItens = calcularValorTotal();
        return valorItens + (valorItens * (pagamento / 100.0));
    }

    @Override
    public void imprimir() {
        System.out.println("===== Detalhes do Orçamento =====");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Data de Criação: " + dataCriacao);
        System.out.println("Garantia: " + garantia + " meses");
        System.out.println("Prazo de Pagamento: " + prazo + " dias");
        System.out.println("Tributação em porcentagem: " + pagamento + "%");

        System.out.println("===== Itens do Orçamento =====");
        System.out.println("Descrição \t\t Valor");
        for (ItemOrcamento item : itens) {
            Pedido pedido = item.getPedido();
            System.out.printf("%-20s \t %.2f\n", pedido.getDescricao(), pedido.getValor());
        }

        System.out.println("===== Resumo do Orçamento =====");
        System.out.println("Valor Total dos Itens: " + calcularValorTotal());
        System.out.println("Total do Orçamento: " + calcularTotalOrcamento());
        System.out.println();
    }
}