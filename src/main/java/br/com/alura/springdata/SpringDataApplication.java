package br.com.alura.springdata;

import java.util.Scanner;

import br.com.alura.springdata.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringDataApplication implements CommandLineRunner {

	private Boolean system = true;

	@Autowired
	private CrudCargo crudCargo;

	@Autowired
	private Relatorios relatorios;

	@Autowired
	private CrudFuncionario crudFuncionario;

	@Autowired
	private CrudUnidadeTrabalho crudUnidadeTrabalho;

	@Autowired
	private RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;


	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual função deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatorios");
			System.out.println("5 - Relatorio dinamico");


			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					crudCargo.inicial(scanner);
					break;
				case 2:
					crudFuncionario.inicial(scanner);
					break;
				case 3:
					crudUnidadeTrabalho.inicial(scanner);
					break;
				case 4:
					relatorios.inicial(scanner);
					break;
				case 5:
					relatorioFuncionarioDinamico.inicial(scanner);
					break;
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}
	}
}