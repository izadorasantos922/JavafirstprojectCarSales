import javax.swing.JOptionPane;

public class Venda {

    private Carro carro;
    private Cliente cliente;

    public void realizarVenda() {
        this.carro = new Carro();
        carro.cadastrarCarro();

        this.cliente = new Cliente();
        cliente.cadastrarCliente();

        double parcela = this.carro.getValorVenda() / 36;

        if (validarVenda(parcela, this.cliente.getRenda())) {
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!\n" + gerarResumoVenda(parcela));
        } else {
            JOptionPane.showMessageDialog(null, "Venda NÃO realizada. O valor da parcela excede 30% da renda do cliente.\n" + gerarResumoVenda(parcela));
        }
    }

    public boolean validarVenda(double valorParcela, double renda) {
        double valorReferencia = renda * 0.3;

        return valorParcela < valorReferencia;
    }

    public String gerarResumoVenda(double parcela) {
        String resumo = "Resumo da Venda:\n";
        resumo += "\n--- Cliente ---\n" + cliente.imprimirResumoCliente();
        resumo += "\n--- Carro ---\n" + carro.imprimirResumoCarro();
        resumo += "\n--- Detalhes da Venda ---\n";
        resumo += String.format("Valor da Parcela: R$ %.2f\n", parcela);
        resumo += String.format("Limite de Parcela (30%% da Renda): R$ %.2f\n", cliente.getRenda() * 0.3);
        return resumo;
    }
}
