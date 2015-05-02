package cfairtestweb.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.encoders.EncoderUtil;
import org.jfree.chart.encoders.ImageFormat;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.image.AImage;
import org.zkoss.lang.Threads;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Button;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import cfairtestweb.client.IRestClient;
import cfairtestweb.model.TradeData;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class IndexController extends SelectorComposer<Window> {

	Desktop _desktop = Executions.getCurrent().getDesktop();

	public static final String DATE_FORMAT = "dd-MMM-yy HH:mm:ss";
	private final SimpleDateFormat parserSDF = new SimpleDateFormat(DATE_FORMAT);

	@WireVariable
	IRestClient restClient;

	@Wire
	Button lastTradeButton;
	@Wire
	Label lastTradeLabel;

	@Wire
	Image tradeChart;
	@Wire
	Button tradeChartButton;

	@AfterCompose
	public void init() {
		// Updater updater = new Updater();
		// updater.start();

		// rest client

	}

	@Listen("onClick=#lastTradeButton")
	public void getLastTrade() {
		lastTradeLabel.setValue(restClient.getLastTrade());
	}

	@Listen("onClick=#tradeChartButton")
	public void getTradeChartModel() throws ParseException, IOException {
		List<TradeData> model = restClient.getTradeStats();
		TimeSeries series = new TimeSeries("Trades");
		for (TradeData data : model) {
			Second second = new Second(parserSDF.parse(data.getDate()));
			series.add(second, data.getCounter());
		}
		XYDataset dataset = (XYDataset) new TimeSeriesCollection(series);
		JFreeChart timechart = ChartFactory.createTimeSeriesChart("Trades",
				"Seconds", "Count", dataset, false, false, false);

		int width = 560; /* Width of the image */
		int height = 370; /* Height of the image */
		
		BufferedImage bi = timechart.createBufferedImage(500, 300, BufferedImage.TRANSLUCENT , null);
		byte[] bytes = EncoderUtil.encode(bi, ImageFormat.PNG, true);
		
		AImage image = new AImage("Trades", bytes);
		tradeChart.setContent(image);
	}

	// private class Updater extends Thread {
	//
	// public void run() {
	// if (!_desktop.isServerPushEnabled())
	// _desktop.enableServerPush(true);
	// while (true) {
	// try {
	// Executions.activate(_desktop);
	// try {
	// input.setValue(Calendar.getInstance().getTimeInMillis()
	// + "");
	// } finally {
	// Executions.deactivate(_desktop);
	// }
	// Threads.sleep(2000); // Update every two seconds
	// } catch (InterruptedException ex) {
	// } finally {
	// if (_desktop.isServerPushEnabled())
	// _desktop.enableServerPush(false);
	// }
	// }
	// }
	// }
}
