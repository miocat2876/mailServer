package common.mailServer.mail.sender.controller;

import common.mailServer.mail.sender.dto.MailDto;
import common.mailServer.mail.sender.dto.MailStateDto;
import common.mailServer.mail.sender.service.template.MailService;
import common.mailServer.util.FileUtil;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Log4j2
@RestController
@RequiredArgsConstructor
public class MailSenderController {

	private final MailService<MailDto> MailDefaultDaum;

	@ApiOperation(value = "메일전송", notes = "멀티파트타입을 변환하여 메일을 전송 합니다")
	@PostMapping(value = "/sender",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MailStateDto<String>> senderToMultipart(@Valid MailDto mailDto) throws Exception {
		log.info("consumes = " + MediaType.MULTIPART_FORM_DATA_VALUE);
		return new ResponseEntity<>(MailDefaultDaum.sender(mailDto), new HttpHeaders(), HttpStatus.OK.value());
	}
	@ApiOperation(value = "메일전송", notes = "제이슨타입을 변환하여 메일을 전송 합니다")
	@PostMapping(value = "/sender",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MailStateDto<String>> senderToJson(@RequestBody @Valid MailDto mailDto) throws Exception {
		log.debug("consumes = " + MediaType.APPLICATION_JSON_VALUE);
		return new ResponseEntity<>(MailDefaultDaum.sender(mailDto), new HttpHeaders(), HttpStatus.OK.value());
	}
}
