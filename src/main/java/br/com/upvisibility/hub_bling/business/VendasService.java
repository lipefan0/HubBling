package br.com.upvisibility.hub_bling.business;

import br.com.upvisibility.hub_bling.infra.client.BlingClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendasService {

    private final BlingClient blingClient;
}
