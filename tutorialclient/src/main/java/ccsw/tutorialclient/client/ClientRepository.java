package ccsw.tutorialclient.client;

import ccsw.tutorialclient.client.model.Client;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Page<Client> findAll(@NonNull Pageable pageable);
}
