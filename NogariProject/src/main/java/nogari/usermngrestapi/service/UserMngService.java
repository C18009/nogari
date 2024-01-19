package nogari.usermngrestapi.service;

import nogari.usermngrestapi.vo.UserMngVo;

public interface UserMngService {

	UserMngVo insertUserMng(UserMngVo info) throws Exception;

	UserMngVo upateUserMng(UserMngVo info)throws Exception;

	UserMngVo updateUserMngDelYn(UserMngVo info)throws Exception;

	UserMngVo deleteUserMngDel(UserMngVo param)throws Exception;

}