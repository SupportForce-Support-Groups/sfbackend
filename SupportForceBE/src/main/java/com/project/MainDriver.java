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
		
		System.out.println(aDao.selectAllAddictions());
		System.out.println(uDao.selectAllUsers());
		System.out.println(pDao.selectAllPosts());
		System.out.println(rDao.selectAllReplies());
		System.out.println(sgDao.selectAllReplies());
		
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
		
		//SUPPORT GROUP
		SupportGroup sg1 = new SupportGroup("Alcohol, Never Again", add1);
		SupportGroup sg2 = new SupportGroup("Cocaine, I Don't Need You Anyway", add7);
		
		//POSTS
		Post post1 = new Post("How are you guys doing on your road to recovery?");
		Post post2 = new Post("Is it just me or is this process really hard to recover from addiction? I'm always thinking about relapsing.");
		
		//REPLIES
		Reply reply1 = new Reply("It's going okay, but it's only been one day so far");
		Reply reply2 = new Reply("It's going better than the first couple of weeks");
		Reply reply3 = new Reply("Trust me... it gets better with time.");
		Reply reply4 = new Reply("Yes, it's a hard process. But, you will come out as the bigger person after this process is said and done.");
		Reply reply5 = new Reply("Trust me you're not by yourself in this road to recovery. We're here to support you as well.");
		Reply reply6 = new Reply("One person's success is everybodies. so, calm down.");
		
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
		
		//INSERTS FOR ADDICTIONS
		aDao.insert(add1);
		aDao.insert(add2);
		aDao.insert(add3);
		aDao.insert(add4);
		aDao.insert(add5);
		aDao.insert(add6);
		aDao.insert(add7);
		
		//INSERTS FOR USERS
		uDao.insert(user1);
		uDao.insert(user2);
		
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
		
		//INSERTS FOR SUPPORT GROUPS
		sgDao.insert(sg1);
		sgDao.insert(sg2);
		
	}
}
