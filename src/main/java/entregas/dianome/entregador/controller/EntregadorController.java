package entregas.dianome.entregador.controller;
import static java.net.URI.create;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import entregas.dianome.entregador.domain.Entregador;
import entregas.dianome.entregador.domain.EntregadorDTO;
import entregas.dianome.entregador.service.EntregadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/entregadores")
@Tag(name = "Entregadores", description = "Endpoint da API que lida com os entregadores")
public class EntregadorController {


    @Autowired
    private EntregadorService entregadorService;
    

    @GetMapping
    @Operation(
        summary = "GET ALL Entregadores",
        description = "Retorna todos os Entregadores contendo todas as suas informações que são guardadas no banco de dados.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Entregador.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public ResponseEntity<List<Entregador>> listaEntregadores() {
        List<Entregador> entregadores = entregadorService.listaEntregadores();
        if (entregadores.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(entregadores);
        return ResponseEntity.ok().body(entregadores);
    }



    @GetMapping("/{id}") 
    @Operation(
        summary = "GET ONE Entregador By ID",
        description = "Retorna um único entregador de acordo com o seu identificador Id.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Entregador.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public ResponseEntity<?> buscaEntregador(@PathVariable("id") Integer id) {
        Optional<Entregador> optEntregador = entregadorService.buscaEmpregadorPeloId(id);
        if (optEntregador.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado para o ID: " + id);
        return ResponseEntity.ok().body(optEntregador.get());
    }



    @DeleteMapping("/{id}")
    @Operation(
        summary = "DELETE ONE Entregador By ID",
        description = "Deleta um Entregador informando o seu identificador Id")
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Entregador.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public ResponseEntity<?> deleteEntregador(@PathVariable("id") Integer id) {
        boolean deleted = entregadorService.deletaEmpregadorPeloId(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado para o ID: " + id);
        }
    }



    @PostMapping("/")
    @Operation(
        summary = "CREATE ONE Entregador",
        description = "Cria um entregador na aplicação. Retorna A URI do conteúdo criado bem como as informações cadastradas no body")
    @ApiResponses({
        @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Entregador.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public ResponseEntity<Entregador> criaEntregador(@RequestBody @Valid EntregadorDTO entregadorDTO) {
        Entregador createdEntregador = entregadorService.criaEntregador(entregadorDTO);
        
        String uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEntregador.getId())
                .toUriString();

        return ResponseEntity
                .created(create(uri))
                .body(createdEntregador);
    }


    
    @PutMapping("/{id}")
    @Operation(
        summary = "UPDATE ONE Entregador By ID",
        description = "Retorna um único entregador de acordo com o seu identificador Id.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Entregador.class), mediaType = "application/json") }),
        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public ResponseEntity<?> updateEntregador(@PathVariable("id") Integer id, @RequestBody EntregadorDTO updatedEntregadorDTO) {
        boolean updated = entregadorService.atualizaEntregador(id, updatedEntregadorDTO);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entregador não encontrado para o ID: " + id);
        }
    }


}
