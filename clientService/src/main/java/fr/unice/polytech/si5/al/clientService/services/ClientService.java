package fr.unice.polytech.si5.al.clientService.services;

import fr.unice.polytech.si5.al.clientService.components.AccountCreator;
import fr.unice.polytech.si5.al.clientService.components.ClientRegisterer;
import fr.unice.polytech.si5.al.clientService.models.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private static final Logger es_logger = LogManager.getLogger("LOG_TO_ES");
    private static final Logger root_logger = LogManager.getLogger(ClientService.class);

    @Autowired
    private ClientRegisterer clientRegisterer;

    @Autowired
    private AccountCreator accountCreator;

    @Autowired
    private TimeService timeService;

    public String addNewClient(Client client) {
        // logger.info("hello");
        String log = "{\n" +
                "  \"value\": \"hello\"" +
                "}";
        root_logger.info(log);
        es_logger.info(log);
        client.setCreationTime(timeService.getCurrentTime());
        long idNewClient = clientRegisterer.addNewClient(client);
        accountCreator.createNewAccount(idNewClient);
        return "You have been registered successfully";
    }
}
