package br.anderson.infnet.apptp3produtos.pages;

import br.anderson.infnet.apptp3produtos.core.BasePage;
import br.anderson.infnet.apptp3produtos.model.domain.Produto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CadastroPage  extends BasePage<HomePage> {
    private static final String URL = "http://localhost:8080/produto?";
    public static final By inputId = By.id("input-id");
    public static final By inputEan = By.id("input-ean");
    public static final By inputNome = By.id("input-nome");
    public static final By inputPreco = By.id("input-preco");
    public static final By inputImglink = By.id("input-imglink");
    private static final By btnCadastrar = By.id("btn-cadastrar");

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
        produto.setEan($(inputEan). getDomAttribute("value"));
        produto.setNome($(inputNome).getDomAttribute("value"));
        produto.setPreco(Float.valueOf($(inputPreco).getDomAttribute("value")));
        produto.setImglink($(inputImglink).getDomAttribute("value"));
        produto.setId(Integer.valueOf($(inputId).getDomAttribute("value")));
        return produto;
    }
}
