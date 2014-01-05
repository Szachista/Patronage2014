package patronage.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import patronage.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import patronage.model.User;

@Controller
@RequestMapping("/users")
public class Kontroler {

	private final Map<Long, User> users = new HashMap<Long, User>();
	private long counter = 1;

	public Kontroler() {
		User user = new User();
		user.setId(-1L);
		user.setUsername("U1");
		user.setEmail("a@b.c");
		users.put(new Long(user.getId()), user);

		user = new User();
		user.setId(-2L);
		user.setUsername("U2");
		user.setEmail("d@e.f");
		users.put(new Long(user.getId()), user);

		user = new User();
		user.setId(-3L);
		user.setUsername("U3");
		user.setEmail("g@h.i");
		users.put(new Long(user.getId()), user);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Message createUser(@RequestBody final User user) {
		Message msg = new Message();

		for (User i : users.values()) {
			if (i.getUsername().equals(user.getUsername())) {
				msg.setMessage("User with username: " + user.getUsername() + " already exists!");
				return msg;
			}
		}

		user.setId(counter);
		users.put(counter, user);

		msg.setMessage("New user with id: " + counter++ + " was created successfully!");
		return msg;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public @ResponseBody Message updateUser(@PathVariable Long userId, @RequestBody final User user) {
		Message msg = new Message();
		User u = users.get(userId);

		if (user == null)
			msg.setMessage("User with id: " + userId + " does not exist!");
		else {
			u.setUsername(user.getUsername());
			u.setEmail(user.getEmail());

			msg.setMessage("User with id: " + userId + " was updated successfully!");
		}
		return msg;
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable Long userId) {
		return users.get(userId);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public @ResponseBody Message deleteUser(@PathVariable Long userId) {
		Message msg = new Message();

		if (users.containsKey(userId)) {
			users.remove(userId);
			msg.setMessage("User with id: " + userId + " was removed successfully!");
		}
		else
			msg.setMessage("User with id: " + userId + " does not exist!");

		return msg;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Map<Long, User> getUsersList() {
		return users;
	}
}
