package service.amazonS3;

import java.io.InputStream;

import com.amazonaws.services.s3.AmazonS3;

/**
 * Amazon S3 Service
 * @author Stephen Enright
 *
 */
public interface AmazonS3Service {
	
	/**
	 * Add an item to the bucket
	 * @param is		the items input stream
	 * @param type		the item type
	 * @param objectKey	the object key
	 */
	public void set(InputStream is, String type, String objectKey);
	
	/**
	 * Get an item from the bucket
	 * @param objectKey	the objhect key in the bucket
	 * @return
	 */
	public InputStream get(String objectKey);
	
	/**
	 * Returns the configured AmazonS3 client
	 * @return
	 */
	public AmazonS3 getS3Client();
	
	
	/**
	 * Removes an item from the s3 bucket
	 * @param objectKey		the object key of the item to delete
	 * @return				true if deleted, otherwise false
	 */
	public boolean deleteObject(String objectKey);

}
