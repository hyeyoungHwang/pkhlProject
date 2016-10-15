package A0000001.Archidom.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface A0000001Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
