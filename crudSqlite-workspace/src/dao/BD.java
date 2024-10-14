package dao;

import java.sql.Connection;

import controller.Conexao;

public class BD {
	
	private static Connection connection = null;
	
	public static void main(String[] args) {

		try 
		{
			connection = Conexao.getInstancia().abrirConexao();
			System.out.println("Banco de dados criado com sucesso.");
			Conexao.getInstancia().fecharConexao();
		} 
		catch (Exception e) 
		{
			System.out.println("Erro:" + e.getMessage());
			System.exit(0);
		}
	}
}
