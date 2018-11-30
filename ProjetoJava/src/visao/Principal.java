package visao;

import modelo.*;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Principal {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Professor professor = new Professor();
		TecAdm tecnico = new TecAdm();
		GrupoDePesquisa grupo = new GrupoDePesquisa();
		Projeto projeto = new Projeto();
		Login login = new Login();
		
		String user;
		String password;
		
		int opcao; //controle do menu
		int opcao2;
		
		do {
		System.out.println("---------------------------------------------------------");
		System.out.println("Sistema de gerenciamento de projetos de iniciação do IESP");
		System.out.println("---------------------------------------------------------");
		System.out.println("Entre com usuário e senha para acessar o sistema!!");
		System.out.print("Usuario = ");
		user = teclado.nextLine();
		System.out.print("Senha = ");
		password = teclado.nextLine();
		
		if (login.getUsuario().equals(user) == true && login.getSenha().equals(password) == true ) { //verificação do login
			
		do {
			System.out.println("--------------------------------");
			System.out.println("\t Seja bem-vindo!!!");
			System.out.println("--------------------------------");
			System.out.println("\t Módulo Coordenador");
		    System.out.println("--------------------------------");
		    System.out.println("1 - Cadastrar Funcionario");
		    System.out.println("2 - Cadastrar Grupos de Pesquisa");
		    System.out.println("3 - Cadastrar Projetos");
		    System.out.println("4 - Aprovar/Encerrar projetos de pesquisa");
		    System.out.println("5 - Gerar declarações");
		    System.out.println("6 - Encerrar");
		    System.out.println("--------------------------------");
		    System.out.println("Escolha uma das opções acima: ");
		    System.out.println("--------------------------------");
		
		    opcao = teclado.nextInt();
		    
		    switch(opcao) {
		    
		    case 1:
		    	
		    	do {
		    		System.out.println("---------------------------");
		    		System.out.println("1 - Professor");
		    		System.out.println("2 - Técnico Administrativo");
		    		System.out.println("3 - Voltar");
		    		System.out.println("---------------------------");
		    		System.out.println("Escolha uma das opções acima: ");
		    		opcao2 = teclado.nextInt();
		    		
		    		switch(opcao2) {
		    		
		    		case 1: 
		    			professor.CadastrarProfessor();//Nesse método a toda a parte de cadastro, edição e remoção de Professores
		    			break;
		    		case 2: 
		    			tecnico.CadastrarTecnicoAdm();//Nesse método a toda a parte de cadastro, edição e remoção de Tec.Administrativo
		    			break;
		    		}
		    		
		    	}while(opcao2 != 3);
		    	
		    	break;
		    	
		    case 2:
		    	
		    	grupo.CadastrarGrupoDePesquisa();//Nesse método a toda a parte de cadastro, edição e remoção de grupos de pesquisa
		    	
		    	break;
		    	
		    case 3:
		    	
		    	projeto.CadastraProjeto();//Nesse método a toda a parte de cadastro, edição e remoção de projetos de pesquisa
		    	
		    	break;
		    
		    case 4:
		    	
		    	projeto.AprovarEncerrarProjeto();//Nesse método a toda a parte de aprovação ou encerramento de projetos
		    	
		    	break;
		    	
		    case 5:
		    	System.out.println("======================");
		    	System.out.println("Gerar declaração");
		    	System.out.println("======================");
		    	try {
		    		String local = "declaração.txt"; //nome do arquivo .txt que será salvo na pasta raiz do projeto
		    		FileWriter arq = new FileWriter(local);
		    		BufferedWriter escrever = new BufferedWriter(arq);
		    		Professor prof3 = new Professor();
		    		Projeto p1 = new Projeto();
		    		Date data = new Date();
		    		System.out.println("================================================================================");
		    		System.out.println("Para que possa gerar a declaração preciso de algumas informações que são elas: ");
		    		System.out.println("================================================================================");
		    		System.out.println("Nome do professor: ");
		    		prof3.setNome(teclado.next() + teclado.nextLine());
		    		System.out.println("Matricula do professor: ");
		    		prof3.setMatricula(teclado.nextLine());
		    		System.out.println("CPF do professor: ");
		    		prof3.setCpf(teclado.nextLine());
		    		System.out.println("Titulo do projeto de pesquisa: ");
		    		p1.setTitulo(teclado.nextLine());
		    		System.out.println("Carga horaria do projeto: ");
		    		p1.setCarga_horaria(teclado.nextInt());
		    		System.out.println("Declaração gerada com sucesso!!!");
		    		escrever.write("\t \t \t \t \t \t \t \t DECLARAÇÃO DE PARTICIPAÇÃO"); //inserindo dados no arquivo .txt que será gerado
		    		escrever.newLine(); escrever.newLine(); escrever.newLine();//pulando linha no .txt
		    		escrever.write("Declaramos que " + prof3.getNome() + " de matrícula " + prof3.getMatricula() + " inscrito no CPF: " + prof3.getCpf() + " participou do projeto de pesquisa " + p1.getTitulo());
		    		escrever.write(", com carga horária equivalente a " + p1.getCarga_horaria() + " horas aula.");
		    		escrever.newLine(); escrever.newLine(); escrever.newLine();escrever.newLine();
		    		escrever.write("\t \t \t \t \t________________________________________________________");
		    		escrever.newLine();
		    		escrever.write("\t \t \t \t \t \t \tAssinatura do Coordenador");
		    		escrever.newLine();escrever.newLine();
		    		escrever.write("\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t Cabedelo, " + data.getDate() + " de Novembro de 2018.");
		    		escrever.flush(); //libera escrever no arquivo
		    		escrever.close(); //fechando a função de gerar o .txt
		    		arq.close(); //fechando a função de gerar o .txt
		    		
		    	}catch (IOException erro){
		    		System.out.println("Erro ao gravar o arquivo!!!"); //captura de erro caso não consiga salvar o txt
		    	}
		    	break;
		    }
		
	}while(opcao != 6);
	
}else {
	System.out.println("usuario ou senha inválidos. Tente novamente!");
}
		}while(login.getUsuario().equals(user) == false || login.getSenha().equals(password) == false );//verificação do login
}
}
