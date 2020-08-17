package nl.hrmanagement.companymanagement.dto;

import java.util.UUID;

public class DeleteFunctionDTO {
    private UUID functionId;
    private UUID moderatorId;

    public DeleteFunctionDTO(UUID functionId, UUID moderatorId) {
        this.functionId = functionId;
        this.moderatorId = moderatorId;
    }

    public DeleteFunctionDTO() {
    }

    public void setFunctionId(UUID functionId) {
        this.functionId = functionId;
    }

    public UUID getFunctionId() {
        return functionId;
    }

    public UUID getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(UUID moderatorId) {
        this.moderatorId = moderatorId;
    }
}
