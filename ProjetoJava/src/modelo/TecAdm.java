package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class TecAdm extends Funcionario{

	
	public TecAdm() {
		
	}

	public TecAdm(String nome, String cpf, String email, int codigo) {
		super(nome, cpf, email, codigo);
		
	}

	@Override
	public String toString() {
		return "Codigo: " + getCodigo() + "\nNome: " + getNome() + "\nCPF: " + getCpf()
				+ "\nE-mail: " + getEmail();
	}
	
public void CadastrarTecnicoAdm() {
		
		ArrayList TecAdm = new ArrayList();
		
		Scanner tec = new Scanner(System.in);
		Scanner teclado2 = new Scanner(System.in);
		
		int t = 0;
		
		int opcao;
		int opcao2;
		
		do {
    		System.out.println("--------------------------------");
    		System.out.println("\t Técnico Administartivo");
			System.out.println("--------------------------------");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar");
			System.out.println("3 - Editar");
			System.out.println("4 - Remover");
			System.out.println("5 - Voltar");
			System.out.println("--------------------------------");
			System.out.println("Escolha uma das opções acima: ");
			System.out.println("--------------------------------");
			opcao = tec.nextInt();
					
				switch(opcao) {
					
				case 1: 
					TecAdm tecnico = new TecAdm();
					t++;
					tecnico.setCodigo(t);
					System.out.println("Informe o nome: ");
					tecnico.setNome(tec.next());
					tec.nextLine();
					System.out.println("Informe o CPF: ");
					tecnico.setCpf(tec.nextLine());
					System.out.println("Informe o e-mail: ");
					tecnico.setEmail(tec.nextLine());
					
					TecAdm.add(tecnico);
					
					break;
				case 2: 
					if (TecAdm.isEmpty()) {
						
						System.out.println("Nenhuma informação cadastrada!");
						
					}else {
						
					for (int i = 0; i < TecAdm.size(); i++) {
						System.out.println("--------------------------");
						System.out.println("\t Técnico: ");
						System.out.println(TecAdm.get(i).toString());
						System.out.println("---------------------------");
					}
					
					}
					break;
				case 3: 
					if (TecAdm.isEmpty()) {
						
					System.out.println("Nenhuma informação cadastrada!");
					
					}else {
					System.out.println("--------------------------------------------------------");
					System.out.println("Segue abaixo os técnicos cadastrados no sistema: ");
					System.out.println("--------------------------------------------------------");
					for (int i = 0; i < TecAdm.size(); i++) {
						System.out.println("--------------------------");
						System.out.println("\t Técnico:");
						System.out.println(TecAdm.get(i).toString());
						System.out.println("---------------------------");
						
					}
					System.out.println("--------------------------------------------------------");
					System.out.println("Informe o código do técnico para que você possa editar suas informações: ");
					int codTec = tec.nextInt();
					System.out.println("--------------------------------------------------------");
					for (int i = 0; i < TecAdm.size(); i++) {
						
						TecAdm aux2 = (TecAdm) TecAdm.get(i);
						
						if (aux2.getCodigo() == codTec) {
							do {
								System.out.println("----------------------");
								System.out.println("1 - Editar Nome");
								System.out.println("2 - Editar CPF");
								System.out.println("3 - Editar e-mail");
								System.out.println("4 - Voltar");
								System.out.println("----------------------");
								System.out.println("Escolha um dos números acima: ");
								System.out.println("----------------------");
							
								opcao2 = tec.nextInt();
							
								switch(opcao2) {
								
								case 1:
									System.out.println("Nome atual: " + aux2.getNome());
									System.out.println("Digite o novo nome: ");
									aux2.setNome(teclado2.nextLine());
								
									System.out.println("Alterado com sucesso!");
									break;
								case 2:
									System.out.println("CPF atual: " + aux2.getCpf());
									System.out.println("Digite o novo CPF: ");
									aux2.setCpf(teclado2.nextLine());
								
									System.out.println("Alterado com sucesso!");
									break;
								case 3:
									System.out.println("E-mail atual: " + aux2.getEmail());
									System.out.println("Digite a nova matricula: ");
									aux2.setEmail(teclado2.nextLine());
								
									System.out.println("Alterado com sucesso!");
									
									break;										
									}
								
							}while(opcao2 != 4);
						}else {
							System.out.println("Código inválido!");
						}
						
						}
					}
						break;
					
				case 4: 
					if (TecAdm.isEmpty()) {
						System.out.println("Nenhuma informação cadastrada!");
					}else {
					System.out.println("--------------------------------------------------------");	
					System.out.println("Para remover algum técnico, usamos sua identificação no sistema (Codigo) para removê-lo.");
					System.out.println("--------------------------------------------------------");
					System.out.println("Segue abaixo os técnicos cadastrados no sistema: ");
					System.out.println("--------------------------------------------------------");
					for (int i = 0; i < TecAdm.size(); i++) {
						System.out.println("--------------------------");
						System.out.println("\t Professor: ");
						System.out.println(TecAdm.get(i).toString());
						System.out.println("---------------------------");
						
					}
					System.out.println("--------------------------------------------------------");
					System.out.println("Quais dos técnicos apresentados acima você deseja remover? ");
					System.out.println("--------------------------------------------------------");
					System.out.println("Informe o Codigo do técnicos que você deseja remover!");
					int codTec = tec.nextInt();
					
					for (int i = 0; i < TecAdm.size(); i++) {
						
						TecAdm aux = (TecAdm) TecAdm.get(i);
						
						if (aux.getCodigo() == codTec) {
							
							TecAdm.remove(i);
							System.out.println("Removido com sucesso!");
							
						}else {
							System.out.println("Código inválido!");
						}
					}
					
					}
					break;
	}
			}while(opcao != 5);
	}
}
