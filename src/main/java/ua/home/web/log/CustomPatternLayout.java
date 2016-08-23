package ua.home.web.log;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
import ua.home.web.listener.RequestListener;

public class CustomPatternLayout extends PatternLayout {
	@Override
	public String format(LoggingEvent event) {
		return  super.format(event).replace("%sid", RequestListener.getCurrentSessionId());
	}
}
