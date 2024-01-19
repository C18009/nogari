/**
 * 
 */
package nogari.loginrestapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import nogari.comm.exception.NogariExcaption;
import nogari.loginrestapi.service.LoginService;
import nogari.loginrestapi.vo.LoginVo;

@Slf4j
@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	
	@Autowired(required = true)
	private LoginMapper loginMapper;
	
	@Override
	@Transactional
	public LoginVo selectLoginProcess(LoginVo parm1)  throws Exception{
		
		log.info("~~~~~~~~~~~~~~~~~~시작");

		LoginVo resultVo = new LoginVo();
		
		try {
			
			String msg     = "";
			String errCd   = "";
			
			LoginVo paramVo1 = new LoginVo();
			paramVo1.setId(parm1.getId());
			
			int idCnt  = loginMapper.selectCountEmp(paramVo1);
			
			paramVo1.setPw(parm1.getPw());

			int pwCnt  = loginMapper.selectCountEmpPw(paramVo1);
			
			List<LoginVo> userInfo = null;
			
			
			//건수가 있으면 정보리턴
			if(idCnt == 0) {
			
				msg      = "없는 ID입니다 다시한번 확인해주세요";
				errCd    = "E00001";
			
			}else if (idCnt > 0 && pwCnt == 0) {
			
				List<LoginVo> userInfo1 = loginMapper.selectEmpList(parm1);
				int LoginErrCnt    = Integer.parseInt(userInfo1.get(0).getFailCnt()) ;
				String useYn       = userInfo1.get(0).getUseYn();
				
				if( useYn.equals("N") && LoginErrCnt == 5) {
					
					msg      ="5회 이상 틀린패스워드를 입력해서 로그인을 할수가 없습니다. 관리자에게 문의해주세요.";
				
				}else{
					paramVo1.setFailCnt( (LoginErrCnt+1)+"" );
					paramVo1.setId(parm1.getId()); 
					paramVo1.setPw(parm1.getPw()); 
					
					loginMapper.updateFalieCnt(paramVo1);
					
					msg      = paramVo1.getFailCnt()+"회 틀린 패스워드입력하였습니다. 5번 틀린패스워드를 입력시 로그인이 안될수 있습니다. 확인해주세요.";
					
					if(Integer.parseInt(paramVo1.getFailCnt())>=5) {
						
						paramVo1.setUseYn("N");
						loginMapper.updateLoginUseYn(paramVo1);
					}
					
				}
				errCd    = "E00001";
			
			}else if (idCnt >0 && pwCnt > 0 ) {
				
				userInfo = loginMapper.selectEmpList(parm1);
				
				String useYn       = userInfo.get(0).getUseYn();
				
				int LoginErrCnt    = Integer.parseInt(userInfo.get(0).getFailCnt()) ;
				
				System.err.println("값은 LoginErrCnt>>"+LoginErrCnt);

				System.err.println("값은 useYn>>"+useYn);
				
				if(useYn.equals("Y") && LoginErrCnt < 5) {
					System.err.println("여기1");
					
					parm1.setUseYn("Y");
					parm1.setFailCnt("0");
					
					loginMapper.updateLoginUseYn(parm1);
					loginMapper.updateFalieCnt(parm1);
					
					msg      = "로그인 성공";
					errCd    = "S00001";
					
					
				}else {
					System.err.println("여기2");
					userInfo = null;
					if( useYn.equals("N") && LoginErrCnt == 5) {
						System.err.println("여기2-1");
						msg      = "패스워드 5회 이상으로 인해 로그인할수 없습니다. 관리자에게 문의해주세요.";
						errCd    = "E00001";
					}else if (useYn.equals("N")) {
						System.err.println("여기2-2");
						msg      = "회원이 탈퇴된 상태입니다 확인해주세요. 관라지에게 문의해주세요";
						errCd    = "E00001";
					}
					System.err.println("여기3");
				}
				
			}else {
				msg      = "로그인 실패";
				errCd    = "E00001";
				userInfo = null;
			}

			resultVo.setMsg(msg);
			resultVo.setErrCd(errCd);
			resultVo.setUserInfo(userInfo);
			
		} catch (Exception e) {
			throw new NogariExcaption(e.getMessage());
		}
		
		return resultVo;
		
	}// end method
	
}// end
