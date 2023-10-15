package br.com.salaodebeleza.dao;

import br.com.salaodebeleza.bank.ConexaoMysql;
import br.com.salaodebeleza.model.ServicoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ServicoDao {
    public void salvar(ServicoModel servico){
        try {
            ConexaoMysql conexaoMysql = new ConexaoMysql();
            Connection conn = conexaoMysql.obterConexao();

            PreparedStatement stmt = null;
            stmt = conn.prepareStatement("INSERT INTO tb_servico(nomeServico, descricao, valor) VALUES (?,?,?)");
            stmt.setString(1, servico.getNomeServico());
            stmt.setString(2, servico.getDescricaoServico());
            stmt.setFloat(3, servico.getValor());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
