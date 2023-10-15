package br.com.salaodebeleza.view;

import br.com.salaodebeleza.dao.ServicoDao;
import br.com.salaodebeleza.model.ServicoModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarServico {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton cadastrarServiçoButton;
    private JLabel descricaoServico;
    private JLabel valor;
    private JLabel nomeServico;
    private JPanel jpPrincipal;


    public CadastrarServico() {
        cadastrarServiçoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServicoDao servicoDao = new ServicoDao();
                ServicoModel servicoModel = new ServicoModel();

                String nome = textField1.getText().trim();
                String descricao = textField2.getText().trim();

                if(nome.isEmpty() && descricao.isEmpty()){/*estou usando o isEmpty para verificar se meu set esá vazio ou não, ele retona verdadeiro se o conjjunto está vazio, caso contrário retorna falso.*/
                    JOptionPane.showMessageDialog(null, "A descrição do produto é obrigatória", "Erro", JOptionPane.ERROR_MESSAGE);
                } else{
                    servicoModel.setNomeServico(nome);
                    servicoModel.setDescricaoServico(descricao);

                    try {
                        servicoDao.salvar(servicoModel);
                        JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                    } catch (HeadlessException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao adicionar produto: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

                    }  
                }
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CadastrarServico");
        frame.setContentPane(new CadastrarServico().jpPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
