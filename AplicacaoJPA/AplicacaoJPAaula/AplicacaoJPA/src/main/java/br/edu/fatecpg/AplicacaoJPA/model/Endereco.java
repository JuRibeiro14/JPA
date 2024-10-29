package br.edu.fatecpg.AplicacaoJPA.model;

import jakarta.persistence.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cep;
    @Column(name = "Rua")
    private String logradouro;
    @Column(name = "Bairro")
    private String bairro;
    @Column(name = "Cidade")
    private String localidade;
    @Column(name = "Estado")
    private String uf;


    /*public Endereco(String cep, String logradouro, String bairro, String localidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }*/

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "Endereco: " +
                " Cep - " + cep +
                ", " + logradouro +
                ", Bairro - " + bairro +
                ", Cidade - " + localidade +
                ", Estado - " + uf;
    }

}
