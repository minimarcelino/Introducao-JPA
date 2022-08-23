package br.edu.ifsp.pep.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;
    
    @Column(name = "ano_fabricacao", nullable = false)
    private int ano_fabricacao;
    
    @Column(name = "ano_modelo", nullable = false)
    private int ano_modelo;
    
    @Column(name = "data_cadastro", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data_cadastro;
    
    @Column(name = "fabricante", nullable = false, length = 40)
    private String fabricante;
    
    @Column(name = "modelo", nullable = false, length = 40)
    private String modelo;
    
    @Column(name = "tipo_combustivel", nullable = false, length = 40)
    private String tipo_combustivel;
    
    @Column(name = "valor", scale = 2, precision = 6)
    private BigDecimal valor;

    @ManyToMany
    @JoinTable(name = "veiculo_acessorio",
    joinColumns = @JoinColumn(name = "veiculo_codigo"),
    inverseJoinColumns = @JoinColumn(name = "acessorio_codigo"))
    private List<Acessorio> acessorios = new ArrayList();
    
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public int getAno_fabricacao() {
        return ano_fabricacao;
    }

    public void setAno_fabricacao(int ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }

    public int getAno_modelo() {
        return ano_modelo;
    }

    public void setAno_modelo(int ano_modelo) {
        this.ano_modelo = ano_modelo;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(String tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }
    
    
}
