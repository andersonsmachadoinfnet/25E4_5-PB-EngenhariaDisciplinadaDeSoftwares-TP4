package br.anderson.infnet.appTp3Produtos.pages;

import br.anderson.infnet.appTp3Produtos.core.BasePage;
import br.anderson.infnet.appTp3Produtos.model.domain.Produto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CadastroPage  extends BasePage<HomePage> {
    private final static String URL = "http://localhost:8080/produto?";
    public final By inputId = By.id("input-id");
    public final By inputEan = By.id("input-ean");
    public final By inputNome = By.id("input-nome");
    public final By inputPreco = By.id("input-preco");
    public final By inputImglink = By.id("input-imglink");
    private final By btnCadastrar = By.id("btn-cadastrar");

    protected CadastroPage(WebDriver driver, Duration duration) {
        super(driver, duration, URL);
    }

    public void cadastrarProduto(Produto produto) {
        type(inputEan, produto.getEan());
        type(inputNome, produto.getNome());
        type(inputPreco, produto.getPreco().toString());
        type(inputImglink, produto.getImglink());
        click(btnCadastrar);
    }

    public Produto getProduto() {
        Produto produto = new Produto();
        produto.setEan($(inputEan).getAttribute("value"));
        produto.setNome($(inputNome).getAttribute("value"));
        produto.setPreco(Float.valueOf($(inputPreco).getAttribute("value")));
        produto.setImglink($(inputImglink).getAttribute("value"));
        produto.setId(Integer.valueOf($(inputId).getAttribute("value")));
        return produto;
    }
}
