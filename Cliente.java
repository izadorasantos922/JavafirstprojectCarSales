import javax.swing.JOptionPane;

public class Cliente {

    private int id;
    private String nome;
    private int idade;
    private double renda;

    public int validarIdade() {
        int idade = 0;
        boolean entradaValida = false;
        do {
            try {
                idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do cliente (deve ser maior ou igual a 18):"));
                if (idade < 18) {
                    JOptionPane.showMessageDialog(null, "Idade inválida. O cliente deve ter 18 anos ou mais.");
                } else {
                    entradaValida = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.");
            }
        } while (!entradaValida);
        return idade;
    }

    public double validarRenda() {
        double renda = 0;
        boolean entradaValida = false;
        do {
            try {
                renda = Double.parseDouble(JOptionPane.showInputDialog("Digite a renda do cliente (deve ser positiva):"));
                if (renda <= 0) {
                    JOptionPane.showMessageDialog(null, "Renda inválida. O valor deve ser maior que zero.");
                } else {
                    entradaValida = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.");
            }
        } while (!entradaValida);
        return renda;
    }

    public void cadastrarCliente() {
        this.id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do cliente"));
        this.nome = JOptionPane.showInputDialog("Digite o nome do cliente");
        this.idade = validarIdade();
        this.renda = validarRenda();
    }

    public String imprimirResumoCliente() {
        return String.format(
            "Cliente:\nID: %d\nNome: %s\nIdade: %d\nRenda: R$ %.2f",
            this.id, this.nome, this.idade, this.renda
        );
    }

    public double getRenda() {
        return this.renda;
    }
}
