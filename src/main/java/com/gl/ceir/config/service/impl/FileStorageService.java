package com.gl.ceir.config.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private static final Logger logger = LogManager.getLogger(FileStorageService.class);


    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        logger.info("File Name" + fileName);
        try {
            if (fileName.contains(".."))
                logger.error("Sorry! Filename contains invalid path sequence " + fileName);  // Check if the file's name contains invalid characters
            var fileStorageLocation = Paths.get("/home/sachin/glocks/").toAbsolutePath().normalize();
            Files.createDirectories(fileStorageLocation);
            Path targetLocation = fileStorageLocation.resolve(fileName); // Copy file to the target location (Replacing existing file with the same name)
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileStorageLocation.toString();
        } catch (IOException ex) {
            logger.error("Could not store file " + fileName + ". Please try again!", ex);
            return null;
        }
    }

    /*  File Download */
    /*  */
    /*  */
    public Resource getFileForDownload(String fileName) {

        var fileStorageLocation = Paths.get("/home/sachin/").toAbsolutePath().normalize();
        logger.info("File Storage Location " + fileStorageLocation);
        try {
            Files.createDirectories(fileStorageLocation);
        } catch (Exception ex) {
            logger.error("Could not create the directory where the uploaded files will be stored.", ex);
        }
        try {
            Path filePath = fileStorageLocation.resolve(fileName).normalize();
            logger.info("File filePath " + filePath);

            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return resource;
            } else {
                logger.error("File not found ie Resource Not exists " + fileName);
                return null;
            }
        } catch (MalformedURLException ex) {
            logger.error("File not found  " + fileName, ex);
            return null;
        }
    }

}
