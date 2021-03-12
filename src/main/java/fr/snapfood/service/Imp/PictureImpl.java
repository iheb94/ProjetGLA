package fr.snapfood.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import fr.snapfood.model.Category;
import fr.snapfood.model.Picture;
import fr.snapfood.repository.PictureRepository;
import fr.snapfood.service.IPictureService;

@Service
public class PictureImpl implements IPictureService {
    @Autowired
    PictureRepository pictureRepository;

    public PictureImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Iterable<Picture> getAllPictures() {
        return pictureRepository.findAll();
    }

    @Override
    public Optional<Picture> getPictureById(Integer id) {
        return pictureRepository.findById(id);
    }

    @Override
    public Picture addPicture(Picture picture) {
        return pictureRepository.save(picture);
    }

    @Override
    public Picture updatePicture(Picture picture) {
        return  pictureRepository.save(picture);
    }

    @Override
    public void deletePictureById(Integer id) {
        pictureRepository.deleteById(id);
    }

    @Override
    public void deletePictureByEntity(Picture picture) {
        pictureRepository.delete(picture);
    }

	@Override
	public Picture getpicbyproduct(int x) {
		// TODO Auto-generated method stub
		return pictureRepository.getpicbyproduct(x);
	}
}