package _11클렉션Member;

import java.util.*;
//화면 -> url(String value) -> DAO연결해주는 클래스
public class Controller {
	private static Controller instance = new Controller();

	public static Controller getInstance() {
		return instance;
	}

	private Controller() {init();}
	
	private Map<String, Action> mapList;
	
	private void init() {
		mapList = new HashMap<>();
		mapList.put("insert", new ActionInsert());
		mapList.put("delete", new ActionDelete());
		mapList.put("modify", new ActionModify());
		mapList.put("print", new ActionPrint());
		mapList.put("save", new ActionFileSave());
		mapList.put("load", new ActionFileLoad());
	}
	public Action getAction(String key) {
		return mapList.get(key);
	}
}
