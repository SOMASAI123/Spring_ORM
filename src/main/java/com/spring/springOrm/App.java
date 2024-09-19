package com.spring.springOrm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.springOrm.Dao.TeacherDao;
import com.spring.springOrm.entities.Teacher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
      ApplicationContext context= new ClassPathXmlApplicationContext("NewFile.xml");
      TeacherDao teacherDao=  context.getBean("teacherDao",TeacherDao.class);
//      Teacher teacher=new Teacher(314,"sai","mhbd");
//      int r=teacherDao.insert(teacher);
//      System.out.println(r);  
      
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boolean go=true;
        
        while(go)
        {
        	System.out.println("PRESS 1 for add new teacher");
        	System.out.println("PRESS 2 for display all teacher");
        	System.out.println("PRESS 3 for get detail of single teacher");
        	System.out.println("PRESS 4 for delete teacher");
        	System.out.println("PRESS 5 for update teacher");
        	System.out.println("PRESS 6 for exit");
        	
        	try {
              int input=Integer.parseInt(br.readLine());
              
              switch(input)
              {
              case 1: 
            	  System.out.println("enter the id");
            	  int tId=Integer.parseInt(br.readLine());
            	  System.out.println("enter the name");
            	  String tName=br.readLine();
            	  System.out.println("enter the city");
            	  String tCity=br.readLine();
            	  
            	  Teacher teacher=new Teacher();
            	  teacher.setId(tId);
            	  teacher.setName(tName);
            	  teacher.setCity(tCity);
            	  teacherDao.insert(teacher);
            	  
            	  System.out.println("done");
            	  break;
              case 2:
            	  
            	  List<Teacher>allteacher=teacherDao.getalldetails();
            	  
            	  for(Teacher t:allteacher)
            	  {
            		  System.out.println("id:"+" "+t.getId());
            		  System.out.println("name:"+" "+t.getName());
            		  System.out.println("city:"+" "+t.getCity());
            	  }
            	  
            	  break;
              case 3:
            	  System.out.println("enter the id");
            	  int uid=Integer.parseInt(br.readLine());
            	  Teacher teachers=teacherDao.getdetails(uid);
            	  
            	  System.out.println("id:"+"  "+teachers.getId());
            	  System.out.println("name:"+" "+teachers.getName());
            	  System.out.println("city:"+"  "+teachers.getCity());
            	  System.out.println("done");
            	  break;
            	  
              case 4:
            	  System.out.println("enter the id");
            	  
            	  int userid=Integer.parseInt(br.readLine());
            	  
            	  teacherDao.delete(userid);
            	  System.out.println("done");
            	  
            	  break;
            	  
              case 5:
            	    System.out.println("enter the id");
            	    int u_id=Integer.parseInt(br.readLine());
            	    teacherDao.update(u_id);
            	    System.out.println("update the city");
            	    String t_City=br.readLine();
            	    System.out.println("update the name");
            	    String t_name=br.readLine();
            	    
            	    Teacher t=new Teacher();
            	    t.setCity(t_City);
            	    t.setName(t_name);
            	    
            	    System.out.println("updated sucessfully");
           
            	    
            	  
            	  break;
              case 6:
            	  
            	  System.out.println("exit");
            	  go=false;
            	  break;
              }
        	}
        	catch(Exception e)
        	{
        		System.out.println(e.getMessage());
        	}
        
        
    }
    }
}
