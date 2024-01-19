/**
 * 
 */
package nogari.usermngrestapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import nogari.comm.exception.NogariExcaption;
import nogari.usermngrestapi.service.UserMngService;
import nogari.usermngrestapi.vo.UserMngVo;

@Slf4j
@Service("userMngService")
public class UserMngServiceImpl implements UserMngService{
	
	
	@Autowired(required = true)
	private UserMngMapper userMngMapper;
	
	@Override
	public UserMngVo insertUserMng(UserMngVo parm1)  throws Exception{
		UserMngVo resultVo = new UserMngVo();
		
		log.info("~~~~~~~~~~~~~~~~~~회원가입시작");
		try {
			
			String msg     = "저장되었습니다.";
			String errCd   = "S00001";
			
			String id    = parm1.getId();
			String pw    = parm1.getPw();
			String email = parm1.getEmail();
			
			if(id == null||id.equals("")) {
				throw new RuntimeException("ID를 입력해주세요.");
			}

			if(pw == null||pw.equals("")) {
				throw new RuntimeException("패스워드를 입력해주세요.");
			}
			
			if(email == null||email.equals("")) {
				throw new RuntimeException("이메일을 입력해주세요.");
			}
			
			userMngMapper.insertUserMng(parm1);

			resultVo.setMsg(msg);
			resultVo.setErrCd(errCd);
		} catch (Exception e) {
			throw new NogariExcaption(e.getMessage());
		}
		
		return resultVo;
		
	}// end method

	@Override
	public UserMngVo upateUserMng(UserMngVo param) throws Exception {
		UserMngVo resultVo = new UserMngVo();
		
		log.info("~~~~~~~~~~~~~~~~~~회원정보수정");
		try {
			
			String msg     = "수정되었습니다.";
			String errCd   = "S00001";
			
			String id = param.getId();
			String pw = param.getPw();
			
			if(id==null||id.equals("")) {
				throw new RuntimeException("ID를 입력해주세요.");
			}

			if(pw==null||pw.equals("")) {
				throw new RuntimeException("패스워드를 입력해주세요.");
			}
			
			userMngMapper.updateUserMng(param);

			resultVo.setMsg(msg);
			resultVo.setErrCd(errCd);
			
		} catch (Exception e) {
			throw new NogariExcaption(e.getMessage());
		}
		
		return resultVo;
	
	}

	@Override
	public UserMngVo updateUserMngDelYn(UserMngVo param) throws Exception {
		
		log.info("~~~~~~~~~~~~~~~~~~회원탈퇴");
		
		UserMngVo resultVo = new UserMngVo();
		try {
			
			String msg     = "정상처리되었습니다.";
			String errCd   = "S00001";
			
			String id = param.getId();
			
			if(id==null||id.equals("")) {
				throw new RuntimeException("ID를 입력해주세요.");
			}
			
			System.err.println("가나다라마자사~~~"+id);
			
			userMngMapper.updateUserMngDelYn(param);

			resultVo.setMsg(msg);
			resultVo.setErrCd(errCd);
			
		} catch (Exception e) {
			throw new NogariExcaption(e.getMessage());
		}
		
		return resultVo;
	}

	@Override
	public UserMngVo deleteUserMngDel(UserMngVo param) throws Exception {
		
		log.info("~~~~~~~~~~~~~~~~~~회원탈퇴");
		
		UserMngVo resultVo = new UserMngVo();
		try {
			
			String msg     = "정상처리되었습니다.";
			String errCd   = "S00001";
			
			String id = param.getId();
			
			if(id==null||id.equals("")) {
				throw new RuntimeException("ID를 입력해주세요.");
			}
			
			System.err.println("삭제 가나다라마자사~~~"+id);
			
			userMngMapper.deleteUserMngDel(param);
			
			resultVo.setMsg(msg);
			resultVo.setErrCd(errCd);
			
		} catch (Exception e) {
			throw new NogariExcaption(e.getMessage());
		}
		
		return resultVo;
	}
	
	
}// end
