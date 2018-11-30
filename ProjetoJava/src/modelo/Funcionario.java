package modelo;

public abstract class Funcionario {
	
		private int codigo;
		private String nome;
		private String cpf;
		private String email;


		public Funcionario(String nome, String cpf, String email, int codigo){

			this.nome = nome;
			this.cpf = cpf;
			this.email = email;
			this.codigo = codigo;
		}

		public Funcionario() {

		}
		

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getNome(){

			return nome;
		}

		public void setNome(String nome){

			this.nome = nome;

		}
		public String getCpf(){

			return cpf;
		}


		public void setCpf(String cpf){

			this.cpf = cpf;

		}

		public String getEmail(){

			return email;
		}


		public void setEmail(String email){

			this.email = email;

		}

		public String toString() {
				return "Nome: " + this.nome + ", CPF: " + this.cpf + ", e-mail " + this.email;
			}
		

	}
