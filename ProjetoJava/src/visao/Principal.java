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
		System.out.println("Sistema de gerenciamento de projetos de inicia��o do IESP");
		System.out.println("---------------------------------------------------------");
		System.out.println("Entre com usu�rio e senha para acessar o sistema!!");
		System.out.print("Usuario = ");
		user = teclado.nextLine();
		System.out.print("Senha = ");
		password = teclado.nextLine();
		
		if (login.getUsuario().equals(user) == true && login.getSenha().equals(password) == true ) { //verifica��o do login
			
		do {
			System.out.println("--------------------------------");
			System.out.println("\t Seja bem-vindo!!!");
			System.out.println("--------------------------------");
			System.out.println("\t M�dulo Coordenador");
		    System.out.println("--------------------------------");
		    System.out.println("1 - Cadastrar Funcionario");
		    System.out.println("2 - Cadastrar Grupos de Pesquisa");
		    System.out.println("3 - Cadastrar Projetos");
		    System.out.println("4 - Aprovar/Encerrar projetos de pesquisa");
		    System.out.println("5 - Gerar declara��es");
		    System.out.println("6 - Encerrar");
		    System.out.println("--------------------------------");
		    System.out.println("Escolha uma das op��es acima: ");
		    System.out.println("--------------------------------");
		
		    opcao = teclado.nextInt();
		    
		    switch(opcao) {
		    
		    case 1:
		    	
		    	do {
		    		System.out.println("---------------------------");
		    		System.out.println("1 - Professor");
		    		System.out.println("2 - T�cnico Administrativo");
		    		System.out.println("3 - Voltar");
		    		System.out.println("---------------------------");
		    		System.out.println("Escolha uma das op��es acima: ");
		    		opcao2 = teclado.nextInt();
		    		
		    		switch(opcao2) {
		    		
		    		case 1: 
		    			professor.CadastrarProfessor();//Nesse m�todo a toda a parte de cadastro, edi��o e remo��o de Professores
		    			break;
		    		case 2: 
		    			tecnico.CadastrarTecnicoAdm();//Nesse m�todo a toda a parte de cadastro, edi��o e remo��o de Tec.Administrativo
		    			break;
		    		}
		    		
		    	}while(opcao2 != 3);
		    	
		    	break;
		    	
		    case 2:
		    	
		    	grupo.CadastrarGrupoDePesquisa();//Nesse m�todo a toda a parte de cadastro, edi��o e remo��o de grupos de pesquisa
		    	
		    	break;
		    	
		    case 3:
		    	
		    	projeto.CadastraProjeto();//Nesse m�todo a toda a parte de cadastro, edi��o e remo��o de projetos de pesquisa
		    	
		    	break;
		    
		    case 4:
		    	
		    	projeto.AprovarEncerrarProjeto();//Nesse m�todo a toda a parte de aprova��o ou encerramento de projetos
		    	
		    	break;
		    	
		    case 5:
		    	System.out.println("======================");
		    	System.out.println("Gerar declara��o");
		    	System.out.println("======================");
		    	try {
		    		String local = "declara��o.txt"; //nome do arquivo .txt que ser� salvo na pasta raiz do projeto
		    		FileWriter arq = new FileWriter(local);
		    		BufferedWriter escrever = new BufferedWriter(arq);
		    		Professor prof3 = new Professor();
		    		Projeto p1 = new Projeto();
		    		Date data = new Date();
		    		System.out.println("================================================================================");
		    		System.out.println("Para que possa gerar a declara��o preciso de algumas informa��es que s�o elas: ");
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
		    		System.out.println("Declara��o gerada com sucesso!!!");
		    		escrever.write("\t \t \t \t \t \t \t \t DECLARA��O DE PARTICIPA��O"); //inserindo dados no arquivo .txt que ser� gerado
		    		escrever.newLine(); escrever.newLine(); escrever.newLine();//pulando linha no .txt
		    		escrever.write("Declaramos que " + prof3.getNome() + " de matr�cula " + prof3.getMatricula() + " inscrito no CPF: " + prof3.getCpf() + " participou do projeto de pesquisa " + p1.getTitulo());
		    		escrever.write(", com carga hor�ria equivalente a " + p1.getCarga_horaria() + " horas aula.");
		    		escrever.newLine(); escrever.newLine(); escrever.newLine();escrever.newLine();
		    		escrever.write("\t \t \t \t \t________________________________________________________");
		    		escrever.newLine();
		    		escrever.write("\t \t \t \t \t \t \tAssinatura do Coordenador");
		    		escrever.newLine();escrever.newLine();
		    		escrever.write("\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t Cabedelo, " + data.getDate() + " de Novembro de 2018.");
		    		escrever.flush(); //libera escrever no arquivo
		    		escrever.close(); //fechando a fun��o de gerar o .txt
		    		arq.close(); //fechando a fun��o de gerar o .txt
		    		
		    	}catch (IOException erro){
		    		System.out.println("Erro ao gravar o arquivo!!!"); //captura de erro caso n�o consiga salvar o txt
		    	}
		    	break;
		    }
		
	}while(opcao != 6);
	
}else {
	System.out.println("usuario ou senha inv�lidos. Tente novamente!");
}
		}while(login.getUsuario().equals(user) == false || login.getSenha().equals(password) == false );//verifica��o do login
}
}
