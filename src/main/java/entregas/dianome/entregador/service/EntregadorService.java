package entregas.dianome.entregador.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import entregas.dianome.entregador.domain.Entregador;
import entregas.dianome.entregador.domain.EntregadorDTO;
import entregas.dianome.entregador.repository.EntregadorRepository;


@Service
public class EntregadorService {

    
    @Autowired
    private EntregadorRepository entregadorRepository;


    public List<Entregador> listaEntregadores() {
        return entregadorRepository.findAll();
    }


    public Optional<Entregador> buscaEmpregadorPeloId(Integer id) {
        return entregadorRepository.findById(id);
    }


    public Entregador criaEntregador(EntregadorDTO dto) {
        Entregador entregador = dto.convertToEntregador();
        return entregadorRepository.save(entregador);
    }


    public boolean deletaEmpregadorPeloId(Integer id) {
        Optional<Entregador> opt = entregadorRepository.findById(id);
        if (opt.isEmpty())
            return false;
        entregadorRepository.delete(opt.get());
        return true;
    }


    public boolean atualizaEntregador(Integer id, EntregadorDTO updatedEntregadorDTO) {
        Optional<Entregador> opt = entregadorRepository.findById(id);
        if (opt.isEmpty())
            return false;
        Entregador entregador = updatedEntregadorDTO.convertToEntregador();
        entregador.setId(id);
        entregadorRepository.save(entregador);
        return true;
    }
}
