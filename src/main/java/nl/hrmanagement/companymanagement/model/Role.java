package nl.hrmanagement.companymanagement.model;

import java.util.UUID;

public class Role {


    private int id;
    private UUID uuid;
    private String name;

    public Role(){

    }

    public Role(int id, UUID uuid, String name){
        this.id= id;
        this.uuid = uuid;
        this.name = name;
    }

    public Role(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getId() {
        return id;
    }


}