package br.anderson.infnet.apptp3produtos;

import br.anderson.infnet.apptp3produtos.model.domain.Produto;
import br.anderson.infnet.apptp3produtos.model.domain.builder.ProdutoBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoTest {

    @Test
    @DisplayName("Testa Produto, campos;")
    public void testeProdutoCampos() {
        Produto produtoOrig = ProdutoBuilder.aProduto().build();
        Produto produtoDest = new Produto();

        produtoDest.setId(produtoOrig.getId());
        produtoDest.setNome(produtoOrig.getNome());
        produtoDest.setPreco(produtoOrig.getPreco());
        produtoDest.setImglink(produtoOrig.getImglink());
        produtoDest.setEan(produtoOrig.getEan());

        Assertions.assertEquals(produtoDest.getId(), produtoOrig.getId());
        Assertions.assertEquals(produtoDest.getNome(), produtoOrig.getNome());
        Assertions.assertEquals(produtoDest.getPreco(), produtoOrig.getPreco());
        Assertions.assertEquals(produtoDest.getImglink(), produtoOrig.getImglink());
        Assertions.assertEquals(produtoDest.getEan(), produtoOrig.getEan());
    }

    @Test
    @DisplayName("Testa o construtor da classe Produto")
    public void testeProdutoConstrutor() {
        Produto produtoBase = ProdutoBuilder.aProduto().build();
        Produto produto = new Produto(1, produtoBase.getEan(), produtoBase.getNome(), produtoBase.getPreco(), produtoBase.getImglink());
        Assertions.assertEquals(produto.getNome(), produtoBase.getNome());
        Assertions.assertEquals(produto.getPreco(), produtoBase.getPreco());
        Assertions.assertEquals(produto.getImglink(), produtoBase.getImglink());
        Assertions.assertEquals(produto.getEan(), produtoBase.getEan());
    }
}
