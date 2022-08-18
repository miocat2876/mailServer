package common.mailServer.mail.board;

import common.mailServer.mail.board.dto.MailLogDto;
import common.mailServer.mail.board.dto.MailLogPagingDto;
import common.mailServer.mail.board.service.FindMailLogService;
import common.mailServer.util.FileUtil;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@RestController
public class MailController {
	private final FindMailLogService findMailLogService;

	@CrossOrigin(origins="*")
	@ApiOperation(value = "메일로그리스트", notes = "메일로그 리스트를 확인할 수 있습니다")
	@GetMapping(value = "/sender-logs")
	public ResponseEntity<Map<String,Object>> mailLogList(@Valid MailLogPagingDto mailLogPagingDto){
		return new ResponseEntity<>(findMailLogService.findBySenderLog(mailLogPagingDto), new HttpHeaders(), HttpStatus.OK.value());
	}
	@CrossOrigin(origins="*")
	@ApiOperation(value = "메일상세로그", notes = "메일 상세 로그를 확인할 수 있습니다")
	@GetMapping(value = "/log/{id}")
	public ResponseEntity<Map<String,Object>> mailDetailLog(@PathVariable String id){
		return new ResponseEntity<>(findMailLogService.findByDetailLog(id), new HttpHeaders(), HttpStatus.OK.value());
	}
}
