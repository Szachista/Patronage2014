package patronage.controller;

import patronage.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class JSONController {

	@RequestMapping(params = {"person"}, method = RequestMethod.GET)
	public @ResponseBody Message printMessage(@RequestParam(value = "person", required = true) String person) {
		Message msg = new Message();
		msg.setMessage(person);
		return msg;
	}
}
