package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //Define que esta classe e uma entidade
@Table(name = "categoria") //Define o nome da tabela

public class Categoria implements Serializable 
{
    @Id //Define a chave primária 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definir como auto increment
    @Column(name = "id", nullable = false) //nullable = false quer dizer que é obrigatório
    private int id;
    
    @Column(name = "descricao", length = 40, nullable = false)
    private String descricao;
    
    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;

    public Categoria() {
    }

    public Categoria(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}

