package play.api.modules.amazons3;

import play.Application;
import play.Play;
import play.Plugin;

/**
 * Amazon S3 plugin
 * 
 * @author Stephen Enright
 * 
 */
public class AmazonS3Plugin extends Plugin {

	public AmazonS3Plugin() {

	}

	public AmazonS3Plugin(Application application) {

	}

	@Override
	public boolean enabled() {
		// TODO Auto-generated method stub
		return super.enabled();
	}

	@Override
	public void onStart() {

		// check if not enabled
		if (Play.application().configuration().getString("aws-s3-enabled") != null
				&& Play.application().configuration()
						.getString("aws-s3-enabled").equalsIgnoreCase("false")) {
			return;
		}

		if (Play.application().configuration().getString("aws-access-key") == null) {
			throw new RuntimeException(
					"Bad configuration for s3: aws-access-key");
		} else if (Play.application().configuration()
				.getString("aws-secret-key") != null) {
			throw new RuntimeException(
					"Bad configuration for s3: aws-secret-key");
		} else if (Play.application().configuration().getString("s3-bucket") == null) {
			throw new RuntimeException("Bad configuration for s3: no s3-bucket");
		}
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

}
