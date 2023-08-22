package controller;
import model.*;
import java.util.List;
import java.util.Scanner;

public class EstudanteController {

    private EstudanteDAO estudanteDAO;
    Estudante estudante;

    private Scanner scanner;

    public EstudanteController() {

        estudanteDAO = new EstudanteDAO();
        scanner = new Scanner(System.in);

    }

    public void adicionarEstudante() {
        System.out.println("Informe os dados do estudante:");

        System.out.print("Número de Matrícula: ");
        int nrMatricula = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Apelido: ");
        String apelido = scanner.nextLine();

        System.out.print("Contacto: ");
        String contacto = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Estudante estudante = new Estudante(nrMatricula, nome, apelido, contacto, endereco);
        estudanteDAO.adicionar(estudante);

        System.out.println("Estudante adicionado com sucesso!");
    }

    public void buscarEstudante() {
        System.out.print("Digite o numero de Matricula: ");
        int nrMatricula = scanner.nextInt();
        System.out.println(estudanteDAO.buscar(nrMatricula));
    }

    public void  listarEstudantes() {
        //Usando o foreach
        /*
        for (Estudante estudante: estudanteDAO.listar()) {
            System.out.println(estudante.toString());
        }*/

        //Usando o Lambda

        estudanteDAO.listar().forEach(estudante -> System.out.println(estudante.toString()));
    }
    //Vou adicionar um comentario so para explicar o commit


public void lista(int matricula){

    int opcao;
    do {
        System.out.println("Menu:");
        System.out.println("O que deseja actualizar????");
        System.out.println("1. Nr Matricula");
        System.out.println("2. Nome");
        System.out.println("3. Apelido");
        System.out.println("4.Contacto");
        System.out.println("5. Endereco");
        System.out.println("6. Nr Matricula & Nome");
        System.out.println("7.  Apelido & Contacto");
        System.out.println("8. Apelido,Nome,Apelido,Contacto,Endereco");
        System.out.println("0. Menu Principal");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        switch (opcao) {
            case 1:nrMatNovo( matricula); break;
            case 2:NomeNovo( matricula); break;
            case 3:novoApelido( matricula); break;
            case 4:Contacto(matricula); break;
            case 5:endereco(matricula);  break;
            case 6: nrMat_Nome( matricula);break;
            case 7: Apelido_Contacto(matricula);break;
            case 8: actualizarTodos(matricula);break;
            case 0: System.out.println("Encerrando o programa...");break;
            default: System.out.println("Opção inválida.");
        }
    } while (opcao != 0);

}

    public void removerEstudante() {

        System.out.println("Digite a Matricula do estudante que deseja remover");
        int matricula=scanner.nextInt();
        estudanteDAO.remover(matricula);
    }





public  void actualizarEstudante() {
    System.out.println("Informe o Numero da Matricula do estudante que deseja actualizar:");

    System.out.print("Número de Matrícula: ");
    int nrMatricula = scanner.nextInt();

    estudanteDAO.verificar(nrMatricula);
   lista(nrMatricula);
}
    public void nrMatNovo(int mat) {
        System.out.println("Actualize o NeMatricula");
        int nrMt = scanner.nextInt();
        estudanteDAO.actualizarnrMat(nrMt, mat);



    }
    public void NomeNovo(int mat) {
        System.out.println("Actualize o nome");
        String NovoNome = scanner.nextLine();
        estudanteDAO.actualizar(NovoNome, mat);



}
    public void novoApelido(int mat) {
        System.out.println("Actualize o Apelido");
        String novoApelido = scanner.nextLine();
        estudanteDAO.actualizarApelido(novoApelido, mat);


    }
    public void Contacto(int mat) {
        System.out.println("Actualize o Contacto");
        String novoContacto = scanner.nextLine();
        estudanteDAO.actualizarContacto(novoContacto, mat);


    }
    public void endereco(int mat) {
        System.out.println("Actualize o Endereco");
        String novoEndereco = scanner.nextLine();
        estudanteDAO.actualizarContacto(novoEndereco, mat);


    }
    public void nrMat_Nome(int mat) {
        NomeNovo( mat);
        nrMatNovo( mat);

    }
    public void Apelido_Contacto(int mat) {

        Contacto( mat);
        novoApelido( mat);

    }
    public void actualizarTodos(int mat) {
        endereco( mat);
        Apelido_Contacto( mat);
        nrMat_Nome( mat);


    }



/*
public void deseja(){
    System.out.println("Deseja Actualizar mais  Alguma coisa??\n1.Sim\n2.Nao");
    int opcao=scanner.nextInt();

    switch (opcao){
        case 1: break;
    }
}
*/

    }



