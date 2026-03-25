package br.anderson.infnet.apptp3produtos;

import br.anderson.infnet.apptp3produtos.model.domain.Produto;
import br.anderson.infnet.apptp3produtos.model.domain.builder.ProdutoBuilder;
import br.anderson.infnet.apptp3produtos.model.service.ProdutoService;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

@SpringBootTest
public class ProdutoServiceTest {
    @Autowired
    private ProdutoService produtoService;

    @Test
    @DisplayName("Testa a cadastramento de um novo item de produto")
    public void testCadastrarProduto() {
        Produto produto = ProdutoBuilder.aProduto().build();
        produto = produtoService.incluir(produto);
        Assertions.assertNotNull(produto.getId());
    }

    @Test
    @DisplayName("Testa alteração de um determinado item.")
    public void testAlterarProduto() {
        Faker faker = new Faker(new Locale("pt-BR"));
        Produto produto = produtoService.buscarPorId(1);
        String  nome = faker.commerce().productName();
        produto.setNome(nome);
        produto = produtoService.incluir(produto);
        Assertions.assertEquals(produto.getNome(), nome);
    }

    @Test
    @DisplayName("Testa exclusão de um determinado item.")
    public void testExcluirProduto() {
        Produto produto = produtoService.buscarPorId(1);
        Assertions.assertNotNull(produto);
        produtoService.excluir(produto.getId());
        Assertions.assertNull(produtoService.buscarPorId(1));
    }

}
