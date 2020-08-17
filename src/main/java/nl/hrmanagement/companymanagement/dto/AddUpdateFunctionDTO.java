package nl.hrmanagement.companymanagement.dto;

import java.util.UUID;

public class AddUpdateFunctionDTO {
    private UUID functionId;
    private String name;
    private String description;
    private String wage;
    private boolean archived;
    private UUID companyId;

    public AddUpdateFunctionDTO() {
    }

    public AddUpdateFunctionDTO(UUID functionId, String name, String description, String wage, boolean archived, UUID companyId) {
        this.name = name;
        this.description = description;
        this.wage = wage;
        this.functionId = functionId;
        this.archived = archived;
        this.companyId = companyId;
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

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    public UUID getFunctionId() {
        return functionId;
    }

    public void setFunctionId(UUID functionId) {
        this.functionId = functionId;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }
}
