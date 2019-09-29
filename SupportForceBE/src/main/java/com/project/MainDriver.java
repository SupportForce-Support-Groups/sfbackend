package com.project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.project.controller.UserController;
import com.project.dao.AddictionDaoImpl;
import com.project.dao.PostDaoImpl;
import com.project.dao.ReplyDaoImpl;
import com.project.dao.SupportGroupDaoImpl;
import com.project.dao.UserDaoImpl;
import com.project.model.Addiction;
import com.project.model.Post;
import com.project.model.Reply;
import com.project.model.SupportGroup;
import com.project.model.User;
import com.project.service.AddictionServiceImpl;
import com.project.service.PostServiceImpl;
import com.project.service.ReplyServiceImpl;
import com.project.service.SupportGroupServiceImpl;
import com.project.service.UserServiceImpl;

public class MainDriver {
	
	public static ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static AddictionDaoImpl addictionDao = appContext.getBean("addictionDao", AddictionDaoImpl.class);
	public static AddictionServiceImpl addictionServ = appContext.getBean("addictionServ", AddictionServiceImpl.class);
	public static PostDaoImpl postDao = appContext.getBean("postDao", PostDaoImpl.class);
	public static PostServiceImpl postServ = appContext.getBean("postServ", PostServiceImpl.class);
	public static ReplyDaoImpl replyDao = appContext.getBean("replyDao", ReplyDaoImpl.class);
	public static ReplyServiceImpl replyServ = appContext.getBean("replyServ", ReplyServiceImpl.class);
	public static SupportGroupDaoImpl sgDao = appContext.getBean("supportGroupDao", SupportGroupDaoImpl.class);
	public static SupportGroupServiceImpl sgServ = appContext.getBean("supportGroupServ", SupportGroupServiceImpl.class);
	public static UserDaoImpl userDao = appContext.getBean("userDao", UserDaoImpl.class);
	public static UserServiceImpl userServ = appContext.getBean("userServ", UserServiceImpl.class);
	//public static UserController userController = appContext.getBean("userController", UserController.class);
	
	/*
	 * public static AddictionDao aDao = new AddictionDaoImpl();*/
	 //public static UserDao uDao = new UserDaoImpl(); 
	 //public static PostDao pDao = new PostDaoImpl(); 
	 //public static ReplyDao rDao = new ReplyDaoImpl(); 
	 //public static SupportGroupDao sgDao = new SupportGroupDaoImpl(); 
	 //public static UserService userServ = new UserServiceImpl(); 
	 //public static AddictionService addictionServ = new AddictionServiceImpl(); 
	 //public static PostService postServ = new PostServiceImpl(); 
	 //public static ReplyService replyServ = new ReplyServiceImpl(); 
	 //public static SupportGroupService supportGrpServ = new SupportGroupServiceImpl();
	
	
	public static void main(String[] args) {
		insertInitialValues();
		
		System.out.println("These are a list of all addictions in the database: \n");
		System.out.println(addictionDao.selectAllAddictions());
		
		System.out.println("This the addiction with the id of 5");
		System.out.println(addictionDao.selectById(5));
		
		System.out.println("This is the addiction with the id of 4");
		System.out.println(addictionServ.getSpecificAddiction(4));
		
		System.out.println("This is a list of all addictions in the database: \n");
		System.out.println(addictionServ.getListOfAddictions());
		
		System.out.println("These are a list of all replies in the database: \n");
		System.out.println(replyDao.selectAllReplies());
		
		System.out.println("This is the reply with the id of 10");
		System.out.println(replyDao.selectById(6));
		
		
		System.out.println("These are a list of all posts in the database: \n");
		System.out.println(postDao.selectAllPosts());
		
		System.out.println("This is the post with the id of 2");
		System.out.println(postDao.selectById(2));
		
		postServ.creationPost("Hey, where is a good place I can start my path to soberity?", 1, 1);
		replyServ.creationReply("The first step is always admitting you have a problem. Congratulations you are already on route for soberity!", 3);
		System.out.println("These are a list of all replies in the database: \n");
		System.out.println(replyServ.listOfAllReplies());
		
		System.out.println(postServ);
		System.out.println("These are a list of all posts in the database: \n");
		System.out.println(postDao.selectAllPosts());
		
		System.out.println("These are a list of all users in the database: \n");
		System.out.println(userDao.selectAllUsers());
		
		System.out.println("This is the user with the id of 1: ");
		System.out.println(userDao.selectById(1));
		
		userServ.registerUser("Jason", "password", "jason.kim@gmail.com");
		System.out.println("These are a list of all users in the database: \n");
		System.out.println(userServ.selectAllUsers());
		
		userServ.UserLogin("jyothi", "password");
		
		System.out.println("These are a list of all support groups: \n");
		System.out.println(sgDao.selectAllSupportGroups());
		
		System.out.println("This is the support group with an ID of 1");
		System.out.println(sgDao.selectById(1));
		
		sgServ.creationOfSupportGroup("Gambling Billionaries", 5, 1);
		System.out.println("These are a list of all support groups in the database: \n");
		System.out.println(sgDao.selectAllSupportGroups());
		
		System.out.println(sgServ.selectAllSupportGroups());
		
		System.out.println("\nDone!");
	}
	
