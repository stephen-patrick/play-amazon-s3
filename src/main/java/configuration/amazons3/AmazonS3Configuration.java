package configuration.amazons3;

import service.amazonS3.AmazonS3Service;

/**
 * Amazon s3 configuration.
 * 
 * The configureS3 method should be called once to configure the plugin the configuration can be swapped
 * by calling setConfigurator prior to calling configureS3
 * @author Stephen Enright
 *
 */
public class AmazonS3Configuration {
	
	private static AmazonS3Configurator defaultConfigurator = new AmazonS3StandardConfiguratorImpl();
	private static AmazonS3Configurator configurator = null;
	
	
	
	public static void configureS3() {
		getConfigurator().configureS3();
	}
	
	public static AmazonS3Service getAmazonS3Service() {
		return  getConfigurator().getAmazonS3Service();
	}


	public static AmazonS3Configurator getConfigurator() {
		return (configurator != null ? configurator : defaultConfigurator);
	}



	public static void setConfigurator(AmazonS3Configurator configurator) {
		AmazonS3Configuration.configurator = configurator;
	}
}
