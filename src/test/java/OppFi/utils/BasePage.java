package OppFi.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public abstract class BasePage {

    public static String  requestBody = "{       \"isProduction\": false,\n" +
            "        \"language\": \"en\",\n" +
            "        \"currency\": \"USD\",\n" +
            "        \"campaignId\": \"11-50-newhope\",\n" +
            "        \"socialSecurityNumber\":\""+ConfigurationReader.getProperty("SSN") +  "\",\n" +
            "        \"leadOfferId\": \"20160912-21EC2020-3AEA-4069-A2DD-08002B30309D\",\n" +
            "        \"email\": \"test_customer@gmail.com\",\n" +
            "        \"stateCode\": \"FL\",\n" +
            "        \"grossMonthlyIncome\": 2800,\n" +
            "        \"personalInfo\": {\n" +
            "        \"firstName\": \"Jennifer\",\n" +
            "        \"lastName\": \"Smith\",\n" +
            "        \"dateOfBirth\": \"19451009\",\n" +
            "        \"address\": {\n" +
            "        \"streetAddress\": \"123 Main Street\",\n" +
            "        \"city\": \"Miami\",\n" +
            "        \"zip\": \"33125\",\n" +
            "        \"countryCode\":\"US\"\n" +
            "        },\n" +
            "        \"mobilePhone\": \"3224340098\",\n" +
            "        \"homePhone\": \"4523452232\"\n" +
            "        },\n" +
            "        \"bankInfo\": {\n" +
            "        \"bankName\": \"Chase\",\n" +
            "        \"abaRoutingNumber\": \"123456789\",\n" +
            "        \"accountNumber\": \"012345789\",\n" +
            "        \"accountType\": 1,\n" +
            "        \"accountLength\": 6\n" +
            "        },\n" +
            "        \"incomeInfo\": {\n" +
            "        \"incomeType\": \"Employment\",\n" +
            "        \"payrollType\": \"DirectDeposit\",\n" +
            "        \"payrollFrequency\": 1,\n" +
            "        \"lastPayrollDate\": \"20160915\"\n" +
            "        },\n" +
            "        \"employmentInfo\": {\n" +
            "        \"employerName\": \"ToysRUs\",\n" +
            "        \"hireDate\": \"20110516\"\n" +
            "        },\n" +
            "        \"requestedLoanAmount\": 1500}\n";


}



