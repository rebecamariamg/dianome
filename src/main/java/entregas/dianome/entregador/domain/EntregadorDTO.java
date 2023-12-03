package entregas.dianome.entregador.domain;
import org.hibernate.validator.constraints.Range;
import jakarta.validation.constraints.NotBlank;


public record EntregadorDTO(

    @NotBlank  String nome,
    @NotBlank  String cpf,
    @NotBlank  String contato,
    @Range(min = 400, max=1200) Double capacidadeDoVeiculoEmKg

) {


    public Entregador convertToEntregador() {
        Entregador entregador = new Entregador();
        entregador.setNome(nome);
        entregador.setCpf(cpf);
        entregador.setCpf(cpf);
        entregador.setCapacidadeDoVeiculoEmKg(capacidadeDoVeiculoEmKg);
        return entregador;
    }
    
}
