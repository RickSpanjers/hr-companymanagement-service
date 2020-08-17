package nl.hrmanagement.companymanagement.service.impl;

import com.google.gson.Gson;
import nl.hrmanagement.companymanagement.dto.AddUpdateCompanyDTO;
import nl.hrmanagement.companymanagement.dto.AddUpdateFunctionDTO;
import nl.hrmanagement.companymanagement.dto.DeleteFunctionDTO;
import nl.hrmanagement.companymanagement.dto.RetrieveDashboardDataDTO;
import nl.hrmanagement.companymanagement.service.IRESTController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Stateless
@RestController
public class CompanyManagementController implements IRESTController {

    @Autowired
    private CompanyManagementServiceProvider companyManagementServiceProvider;
    private Gson gson = new Gson();

    @Override
    @PostMapping(
            path = "/add",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity addCompany(@NotNull @RequestBody AddUpdateCompanyDTO dto){
        String body = gson.toJson(companyManagementServiceProvider.addCompany(dto));
        return generateRequestResponse(body);
    }

    @Override
    @PostMapping(
            path = "/archive",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity archiveCompany(@NotNull @RequestBody UUID companyId){
        String body = gson.toJson(companyManagementServiceProvider.archiveCompany(companyId));
        return generateRequestResponse(body);
    }

    @Override
    @PostMapping(
            path = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity updateCompany(@NotNull @RequestBody AddUpdateCompanyDTO dto){
        String body = gson.toJson(companyManagementServiceProvider.updateCompany(dto));
        return generateRequestResponse(body);
    }

    @Override
    @PostMapping(
            path = "/function/add",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity addFunction(@NotNull @RequestBody AddUpdateFunctionDTO dto){
        String body = gson.toJson(companyManagementServiceProvider.addFunction(dto));
        return generateRequestResponse(body);
    }

    @Override
    @PostMapping(
            path = "/function/delete",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity deleteFunction(@NotNull @RequestBody DeleteFunctionDTO dto){
        String body = gson.toJson(companyManagementServiceProvider.deleteFunction(dto));
        return generateRequestResponse(body);
    }

    @Override
    @PostMapping(
            path = "/function/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity updateFunction(@NotNull @RequestBody AddUpdateFunctionDTO dto){
        String body = gson.toJson(companyManagementServiceProvider.updateFunction(dto));
        return generateRequestResponse(body);
    }

    @Override
    @GetMapping(path = "/{companyId}", produces = "application/json")
    @ResponseBody
    public ResponseEntity retrieveCompany(@PathVariable UUID companyId) {
        String body = gson.toJson(companyManagementServiceProvider.retrieveCompany(companyId));
        return generateRequestResponse(body);
    }

    @Override
    @GetMapping(path = "/function/{companyId}/all", produces = "application/json")
    @ResponseBody
    public ResponseEntity retrieveCompanyFunctions(@PathVariable UUID companyId) {
        String body = gson.toJson(companyManagementServiceProvider.retrieveCompanyFunctions(companyId));
        return generateRequestResponse(body);
    }

    @Override
    @GetMapping(path = "/function/{functionId}", produces = "application/json")
    @ResponseBody
    public ResponseEntity retrieveCompanyFunction(@PathVariable UUID functionId) {
        String body = gson.toJson(companyManagementServiceProvider.retrieveCompanyFunction(functionId));
        return generateRequestResponse(body);
    }

    @Override
    @GetMapping(path = "/all/{administratorId}", produces = "application/json")
    @ResponseBody
    public ResponseEntity retrieveCompanies(@PathVariable UUID administratorId) {
        String body = gson.toJson(companyManagementServiceProvider.retrieveCompanies(administratorId));
        return generateRequestResponse(body);
    }

    @Override
    @GetMapping(path = "/allArchived/{administratorId}", produces = "application/json")
    @ResponseBody
    public ResponseEntity retrieveArchivedCompanies(@PathVariable UUID administratorId) {
        String body = gson.toJson(companyManagementServiceProvider.retrieveArchivedCompanies(administratorId));
        return generateRequestResponse(body);
    }

    @Override
    @PostMapping(
            path = "/retrieveDashboardData",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity retrieveDashboardData(@NotNull @RequestBody RetrieveDashboardDataDTO dto) {
        String body = gson.toJson(companyManagementServiceProvider.retrieveDashboardData(dto));
        return generateRequestResponse(body);
    }

    private ResponseEntity generateRequestResponse(String body){
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        headers.add("Responded", "Company Management Service");
        if(body != null){
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(body, headers, status);
    }



}
