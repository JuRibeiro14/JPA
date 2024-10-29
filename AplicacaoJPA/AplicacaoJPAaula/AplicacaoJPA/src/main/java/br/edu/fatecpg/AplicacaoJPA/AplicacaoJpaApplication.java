package br.edu.fatecpg.AplicacaoJPA;

import br.edu.fatecpg.AplicacaoJPA.model.ConsomeApi;
import br.edu.fatecpg.AplicacaoJPA.model.Endereco;
import br.edu.fatecpg.AplicacaoJPA.repository.EnderecoRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AplicacaoJpaApplication implements CommandLineRunner {
	@Autowired
	private EnderecoRepository repositorio;
	public static void main(String[] args) {
		SpringApplication.run(AplicacaoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Gson gson = new Gson();


		while (true) {
			System.out.println("\n1. Consultar CEP");
			System.out.println("2. Listar CEPs Consultados");
			System.out.println("3. Sair");
			System.out.print("Escolha uma opção: ");
			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
				case 1 -> {
					ConsomeApi consomeApi = new ConsomeApi();
					System.out.print("Cep: ");
					String cep = scanner.nextLine();
					String json = consomeApi.responseHttp(cep);
					Endereco endereco = gson.fromJson(json, Endereco.class);
					Endereco cepDuplicado = repositorio.findByCep(endereco.getCep());
					if (cepDuplicado != null) {
						System.out.println("Este CEP já foi cadastrado!");
					} else {
						repositorio.save(endereco);
						System.out.println("Endereço cadastrado!");
					}


				}
				case 2 -> {
					Endereco endereco = new Endereco();
					List<Endereco> enderecos = repositorio.findAll();
					enderecos.forEach(System.out::println);
				}
				case 3 -> {
					System.out.println("Saindo...");
					return;
				}
				default -> System.out.println("Opção inválida.");
			}
		}
	}

}

