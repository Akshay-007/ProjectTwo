package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.BlogComment;
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

	public BlogPost getBlogById(int id) {
		Session session=sessionFactory.openSession();
		BlogPost blogPost=(BlogPost) session.get(BlogPost.class, id);
		session.close();
		return blogPost;
	}

	public void updateBlogPost(BlogPost blogPost) {
		Session session=sessionFactory.openSession();
		session.update(blogPost);
		session.flush();
		session.close();
		
	}

	public void addComment(BlogComment blogComment) {
		Session session=sessionFactory.openSession();
		session.save(blogComment);
		session.flush();
		session.close();
	}

	public List<BlogComment> getBlogComments(int blogId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment where blogpost_id="+blogId);
		@SuppressWarnings("unchecked")
		List<BlogComment> blogComments=query.list();
		session.close();
		return blogComments;
	}
	
	public List<BlogComment> getBlogComments2(BlogPost blogPost)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment where blogpost_id="+blogPost.getId());
		@SuppressWarnings("unchecked")
		List<BlogComment> blogComments=query.list();
		session.close();
		return blogComments;
	}

}
