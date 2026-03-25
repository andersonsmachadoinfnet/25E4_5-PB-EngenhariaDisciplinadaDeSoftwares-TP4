package br.anderson.infnet.appTp3Produtos.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.anderson.infnet.appTp3Produtos.model.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
