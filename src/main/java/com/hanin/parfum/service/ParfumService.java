package com.hanin.parfum.service;

import java.util.List;

import com.hanin.parfum.entities.Famille;
import com.hanin.parfum.entities.Parfum;

public interface ParfumService {
	Parfum saveParfum(Parfum p);
	Parfum updateParfum(Parfum p);
	void deleteParfum(Parfum p);
	void deleteParfumById(Long id);
	Parfum getParfum(Long id);
	List<Parfum> getAllParfums();
	List<Parfum> findByNomParfum(String nom);
	List<Parfum> findByNomParfumContains(String nom);
	List<Parfum> findByNomPrix (String nom, Double prix);
	List<Parfum> findByFamille (Famille famille);
	List<Parfum> findByFamilleIdFam(Long id);
	List<Parfum> findByOrderByNomParfumAsc();
	List<Parfum> trierParfumsNomsPrix();
}
