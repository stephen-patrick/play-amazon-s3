A Simple module for working with amazon S3, get, put, remove from an amazon s3 bucket

This module requires the following properties to be set in applicaiton config 


s3-bucket -- the bucket name to use
aws-access-key -- the access key to use
aws-secret-key - the secret key to use
aws-s3-enabled -- set to true to enable s3 interaction, other false

Note the plugin will throw an exception if the plugin is enabled and the above properties are not set.
If the plugin is enabled and you would like it disabled so the configuration error is not thrown
set the property aws-s3-enabled="false"




Policy to all all users read the contents on upload
Should be set on the s3 bucket
{
	"Version": "2008-10-17",
	"Id": "",
	"Statement": [
		{
			"Sid": "AddPerm",
			"Effect": "Allow",
			"Principal": {
				"AWS": "*"
			},
			"Action": "s3:GetObject",
			"Resource": "arn:aws:s3:::YOUR BUCKET NAME/*"
		}
	]
}