
import java.io.InputStream;

//import nividous.loanunderwriting.Loan;

import org.drools.core.io.impl.UrlResource;
import org.kie.api.KieServices;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.io.KieResources;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class JavaClientForKieWB {

	public static void main(String[] args) {
		try {

			KieServices ks = KieServices.Factory.get();
		/*	KieResources resources = ks.getResources();
			String url = "http://localhost:7070/kie-drools-webb/maven2/Nividous/LoanUnderwriting/7.0/LoanUnderwriting-7.0.jar";
			UrlResource urlResource = (UrlResource) resources
					.newUrlResource(url);
			urlResource.setUsername("tomcat");
			urlResource.setPassword("tomcat");
			urlResource.setBasicAuthentication("enabled");
			InputStream stream = urlResource.getInputStream();

			KieRepository repo = ks.getRepository();
			KieModule k = repo.addKieModule(resources
					.newInputStreamResource(stream));
			System.out.println(k.getReleaseId());
			KieContainer kieContainer = ks.newKieContainer(k.getReleaseId());*/
			KieContainer kieContainer = ks.getKieClasspathContainer();
			
			KieSession kieSession = kieContainer.newKieSession();
			/*Loan loan =new Loan();
			System.out.println("Loan Status: "+ loan.isLoanstatus() + "Loan Reason :: "+ loan.getReason());
			//loantype == "Home Loan" , annualIncome >= 75000 , loanpremium < 3500 , creditscore >= 70 , industry == "Legal Services" 
			loan.setLoantype("HomeLoan");
			loan.setAnnualIncome(760000);
			loan.setLoanpremium(2000);
			loan.setCreditscore(80);
			loan.setIndustry("Legal Services");*/
		//	kieSession.insert(loan);
			kieSession.fireAllRules();
			
			System.out.println("Testin");
			//System.out.println("Loan Status: "+ loan.isLoanstatus() + "Loan Reason :: "+ loan.getReason());
			//StatelessKieSession kieSession2 = kieContainer.newStatelessKieSession("defaultStatelessKieSession");
			//kieSession.fireAllRules();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
