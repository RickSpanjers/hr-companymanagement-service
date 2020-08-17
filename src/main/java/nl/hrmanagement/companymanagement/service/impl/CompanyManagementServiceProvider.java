package nl.hrmanagement.companymanagement.service.impl;

import com.google.gson.Gson;
import nl.hrmanagement.companymanagement.dto.*;
import nl.hrmanagement.companymanagement.model.Company;
import nl.hrmanagement.companymanagement.model.Function;
import nl.hrmanagement.companymanagement.rabbitmq.TaskSender;
import nl.hrmanagement.companymanagement.repository.*;
import nl.hrmanagement.companymanagement.service.IServiceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.ejb.Stateless;
import java.util.List;
import java.util.UUID;

@Stateless
@Service
public class CompanyManagementServiceProvider implements IServiceProvider {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private FunctionRepository functionRepository;

    @Autowired
    private TaskSender rabbitMQSender;

    private Logger logger = LoggerFactory.getLogger(CompanyManagementServiceProvider.class);
    private Gson gson = new Gson();

    @Override
    public GenericResponseDTO addCompany(AddUpdateCompanyDTO dto){
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", "Unable to add company into system");
        if(dto.getMail() != null){
            //Generate UUID based on values
            String generate = dto.getRegistrationNumber()+dto.getTaxId()+dto.getPhone();
            Company company = new Company(0, UUID.nameUUIDFromBytes(generate.getBytes()));
            company.setAddressOne(dto.getAddressOne());
            company.setAddressTwo(dto.getAddressTwo());
            company.setCity(dto.getCity());
            company.setCountry(dto.getCountry());
            company.setMail(dto.getMail());
            company.setName(dto.getName());
            company.setPhone(dto.getPhone());
            company.setRegistrationNumber(dto.getRegistrationNumber());
            company.setTaxId(dto.getTaxId());
            company.setZipcode(dto.getZipcode());
            company.setArchived(false);
            company.setCeo(dto.getCeo());
            companyRepository.save(company);
            result = new GenericResponseDTO(true, "Success", "Successfully added company "+dto.getName()+" into system");
        }
        return result;
    }

    @Override
    public GenericResponseDTO archiveCompany(UUID companyId){
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", "Unable to change archive status");
        if(companyId != null){
            Company company = companyRepository.findByUuid(companyId);
            if(company.isArchived()){
                company.setArchived(false);
            }else{
                company.setArchived(true);
            }
            companyRepository.save(company);
            rabbitMQSender.send(companyId);
            result = new GenericResponseDTO(true, "Success", "Successfully changed company archived status to "+company.isArchived());
        }
        return result;
    }

    @Override
    public GenericResponseDTO updateCompany(AddUpdateCompanyDTO dto){
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", null);
        if(dto.getMail() != null & dto.getName() != null & dto.getCompanyId() != null){
            Company company = companyRepository.findByUuid(dto.getCompanyId());
            company.setAddressOne(dto.getAddressOne());
            company.setAddressTwo(dto.getAddressTwo());
            company.setCity(dto.getCity());
            company.setCountry(dto.getCountry());
            company.setMail(dto.getMail());
            company.setName(dto.getName());
            company.setPhone(dto.getPhone());
            company.setRegistrationNumber(dto.getRegistrationNumber());
            company.setTaxId(dto.getTaxId());
            company.setZipcode(dto.getZipcode());
            company.setArchived(dto.getArchived());
            company.setCeo(dto.getCeo());
            companyRepository.save(company);
            result = new GenericResponseDTO(true, company, "Successfully updated company "+company.getName());

        }
        return result;
    }

    @Override
    public GenericResponseDTO addFunction(AddUpdateFunctionDTO dto){
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", null);
        if(dto.getCompanyId() != null & dto.getName() != null){
            //Generate UUID based on data
            String generate = dto.getName()+dto.getCompanyId()+dto.getWage();
            float f = Float.parseFloat(dto.getWage());
            Function function = new Function(0, UUID.nameUUIDFromBytes(generate.getBytes()), dto.getName(), dto.getDescription(), f, false, companyRepository.findByUuid(dto.getCompanyId()));
            functionRepository.save(function);
            List<Function> functionList = functionRepository.findAllByCompanyUuid(dto.getCompanyId());
            result = new GenericResponseDTO(true, functionList, "Successfully added function "+function.getName());
        }
        return result;
    }

    @Override
    public GenericResponseDTO deleteFunction(DeleteFunctionDTO dto){
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", null);
        if(dto.getFunctionId() != null){
            Function function = functionRepository.findByUuid(dto.getFunctionId());
            functionRepository.delete(function);
            result = new GenericResponseDTO(true, "Success", "Successfully deleted "+function.getName());
        }
        return result;
    }

    @Override
    public GenericResponseDTO updateFunction(AddUpdateFunctionDTO dto){
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", null);
        if(dto.getFunctionId() != null){
            Function function = functionRepository.findByUuid(dto.getFunctionId());
            function.setName(dto.getName());
            function.setDescription(dto.getDescription());
            function.setWage(Float.parseFloat(dto.getWage()));
            function.setArchived(dto.isArchived());
            functionRepository.save(function);
            result = new GenericResponseDTO(true, function, "Successfully updated "+function.getName());
        }
        return result;
    }

    @Override
    public GenericResponseDTO retrieveCompany(UUID companyId){
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", null);
        if(companyId != null){
            Company company = companyRepository.findByUuid(companyId);
            result = new GenericResponseDTO(true, company, "Successfully retrieved company: " + company.getName());
        }
        return result;
    }

    @Override
    public GenericResponseDTO retrieveCompanyFunctions(UUID companyId){
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", null);
        if(companyId != null){
            List<Function> functionList  = functionRepository.findAllByCompanyUuid(companyId);
            result = new GenericResponseDTO(true, functionList, "Successfully retrieved functions");
        }
        return result;
    }
    @Override
    public GenericResponseDTO retrieveCompanyFunction(UUID functionId){
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", null);
        if(functionId != null){
            Function function  = functionRepository.findByUuid(functionId);
            result = new GenericResponseDTO(true, function, "Successfully retrieved function");
        }
        return result;
    }

    @Override
    public GenericResponseDTO retrieveCompanies(UUID administratorId){
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", null);
        if(administratorId != null){
            List<Company> companyList = companyRepository.findAllByArchivedFalse();
            result = new GenericResponseDTO(true, companyList, "Successfully retrieved companies");
        }
        return result;
    }

    @Override
    public GenericResponseDTO retrieveArchivedCompanies(UUID administratorId){
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", null);
        if(administratorId != null){
            List<Company> companyList = companyRepository.findAllByArchivedTrue();
            result = new GenericResponseDTO(true, companyList, "Successfully retrieved archived companies");
        }
        return result;
    }

    @Override
    public GenericResponseDTO retrieveDashboardData(RetrieveDashboardDataDTO dto){
        GenericResponseDTO result = new GenericResponseDTO(false, "Failure", null);
        if(dto.getCompanyId() != null){
            DashboardDataResponseDTO responseData = new DashboardDataResponseDTO();
            Company company = companyRepository.findByUuid(dto.getCompanyId());
            Function function = functionRepository.findByUuid(dto.getFunctionId());

            if(company != null){
                responseData.setCompany(company.getName());
            }
            if(function != null){
                responseData.setFunction(function.getName());
            }

            result = new GenericResponseDTO(true, responseData,"Successfully retrieved company dashboard data");
        }
        return result;
    }


}
