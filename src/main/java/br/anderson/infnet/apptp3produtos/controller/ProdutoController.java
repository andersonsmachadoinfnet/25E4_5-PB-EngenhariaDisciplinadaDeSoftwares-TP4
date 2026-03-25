package br.anderson.infnet.apptp3produtos.controller;

import br.anderson.infnet.apptp3produtos.model.domain.Produto;
import br.anderson.infnet.apptp3produtos.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {
    private static final String LINK_LISTA = "produto/lista";

    @Autowired
    private ProdutoService produtoService;
    private String msg;

    @GetMapping(value="/produto")
    public String telaCadastro() {return "produto/cadastro";}

    @GetMapping(value = "/produto/lista")
    public String telaLista(Model model) {
        model.addAttribute("produtos", produtoService.listar());
        model.addAttribute("mensagem", msg);
        msg = null;
        return LINK_LISTA;
    }

    @PostMapping(value="/produto/incluir")
    public String incluir(Produto produto) {
        produtoService.incluir(produto);
        msg = "Produto "+produto.getNome()+" incluido com sucesso!";
        return "redirect:/"+LINK_LISTA;
    }

    @GetMapping(value="/produto/{id}/excluir")
    public String excluir(@PathVariable int id) {
        Produto produto = produtoService.buscarPorId(id);
        try {
            produtoService.excluir(id);
            msg = "A exclusão do produto "+produto.getNome()+" foi realizada com sucesso!!!";
        } catch (Exception e) {
            msg = "Impossível realizar a exclusão do produto ";
        }
        return "redirect:/"+LINK_LISTA;
    }

    @GetMapping(value="/produto/{id}/editar")
    public String editar(@PathVariable int id, Model model) {
        Produto produto = produtoService.buscarPorId(id);
        if (produto == null) {
            msg = "Produto inexistente";
            return "redirect:/produto/lista";
        }
        else {
            model.addAttribute("produto", produto);
            msg = null;
            return "produto/cadastro";
        }
    }
}
