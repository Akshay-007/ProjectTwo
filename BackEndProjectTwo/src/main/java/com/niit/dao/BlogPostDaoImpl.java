package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.BlogPost;

@Repository
public class BlogPostDaoImpl implements BlogPostDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void saveBlogPost(BlogPost blogPost) {
		Session session = sessionFactory.openSession();
		session.save(blogPost);
		session.flush();
		session.close();
	}

	public List<BlogPost> getallblogs(boolean approved) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogPost where approval="+approved);
		@SuppressWarnings("unchecked")
		List<BlogPost> blogs=query.list();
		session.close();
		return blogs;
	}

}