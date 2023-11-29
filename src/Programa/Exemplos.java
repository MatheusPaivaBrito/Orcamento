package Programa;

import Entidades.Cliente;
import Entidades.ItemOrcamento;
import Entidades.Orcamento;

import java.time.LocalDate;
import java.util.List;

public class Exemplos {

    public static void criarOrcamentosDefault(List<Orcamento> orcamentos) {
        // Exemplo 1
        Cliente cliente1 = new Cliente("Jorge Vacilão", "Rua de ninguem te chamou");
        Orcamento orcamento1 = new Orcamento(
                LocalDate.now(),
                12,
                30,
                5.0f,
                cliente1
        );
        orcamento1.adicionarItem(new ItemOrcamento("Bota", 100.0f));
        orcamento1.adicionarItem(new ItemOrcamento("Meia", 150.0f));
        orcamentos.add(orcamento1);

        // Exemplo 2
        Cliente cliente2 = new Cliente("Tiquinho Damassa", "Rua da quebrada");
        Orcamento orcamento2 = new Orcamento(
                LocalDate.now().minusDays(5),
                10,
                20,
                7.5f,
                cliente2
        );
        orcamento2.adicionarItem(new ItemOrcamento("coisas licitas", 200.0f));
        orcamento2.adicionarItem(new ItemOrcamento("giz branco", 120.0f));
        orcamentos.add(orcamento2);
    }
}