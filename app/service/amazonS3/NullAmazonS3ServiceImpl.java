package service.amazonS3;

import java.io.InputStream;

import com.amazonaws.services.s3.AmazonS3;

/**
 * An Amazon s3 service that does nothing, 
 * @author Stephen Enright
 *
 */
public class NullAmazonS3ServiceImpl implements AmazonS3Service {

	@Override
	public void set(InputStream is, String type, String objectKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InputStream get(String objectKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AmazonS3 getS3Client() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteObject(String objectKey) {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	
	
}
