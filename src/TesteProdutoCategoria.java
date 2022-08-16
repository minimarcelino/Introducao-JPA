
import br.edu.ifsp.pep.modelo.Categoria;
import br.edu.ifsp.pep.modelo.Produto;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteProdutoCategoria 
{
    public static void main(String[] args) {
        
        EntityManager em = Persistence
                .createEntityManagerFactory("Aula01PU")    
                .createEntityManager();
        
        
        Categoria categoria = new Categoria();
        categoria.setDescricao("Informática");
    
        Produto produto = new Produto();
        produto.setDescricao("Teclado");
        produto.setPreco(new BigDecimal(60.0));
        produto.setQuantidade(100);
        produto.setCategoria(categoria);
    
        em.getTransaction().begin();
        
        em.persist(categoria);
        em.persist(produto);
        
        em.getTransaction().commit();
        
        //JPQL
        //sempre pensar em classe
        //SELECT p FROM Produto p
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
        List<Produto> produtos = query.getResultList();
        
        for(Produto p : produtos){
            System.out.println("Descrição: "+p.getDescricao());
            System.out.println("Categoria: "+p.getCategoria().getDescricao());

        }
        
        em.close();
    }
}
