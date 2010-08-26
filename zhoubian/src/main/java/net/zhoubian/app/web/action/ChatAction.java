package net.zhoubian.app.web.action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.zhoubian.app.model.Chat;
import net.zhoubian.app.model.Location;
import net.zhoubian.app.model.User;
import net.zhoubian.app.service.ChatService;
import net.zhoubian.app.service.MapService;
import net.zhoubian.app.service.UserService;
import net.zhoubian.app.util.GridUtil;
import net.zhoubian.app.util.Page;
import net.zhoubian.app.web.listener.CustomSSManager;

import org.apache.log4j.Logger;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.extend.RealScriptSession;
import org.directwebremoting.impl.DefaultScriptSession;
import org.directwebremoting.proxy.ScriptProxy;

@SuppressWarnings("serial")
public class ChatAction extends AbstractAction {
	private static Logger logger = Logger.getLogger(ChatAction.class);
	
	public static Map<String, TreeNode> onlineUsers = new TreeMap<String, TreeNode>();

	private Map<String, Object> infos = new HashMap<String, Object>();

	public static Map<Long, Chat> chats = new TreeMap<Long, Chat>();

	private Chat chat;

	private Page page;

	private ChatService chatService;
	
	private UserService userService;

	private MapService mapService;
	
	public static CustomSSManager customSSManager;
	
	public void setChatService(ChatService chatService) {
		this.chatService = chatService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setMapService(MapService mapService) {
		this.mapService = mapService;
	}


	private String jsonString;

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}


	private boolean success;

	private User user;

	/**
	 * 发送消息，在这个方法里面当聊天记录等于5条的时候自动保存到数据库，然后清空记录
	 * 
	 */
	@SuppressWarnings("unchecked")
	public String addChat(String text, String sender, HttpServletRequest req) throws Exception {
		HttpSession httpSession = req.getSession();
		if (text != null) {
			chat = new Chat();
			chat.setDate(new Date());
			chat.setSender(sender);
			chat.setText(text);
			chats.put(chat.getId(), chat);
			if (chats.size() >= 5) {
				List list = new ArrayList();
				list.addAll(chats.values());
				chatService.saveAll(list);
				chats.clear();
			}

			WebContext wctx = WebContextFactory.get();
			String currentPage = wctx.getCurrentPage();
			logger.debug("currentPage:" + currentPage);
			logger.debug("ssid:" + req.getSession().getAttribute(currentPage));
			logger.debug("sessionid:" + req.getSession().getId());
			Location location = (Location) httpSession.getAttribute("location");
			
			List<Long> codes = GridUtil.getRelatedGridCode(location.getLatitude(), location.getLongitude(), 4);
			customSSManager.bt.find(GridUtil.getOwnGridCode(location.getLatitude(), location.getLongitude()));
			
			Collection<ScriptSession> sessions = wctx.getScriptSessionsByPage(currentPage);
			for(ScriptSession ss:sessions){
				logger.debug("ss:" + ss.getId());
			}
			ScriptProxy s = new ScriptProxy(sessions);
			s.addFunctionCall("receiveChats", chat);
		}
		return NONE;
	}

	public String findChatHistory() throws ParseException {
		
//		DetachedCriteria dc = DetachedCriteria.forClass(TMessage.class);
//		page.setResult(dc);
//		page = messageService.findByCriteria(page);
//		tmessageService.
		return SUCCESS;
	}
	
	public String login() {
		return SUCCESS;
	}
	
	public String chatIndex() {
		return SUCCESS;
	}

	public String addUser() {
		System.out.println("addUser");
		try {
			HttpSession httpSession = request.getSession();
			String loginName = this.getRequestParameter("userName", "error");
			User user = userService.getUserByLoginName(loginName);
			if(user != null){
				TreeNode tn = new TreeNode();
				tn.setId(user.getUid().toString());
				tn.setText(user.getName());
				System.out.println(tn.getText());
				onlineUsers.put(tn.getId(), tn); // 用户下线,则从map中移除
				
				request.getSession().setAttribute("user", user);
				Location location = mapService.findLocationsById(user.getCurrentLocationId());
				request.getSession().setAttribute("location", location);
				
				//插入到二叉树
				Collection<RealScriptSession> col= customSSManager.getScriptSessionsByHttpSessionId(httpSession.getId());
				for(RealScriptSession old : col){
					System.out.println("col:" + old.getId());
				}
				
				String currentPage = request.getRequestURI();
				System.out.println("currentPage:" + currentPage);
				ScriptSession ss = (ScriptSession) httpSession.getAttribute(currentPage);
				if (ss != null) {
					System.out.println("ss:" + ss.getId());
				}
				customSSManager.bt.insert(GridUtil.getOwnGridCode(location.getLatitude(), location.getLongitude()), httpSession.getId(), httpSession);
				
				customSSManager.bt.printTree();
				this.setSuccess(true);
				return SUCCESS;
			}else{
				this.setSuccess(false);
				return SUCCESS;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public String getOnlineUsers() {
		this.jsonString = "[";
		for (Iterator it = onlineUsers.entrySet().iterator(); it.hasNext();) {
			Map.Entry en = (Map.Entry) it.next();
			TreeNode tn = (TreeNode) en.getValue();
			this.jsonString += "{id:'" + tn.getId() + "'";
			this.jsonString += ",leaf:true,iconCls:'icon-user',";
			this.jsonString += "text:'" + tn.getText() + "'}";
			if (it.hasNext()) {
				this.jsonString += ",";
			}
		}
		this.jsonString += "]";
		System.out.println("jsonString:" + this.jsonString);
//		this.outJson(null);
		return SUCCESS;
	}

	public boolean isSuccess() {
		return success;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Map<String, Object> getInfos() {
		return infos;
	}

	public void setInfos(Map<String, Object> infos) {
		this.infos = infos;
	}


	public static class TreeNode {
		public String id;

		public String text;

		public String getId() {
			return this.id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getText() {
			return this.text;
		}

		public void setText(String text) {
			this.text = text;
		}
	}
}