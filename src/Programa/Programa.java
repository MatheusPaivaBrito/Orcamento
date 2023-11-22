package Programa;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

import Entidades.Orcamento;
import Entidades.Cliente;
import Entidades.ItemOrcamento;

//Programa.java
//add classe abstrata, interface
public class Programa {
 private static List<Orcamento> orcamentos = new ArrayList<>();
 private static Scanner scanner = new Scanner(System.in);

 public static void main(String[] args) {
     int opcao;
     do {
         exibirMenu();
         opcao = scanner.nextInt();

         switch (opcao) {
             case 1:
                 adicionarOrcamento();
                 break;
             case 2:
                 excluirOrcamento();
                 break;
             case 3:
                 alterarOrcamento();
                 break;
             case 4:
                 listarOrcamentos();
                 break;
             case 5:
                 ordenarOrcamentos();
                 break;
             case 0:
                 System.out.println("Saindo do programa. Até mais!");
                 break;
             default:
                 System.out.println("Opção inválida. Tente novamente.");
         }
     } while (opcao != 0);
 }

 private static void exibirMenu() {
     System.out.println("===== Menu =====");
     System.out.println("1. Adicionar Orçamento");
     System.out.println("2. Excluir Orçamento");
     System.out.println("3. Alterar Orçamento");
     System.out.println("4. Listar Orçamentos");
     System.out.println("5. Ordenar Orçamentos");
     System.out.println("0. Sair");
     System.out.print("Escolha uma opção: ");
 }

 private static void adicionarOrcamento() {
     System.out.println("===== Adicionar Orçamento =====");

     // Capturar dados do cliente
     System.out.print("Nome do Cliente: ");
     String nomeCliente = scanner.nextLine();

     System.out.print("Endereço do Cliente: ");
     String enderecoCliente = scanner.nextLine();

     Cliente cliente = new Cliente(nomeCliente, enderecoCliente);

     // Capturar dados do orçamento
     System.out.print("Garantia (em meses): ");
     int garantia = scanner.nextInt();

     System.out.print("Prazo de Pagamento (em dias): ");
     int prazo = scanner.nextInt();

     System.out.print("Condições de Pagamento: ");
     float pagamento = scanner.nextFloat();

     System.out.print("Data de Criação (AAAA-MM-DD): ");
     String dataCriacaoStr = scanner.next();
     LocalDate dataCriacao = LocalDate.parse(dataCriacaoStr);

     Orcamento novoOrcamento = new Orcamento(dataCriacao, garantia, prazo, pagamento, cliente);

     // Adicionar itens ao orçamento
     System.out.println("===== Adicionar Itens ao Orçamento =====");
     char adicionarItem;
     do {
         System.out.print("Descrição do Item: ");
         String descricaoItem = scanner.next();

         System.out.print("Valor do Item: ");
         float valorItem = scanner.nextFloat();

         novoOrcamento.adicionarItem(new ItemOrcamento(descricaoItem, valorItem));

         System.out.print("Deseja adicionar outro item? (S para Sim, N para Não): ");
         adicionarItem = scanner.next().charAt(0);
     } while (adicionarItem == 'S' || adicionarItem == 's');

     // Adicionar o novo orçamento à lista
     orcamentos.add(novoOrcamento);
     System.out.println("Orçamento adicionado com sucesso!");
 }

 private static void excluirOrcamento() {
     System.out.println("===== Excluir Orçamento =====");

     if (orcamentos.isEmpty()) {
         System.out.println("Não há orçamentos para excluir.");
         return;
     }

     // Listar os orçamentos disponíveis
     listarOrcamentos();

     System.out.print("Digite o número do orçamento que deseja excluir: ");
     int indice = scanner.nextInt();

     if (indice >= 0 && indice < orcamentos.size()) {
         orcamentos.remove(indice);
         System.out.println("Orçamento removido com sucesso!");
     } else {
         System.out.println("Índice inválido. Nenhum orçamento removido.");
     }
 }

 private static void alterarOrcamento() {
     System.out.println("===== Alterar Orçamento =====");

     if (orcamentos.isEmpty()) {
         System.out.println("Não há orçamentos para alterar.");
         return;
     }

     // Listar os orçamentos disponíveis
     listarOrcamentos();

     System.out.print("Digite o número do orçamento que deseja alterar: ");
     int indice = scanner.nextInt();

     if (indice >= 0 && indice < orcamentos.size()) {
         // Obter o orçamento selecionado
         Orcamento orcamentoSelecionado = orcamentos.get(indice);

         // Exibir informações do orçamento
         System.out.println("Informações do Orçamento a ser alterado:");
         orcamentoSelecionado.imprimirOrcamento();

         // Capturar novos dados para o orçamento
         System.out.println("===== Atualizar Dados do Orçamento =====");

         System.out.print("Garantia (em meses): ");
         orcamentoSelecionado.setGarantia(scanner.nextInt());

         System.out.print("Prazo de Pagamento (em dias): ");
         orcamentoSelecionado.setPrazo(scanner.nextInt());

         System.out.print("Condições de Pagamento: ");
         orcamentoSelecionado.setPagamento(scanner.nextFloat());

         // Atualizar itens do orçamento
         orcamentoSelecionado.getItens().clear(); // Limpar os itens existentes

         System.out.println("===== Adicionar Itens Atualizados ao Orçamento =====");
         char adicionarItem;
         do {
             System.out.print("Descrição do Item: ");
             String descricaoItem = scanner.next();

             System.out.print("Valor do Item: ");
             float valorItem = scanner.nextFloat();

             orcamentoSelecionado.adicionarItem(new ItemOrcamento(descricaoItem, valorItem));

             System.out.print("Deseja adicionar outro item? (S para Sim, N para Não): ");
             adicionarItem = scanner.next().charAt(0);
         } while (adicionarItem == 'S' || adicionarItem == 's');

         System.out.println("Orçamento alterado com sucesso!");
     } else {
         System.out.println("Índice inválido. Nenhum orçamento alterado.");
     }
 }

 private static void listarOrcamentos() {
     System.out.println("===== Listar Orçamentos =====");

     if (orcamentos.isEmpty()) {
         System.out.println("Não há orçamentos para listar.");
     } else {
         for (int i = 0; i < orcamentos.size(); i++) {
             System.out.println("Orçamento #" + i);
             orcamentos.get(i).imprimirOrcamento();
             System.out.println();
         }
     }
 }

 private static void ordenarOrcamentos() {
     System.out.println("===== Ordenar Orçamentos =====");

     if (orcamentos.isEmpty()) {
         System.out.println("Não há orçamentos para ordenar.");
         return;
     }

     System.out.println("1. Ordenar por Data de Criação");
     System.out.println("2. Ordenar por Valor Total");
     System.out.print("Escolha uma opção: ");

     int opcaoOrdenacao = scanner.nextInt();

     switch (opcaoOrdenacao) {
         case 1:
             Collections.sort(orcamentos, Comparator.comparing(Orcamento::getDataCriacao));
             break;
         case 2:
             Collections.sort(orcamentos, Comparator.comparingDouble(Orcamento::calcularValorTotal));
             break;
         default:
             System.out.println("Opção inválida. Nenhum orçamento ordenado.");
             return;
     }

     System.out.println("Orçamentos ordenados com sucesso!");
 }
}