package br.com.upvisibility.hub_bling.business;

import br.com.upvisibility.hub_bling.business.request.produtos.ProdutoRequest;
import br.com.upvisibility.hub_bling.business.response.produtos.ProdutoCreatedResponse;
import br.com.upvisibility.hub_bling.business.response.produtos.ProdutoResponse;
import br.com.upvisibility.hub_bling.infra.client.BlingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutosService {

    private final BlingClient blingClient;

    public ProdutoCreatedResponse criarProduto(String token, ProdutoRequest request) {
        return blingClient.criarProduto("Bearer " + token, request);
    }

    public ProdutoResponse buscarProdutoPorCodigo(String token, List<String> codigos) {
        return blingClient.buscarProdutoPorCodigo("Bearer " + token, codigos);
    }

    public ProdutoResponse buscarProdutoPorId(String token, ProdutoRequest request ,Long idProduto) {
        return blingClient.editarProduto("Bearer " + token, request ,idProduto);
    }
}
