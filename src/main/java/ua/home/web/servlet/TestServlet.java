package ua.home.web.servlet;

import org.apache.log4j.Logger;
import ua.home.web.listener.RequestListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/")
public class TestServlet extends HttpServlet {

	private static final Logger LOG = Logger.getLogger(TestServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String currentSessionId = RequestListener.getCurrentSessionId();
		String id = req.getSession().getId();

		LOG.info("doGet");


		try (PrintWriter writer = resp.getWriter()) {
			writer.printf("<p>session from RequestListener = '%s'</p>", currentSessionId);
			writer.printf("<p>session from HttpServletRequest = '%s'</p>", id);
			writer.flush();
		}
	}
}
