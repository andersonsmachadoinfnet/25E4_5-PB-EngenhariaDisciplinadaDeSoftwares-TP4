package br.anderson.infnet.apptp3produtos.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ean", length = 14, nullable = true)
    private String ean;
    @Column(name = "nome", length = 128, nullable = true)
    private String nome;
    private Float preco;
    @Column(name = "imglink", length = 255, nullable = false)
    private String imglink;

    public Produto(Integer id, String ean, String nome, float preco, String imglink) {
			this.id = id;
			this.ean = ean;
			this.nome = nome;
			this.preco = preco;
			this.imglink = imglink;
		}

		public Produto() {
		}

		public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getImglink() {
        return imglink;
    }

    public void setImglink(String imglink) {
        this.imglink = imglink;
    }
}
