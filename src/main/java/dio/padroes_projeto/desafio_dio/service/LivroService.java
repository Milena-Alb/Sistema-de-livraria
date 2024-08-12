package dio.padroes_projeto.desafio_dio.service;

import dio.padroes_projeto.desafio_dio.model.Livro;

public interface LivroService {
    Iterable<Livro> buscarTodos();
    Livro buscarPorId(Long id);
    void  inserir(Livro livro);
    void  atualizar(Long id, Livro livro);
    void  deletar(Long id);

}
