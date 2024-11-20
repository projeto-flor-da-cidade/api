package com.flordacidade.api.flor_da_cidade_api.principal;


import com.flordacidade.api.flor_da_cidade_api.model.Organiza;
import com.flordacidade.api.flor_da_cidade_api.service.OrganizaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal implements CommandLineRunner {

    @Autowired
    private OrganizaService organizaService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Listar cadastros");
            System.out.println("2 - Adicionar novo cadastro");
            System.out.println("3 - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o newline

            switch (opcao) {
                case 1:
                    listarCadastros();
                    break;
                case 2:
                    adicionarCadastro(scanner);
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private void listarCadastros() {
        System.out.println("Listando cadastros...");
        organizaService.listarTodos().forEach(organiza -> {
            System.out.println("ID: " + organiza.getSeqOrga() + " | Nome: " + organiza.getNome() + " | Endereço: " + organiza.getEndereco());
        });
    }

    private void adicionarCadastro(Scanner scanner) {
        String nome = "";
        String endereco = "";

        // Loop para garantir que o nome não esteja vazio
        while (nome.isBlank()) {
            System.out.print("Digite o nome (não pode estar vazio): ");
            nome = scanner.nextLine().trim(); // Remove espaços em branco no início e fim
            if (nome.isBlank()) {
                System.out.println("O nome é obrigatório! Tente novamente.");
            }
        }

        // Loop para garantir que o endereço não esteja vazio
        while (endereco.isBlank()) {
            System.out.print("Digite o endereço (não pode estar vazio): ");
            endereco = scanner.nextLine().trim();
            if (endereco.isBlank()) {
                System.out.println("O endereço é obrigatório! Tente novamente.");
            }
        }

        // Cria o objeto Organiza com os valores válidos
        Organiza organiza = new Organiza();
        organiza.setNome(nome);
        organiza.setEndereco(endereco);

        // Salva o cadastro
        organizaService.salvar(organiza);
        System.out.println("Cadastro salvo com sucesso!");
    }

}
