package Entidades;

public class ItemOrcamento {
    private Pedido pedido;

    public ItemOrcamento(String descricao, float valor) {
        this.pedido = new Pedido(descricao, valor);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}