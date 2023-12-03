package entregas.dianome.entregador.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@Table(name = "entregador")
@EqualsAndHashCode(of = "id")
public class Entregador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    
    private String cpf;

    private String contato;

    @Column(name = "capacidade_do_veiculo_em_kg")
    private Double capacidadeDoVeiculoEmKg;
    
}
