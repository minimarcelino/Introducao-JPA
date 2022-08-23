
import br.edu.ifsp.pep.modelo.Acessorio;
import br.edu.ifsp.pep.modelo.Veiculo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteAcessorioVeiculo 
{
    public static void main(String[] args) {
        
        EntityManager em = Persistence
                .createEntityManagerFactory("Aula01PU")    
                .createEntityManager();
        
        Acessorio roda = new Acessorio();
        roda.setDescricao("Rodas de liga leve");
        
        Acessorio sensor = new Acessorio();
        sensor.setDescricao("Sensores de estacionamento");
        
        Acessorio mp3 = new Acessorio();
        mp3.setDescricao("MP3 Player");
        
        Acessorio pintura = new Acessorio();
        pintura.setDescricao("Pintura metalizada");
        
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setFabricante("VW");
        veiculo1.setModelo("Gol");
        veiculo1.setAno_fabricacao(2018);
        veiculo1.setAno_modelo(2018);
        veiculo1.setValor(new BigDecimal(17.200));
        veiculo1.setTipo_combustivel("Gasolina");
        veiculo1.setData_cadastro(new Date());
        veiculo1.getAcessorios().add(roda);
        veiculo1.getAcessorios().add(mp3);
    
        em.getTransaction().begin();
        
        em.persist(roda);
        em.persist(sensor);
        em.persist(mp3);
        em.persist(pintura);
        
        em.persist(veiculo1);
        
        em.getTransaction().commit();
        
        
        TypedQuery<Veiculo> query = em.createQuery("SELECT v FROM Veiculo v", Veiculo.class);
        List<Veiculo> veiculos = query.getResultList();
        
        for(Veiculo v : veiculos){
            System.out.println("Fabricante: "+v.getFabricante());
            System.out.println("Modelo: "+v.getModelo());
            System.out.println("Ano Fabricação: "+v.getAno_fabricacao());
            System.out.println("Ano Modelo: "+v.getAno_modelo());
            System.out.println("Valor: "+v.getValor());
            System.out.println("Tipo Combustível: "+v.getTipo_combustivel());
            
            //System.out.println("Categoria: "+p.getCategoria().getDescricao());

        }
        
        em.close();
    }
    
    
    
    
}