	public static void insertInitialValues() {
		//ADDICTIONS
		Addiction add1 = new Addiction("Alcohol");
		Addiction add2 = new Addiction("Heroin");
		Addiction add3 = new Addiction("Painkillers");
		Addiction add4 = new Addiction("Meth");
		Addiction add5 = new Addiction("Gambling");
		Addiction add6 = new Addiction("Nicotine");
		Addiction add7 = new Addiction("Cocaine");
		
		//POSTS
		Post post1 = new Post("How are you guys doing on your road to recovery?");
		Post post2 = new Post("Is it just me or is this process really hard to recover from addiction? I'm always thinking about relapsing.");
		
		//REPLIES
		Reply reply1 = new Reply("It's going okay, but it's only been one day so far", post1);
		post1.getReplies().add(reply1);
		Reply reply2 = new Reply("It's going better than the first couple of weeks", post1);
		post1.getReplies().add(reply2);
		Reply reply3 = new Reply("Trust me... it gets better with time.", post1);
		post1.getReplies().add(reply3);
		Reply reply4 = new Reply("Yes, it's a hard process. But, you will come out as the bigger person after this process is said and done.", post2);
		post2.getReplies().add(reply4);
		Reply reply5 = new Reply("Trust me you're not by yourself in this road to recovery. We're here to support you as well.", post2);
		post2.getReplies().add(reply5);
		Reply reply6 = new Reply("One person's success is everybodies. so, calm down.", post2);
		post2.getReplies().add(reply6);
		
		//SUPPORT GROUP
		SupportGroup sg1 = new SupportGroup("Alcohol, Never Again", add1);
		sg1.getPostList().add(post1);
		sg1.getPostList().add(post2);
		sg1.getReplyList().add(reply1);
		sg1.getReplyList().add(reply2);
		sg1.getReplyList().add(reply4);
		sg1.getReplyList().add(reply6);
		SupportGroup sg2 = new SupportGroup("Cocaine, I Don't Need You Anyway", add7);
		sg2.getPostList().add(post1);
		sg2.getReplyList().add(reply1);
		sg2.getReplyList().add(reply2);
		sg2.getReplyList().add(reply3);
		
		
		//USERS
		User user1 = new User("jyothi", "password", "jyothi.thi@gmail.com");
		user1.getAddictions().add(add5);
		user1.getAddictions().add(add1);
		user1.getSupportGroups().add(sg1);
		user1.getPosts().add(post1);
		user1.getReplies().add(reply3);
		user1.getReplies().add(reply6);
		sg1.getSupportGroupUsers().add(user1);
		User user2 = new User("easley", "password", "easley.boo@gmail.com");
		user2.getAddictions().add(add1);
		user2.getAddictions().add(add3);
		user2.getSupportGroups().add(sg1);
		user2.getPosts().add(post2);
		user2.getReplies().add(reply1);
		sg1.getSupportGroupUsers().add(user2);
		
		//INSERTS FOR ADDICTIONS
		addictionDao.insert(add1);
		addictionDao.insert(add2);
		addictionDao.insert(add3);
		addictionDao.insert(add4);
		addictionDao.insert(add5);
		addictionDao.insert(add6);
		addictionDao.insert(add7);
		
		//INSERTS FOR POSTS
		postDao.insert(post1);
		postDao.insert(post2);
		
		//INSERTS FOR REPLIES
		replyDao.insert(reply1);
		replyDao.insert(reply2);
		replyDao.insert(reply3);
		replyDao.insert(reply4);
		replyDao.insert(reply5);
		replyDao.insert(reply6);
		
		//INSERTS FOR USERS
		userDao.insert(user1);
		userDao.insert(user2);
		
		//INSERTS FOR SUPPORT GROUPS
		sgDao.insert(sg1);
		sgDao.insert(sg2);
		
	}
}
