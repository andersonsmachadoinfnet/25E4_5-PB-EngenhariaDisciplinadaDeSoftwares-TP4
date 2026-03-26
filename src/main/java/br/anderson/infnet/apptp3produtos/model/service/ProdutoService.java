package br.anderson.infnet.apptp3produtos.model.service;

import br.anderson.infnet.apptp3produtos.model.domain.Produto;
import br.anderson.infnet.apptp3produtos.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto incluir(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void excluir(Integer id) {
        produtoRepository.deleteById(id);
    }

    public Collection<Produto> listar() {
        return (Collection<Produto>) produtoRepository.findAll();
    }

    public Produto buscarPorId(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }
}
