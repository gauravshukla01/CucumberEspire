package commonUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath= System.getProperty("user.dir")+ System.getProperty("file.separator")
	+"src\\test\\resources\\configuration\\config.properties";
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties file not found at " + propertyFilePath);
		}		
	}

	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) 
			return driverPath;
		else throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");		
	}

	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			try{
				return Long.parseLong(implicitlyWait);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		return 30;		
	}

	public String getApplicationUrl() {
		String applicationUrl = properties.getProperty("applicationUrl");
		if(applicationUrl != null) return applicationUrl;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key: applicationUrl");
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browserName.equals("edge")) return DriverType.EDGE;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}
	
	public String getAzureEndPointToCreateTask() {
		String azureEndPointToCreateTask = properties.getProperty("azureEndPointToCreateTask");
		if(azureEndPointToCreateTask != null) return azureEndPointToCreateTask;
		else throw new RuntimeException("Azure endPoint to createTask not specified in the Configuration.properties file for the Key:azureEndPointToCreateTask");	
	}
	
	public String getAzurePeronalToken() {
		String azurePersonalAccessToken = properties.getProperty("azurePersonalAccessToken");
		if(azurePersonalAccessToken != null) return azurePersonalAccessToken;
		else throw new RuntimeException("Azure personal token not specified in the Configuration.properties file for the Key:azurePersonalAccessToken");	
	}
	
	public String getAzureOrganizationName() {
		String azureOrganozationName = properties.getProperty("azureOrganozationName");
		if(azureOrganozationName != null) return azureOrganozationName;
		else throw new RuntimeException("Azure organization name not specified in the Configuration.properties file for the Key:azureOrganozationName");	
	}
	
	public String getAzureProjectName() {
		String azureProjectName = properties.getProperty("azureProjectName");
		if(azureProjectName != null) return azureProjectName;
		else throw new RuntimeException("Azure project name not specified in the Configuration.properties file for the Key:azureProjectName");	
	}
	
	public long getAzureTestDefectsEpicId() {
		String azureTestDefectsEpicId = properties.getProperty("azureTestDefectsEpicId");
		if(azureTestDefectsEpicId != null)
           return Long.parseLong(azureTestDefectsEpicId);
	       throw new RuntimeException("Not able to parse value : " + azureTestDefectsEpicId + " in to Long");
			}
	
	public String getAzureProjectId() {
		String azureProjectId = properties.getProperty("azureProjectID");
		if(azureProjectId != null)
           return azureProjectId;
	       throw new RuntimeException("Azure project ID not specified in the Configuration.properties file for the Key:azureProjectID");
			}
	
	public String getAzureSessionId() {
		String azureSessionID = properties.getProperty("azureSessionID");
		if(azureSessionID != null)
           return azureSessionID;
	       throw new RuntimeException("Azure session ID not specified in the Configuration.properties file for the Key:azureSessionID");
			}
	
	public String getAzureKeyVaultUrl() {
		String azureKeyVaultURL = properties.getProperty("azureKeyVaultURL");
		if(azureKeyVaultURL != null)
           return azureKeyVaultURL;
	       throw new RuntimeException("Azure key vault Url not specified in the Configuration.properties file for the Key:azureKeyVaultURL");
			}
	
	public String getAzureKeyName() {
		String azureKeyName = properties.getProperty("azureKeyName");
		if(azureKeyName != null)
           return azureKeyName;
	       throw new RuntimeException("Azure key name not specified in the Configuration.properties file for the Key:azureKeyName");
		}
	
	public String getEmailableReportPath() {
		String reportPath = properties.getProperty("reportPath");
		if(reportPath != null)
           return reportPath;
	       throw new RuntimeException("Azure key name not specified in the Configuration.properties file for the Key:reportPath");
		}
	
	public String getEmailRecieverAddress() {
		String recieverEmailAddress = properties.getProperty("recieverEmailAddress");
		if(recieverEmailAddress != null)
           return recieverEmailAddress;
	       throw new RuntimeException("Azure key name not specified in the Configuration.properties file for the Key:recieverEmailAddress");
		}
	
	public String getEmailSenderAddress() {
		String senderEmailAddress = properties.getProperty("senderEmailAddress");
		if(senderEmailAddress != null)
           return senderEmailAddress;
	       throw new RuntimeException("Azure key name not specified in the Configuration.properties file for the Key:senderEmailAddress");
		}
	
	public String getEmailSenderPassword() {
		String senderEmailPassword = properties.getProperty("senderEmailPassword");
		if(senderEmailPassword != null)
           return senderEmailPassword;
	       throw new RuntimeException("Azure key name not specified in the Configuration.properties file for the Key:senderEmailPassword");
		}
	
	public String getEmailHostAddress() {
		String host = properties.getProperty("host");
		if(host != null)
           return host;
	       throw new RuntimeException("Azure key name not specified in the Configuration.properties file for the Key:host");
		}
	
	public String getEmailHostPortNumber() {
		String portNumber = properties.getProperty("portNumber");
		if(portNumber != null)
           return portNumber;
	       throw new RuntimeException("Azure key name not specified in the Configuration.properties file for the Key:portNumber");
		}
	
	public String getEmailSubject() {
		String emailSubject = properties.getProperty("emailSubject");
		if(emailSubject != null)
           return emailSubject;
	       throw new RuntimeException("Azure key name not specified in the Configuration.properties file for the Key:reportPath");
		}
	
	public String getEmailBody() {
		String emailBody = properties.getProperty("emailBody");
		if(emailBody != null)
           return emailBody;
	       throw new RuntimeException("Azure key name not specified in the Configuration.properties file for the Key:emailBody");
		}
	

	public String getApplicationEnvironment() {
		String applicationEnvironment = properties.getProperty("applicationEnvironment");
		if(applicationEnvironment != null)
           return applicationEnvironment;
	       throw new RuntimeException("Application Envinorment not specified in the Configuration.properties file for the Key:applicationEnvironment");
		}
	
}
