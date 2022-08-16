
import br.edu.ifsp.pep.modelo.Pessoa;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal 
{
    public static void main(String[] args) 
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Aula01PU");
        
        Pessoa pessoa = new Pessoa("Vivi", null, new Date());
        //Pessoa pessoa = new Pessoa();
//        pessoa.setDataNascimento(new Date());
//        pessoa.setNome("Vivi");
//        pessoa.setSalario(1000.99); //double ou casas decimais
          pessoa.setEmail("minimarcelino23");
          pessoa.setLogradouro("Manaus");
          pessoa.setNumero(12);
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin(); //inicia a transação
        
        //em.persist(pessoa); //insert
        em.merge(pessoa); //update se o objeto existir, senão faz o insert
                
        em.getTransaction().commit(); //finaliza a transação
    }
}
