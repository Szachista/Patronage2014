/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package patronage.model;

public class Message {
	private String message;

	public Message() {
		message = "Hello, world!";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String person) {
		message = "Hello, " + person + "!";
	}
}
