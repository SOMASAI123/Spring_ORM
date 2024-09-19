package com.spring.springOrm.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.springOrm.entities.Teacher;

public class TeacherDao {
    

	private HibernateTemplate hibernateTemplate;
	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int insert(Teacher teacher)
	{
	  Integer i=(Integer) this.hibernateTemplate.save(teacher);
		return i;
	}
	
	@Transactional
	public Teacher getdetails(int id)
	{
		Teacher teacher=this.hibernateTemplate.get(Teacher.class, id);
		return teacher;
	}
	@Transactional
	public List<Teacher> getalldetails()
	{
	   List<Teacher> teacher=this.hibernateTemplate.loadAll(Teacher.class);
		return teacher;
	}
	@Transactional
	public void delete(int id)
	{
	Teacher teacher=this.hibernateTemplate.get(Teacher.class, id);
	
	this.hibernateTemplate.delete(teacher);
	}
	@Transactional
	public void update(int id)
	{
		Teacher teacher=this.hibernateTemplate.get(Teacher.class,id);
		this.hibernateTemplate.update(teacher);
		
	}
	
}
