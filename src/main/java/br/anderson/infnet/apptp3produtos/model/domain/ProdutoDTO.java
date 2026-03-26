package br.anderson.infnet.apptp3produtos.model.domain;

import jakarta.persistence.Column;

public record ProdutoDTO(Integer id, String ean, String nome, Float preco, String imglink) {
}
