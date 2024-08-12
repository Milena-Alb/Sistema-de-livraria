package dio.padroes_projeto.desafio_dio.service;

import dio.padroes_projeto.desafio_dio.model.Localizacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "viacod", url = "https://viacod.com.br/ws")
public interface ViaCodService {
    @RequestMapping(method = RequestMethod.GET, value = "/{codLocalizacao}/json/")
    Localizacao consultarCod(@PathVariable("codLocalizacao")String codLocalizacao);
}
