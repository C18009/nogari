/**
 * 
 */
package nogari.usermngrestapi.vo;

import lombok.Data;
import nogari.comm.CommonVo;

/**
 *
 */
@Data
public class UserMngVo extends CommonVo{

	String id;
	String pw;
	String name;
	String nickname;
	String age;
	String address;
	String email;
	String useYn;
	String failCnt;

}// end class
