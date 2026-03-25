package br.anderson.infnet.apptp3produtos.model.domain.builder;

import br.anderson.infnet.apptp3produtos.model.domain.Produto;
import com.github.javafaker.Faker;

import java.util.Locale;

public final class ProdutoBuilder {
    private Produto produto;

    public ProdutoBuilder() {
        this.produto = new Produto();
        Faker faker = new Faker(new Locale("pt-BR"));
        Long lEan = faker.number().numberBetween(7890000000000l, 7899999999999l);
        this.produto.setEan(lEan.toString());
        this.produto.setNome(faker.commerce().productName());
        this.produto.setPreco((float)faker.random().nextDouble() * (100 - 1));
        this.produto.setImglink(faker.internet().url());
    }

    public static ProdutoBuilder aProduto() {
        return new ProdutoBuilder();
    }

    public Produto build() {
        return this.produto;
    }
}
