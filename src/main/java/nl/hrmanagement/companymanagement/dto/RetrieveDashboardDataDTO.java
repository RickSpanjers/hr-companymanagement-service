package nl.hrmanagement.companymanagement.dto;

import java.util.UUID;

public class RetrieveDashboardDataDTO {
    private UUID companyId;
    private UUID functionId;

    public RetrieveDashboardDataDTO() {
    }

    public RetrieveDashboardDataDTO(UUID companyId, UUID functionId) {
        this.companyId = companyId;
        this.functionId = functionId;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public UUID getFunctionId() {
        return functionId;
    }

    public void setFunctionId(UUID functionId) {
        this.functionId = functionId;
    }
}
