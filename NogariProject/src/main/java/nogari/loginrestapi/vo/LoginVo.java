/**
 * 
 */
package nogari.loginrestapi.vo;

import java.util.List;

import nogari.comm.CommonVo;
import lombok.Data;

/**
 *
 */
@Data
public class LoginVo extends CommonVo{

	String id;
	String pw;
	String name;
	String nickname;
	String age;
	String address;
	String email;
	String useYn;
	String failCnt;
	
	List<LoginVo> userInfo;

}// end class
