package fr.snapfood.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
public interface IFileStorageService {
	 String storeFile(MultipartFile file);

	    Resource loadFileAsResource(String fileName);

}
