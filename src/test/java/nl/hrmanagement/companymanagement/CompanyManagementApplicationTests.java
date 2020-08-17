package nl.hrmanagement.companymanagement;

import nl.hrmanagement.companymanagement.dto.*;
import nl.hrmanagement.companymanagement.service.impl.CompanyManagementServiceProvider;
import org.hibernate.service.spi.ServiceException;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Rick Spanjers
 * @since 21/10/2019
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CompanyManagementApplicationTests {

	@InjectMocks
	private CompanyManagementServiceProvider companyManagementServiceProvider;

	@Before
	public void setUp() {
		ClassLoader classLoader = getClass().getClassLoader();
		MockitoAnnotations.initMocks(this);
	}

	public CompanyManagementApplicationTests() throws ServiceException {

	}


	@Test
	public void setupContext(){

	}

	@Test()
	public void testAddCompany_NoMail(){
		AddUpdateCompanyDTO dto = new AddUpdateCompanyDTO();
		dto.setMail(null);
		GenericResponseDTO actualResult = companyManagementServiceProvider.addCompany(dto);
		assertFalse(actualResult.getSuccess());
	}

	@Test(expected = NullPointerException.class)
	public void testArchiveCompany_NoId(){
		GenericResponseDTO actualResult = companyManagementServiceProvider.archiveCompany(UUID.randomUUID());
		assertFalse(actualResult.getSuccess());
	}

	@Test()
	public void testUpdateCompany_NoId(){
		AddUpdateCompanyDTO dto = new AddUpdateCompanyDTO();
		dto.setMail(null);
		GenericResponseDTO actualResult = companyManagementServiceProvider.updateCompany(dto);
		assertFalse(actualResult.getSuccess());
	}

	@Test()
	public void testAddFunction_NoId(){
		AddUpdateFunctionDTO dto = new AddUpdateFunctionDTO();
 		dto.setCompanyId(UUID.randomUUID());
		GenericResponseDTO actualResult = companyManagementServiceProvider.addFunction(dto);
		assertFalse(actualResult.getSuccess());
	}

	@Test(expected = NullPointerException.class)
	public void testRemoveFunction_NoId(){
		GenericResponseDTO actualResult = companyManagementServiceProvider.deleteFunction(null);
		assertFalse(actualResult.getSuccess());
	}

	@Test()
	public void testUpdateFunction_NoId(){
		AddUpdateFunctionDTO dto = new AddUpdateFunctionDTO();
		dto.setCompanyId(UUID.randomUUID());
		GenericResponseDTO actualResult = companyManagementServiceProvider.updateFunction(dto);
		assertFalse(actualResult.getSuccess());
	}

	@Test(expected = NullPointerException.class)
	public void testRetrieveFunction_NoId(){
		GenericResponseDTO actualResult = companyManagementServiceProvider.retrieveCompanyFunction(UUID.randomUUID());
		assertFalse(actualResult.getSuccess());
	}

	@Test(expected = NullPointerException.class)
	public void testRetrieveFunctions_NoId(){
		GenericResponseDTO actualResult = companyManagementServiceProvider.retrieveCompanyFunctions(UUID.randomUUID());
		assertFalse(actualResult.getSuccess());
	}

	@Test(expected = NullPointerException.class)
	public void testRetrieveCompanies_NoAdminId(){
		GenericResponseDTO actualResult = companyManagementServiceProvider.retrieveCompanies(UUID.randomUUID());
		assertFalse(actualResult.getSuccess());
	}

	@Test(expected = NullPointerException.class)
	public void testRetrieveArchivedCompanies_NoAdminId(){
		GenericResponseDTO actualResult = companyManagementServiceProvider.retrieveArchivedCompanies(UUID.randomUUID());
		assertFalse(actualResult.getSuccess());
	}




}
