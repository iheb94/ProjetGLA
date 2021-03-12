package fr.snapfood.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import fr.snapfood.model.Picture;
import fr.snapfood.model.Product;
import fr.snapfood.service.IPictureService;
import fr.snapfood.service.IProductService;
import fr.snapfood.service.Imp.FileStorageServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PictureRest {
    private static final Logger log = LoggerFactory.getLogger(PictureRest.class);
    @Autowired
    private final FileStorageServiceImpl fileStorageService;
    @Autowired
    IPictureService iPictureService;
    @Autowired
    IProductService iProductService;
    public PictureRest(IPictureService iPictureService, FileStorageServiceImpl fileStorageService,IProductService iProductService) {
        this.iPictureService = iPictureService;
        this.fileStorageService = fileStorageService;
        this.iProductService=iProductService;
    }

    @PostMapping("/picture")
    public Picture add(@RequestBody Picture picture) {
        return iPictureService.addPicture(picture);
    }

    @PutMapping("/picture")
    public Picture update(@RequestBody Picture picture) {
        return iPictureService.updatePicture(picture);
    }

    @DeleteMapping("/picture/{id}")
    public void delete(@PathVariable int id) {
        iPictureService.deletePictureById(id);
    }

    @PostMapping("/upload/{idproduct}")
        public void uploadFile(@RequestParam(value = "file") MultipartFile file, @PathVariable int idproduct) {
       String  baseURL = "http://127.0.0.1:8080/api/getfile/";
        Optional<Product> productById = iProductService.getProductById(idproduct);
        if (productById.isPresent()) {
            String fileName = fileStorageService.storeFile(file);
            Picture picture = new Picture();
            picture.setBig( baseURL + fileName);
            picture.setSmall(baseURL + fileName);
            picture.setProducts(productById.get());
            iPictureService.addPicture(picture);
        }
    }

    @GetMapping("getfile/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            log.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }@GetMapping("img/{id}")
    public List<Picture> getpicbyproduct(@PathVariable("id")int x) {
		// TODO Auto-generated method stub
		return (List<Picture>)iPictureService.getpicbyproduct(x);
	}
}