package com.mycompany.app.model;

import org.springframework.context.Lifecycle;

public class BlogService implements Lifecycle {
	
	private BlogDao blogDao;
	
	public BlogService() {
		
	}
	
	public void setBlogDao(BlogDao blogdao) {
		this.blogDao = blogdao;
	}

	public BlogService(BlogDao blogdao) {
		super();
		this.blogDao = blogdao;
	}

	public void init() {
		if(this.blogDao == null) {
			throw new IllegalStateException("This {blogDao} property is set");
		}
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
		System.out.println(" Blog Service is started");
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println(" Blog Service is stopped");
	}

	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
