package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;

import java.util.List;

@Service
@AllArgsConstructor
public class IClientServiceImp implements IClientService {
    @Override
    public Client ajouterClient(Client client) {
        return null;
    }

    @Override
    public Client modifierClient(Client client) {
        return null;
    }

    @Override
    public List<Client> afficherClient() {
        return List.of();
    }

    @Override
    public Client afficherClientById(Long id) {
        return null;
    }

    @Override
    public void supprimerClient(Long id) {

    }
}
