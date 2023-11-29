package Entidades;


import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

//Orcamento.java


public class Orcamento
{
 private LocalDate dataCriacao;
 private Integer garantia;
 private Integer prazo;
 private Float pagamento;
 private Cliente cliente;
 private List<ItemOrcamento> itens;

 public Orcamento(LocalDate dataCriacao, Integer garantia, Integer prazo, Float pagamento, Cliente cliente) {
     this.dataCriacao = dataCriacao;
     this.garantia = garantia;
     this.prazo = prazo;
     this.pagamento = pagamento;
     this.cliente = cliente;
     this.itens = new ArrayList<>();
 }

 public void imprimirOrcamento() {
     System.out.println("Data de criação: " + dataCriacao);
     System.out.println("Garantia: " + garantia);
     System.out.println("Prazo: " + prazo);
     System.out.println("Pagamento: " + pagamento);
     System.out.println("Cliente: " + cliente);
     System.out.println("Itens: ");
     for (ItemOrcamento item : itens) {
         System.out.println(item);
     }
 }

 public LocalDate getDataCriacao() {
     return dataCriacao;
 }

 public void setDataCriacao(LocalDate dataCriacao) {
     this.dataCriacao = dataCriacao;
 }

 public Integer getGarantia() {
     return garantia;
 }

 public void setGarantia(Integer garantia) {
     this.garantia = garantia;
 }

 public Integer getPrazo() {
     return prazo;
 }

 public void setPrazo(Integer prazo) {
     this.prazo = prazo;
 }

 public Float getPagamento() {
     return pagamento;
 }

 public void setPagamento(Float pagamento) {
     this.pagamento = pagamento;
 }

 public Cliente getCliente() {
     return cliente;
 }

 public void setCliente(Cliente cliente) {
     this.cliente = cliente;
 }

 public List<ItemOrcamento> getItens() {
     return Collections.unmodifiableList(itens);
 }

 public void adicionarItem(ItemOrcamento item) {
     this.itens.add(item);
 }

 @Override
 public String toString() {
     return "Orcamento{" +
             "dataCriacao=" + dataCriacao +
             ", garantia=" + garantia +
             ", prazo=" + prazo +
             ", pagamento=" + pagamento +
             ", cliente=" + cliente +
             ", itens=" + itens +
             '}';
 }

 public double calcularValorTotal() {
     return itens.stream().mapToDouble(ItemOrcamento::getValor).sum();
 }
}

