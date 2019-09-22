package com.project;

import java.util.ArrayList;
import java.util.List;

//import java.text.SimpleDateFormat;

import com.project.dao.AddictionDao;
import com.project.dao.PostDao;
import com.project.dao.ReplyDao;
import com.project.dao.SupportGroupDao;
import com.project.dao.UserDao;
import com.project.model.Addiction;
import com.project.model.Post;
import com.project.model.Reply;
import com.project.model.SupportGroup;
import com.project.model.User;
import com.project.util.HibernateUtil;

public class MainDriver {
	
	public static AddictionDao aDao = new AddictionDao();
	public static UserDao uDao = new UserDao();
	public static PostDao pDao = new PostDao();
	public static ReplyDao rDao = new ReplyDao();
	public static SupportGroupDao sgDao = new SupportGroupDao();
	
	public static void main(String[] args) {
		insertInitialValues();
		
		System.out.println("These are a list of all addictions in the database: \n");
		System.out.println(aDao.selectAllAddictions());
		
		System.out.println("These are a list of all users in the database: \n");
		System.out.println(uDao.selectAllUsers());
		
		System.out.println("These are a list of all posts in the database: \n");
		System.out.println(pDao.selectAllPosts());
		
		System.out.println("These are a list of all replies in the database: \n");
		System.out.println(rDao.selectAllReplies());
		
		System.out.println("These are a list of all support groups: \n");
		System.out.println(sgDao.selectAllSupportGroups());
		
		System.out.println("\nDone!");
		HibernateUtil.closeSes();
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
		List<Post> listPost = new ArrayList<>();
		listPost.add(post1);
		listPost.add(post2);
		List<Reply> listReply = new ArrayList<>();
		listReply.add(reply1);
		listReply.add(reply2);
		listReply.add(reply4);
		listReply.add(reply6);
		SupportGroup sg1 = new SupportGroup("Alcohol, Never Again", add1, listPost, listReply);
		listPost = new ArrayList<>();
		listPost.add(post1);
		listReply = new ArrayList<>();
		listReply.add(reply1);
		listReply.add(reply2);
		listReply.add(reply3);
		SupportGroup sg2 = new SupportGroup("Cocaine, I Don't Need You Anyway", add7, listPost, listReply);
		
		//USERS
		List<Addiction> addictionList = new ArrayList<>();
		addictionList.add(add5);
		addictionList.add(add1);
		List<SupportGroup> supportGroupList = new ArrayList<>();
		supportGroupList.add(sg1);
		List<Post> postList = new ArrayList<>(); 
		postList.add(post1);
		List<Reply>replyList = new ArrayList<>();
		replyList.add(reply3);
		replyList.add(reply6);
		User user1 = new User("jyothi", "password", "jyothi.thi@gmail.com", addictionList, supportGroupList, postList, replyList);
		sg1.getSupportGroupUsers().add(user1);
		addictionList = new ArrayList<>();
		addictionList.add(add1);
		addictionList.add(add3);
		supportGroupList = new ArrayList<>();
		supportGroupList.add(sg1);
		postList = new ArrayList<>();
		postList.add(post2);
		replyList = new ArrayList<>();
		replyList.add(reply1);
		User user2 = new User("easley", "password", "easley.boo@gmail.com", addictionList, supportGroupList, postList, replyList);
		sg1.getSupportGroupUsers().add(user2);
		
		//INSERTS FOR ADDICTIONS
		aDao.insert(add1);
		aDao.insert(add2);
		aDao.insert(add3);
		aDao.insert(add4);
		aDao.insert(add5);
		aDao.insert(add6);
		aDao.insert(add7);
		
		//INSERTS FOR POSTS
		pDao.insert(post1);
		pDao.insert(post2);
		
		//INSERTS FOR REPLIES
		rDao.insert(reply1);
		rDao.insert(reply2);
		rDao.insert(reply3);
		rDao.insert(reply4);
		rDao.insert(reply5);
		rDao.insert(reply6);
		
		//INSERTS FOR USERS
		uDao.insert(user1);
		uDao.insert(user2);
		
		//INSERTS FOR SUPPORT GROUPS
		sgDao.insert(sg1);
		sgDao.insert(sg2);
		
	}
}
