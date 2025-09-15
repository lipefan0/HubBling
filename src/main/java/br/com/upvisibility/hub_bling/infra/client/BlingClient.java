package br.com.upvisibility.hub_bling.infra.client;

import br.com.upvisibility.hub_bling.business.request.auth.PayloadGerarTokenRequest;
import br.com.upvisibility.hub_bling.business.request.auth.PayloadRefreshTokenBling;
import br.com.upvisibility.hub_bling.business.request.contatos.ContatoRequest;
import br.com.upvisibility.hub_bling.business.request.estoque.EstoqueRequest;
import br.com.upvisibility.hub_bling.business.request.fpagamentos.FPagamentoRequest;
import br.com.upvisibility.hub_bling.business.request.produtos.ProdutoRequest;
import br.com.upvisibility.hub_bling.business.response.auth.TokenResponse;
import br.com.upvisibility.hub_bling.business.response.contatos.ContatoCreatedIdResponse;
import br.com.upvisibility.hub_bling.business.response.contatos.ContatoResponse;
import br.com.upvisibility.hub_bling.business.response.estoque.SaldoEstoqueDepositoResponse;
import br.com.upvisibility.hub_bling.business.response.estoque.SaldoEstoqueResponse;
import br.com.upvisibility.hub_bling.business.response.fpagamentos.FPagamentoCreatedResponse;
import br.com.upvisibility.hub_bling.business.response.fpagamentos.FPagamentoResponse;
import br.com.upvisibility.hub_bling.business.response.lojas.LojaResponse;
import br.com.upvisibility.hub_bling.business.response.produtos.ProdutoCreatedResponse;
import br.com.upvisibility.hub_bling.business.response.produtos.ProdutoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "bling",
        url = "${bling.url}"
)
public interface BlingClient {

    // Autenticação Bling
    @PostMapping("/oauth/token")
    TokenResponse GerarTokenBling(
            @RequestHeader String credentials,
            @RequestBody PayloadGerarTokenRequest request
    );

    @PostMapping("/oauth/token")
    TokenResponse RefreshTokenBling(
            @RequestHeader String credentials,
            @RequestBody PayloadRefreshTokenBling request
    );

    // Endpoints de contato
    @PostMapping("/contatos")
    ContatoCreatedIdResponse criarContato(
            @RequestHeader String token,
            @RequestBody ContatoRequest request
    );

    @GetMapping("/contatos")
    ContatoResponse buscarContatoPorDocumento(
            @RequestHeader String token,
            @RequestParam("numeroDocumento") String documento
    );

    @GetMapping("/contatos/{id}")
    ContatoResponse buscarContatoPorId(
            @RequestHeader String token,
            @PathVariable("id") String id
    );

    // Endpoints de produtos

    @PostMapping("/produtos")
    ProdutoCreatedResponse criarProduto(
            @RequestHeader String token,
            @RequestBody ProdutoRequest request
    );

    @GetMapping("/produtos")
    ProdutoResponse buscarProdutoPorCodigo(
            @RequestHeader String token,
            @RequestParam("codigos[]") String codigo
    );

    @PutMapping("/produtos/{id}")
    ProdutoResponse editarProduto(
            @RequestHeader String token,
            @RequestBody ProdutoRequest request,
            @PathVariable("id") String id
    );

    // Endpoints de formas de pagamento

    @PostMapping("/formas-pagamentos")
    FPagamentoCreatedResponse criarFormaPagamento(
            @RequestHeader String token,
            @RequestBody FPagamentoRequest request
    );

    @GetMapping("/formas-pagamentos")
    FPagamentoResponse listarFormasPagamentos(
            @RequestHeader String token
    );

    @GetMapping("/formas-pagamentos")
    FPagamentoResponse buscarFormaPagamentoPorNome(
            @RequestHeader String token,
            @RequestParam("descricao") String descricao
    );

    // Endpoints de estoque

    @PostMapping("/estoques")
    void criaRegistroEstoque(
            @RequestHeader String token,
            @RequestBody EstoqueRequest request
    );

    @GetMapping("/estoques/saldos")
    SaldoEstoqueResponse buscarSaldoEstoque(
            @RequestHeader String token,
            @RequestParam("idsProdutos[]") List<Long> idProduto
    );

    @GetMapping("/estoques/saldos/{idDeposito}")
    SaldoEstoqueDepositoResponse buscarSaldoEstoque(
            @RequestHeader String token,
            @RequestParam("idsProdutos[]") List<Long> idProduto,
            @PathVariable("idDeposito") Long idDeposito
    );

    // Endpoints de lojas

    @GetMapping("/canais-venda")
    LojaResponse listarLojas(
            @RequestHeader String token
    );

}
