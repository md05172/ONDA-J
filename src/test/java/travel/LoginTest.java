package travel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import dao.MemberDao;

class LoginTest {

	@Test
	void test() {
		MemberDao dao = MemberDao.getInstance();
		Map<String, String> map = new HashMap<>();
		map.put("id", "admin1");
		map.put("pw", "1234");
		int cnt = dao.login(map);
		assertEquals(1, cnt);
	}

}
