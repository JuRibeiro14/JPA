package br.edu.fatecpg.Aplicacao.JPA.model;
import jakarta.persistence.*;
@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;

    public Aluno (String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
    public Aluno(){

    }
}