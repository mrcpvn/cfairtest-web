package cfairtestweb.controller;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class IndexController extends SelectorComposer<Window> {

	@Wire
	Textbox input;

	@Wire
	Textbox output;

	@Listen("onChange=#input")
	public void submit(Event event) { // register a listener to a component
										// called input
		output.setValue(input.getValue());
	}

}
