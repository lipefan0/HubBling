package br.com.upvisibility.hub_bling.infra.client;

import br.com.upvisibility.hub_bling.business.request.auth.PayloadGerarTokenRequest;
import br.com.upvisibility.hub_bling.business.request.auth.PayloadRefreshTokenBling;
import br.com.upvisibility.hub_bling.business.request.contatos.ContatoRequest;
import br.com.upvisibility.hub_bling.business.request.estoque.EstoqueRequest;
import br.com.upvisibility.hub_bling.business.request.fpagamentos.FPagamentoRequest;
import br.com.upvisibility.hub_bling.business.request.produtos.ProdutoRequest;
import br.com.upvisibility.hub_bling.business.request.vendas.VendaRequest;
import br.com.upvisibility.hub_bling.business.response.auth.TokenResponse;
import br.com.upvisibility.hub_bling.business.response.contatos.ContatoCreatedIdResponse;
import br.com.upvisibility.hub_bling.business.response.contatos.ContatoResponse;
import br.com.upvisibility.hub_bling.business.response.empresa.EmpresaResponse;
import br.com.upvisibility.hub_bling.business.response.estoque.SaldoEstoqueDepositoResponse;
import br.com.upvisibility.hub_bling.business.response.estoque.SaldoEstoqueResponse;
import br.com.upvisibility.hub_bling.business.response.fpagamentos.FPagamentoCreatedResponse;
import br.com.upvisibility.hub_bling.business.response.fpagamentos.FPagamentoResponse;
import br.com.upvisibility.hub_bling.business.response.lojas.LojaResponse;
import br.com.upvisibility.hub_bling.business.response.produtos.ProdutoCreatedResponse;
import br.com.upvisibility.hub_bling.business.response.produtos.ProdutoResponse;
import br.com.upvisibility.hub_bling.business.response.vendas.VendaListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

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

    @GetMapping("/empresas/me/dados-basicos")
    EmpresaResponse getEmpresaDadosBasicos(
            @RequestHeader("Authorization") String token
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

    // Endpoints de pedidos de venda

    @PostMapping("/pedidos/vendas")
    void criarPedidoVenda(
            @RequestHeader String token,
            @RequestBody VendaRequest request
    );

    @PatchMapping("/pedidos/vendas/{idVenda}/situacoes/{idSituacao}")
    void atualizarSituacaoPedidoVenda(
            @RequestHeader String token,
            @PathVariable("idVenda") Long idVenda,
            @PathVariable("idSituacao") Long idSituacao
    );

    @PostMapping("/pedidos/vendas/{idVenda}/lancar-estoque")
    void lancarEstoquePedidoVenda(
            @RequestHeader String token,
            @PathVariable("idVenda") Long idVenda
    );

    @PostMapping("/pedidos/vendas/{idVenda}/estornar-estoque")
    void estornarEstoquePedidoVenda(
            @RequestHeader String token,
            @PathVariable("idVenda") Long idVenda
    );

    @PostMapping("/pedidos/vendas/{idVenda}/lancar-contas")
    void lancarContasPedidoVenda(
            @RequestHeader String token,
            @PathVariable("idVenda") Long idVenda
    );

    @PostMapping("/pedidos/vendas/{idVenda}/estornar-contas")
    void estornarContasPedidoVenda(
            @RequestHeader String token,
            @PathVariable("idVenda") Long idVenda
    );

    @PostMapping("/pedidos/vendas/{idVenda}/gerar-nfe")
    void lancarNotaFiscal(
            @RequestHeader String token,
            @PathVariable("idVenda") Long idVenda
    );

    @PostMapping("/pedidos/vendas/{idVenda}/gerar-nfce")
    void lancarNotaFiscalConsumidor(
            @RequestHeader String token,
            @PathVariable("idVenda") Long idVenda
    );

    @GetMapping("/pedidos/vendas")
    VendaListResponse listarPedidosVenda(
            @RequestHeader String token
    );

    @GetMapping("/pedidos/vendas")
    VendaListResponse buscarPedidoVenda(
            @RequestHeader String token,
            @RequestParam("numero") String numero
    );

    @GetMapping("/pedidos/vendas")
    VendaListResponse listarPedidosVendaBySituacao(
            @RequestHeader String token,
            @RequestParam("idsSituacoes[]") List<Long> idsSituacao
    );

}
