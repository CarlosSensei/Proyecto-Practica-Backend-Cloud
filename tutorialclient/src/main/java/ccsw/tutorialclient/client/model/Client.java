package ccsw.tutorialclient.client.model;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public void setId(Long id) { this.id = id; }

    public Long getId() { return this.id; }

    public void setName(String name) { this.name = name; }

    public String getName() { return this.name; }


}
