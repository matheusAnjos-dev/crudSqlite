package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {
	
	private static final String[] colunas = {
			"ID", "Nome", "CPF/CNPJ", "Email", "Telefone", "Endereco"
		};
	private ArrayList<Cliente> clientes;
	
	public ModeloTabela(ArrayList<Cliente> clientes) {
		super();
		this.clientes = clientes;
	}
	
	@Override
	public int getRowCount() {
		
		return clientes.size(); // a quantidade de linhas será a quantidade de clientes na lista
		
	}

	@Override
	public int getColumnCount() {
		
		return colunas.length; // será o tamanho do array colunas
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Cliente cliente = clientes.get(rowIndex);
		
		if(columnIndex == 0) {
			return cliente.getId();
		}else
			if(columnIndex == 1) {
				return cliente.getNome();
			}else
				if(columnIndex == 2) {
					return cliente.getCpfCnpj();
				}else
					if(columnIndex == 3) {
						return cliente.getEmail();
					}else
						if(columnIndex == 4) {
							return cliente.getTelefone();
						}else
							if(columnIndex == 5) {
								return cliente.getEndereco();
							}else {
								return null;
							}

	}

	@Override
	public String getColumnName(int column) {

		return colunas[column];
	}
	

}
