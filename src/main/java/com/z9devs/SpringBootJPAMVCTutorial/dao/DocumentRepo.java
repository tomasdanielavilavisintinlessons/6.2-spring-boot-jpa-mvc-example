package com.z9devs.SpringBootJPAMVCTutorial.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.z9devs.SpringBootJPAMVCTutorial.Document;

public interface DocumentRepo extends JpaRepository<Document, Integer>
{
	// Così aggiungo delle query aggiuntive, seguendo lo standard per cui
	// il nome del metodo deve essere fatto da "findBy" + nome della proprietà
	public List<Document> findBySkills(String skill);
	
	public List<Document> findByIdGreaterThan(int id);
	
	@Query("from Document where name=?1 and skills=?2")
	public List<Document> findBySkillAndName(String name, String skill);
}
