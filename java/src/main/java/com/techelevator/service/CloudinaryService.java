//package com.techelevator.service;
//
//import com.cloudinary.Cloudinary;
//import com.cloudinary.utils.ObjectUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.util.Map;
//
//@Service
//public class CloudinaryService {
//
//    private Cloudinary cloudinary;
//
//    @Value("${cloudinary.cloud_name}")
//    private String cloudName;
//
//    @Value("${cloudinary.api_key}")
//    private String apiKey;
//
//    @Value("${cloudinary.api_secret}")
//    private String apiSecret;
//
//    @PostConstruct
//    public void init() {
//        cloudinary = new Cloudinary(ObjectUtils.asMap(
//                "cloud_name", cloudName,
//                "api_key", apiKey,
//                "api_secret", apiSecret
//        ));
//    }
//
//    // takes in the byte representation of the image being uploaded, obtained from MultipartFile object in ImageController
//    // Uploads image using the image data as an argument then gets and returns the image URL.
//    // The controller will send the URL to be stored in the database.
//    // If we want to add specific options or configurations for uploading, we can add them to the (currently) emptyMap object.
//    public String uploadImage(byte[] imageBytes) throws Exception {
//        Map<String, Object> uploadResult = cloudinary.uploader().upload(imageBytes, ObjectUtils.emptyMap());
//        return (String) uploadResult.get("url");
//    }
//
//}
