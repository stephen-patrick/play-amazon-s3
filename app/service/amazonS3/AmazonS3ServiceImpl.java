package service.amazonS3;

import java.io.InputStream;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;


/**
 * Simple amazon s3 service for getting and saving media
 * 
 * @author Stephen Enright
 *
 */
public class AmazonS3ServiceImpl implements AmazonS3Service {

	private final AmazonS3 s3Client;
	private String bucket;
	
	
	/**
	 * Creates a new Amazon S3 service for the given the given connection
	 * details and bucket.
	 * @param bucket
	 * @param key
	 * @param accessKey
	 * @param create true to create the bucket if it does not exist
	 */
	public AmazonS3ServiceImpl(String bucket, String accessKey, String secretKey, boolean create) {
		this.bucket = bucket;
		AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
		s3Client = new AmazonS3Client(awsCredentials);
		 
		 if (create && !s3Client.doesBucketExist(bucket)) {
		     s3Client.createBucket(bucket);
		 } 
	}
	

	@Override
	public AmazonS3 getS3Client() {
		return s3Client;
	}

	
	@Override
	public InputStream get(String objectKey) {
		S3Object s3Object = s3Client.getObject(bucket, objectKey);
		return s3Object.getObjectContent();
	}


	@Override
	public void set(InputStream is, String type, String objectKey) {
	    ObjectMetadata om = new ObjectMetadata();
	    om.setContentType(type);
	    s3Client.putObject(bucket, objectKey, is, om);
	}

	
	@Override
	public boolean deleteObject(String objectKey) {
		s3Client.deleteObject(new DeleteObjectRequest(bucket, objectKey));
		return true;
	}


	protected boolean exists(String objectKey) {
		ObjectMetadata om = s3Client.getObjectMetadata(bucket, objectKey);
		return om != null;
	}
	
}
