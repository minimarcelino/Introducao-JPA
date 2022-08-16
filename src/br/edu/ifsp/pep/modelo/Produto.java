package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //Define que esta classe e uma entidade
@Table(name = "produto") //Define o nome da tabela

public class Produto implements Serializable 
{
    @Id //Define a chave primária 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definir como auto increment
    @Column(name = "id", nullable = false) //nullable = false quer dizer que é obrigatório
    private int id;
    
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    
    @Column(name = "preco", precision = 8, scale = 2, nullable = false)
    private BigDecimal preco;

    @JoinColumn(name = "categoria_id", nullable = false)
    @ManyToOne
    private Categoria categoria;
    
    public Produto() {
    }

    public Produto(int id, String descricao, int quantidade, BigDecimal preco) {
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}
