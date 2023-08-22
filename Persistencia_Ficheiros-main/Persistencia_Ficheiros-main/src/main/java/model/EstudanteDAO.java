package model;


import controller.EstudanteController;
import sun.applet.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EstudanteDAO {
EstudanteController controlar;
    private static final String ARQUIVO_ESTUDANTES = "estudantes.dat";


    public void adicionar(Estudante estudante) {


        List<Estudante> estudantes = listar();
        estudantes.add(estudante);

        salvarListaEstudantes(estudantes);
    }

    public Estudante buscar(int nrMatricula) {
        List<Estudante> estudantes = listar();
        // Estudante não encontrado
        for (Estudante estudante : estudantes) {
            if (estudante.getNrMatricula() == nrMatricula) {



                return estudante;

            }
        }

        return null; // Estudante não encontrado
    }
    public List<Estudante> listar() {
        File file = new File(ARQUIVO_ESTUDANTES);
        if (!file.exists()) {
            criarArquivo();
        }

        List<Estudante> estudantes = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ARQUIVO_ESTUDANTES))) {
            estudantes = (List<Estudante>) inputStream.readObject();


        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ocorreu um erro na leitura do arquivo.");
        }

        return estudantes;
    }




    /*    List<Estudante> estudantes = listar();

        for (int i = 0; i < estudantes.size(); i++) {
            Estudante estudante = estudantes.get(i);
            if (estudante.getNrMatricula() == estudanteAtualizado.getNrMatricula()) {




                estudantes.set(i, estudanteAtualizado);
                break;
            }
        }

        salvarListaEstudantes(estudantes);*/



    public void remover(int nrMatricula) {
        List<Estudante> estudantes = listar();

        estudantes.removeIf(estudante -> estudante.getNrMatricula() == nrMatricula);
        System.out.println("Removido com sucesso");
        salvarListaEstudantes(estudantes);

    }

    private void salvarListaEstudantes(List<Estudante> estudantes) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ARQUIVO_ESTUDANTES))) {
            outputStream.writeObject(estudantes);

        } catch (IOException e) {
            System.out.println("Ocorreu um erro na gravação do arquivo.");
        }
    }

    private void criarArquivo() {
        try {
            File file = new File(ARQUIVO_ESTUDANTES);
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro na criação do arquivo.");
        }
    }



    public void verificar(int nrMatricula){
        List<Estudante> estudantes = listar();
        for(int i=0;i<estudantes.size();i++){
        if (estudantes.get(i).getNrMatricula() == nrMatricula) {

            System.out.println(estudantes.get(i).toString());
        }
        }
    }
        public void actualizar(String Nome, int nrMatricula){
            List<Estudante> estudantes = listar();
        for (int i = 0; i < estudantes.size(); i++) {
if(estudantes.get(i).getNrMatricula() == nrMatricula){

            estudantes.get(i).setNome(Nome);
            System.out.println("Actualizado com sucesso");
            salvarListaEstudantes(estudantes);
        }}


    }
    public void actualizarApelido(String apelido, int nrMatricula){
        List<Estudante> estudantes = listar();
        for (int i = 0; i < estudantes.size(); i++) {
            if(estudantes.get(i).getNrMatricula() == nrMatricula){

                estudantes.get(i).setApelido(apelido);
                System.out.println("Actualizado com sucesso");
                salvarListaEstudantes(estudantes);
            }}


    }
    public void actualizarContacto(String Contacto, int nrMatricula){
        List<Estudante> estudantes = listar();
        for (int i = 0; i < estudantes.size(); i++) {
            if(estudantes.get(i).getNrMatricula() == nrMatricula){

                estudantes.get(i).setContacto(Contacto);
                System.out.println("Actualizado com sucesso");
                salvarListaEstudantes(estudantes);
            }}


    }
    public void actualizarnrMat(int nrMt, int nrMatricula){
        List<Estudante> estudantes = listar();
        for (int i = 0; i < estudantes.size(); i++) {
            if(estudantes.get(i).getNrMatricula() == nrMatricula){

                estudantes.get(i).setNrMatricula(nrMt);
                System.out.println("Actualizado com sucesso");
                salvarListaEstudantes(estudantes);
            }}


    }
    public void actualizarEndereco(String endereco, int nrMatricula){
        List<Estudante> estudantes = listar();
        for (int i = 0; i < estudantes.size(); i++) {
            if(estudantes.get(i).getNrMatricula() == nrMatricula){

                estudantes.get(i).setEndereco(endereco);
                System.out.println("Actualizado com sucesso");
                salvarListaEstudantes(estudantes);
            }}


    }
}



