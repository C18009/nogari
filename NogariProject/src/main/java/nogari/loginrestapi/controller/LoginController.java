/**
 * 
 */
package nogari.loginrestapi.controller;

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
import nogari.loginrestapi.service.LoginService;
import nogari.loginrestapi.vo.LoginVo;

@Api(tags = {"로그인 관련 API Controller"})
@RestController
@RequestMapping("/api")
public class LoginController{
	
	@Autowired(required = true)
	private LoginService loginService;
	
	@ApiOperation(value = "로그인 성공 또는 실패를 반환하는 메소드")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String", paramType = "path"),
           @ApiImplicitParam(name = "pw", value = "패스워드", required = true, dataType = "String", paramType = "path")
           //@ApiImplicitParam(name = "pw", value = "패스워드", required = true, dataType = "String", paramType = "query")
    })
	@PostMapping("/v1/login/login-process/{id}/{pw}")
	public ResponseEntity<LoginVo> loginProcess(@PathVariable("id") String id
			                     , @PathVariable("pw") String pw) throws Exception{
		LoginVo parm1 = new LoginVo(); 
		parm1.setId(id);
		parm1.setPw(pw);
		
		LoginVo resultVo = loginService.selectLoginProcess(parm1);
		return ResponseEntity.status(HttpStatus.OK).body(resultVo);
	}

}// end 
