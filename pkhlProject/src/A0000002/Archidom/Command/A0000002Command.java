package A0000002.Archidom.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��û �Ķ���ͷ� ��ɾ �����ϴ� ����� ���� �������̽�
//super interface - ������ : �ڼ�Ŭ�������� ����....
public interface A0000002Command {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
