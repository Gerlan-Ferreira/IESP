package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Projeto {
	
	private int codigo;
	private String titulo;
	private String descricao;
	private int carga_horaria;
	private String grupo_pesquisa;
	
	public Projeto(int codigo, String titulo, String descricao, int carga_horaria, String grupo_pesquisa) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.carga_horaria = carga_horaria;
		this.grupo_pesquisa = grupo_pesquisa;
	}
	
	public Projeto() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getGrupo_pesquisa() {
		return grupo_pesquisa;
	}

	public void setGrupo_pesquisa(String grupo_pesquisa) {
		this.grupo_pesquisa = grupo_pesquisa;
	}

	public int getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(int carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return "C�digo: " + this.codigo +  "\nT�tulo do Projeto: " + this.titulo + "\nDescri��o do projeto: " + this.descricao + "\nCarga horaria: " + this.carga_horaria
				+ "\nGrupo de pesquisa: " + this.grupo_pesquisa;
	}

	public void CadastraProjeto() {
		
		Scanner teclado = new Scanner(System.in);
		
		Scanner teclado2 = new Scanner(System.in);
		
		ArrayList Projeto = new ArrayList();
		
		ArrayList GrupoDePesquisa = new ArrayList();
		
		int pj = 0;
		int opcao;
		int opcao2;
		
		if (GrupoDePesquisa.isEmpty()) {
    		System.out.println("Nenhum grupo de pesquisa cadastrado at� o momento. \n"
    				+ "Logo voc� n�o pode cadastrar um projeto sem um grupo de pesquisa.");
    		
    	}else {
    		
    		do {
	    		System.out.println("--------------------------------");
	    		System.out.println("\t Projetos");
				System.out.println("--------------------------------");
				System.out.println("1 - Cadastrar");
				System.out.println("2 - Listar");
				System.out.println("3 - Editar");
				System.out.println("4 - Remover");
				System.out.println("5 - Voltar");
				System.out.println("--------------------------------");
				System.out.println("Escolha uma das op��es acima: ");
				System.out.println("--------------------------------");
				opcao = teclado.nextInt();
						
					switch(opcao) {
						
					case 1: 
						Projeto projetos = new Projeto();
						pj++;
						projetos.setCodigo(pj);
						System.out.println("Informe o t�tulo do projeto: ");
						projetos.setTitulo(teclado.next());
						teclado.nextLine();
						System.out.println("Informe a descri��o do projeto: ");
						projetos.setDescricao(teclado.nextLine());
						System.out.println("Informe a carga hor�ria: ");
						projetos.setCarga_horaria(teclado.nextInt());
						System.out.println("A qual grupo de pesquisa mostrado abaixo se refere esse projeto? ");
						
						for (int i = 0; i < GrupoDePesquisa.size(); i ++) {
							
							System.out.println("------------------------------------");
							System.out.println("Grupo de Pesquisa: ");
							System.out.println(GrupoDePesquisa.get(i).toString());
							System.out.println("------------------------------------");
							
						}
						System.out.println("Informe o nome do grupo de pesquisa que voc� deseja vincular o seu projeto: ");
						projetos.setGrupo_pesquisa(teclado2.nextLine());
						
						Projeto.add(projetos);
						
						break;
					case 2: 
						if (Projeto.isEmpty()) {
							
							System.out.println("Nenhum projeto foi cadastrado!");
							
						}else {
							
						for (int i = 0; i < Projeto.size(); i++) {
							System.out.println("--------------------------");
							System.out.println("\t Projeto: ");
							System.out.println(Projeto.get(i).toString());
							System.out.println("---------------------------");
						}
						
						}	
						break;
					case 3: 
						if (Projeto.isEmpty()) {
							
						System.out.println("Nenhum projeto foi cadastrado!");
						
						}else {
						System.out.println("--------------------------------------------------------");
						System.out.println("Segue abaixo os Projetos cadastrados no sistema: ");
						System.out.println("--------------------------------------------------------");
						for (int i = 0; i < Projeto.size(); i++) {
							System.out.println("--------------------------");
							System.out.println("\t Projeto:");
							System.out.println(Projeto.get(i).toString());
							System.out.println("---------------------------");
							
						}
						System.out.println("--------------------------------------------------------");
						System.out.println("Informe o c�digo do Projeto para que voc� possa editar suas informa��es: ");
						int codProj = teclado.nextInt();
						System.out.println("--------------------------------------------------------");
						for (int i = 0; i < Projeto.size(); i++) {
							
							Projeto aux = (Projeto) Projeto.get(i);
							
							if (aux.getCodigo() == codProj) {
								do {
									System.out.println("----------------------");
									System.out.println("1 - Editar T�tulo");
									System.out.println("2 - Editar Descri��o");
									System.out.println("3 - Editar Carga hor�ria");
									System.out.println("4 - Editar Grupo de Pesquisa");
									System.out.println("5 - Voltar");
									System.out.println("----------------------");
									System.out.println("Escolha um dos n�meros acima: ");
									System.out.println("----------------------");
								
									opcao2 = teclado.nextInt();
								
									switch(opcao2) {
									
									case 1:
										System.out.println("T�tulo atual: " + aux.getTitulo());
										System.out.println("Digite o novo t�tulo: ");
										aux.setTitulo(teclado2.nextLine());
									
										System.out.println("Alterado com sucesso!");
										break;
									case 2:
										System.out.println("Descri��o atual: " + aux.getDescricao());
										System.out.println("Digite a nova descri��o: ");
										aux.setDescricao(teclado2.nextLine());
									
										System.out.println("Alterado com sucesso!");
										break;
									case 3:
										System.out.println("Carga hor�ria atual: " + aux.getCarga_horaria());
										System.out.println("Digite a nova carga hor�ria: ");
										aux.setCarga_horaria(teclado2.nextInt());
									
										System.out.println("Alterado com sucesso!");
										
										break;
									case 4: 
										System.out.println("Grupo de pesquisa atual: " + aux.getGrupo_pesquisa());
										System.out.println("Digite a novo grupo de pesquisa: ");
										aux.setGrupo_pesquisa(teclado2.nextLine());
									
										System.out.println("Alterado com sucesso!");
										break;										
										}
									
								}while(opcao2 != 5);
							}else {
								System.out.println("C�digo inv�lido!");
							}
							
							}
						}
							break;
					case 4: 
						if (Projeto.isEmpty()) {
							System.out.println("Nenhuma projeto foi cadastrado!");
						}else {
						System.out.println("--------------------------------------------------------");	
						System.out.println("Para remover algum Projeto, usamos sua identifica��o no sistema (Codigo) para remov�-lo.");
						System.out.println("--------------------------------------------------------");
						System.out.println("Segue abaixo os Projeto cadastrados no sistema: ");
						System.out.println("--------------------------------------------------------");
						for (int i = 0; i < Projeto.size(); i++) {
							System.out.println("--------------------------");
							System.out.println("\t Projeto: ");
							System.out.println(Projeto.get(i).toString());
							System.out.println("---------------------------");
							
						}
						System.out.println("--------------------------------------------------------");
						System.out.println("Quais dos Projetos apresentados acima voc� deseja remover? ");
						System.out.println("--------------------------------------------------------");
						System.out.println("Informe o Codigo do Projeto que voc� deseja remover!");
						int codProj2 = teclado.nextInt();
						
						for (int i = 0; i < Projeto.size(); i++) {
							
							Projeto aux2 = (Projeto) Projeto.get(i);
							
							if (aux2.getCodigo() == codProj2) {
								
								Projeto.remove(i);
								System.out.println("Removido com sucesso!");
								
							}else {
								System.out.println("C�digo inv�lido!");
							}
						}
						
						}
						break;
		
						}
	
    		}while(opcao != 5);
    	}
	}
	
	public void AprovarEncerrarProjeto() {
		
		ArrayList Projeto = new ArrayList();
		
		Scanner teclado = new Scanner (System.in);
		
		int esc;
		
    	if (Projeto.isEmpty()) {
    		System.out.println("Nenhum projeto foi cadastrado!");
    	}else {
		do {
		System.out.println("-----------------------");
    	System.out.println("1 - Aprovar projeto");
    	System.out.println("2 - Encerrar projeto");
    	System.out.println("3 - Voltar");
    	System.out.println("-----------------------");
    	System.out.println("Escolha uma das op��es: ");
    	esc = teclado.nextInt();
    	System.out.println("-----------------------");
    	switch(esc) {
    	case 1: 
			System.out.println("Segue abaixo os Projetos cadastrados no sistema: ");
			System.out.println("--------------------------------------------------------");
			for (int i = 0; i < Projeto.size(); i++) {
				
				System.out.println("--------------------------");
				System.out.println("\t Projeto:");
				System.out.println(Projeto.get(i).toString());
				System.out.println("---------------------------");
				
			}
			System.out.println("--------------------------------------------------------");
			System.out.println("Informe o c�digo do Projeto para que voc� deseja aprovar: ");
			int codProj = teclado.nextInt();
			for (int i = 0; i < Projeto.size(); i++) {
				
				Projeto aux2 = (Projeto) Projeto.get(i);
				
				if (aux2.getCodigo() == codProj) {
					System.out.println("O projeto " + aux2.getTitulo() + " foi APROVADO!!!");
				}else {
					System.out.println("C�digo inv�lido!");
				}
			}
    		break;
    	case 2: 
    		System.out.println("Segue abaixo os Projetos cadastrados no sistema: ");
			System.out.println("--------------------------------------------------------");
			for (int i = 0; i < Projeto.size(); i++) {
				
				System.out.println("--------------------------");
				System.out.println("\t Projeto:");
				System.out.println(Projeto.get(i).toString());
				System.out.println("---------------------------");
				
			}
			System.out.println("--------------------------------------------------------");
			System.out.println("Informe o c�digo do Projeto para que voc� deseja encerrar: ");
			int codProj2 = teclado.nextInt();
			for (int i = 0; i < Projeto.size(); i++) {
				
				Projeto aux3 = (Projeto) Projeto.get(i);
				
				if (aux3.getCodigo() == codProj2) {
					System.out.println("O projeto " + aux3.getTitulo() + " foi ENCERRADO!!!");
				}else {
					System.out.println("C�digo inv�lido!");
				}	
			}
			
    		break;
    	}
    	}while(esc != 3);
    	}
	}
}
