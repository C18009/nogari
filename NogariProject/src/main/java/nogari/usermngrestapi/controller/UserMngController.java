/**
 * 
 */
package nogari.usermngrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import nogari.usermngrestapi.service.UserMngService;
import nogari.usermngrestapi.vo.UserMngVo;

@Api(tags = {"사용자관리 API Controller"})
@RestController
@RequestMapping("/api")
public class UserMngController{
	
	@Autowired(required = true)
	private UserMngService userMngService;
	
	@ApiOperation(value = "회원가입(등록)API")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id",       value = "ID",     required = true,  dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "pw",       value = "패스워드",  required = true,   dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "name",     value = "이름",    required = true,   dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "nickname", value = "별명",                       dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "age",      value = "나이",                       dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "email",    value = "이메일주소",  required = true,  dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "useYn",    value = "사용여부",   required = true,  dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "failCnt",  value = "로그인실패횟수",                  dataType = "String", paramType = "query")
    })
	@PostMapping("/v1/user/regist")
	public ResponseEntity<UserMngVo> insertUserMng(UserMngVo info) throws Exception{
		
		UserMngVo resultVo = userMngService.insertUserMng(info);
		return ResponseEntity.status(HttpStatus.OK).body(resultVo);
	}

	@ApiOperation(value = "회원정보수정 API")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id",       value = "ID",     required = true,  dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "pw",       value = "패스워드",  required = true,   dataType = "String",  paramType = "query"),
		@ApiImplicitParam(name = "name",     value = "이름",    required = true,   dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "nickname", value = "별명",                       dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "age",      value = "나이",                       dataType = "int",    paramType = "query"),
		@ApiImplicitParam(name = "email",    value = "이메일주소",                    dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "useYn",    value = "사용여부",   required = true,  dataType = "String", paramType = "query"),
		@ApiImplicitParam(name = "failCnt",  value = "로그인실패횟수",                  dataType = "String", paramType = "query")
	})
	@PostMapping("/v1/user/modify")
	public ResponseEntity<UserMngVo>upateUserMng(UserMngVo info) throws Exception{
		
		UserMngVo resultVo = userMngService.upateUserMng(info);
		return ResponseEntity.status(HttpStatus.OK).body(resultVo);
	}
	
	@ApiOperation(value = "회원탈퇴 API")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "ID", value = "회원아이디", required = true, dataType = "String", paramType = "path")
	})
	@PostMapping("/v1/user/withdrawal/{id}")
	public ResponseEntity<UserMngVo>updateUserMngDelYn(@PathVariable("id") String id ) throws Exception{
		
		UserMngVo param = new UserMngVo();
		param.setId(id);
		
		UserMngVo resultVo = userMngService.updateUserMngDelYn(param);
		return ResponseEntity.status(HttpStatus.OK).body(resultVo);
	}

	@ApiOperation(value = "회원삭제 API")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "ID", value = "회원아이디", required = true, dataType = "String", paramType = "path")
	})
	@PostMapping("/v1/user/delUser/{id}")
	public ResponseEntity<UserMngVo>deleteUserMngDel(@PathVariable("id") String id ) throws Exception{
		
		UserMngVo param = new UserMngVo();
		param.setId(id);
		
		UserMngVo resultVo = userMngService.deleteUserMngDel(param);
		return ResponseEntity.status(HttpStatus.OK).body(resultVo);
	}
	

}// end 
