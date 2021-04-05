package com.revature.services;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

@Service
public class AmazonClient {
	private AmazonS3 s3client;

    @Value("${amazonProperties.endpointUrl}")
    private String endpointUrl;
    @Value("${amazonProperties.bucketName}")
    private String bucketName;
    @Value("${amazonProperties.accessKey}")
    private String accessKey;
    @Value("${amazonProperties.secretKey}")
    private String secretKey;
   
    @PostConstruct
    private void initializeAmazon() {
       //AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
    	AWSCredentials credentials = new BasicAWSCredentials("AKIAQGUVDSHJANFEWTU7", "9oHkO0omoEFSEamhtLze05FWXwyfv075lKvdyc3G");
       this.s3client = AmazonS3ClientBuilder
    		   .standard()
    		   .withCredentials(new AWSStaticCredentialsProvider(credentials))
    		   .withRegion(Regions.US_WEST_1)
    		   .build(); 
    }
    
    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }
    private void uploadFileTos3bucket(String fileName, File file) {

    	s3client.putObject(new PutObjectRequest("p2revstoreimages", fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    	
    	//return this object so that the picture can be set to this
    }
    
    public String uploadFile(MultipartFile multipartFile) {

        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = "https://s3.us-west-1.amazonaws.com" + "/" + "p2revstoreimages" + "/" + fileName;
            uploadFileTos3bucket(fileName, file);
            file.delete();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return fileUrl;
    }
    
    public String deleteFileFromS3Bucket(String fileUrl) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        s3client.deleteObject(new DeleteObjectRequest(bucketName + "/", fileName));
        return "Successfully deleted";
    }
    
    public byte[] retrieveImage(String url) {
    	S3Object s3object = s3client.getObject("p2revstoreimages",url);
    	S3ObjectInputStream inputStream = s3object.getObjectContent();
    	
    	ByteArrayOutputStream output = new ByteArrayOutputStream();
    	
    	int n = 0;
        byte [] buffer = new byte[ 1024 ];
        try {
			while (-1 != (n = inputStream.read(buffer))) {
			    output.write(buffer, 0, n);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
        return output.toByteArray();
    }

}
