package com.ifly.travel.control;  
  
import java.util.ArrayList;  
import java.util.Date;  
import java.util.List;  
  
import javax.servlet.ServletContext;  
import javax.servlet.http.HttpSession;  
  
public class DealData {  
    //用户登录的判读  
    public String userLogin(String username,String password,HttpSession session,ServletContext application){  
        if("123".equals(password)){  
            //如果密码正确就将用户名放入session  
            session.setAttribute("username", username);  
            //获取在线用户列表  
            List<String> users=(List<String>)application.getAttribute("users");  
            if(users==null){  
                users=new ArrayList<String>();  
            }  
            //将当前用户加入用户列表  
            users.add(username);  
            //更新application中的对象  
            application.setAttribute("users", users);  
            return "True";  
        }else{  
            return "False";  
        }  
    }  
    //添加消息  
    public String addContent(String content,ServletContext application,HttpSession session){  
        List<String> strList=(List<String>) application.getAttribute("MessageList");  
        if(strList==null){  
            strList=new ArrayList<String>();  
        }  
        //获取session中的用户名  
        String username=(String)session.getAttribute("username");  
        //获取时间  
        Date date=new Date();  
        content=content.replace("<:", "<img src='QQface/");  
        content=content.replace(":>", ".gif' />");  
        //组装消息  
        String message="<span class=\"word_say\">"+username+"于"+date.toLocaleString()+"说："+"</span>"+content;
        //添加到集合中  
        strList.add(message);  
        //放入application对象中  
        application.setAttribute("MessageList", strList);  
        return "True";  
    }  
    //获取所有的消息  
    public String AllChatList(ServletContext application){  
        StringBuffer sb=new StringBuffer(); 
        List<String> strList=(List<String>) application.getAttribute("MessageList");  
        if(strList!=null){  
            for(String s:strList){  
                sb.append(s+"<br />");  
            }  
        }   
        return sb.toString();  
    }  
    //获取在线用户列表  
    public String GetOnlineUsers(ServletContext application,HttpSession session){  
        StringBuffer sb=new StringBuffer();  
        String username = session.getAttribute("username").toString();
        //获取在线用户列表  
        List<String> users=(List<String>)application.getAttribute("users");  
        if(users==null){  
            users=new ArrayList<String>();  
            users.add(username);
        }  
        //将当前用户加入用户列表  
        if (!users.contains(username)) {
        	users.add(username);
		}
        //更新application中的对象  
        application.setAttribute("users", users);  
        sb.append("<span class=\"man_show\">");
        if(users!=null){  
            for(String user:users){  
                sb.append("<span class=\"glyphicon glyphicon-user\"></span>"+user+"<br />");  
            }  
        }   
        sb.append("</span>");
        return sb.toString();  
    }  
    //下线  
    public String OffLine(ServletContext application,HttpSession session){  
        //先取出用户名  
        String username=(String)session.getAttribute("username");  
        //移除session中的内容  
        session.removeAttribute("username");  
        //移除用户列表中的用户名  
        List<String> strList=(List<String>) application.getAttribute("users");  
        if(strList!=null){  
            strList.remove(username);  
        }   
        return "True";  
    }  
}