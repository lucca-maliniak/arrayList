import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class arrayListUI extends JFrame {
    private JPanel painel = new JPanel();
    private JLabel titulo = new JLabel("Aplicativo de Lista de Tarefas");
    private JButton botaoAdd = new JButton("Adicionar tarefa");
    private JButton botaoRemove = new JButton("Remover tarefa");
    private JButton botaoList = new JButton("Listar tarefas");

    public arrayListUI() {
        ArrayList<String> tarefas = new ArrayList<>();
        this.setSize(400, 300);
        this.add(painel);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255, 255, 255));
        painel.add(titulo);
        painel.add(botaoAdd);
        painel.add(botaoRemove);
        painel.add(botaoList);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        botaoAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask(tarefas);
            }
        });
        botaoRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeTask(tarefas);
            }
        });
        botaoList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listTask(tarefas);
            }
        });
    }

    private void addTask(ArrayList<String> tarefas) {
        String tarefa = JOptionPane.showInputDialog("Digite a tarefa para ser adicionada.");
        try {
            if (!tarefa.isEmpty()) {
                tarefas.add(tarefa);
                JOptionPane.showMessageDialog(null, "Tarefa '" + tarefa + "' adicionada com sucesso!");
            }
        } catch (NullPointerException err) {
            JOptionPane.showMessageDialog(null, "Não foi possível adicionar a tarefa!");
        }
    }

    private void removeTask(ArrayList<String> tarefas) {
        String resultado = "";
        boolean removido = false;
        boolean removidoID = false;
        String itemRemovido = "";
        Integer cont = 1;
        if (!tarefas.isEmpty()) {
            for (String elem : tarefas) {
                resultado += cont + "- " + elem + "\n";
                cont++;
            }
            String tarefa = JOptionPane.showInputDialog("Digite a tarefa para ser removida:\n" + resultado);
            if (tarefa.matches("[0-9]+")) {
                int tarefaid = Integer.parseInt(tarefa);
                if (tarefaid <= tarefas.size()) { // verifica se o numero informado existe no array
                    itemRemovido = tarefas.remove(--tarefaid);
                    removidoID = !itemRemovido.isEmpty();
                } else {
                    JOptionPane.showMessageDialog(null, "O índice informado não existe na lista!");
                }
            } else {
                removido = tarefas.remove(tarefa);
            }
            if (removido || removidoID) {
                JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Tarefa informada não foi encontrada!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista está vazia! :(");
        }
    }

    private void listTask(ArrayList<String> tarefas) {
        String resultado = "";
        Integer cont = 1;
        if (!tarefas.isEmpty()) {
            for (String elem : tarefas) {
                resultado += cont + "- " + elem + "\n";
                cont++;
            }
            JOptionPane.showMessageDialog(null, resultado);
        } else {
            JOptionPane.showMessageDialog(null, "Lista está vazia! :(");
        }
    }

    public static void main(String[] args) {
        new arrayListUI();
    }
}