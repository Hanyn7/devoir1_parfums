package com.hanin.parfum.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.hanin.parfum.entities.Image;
public interface ImageService {
 Image uplaodImage(MultipartFile file) throws IOException;
 Image getImageDetails(Long id) throws IOException;
 ResponseEntity<byte[]> getImage(Long id) throws IOException;
 void deleteImage(Long id) ;
 Image uplaodImageParf(MultipartFile file,Long idParf) throws IOException;
 List<Image> getImagesParParf(Long parfId);
}