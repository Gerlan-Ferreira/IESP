package modelo;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Professor extends Funcionario {
	
	private String matricula;
	private String turma;
	
	
	public Professor(String nome, String cpf, String email, String matricula, int codigo, String turma) {
		super(nome, cpf, email, codigo);
		this.matricula = matricula;
		this.turma = turma;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Professor() {
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String toString() {
		return "Código: " + getCodigo() + "\nNome: " + getNome() + "\nMatricula: " + this.matricula + "\nTurma: " + this.turma + "\nCPF: " + getCpf()
				+ "\nE-mail: " + getEmail();
	}
	
	public void CadastrarProfessor() {
		
		ArrayList Professor = new ArrayList();
		
		Scanner tec = new Scanner(System.in);
		Scanner teclado2 = new Scanner(System.in);
		
		int p = 0;
		
		int opcao;
		int opcao2;
		
		do {
    		System.out.println("--------------------------------");
    		System.out.println("\t Professor");
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
					Professor prof = new Professor();
					p++;
					prof.setCodigo(p);
					System.out.println("Informe o nome: ");
					prof.setNome(tec.next());
					tec.nextLine();
					System.out.println("Informe a matricula: ");
					prof.setMatricula(tec.nextLine());
					System.out.println("Informe a turma: ");
					prof.setTurma(tec.nextLine());
					System.out.println("Informe o CPF: ");
					prof.setCpf(tec.nextLine());
					System.out.println("Informe o e-mail: ");
					prof.setEmail(tec.nextLine());
					
					Professor.add(prof);
					
					break;
				case 2: 
					if (Professor.isEmpty()) {
						
						System.out.println("Nenhuma informação cadastrada!");
						
					}else {
						
					for (int i = 0; i < Professor.size(); i++) {
						System.out.println("--------------------------");
						System.out.println("\t Professor: ");
						System.out.println(Professor.get(i).toString());
						System.out.println("---------------------------");
					}
					
					}
					break;
				case 3: 
					if (Professor.isEmpty()) {
						
					System.out.println("Nenhuma informação cadastrada!");
					
					}else {
					System.out.println("--------------------------------------------------------");
					System.out.println("Segue abaixo os professores cadastrados no sistema: ");
					System.out.println("--------------------------------------------------------");
					for (int i = 0; i < Professor.size(); i++) {
						System.out.println("--------------------------");
						System.out.println("\t Professor:");
						System.out.println(Professor.get(i).toString());
						System.out.println("---------------------------");
						
					}
					System.out.println("--------------------------------------------------------");
					System.out.println("Informe o código do professor para que você possa editar suas informações: ");
					int codProf = tec.nextInt();
					System.out.println("--------------------------------------------------------");
					for (int i = 0; i < Professor.size(); i++) {
						
						Professor aux2 = (Professor) Professor.get(i);
						
						if (aux2.getCodigo() == codProf) {
							do {
								System.out.println("----------------------");
								System.out.println("1 - Editar Nome");
								System.out.println("2 - Editar CPF");
								System.out.println("3 - Editar e-mail");
								System.out.println("4 - Editar matricula");
								System.out.println("5 - Editar turma");
								System.out.println("6 - Voltar");
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
								case 4: 
									System.out.println("Matricula atual: " + aux2.getMatricula());
									System.out.println("Digite a nova matricula: ");
									aux2.setMatricula(teclado2.nextLine());
								
									System.out.println("Alterado com sucesso!");
									break;
								case 5: 
									System.out.println("Turma atual: " + aux2.getTurma());
									System.out.println("Digite a nova turma: ");
									aux2.setTurma(teclado2.nextLine());
								
									System.out.println("Alterado com sucesso!");
									break;										
									}
								
							}while(opcao2 != 6);
						}else {
							System.out.println("Código inválido!");
						}
						
						}
					}
						break;
					
				case 4: 
					if (Professor.isEmpty()) {
						System.out.println("Nenhuma informação cadastrada!");
					}else {
					System.out.println("--------------------------------------------------------");	
					System.out.println("Para remover algum professor, usamos sua identificação no sistema (Codigo) para removê-lo.");
					System.out.println("--------------------------------------------------------");
					System.out.println("Segue abaixo os professores cadastrados no sistema: ");
					System.out.println("--------------------------------------------------------");
					for (int i = 0; i < Professor.size(); i++) {
						System.out.println("--------------------------");
						System.out.println("\t Professor: ");
						System.out.println(Professor.get(i).toString());
						System.out.println("---------------------------");
						
					}
					System.out.println("--------------------------------------------------------");
					System.out.println("Quais dos professores apresentados acima você deseja remover? ");
					System.out.println("--------------------------------------------------------");
					System.out.println("Informe o Codigo do professor que você deseja remover!");
					int codProfe = tec.nextInt();
					
					for (int i = 0; i < Professor.size(); i++) {
						
						Professor aux = (Professor) Professor.get(i);
						
						if (aux.getCodigo() == codProfe) {
							
							Professor.remove(i);
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
