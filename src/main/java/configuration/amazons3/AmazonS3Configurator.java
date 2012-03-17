package configuration.amazons3;

import service.amazonS3.AmazonS3Service;

/**
 * An interface which represents the configurator for the amazon s3 service
 * @author stephen
 *
 */
public interface AmazonS3Configurator {
	
	public void configureS3();
	
	
	/**
	 * Returns the configured s3 service
	 * @return the configurd s3 service
	 */
	public AmazonS3Service getAmazonS3Service();

}
