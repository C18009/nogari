package nogari.loginrestapi.service;

import nogari.loginrestapi.vo.LoginVo;

public interface LoginService {

	LoginVo selectLoginProcess(LoginVo parm1) throws Exception;

}