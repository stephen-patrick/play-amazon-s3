package configuration.amazons3;

import play.Play;
import service.amazonS3.AmazonS3Service;
import service.amazonS3.AmazonS3ServiceImpl;
import service.amazonS3.NullAmazonS3ServiceImpl;

/**
 * Standard Amazon S3 Configuration
 * @author Stephen Enright
 *
 */
public class AmazonS3StandardConfiguratorImpl implements AmazonS3Configurator {

	/**
	 * Amazon s3 service
	 */
	private  AmazonS3Service amazonS3Service;
	
	
	@Override
	public void configureS3() {
		String bucket = getConfigurationValue("s3-bucket");
		  String accessKey = getConfigurationValue("aws-access-key");
		  String secretKey = getConfigurationValue("aws-secret-key");
		  String enabled = getConfigurationValue("aws-s3-enabled");
		  if(enabled!=null && enabled.equals("true")) {
			  amazonS3Service = new AmazonS3ServiceImpl(bucket, accessKey, secretKey, true);  
		  }
		  else {
			  amazonS3Service = new NullAmazonS3ServiceImpl();
		  }
	}

	@Override
	public AmazonS3Service getAmazonS3Service() {
		return amazonS3Service;
	}

	
	protected String getConfigurationValue(String key) {
		return Play.application().configuration().getString(key);
	}
	

}
