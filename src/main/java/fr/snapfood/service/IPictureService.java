package fr.snapfood.service;

import java.util.List;
import java.util.Optional;

import fr.snapfood.model.Picture;

public interface IPictureService {
	 Iterable<Picture> getAllPictures();
	 Picture getpicbyproduct(int x);
	    Optional<Picture> getPictureById(Integer id);

	    Picture addPicture(Picture picture);

	    Picture updatePicture(Picture picture);

	    void deletePictureById(Integer id);

	    void deletePictureByEntity(Picture picture);

}
