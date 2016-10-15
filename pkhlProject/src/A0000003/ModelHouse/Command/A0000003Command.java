package A0000003.ModelHouse.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface A0000003Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
