package dio.padroes_projeto.desafio_dio.service.impl;

import dio.padroes_projeto.desafio_dio.model.Livro;
import dio.padroes_projeto.desafio_dio.model.LivroRepository;
import dio.padroes_projeto.desafio_dio.model.Localizacao;
import dio.padroes_projeto.desafio_dio.model.LocalizacaoRepository;
import dio.padroes_projeto.desafio_dio.service.LivroService;
import dio.padroes_projeto.desafio_dio.service.ViaCodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private LocalizacaoRepository localizacaoRepository;
    @Autowired
    private ViaCodService viaCodService;

    @Override
    public Iterable<Livro> buscarTodos(){
        return livroRepository.findAll();
    }
    @Override
    public Livro buscarPorId(Long id){
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isPresent()){
            return livro.get();
        }else{
            System.out.println("O livro não esta cadastrado.");
            return null;
        }
    }
    @Override
    public void inserir(Livro livro){
        salvandoLivroPeloCod(livro);
    }

    @Override
    public void atualizar(Long id, Livro livro){
        Optional<Livro> livroBd = livroRepository.findById(id);
        if(livroBd.isPresent()){
            salvandoLivroPeloCod(livro);
        }
    }
    @Override
    public void deletar(Long id){
        livroRepository.deleteById(id);
    }

    private void salvandoLivroPeloCod(Livro livro) {
        String codLocalizacao = livro.getLocalizacao().getCodLocalizacao();
        Localizacao localizacao = localizacaoRepository.findById(codLocalizacao).orElseGet(() ->{
            Localizacao novaLocalizacao = viaCodService.consultarCod(codLocalizacao);
            localizacaoRepository.save(novaLocalizacao);
            return novaLocalizacao;
        });
        livro.setLocalizacao(localizacao);
        livroRepository.save(livro);
    }

}
