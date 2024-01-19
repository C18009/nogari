/**
 * 
 */
package nogari.loginrestapi.vo;

import java.util.List;

import lombok.Data;
import nogari.comm.CommonVo;

/**
 *
 */
@Data
public class OracleMyBatisVo extends CommonVo{

	String id;
	String pw;
	String name;
	String nickname;
	String age;
	String address;
	
	List<OracleMyBatisVo> userInfo;

}// end class
