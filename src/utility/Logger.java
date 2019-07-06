package utility;

import java.util.LinkedList;
import java.util.List;

public class Logger {

	
	private static List<LoggerListener> listeners = new LinkedList<LoggerListener>();
	
	public static void listen(LoggerListener listener) {
		if(listener==null) return;
		
		if(!listeners.contains(listener)) {
			listeners.add(listener);
		}
		
	}
	
	public static void unListen(LoggerListener listener) {
		if(listener==null) return;
		
		listeners.remove(listener);
		
	}
	
	public static void println(String message) {
		
		System.out.println(message);
		
		for(LoggerListener ll:listeners)
		{
			ll.onMessageRecieve(message);
		}
	}
	
}
