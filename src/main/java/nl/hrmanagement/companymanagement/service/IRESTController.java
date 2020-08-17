package nl.hrmanagement.companymanagement.service;

import nl.hrmanagement.companymanagement.dto.AddUpdateCompanyDTO;
import nl.hrmanagement.companymanagement.dto.AddUpdateFunctionDTO;
import nl.hrmanagement.companymanagement.dto.DeleteFunctionDTO;
import nl.hrmanagement.companymanagement.dto.RetrieveDashboardDataDTO;
import org.springframework.http.ResponseEntity;

import javax.ejb.Local;
import java.util.UUID;

@Local
public interface IRESTController {
    ResponseEntity addCompany(AddUpdateCompanyDTO dto);
    ResponseEntity archiveCompany(UUID companyId);
    ResponseEntity updateCompany(AddUpdateCompanyDTO dto);
    ResponseEntity addFunction(AddUpdateFunctionDTO dto);
    ResponseEntity deleteFunction(DeleteFunctionDTO dto);
    ResponseEntity updateFunction(AddUpdateFunctionDTO dto);
    ResponseEntity retrieveCompany(UUID companyId);
    ResponseEntity retrieveCompanyFunctions(UUID companyId);
    ResponseEntity retrieveCompanyFunction(UUID functionId);
    ResponseEntity retrieveCompanies(UUID administratorId);
    ResponseEntity retrieveArchivedCompanies(UUID administratorId);
    ResponseEntity retrieveDashboardData(RetrieveDashboardDataDTO dto);
}
