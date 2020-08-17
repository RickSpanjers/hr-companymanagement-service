package nl.hrmanagement.companymanagement.dto;

public class DashboardDataResponseDTO {
    private String company;
    private String function;

    public DashboardDataResponseDTO() {
    }

    public DashboardDataResponseDTO(String company, String function) {
        this.company = company;
        this.function = function;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
