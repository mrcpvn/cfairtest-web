package cfairtestweb.controller;

import java.util.Calendar;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.lang.Threads;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class IndexController extends SelectorComposer<Window> {

	Desktop _desktop = Executions.getCurrent().getDesktop();
	
	@Wire
	Textbox input;

	@Wire
	Textbox output;

	@AfterCompose
	public void init(){
		Updater updater = new Updater();
		updater.start();
	}
	
	@Listen("onChange=#input")
	public void submit(Event event) { // register a listener to a component
										// called input
		output.setValue(input.getValue());
	}

	private class Updater extends Thread {
		
		public void run() {
	        if (!_desktop.isServerPushEnabled())
	            _desktop.enableServerPush(true);
	        try {
	                Executions.activate(_desktop);
	                try {
	                    input.setValue(Calendar.getInstance().getTimeInMillis()+"");
	                } finally {
	                    Executions.deactivate(_desktop);
	                }
	                Threads.sleep(2000); // Update every two seconds
	        } catch (InterruptedException ex) {
	        } finally {
	            if (_desktop.isServerPushEnabled())
	                _desktop.enableServerPush(false);
	        }
	    }
	}
}
