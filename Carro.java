import javax.swing.JOptionPane;

public class Carro {

    private int id;
    private String modelo;
    private double quilometragem;
    private double valorVenda;

    public void cadastrarCarro() {
        this.id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do carro"));
        this.modelo = JOptionPane.showInputDialog("Digite o modelo do carro");
        this.quilometragem = Double.parseDouble(JOptionPane.showInputDialog("Digite a quilometragem do carro"));
        this.valorVenda = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de venda do carro"));
    }

    public String imprimirResumoCarro() {
        String msg = "Id: " + this.id + "\n";
        msg += "Modelo: " + this.modelo + "\n";
        msg += "Quilometragem: " + this.quilometragem + "\n";
        msg += "Valor Venda: " + this.valorVenda;
        return msg;
    }

    public void atualizarValorDesconto(double percentualDesconto) {
        this.valorVenda -= this.valorVenda * (percentualDesconto / 100);
    }

    public double getValorVenda() {
        return this.valorVenda;
    }
}
