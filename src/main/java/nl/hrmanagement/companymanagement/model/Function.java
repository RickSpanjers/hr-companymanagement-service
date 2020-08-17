package nl.hrmanagement.companymanagement.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Cacheable
@Table(name = "functions")
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", columnDefinition = "BINARY(16)")
    private UUID uuid;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "wage")
    private float wage;
    @Column(name = "archived")
    private boolean archived;

    @ManyToOne
    @JoinColumn(name="company_id", nullable=true)
    private Company company;

    public Function(int id, UUID uuid, String name, String description, float wage, boolean archived, Company company) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.wage = wage;
        this.archived = archived;
        this.company = company;
    }

    public Function(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    public int getId() {
        return id;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Company getCompany() {
        return company;
    }
}