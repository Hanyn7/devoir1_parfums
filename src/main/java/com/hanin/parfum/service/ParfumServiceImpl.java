package com.hanin.parfum.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanin.parfum.entities.Famille;
import com.hanin.parfum.entities.Parfum;
import com.hanin.parfum.repos.ImageRepository;
import com.hanin.parfum.repos.ParfumRepository;

@Service
public class ParfumServiceImpl implements ParfumService {
	@Autowired
	ParfumRepository parfumRepository;
	@Autowired
	ImageRepository imageRepository;


	@Override
	public void deleteParfum(Parfum p) {
	parfumRepository.delete(p);
	}

	@Override
	public void deleteParfumById(Long id) {
	 Parfum p = getParfum(id);
	try {
	Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
	} catch (IOException e) {
	e.printStackTrace();
	}
	parfumRepository.deleteById(id);
	}
	
	@Override
	public Parfum getParfum(Long id) {
	return parfumRepository.findById(id).get();
	}

	@Override
	public List<Parfum> getAllParfums() {
	return parfumRepository.findAll();
	}

	@Override
	public Parfum saveParfum(Parfum p) {
		return parfumRepository.save(p);
	}

	@Override
	public Parfum updateParfum(Parfum p) {
	//Long oldProdImageId = this.getParfum(p.getIdParfum()).getImage().getIdImage();
	//Long newProdImageId = p.getImage().getIdImage();
	Parfum prodUpdated = parfumRepository.save(p);
	//if (oldProdImageId != newProdImageId) 
	//imageRepository.deleteById(oldProdImageId);
	return prodUpdated;
	}

	@Override
	public List<Parfum> findByNomParfum(String nom) {
		return parfumRepository.findByNomParfum(nom);
	}

	@Override
	public List<Parfum> findByNomParfumContains(String nom) {
		return parfumRepository.findByNomParfumContains(nom);
	}

	@Override
	public List<Parfum> findByNomPrix(String nom, Double prix) {
		return parfumRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Parfum> findByFamille(Famille famille) {
		return parfumRepository.findByFamille(famille);
	}

	@Override
	public List<Parfum> findByFamilleIdFam(Long id) {
		return parfumRepository.findByFamilleIdFam(id);
	}

	@Override
	public List<Parfum> findByOrderByNomParfumAsc() {
		return parfumRepository.findByOrderByNomParfumAsc();
	}

	@Override
	public List<Parfum> trierParfumsNomsPrix() {
		return parfumRepository.trierParfumsNomsPrix();
	}

	
}
