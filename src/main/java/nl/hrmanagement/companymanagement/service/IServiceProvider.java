package nl.hrmanagement.companymanagement.service;

import nl.hrmanagement.companymanagement.dto.*;

import javax.ejb.Local;
import java.util.UUID;

@Local
public interface IServiceProvider {
    GenericResponseDTO addCompany(AddUpdateCompanyDTO dto);
    GenericResponseDTO archiveCompany(UUID companyId);
    GenericResponseDTO updateCompany(AddUpdateCompanyDTO dto);
    GenericResponseDTO addFunction(AddUpdateFunctionDTO dto);
    GenericResponseDTO deleteFunction(DeleteFunctionDTO dto);
    GenericResponseDTO updateFunction(AddUpdateFunctionDTO dto);
    GenericResponseDTO retrieveCompany(UUID companyId);
    GenericResponseDTO retrieveCompanyFunctions(UUID companyId);
    GenericResponseDTO retrieveCompanyFunction(UUID functionId);
    GenericResponseDTO retrieveCompanies(UUID administratorId);
    GenericResponseDTO retrieveArchivedCompanies(UUID administratorId);
    GenericResponseDTO retrieveDashboardData(RetrieveDashboardDataDTO dto);
}
