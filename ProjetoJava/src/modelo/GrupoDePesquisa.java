package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class GrupoDePesquisa {
	
	private int codigo;
	private String nome;
	private int qtde_partic;
	private String curso;
	private String tipo_pesquisa;
	private String prof_resp;
	public static ArrayList GrupoDePesquisa = new ArrayList(); //arraylist criado para que as demais classes possam ter acesso a ele
	
	public GrupoDePesquisa(int codigo, String nome, int qtde_partic, String curso, String tipo_pesquisa,
			String prof_resp) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.qtde_partic = qtde_partic;
		this.curso = curso;
		this.tipo_pesquisa = tipo_pesquisa;
		this.prof_resp = prof_resp;
	}

	public GrupoDePesquisa() {
		
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtde_partic() {
		return qtde_partic;
	}

	public void setQtde_partic(int qtde_partic) {
		this.qtde_partic = qtde_partic;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTipo_pesquisa() {
		return tipo_pesquisa;
	}

	public void setTipo_pesquisa(String tipo_pesquisa) {
		this.tipo_pesquisa = tipo_pesquisa;
	}
	
	
	public String getProf_resp() {
		return prof_resp;
	}

	public void setProf_resp(String prof_resp) {
		this.prof_resp = prof_resp;
	}

	public String toString() {
		return "Codigo: " + this.codigo  + "\nNome: " + this.nome + "\nQuantidade de Participantes: " + this.qtde_partic + "\nCurso: " + this.curso
				+ "\nTipo de Pesquisa: " + this.tipo_pesquisa + "\nProfessor responsável: " + this.prof_resp;
	}
	
	public void CadastrarGrupoDePesquisa() {
		
		Scanner teclado = new Scanner(System.in);
		
		Scanner teclado2 = new Scanner(System.in);
		
		int d = 0;
		int opcao;
		int opcao2;
		
		do {
    		System.out.println("--------------------------------");
    		System.out.println("\t Grupor de Pesquisa");
			System.out.println("--------------------------------");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar");
			System.out.println("3 - Editar");
			System.out.println("4 - Remover");
			System.out.println("5 - Voltar");
			System.out.println("--------------------------------");
			System.out.println("Escolha uma das opções acima: ");
			System.out.println("--------------------------------");
			opcao = teclado.nextInt();
					
				switch(opcao) {
					
				case 1: 
					GrupoDePesquisa grupo = new GrupoDePesquisa();
					d++; //contador para gerar o código
					grupo.setCodigo(d);
					System.out.println("Informe o nome do grupo: ");
					grupo.setNome(teclado.next());
					teclado.nextLine();
					System.out.println("Informe a quantidade de participantes do grupo: ");
					grupo.setQtde_partic(teclado.nextInt());
					teclado.nextLine();
					System.out.println("Informe o nome do curso: ");
					grupo.setCurso(teclado.nextLine());
					System.out.println("Informe o tipo de pesquisa: ");
					grupo.setTipo_pesquisa(teclado.nextLine());
					System.out.println("Informe o nome do professor responsável: ");
					grupo.setProf_resp(teclado.nextLine());
					
					GrupoDePesquisa.add(grupo);
					
					break;
				case 2: 
					if (GrupoDePesquisa.isEmpty()) {
						
						System.out.println("Nenhum grupo foi cadastrado!");
						
					}else {
						
					for (int i = 0; i < GrupoDePesquisa.size(); i++) {
						System.out.println("--------------------------");
						System.out.println("\t Grupo De Pesquisa: ");
						System.out.println(GrupoDePesquisa.get(i).toString());
						System.out.println("---------------------------");
					}
					
						}
					break;
				case 3: 
					if (GrupoDePesquisa.isEmpty()) {
						
					System.out.println("Nenhum grupo foi cadastrado!");
					
					}else {
					System.out.println("--------------------------------------------------------");
					System.out.println("Segue abaixo os grupos de pesquisa cadastrados no sistema: ");
					System.out.println("--------------------------------------------------------");
					for (int i = 0; i < GrupoDePesquisa.size(); i++) {
						System.out.println("--------------------------");
						System.out.println("\t Grupo De Pesquisa: ");
						System.out.println(GrupoDePesquisa.get(i).toString());
						System.out.println("---------------------------");
						
					}
					System.out.println("--------------------------------------------------------");
					System.out.println("Informe o código do grupo para que você possa editar suas informações: ");
					int codgrupo = teclado.nextInt();
					System.out.println("--------------------------------------------------------");
					for (int i = 0; i < GrupoDePesquisa.size(); i++) {
						
						GrupoDePesquisa aux = (GrupoDePesquisa) GrupoDePesquisa.get(i);
						
						if (aux.getCodigo() == codgrupo) {
							do {
								System.out.println("----------------------");
								System.out.println("1 - Editar Nome");
								System.out.println("2 - Editar quantidade de participantes");
								System.out.println("3 - Editar curso");
								System.out.println("4 - Editar tipo de pesquisa");
								System.out.println("5 - Editar professor responsável");
								System.out.println("6 - Voltar");
								System.out.println("----------------------");
								System.out.println("Escolha um dos números acima: ");
								System.out.println("----------------------");
							
								opcao2 = teclado.nextInt();
							
								switch(opcao2) {
								
								case 1:
									System.out.println("Nome atual: " + aux.getNome());
									System.out.println("Digite o novo nome: ");
									aux.setNome(teclado2.nextLine());
								
									System.out.println("Alterado com sucesso!");
									break;
								case 2:
									System.out.println("Quantidade de pariticipantes atual: " + aux.getQtde_partic());
									System.out.println("Digite a nova quantidade de participantes: ");
									aux.setQtde_partic(teclado2.nextInt());
								
									System.out.println("Alterado com sucesso!");
									break;
								case 3:
									System.out.println("Curso atual: " + aux.getCurso());
									System.out.println("Digite o novo curso: ");
									aux.setCurso(teclado2.nextLine());
								
									System.out.println("Alterado com sucesso!");
									
									break;
								case 4: 
									System.out.println("Tipo de pesquisa atual: " + aux.getTipo_pesquisa());
									System.out.println("Digite o novo tipo de pesquisa: ");
									aux.setTipo_pesquisa(teclado2.nextLine());
								
									System.out.println("Alterado com sucesso!");
									break;
								case 5: 
									System.out.println("Professor responsável atual: " + aux.getProf_resp());
									System.out.println("Digite o novo professor responsável: ");
									aux.setProf_resp(teclado2.nextLine());
								
									System.out.println("Alterado com sucesso!");
									break;										
									}
								
							}while(opcao2 != 6);
						}
						}
					}
						break;
				case 4: 
					if (GrupoDePesquisa.isEmpty()) {
						System.out.println("Nenhum grupo foi cadastrado!");
					}else {
					System.out.println("--------------------------------------------------------");	
					System.out.println("Para remover algum Grupo De Pesquisa, usamos sua identificação no sistema (Codigo) para removê-lo.");
					System.out.println("--------------------------------------------------------");
					System.out.println("Segue abaixo os Grupos De Pesquisa cadastrados no sistema: ");
					System.out.println("--------------------------------------------------------");
					for (int i = 0; i < GrupoDePesquisa.size(); i++) {
						System.out.println("--------------------------");
						System.out.println("\t Grupo De Pesquisa " + (i + 1) +  ":");
						System.out.println(GrupoDePesquisa.get(i).toString());
						System.out.println("---------------------------");
						
					}
					System.out.println("--------------------------------------------------------");
					System.out.println("Quais dos Grupos De Pesquisa apresentados acima você deseja remover? ");
					System.out.println("--------------------------------------------------------");
					System.out.println("Informe o Codigo do Grupo De Pesquisa que você deseja remover: ");
					int codgrupo2 = teclado.nextInt();
					
					for (int i = 0; i < GrupoDePesquisa.size(); i++) {
						
						GrupoDePesquisa aux2 = (GrupoDePesquisa) GrupoDePesquisa.get(i);
						
						if (aux2.getCodigo() == codgrupo2) {
							
							GrupoDePesquisa.remove(i);
							System.out.println("Removido com sucesso!");
							
						}
					}
					
					}
					break;
		
				}
	
	
			}while(opcao != 5);
		}
}
