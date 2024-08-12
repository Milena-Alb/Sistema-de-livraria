package dio.padroes_projeto.desafio_dio.controller;

import dio.padroes_projeto.desafio_dio.model.Livro;
import dio.padroes_projeto.desafio_dio.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("livros")
public class LivroRestController {
    @Autowired
    private LivroService clienteService;

    @GetMapping
    public ResponseEntity<Livro>buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Livro> inserir(@RequestBody Livro livro){
        clienteService.inserir(livro);
        return ResponseEntity.ok(livro);
    }
    @PutMapping("/{id}")
        public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livro){
        clienteService.atualizar(id, livro);
        return ResponseEntity.ok(livro);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return  ResponseEntity.ok().build();
    }
}
