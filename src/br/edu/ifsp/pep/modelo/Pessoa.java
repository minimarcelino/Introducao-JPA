package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

@Entity //Define que esta classe e uma entidade
@Table(name = "pessoa", uniqueConstraints = {
@UniqueConstraint(name = "UniqueLogradouroAndNumero",
        columnNames = {"logradouro", "numero"}),
@UniqueConstraint(name = "UniqueEmail",
        columnNames = "email")
}) //Define o nome da tabela
public class Pessoa implements Serializable 
{
    @Id //Define a chave primária 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Definir como auto increment
    @Column(name = "codigo", nullable = false) //nullable = false quer dizer que é obrigatório
    private Long codigo;
    
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    
    @Column(name = "email", nullable = false) //unique = true não pode ter dado igual, duplicado
    private String email;
    
    @Column(name = "logradouro", nullable = false)
    private String logradouro;
    
    @Column(name = "numero", nullable = false)
    private Integer numero;
    
    @Column(name = "salario") //precision = 8, scale = 2
    //private BigDecimal salario; //da pra especificar a quantidade de casas
    //trocou o tipo do atributo tem que mudar a configuração para apagar e criar nova tabela
    private Double salario;
    
    @Column(name = "data_nascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    public Pessoa(){
        
    }
    
    public Pessoa(String nome, Double salario, Date dataNascimento) {
        this.nome = nome;
        this.salario = salario;
        this.dataNascimento = dataNascimento;
    }
    
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
    
    
    
    
}
