package common.mailServer.mail.sender.config.options;

import lombok.Getter;

import java.util.Random;

public class RandomKeyOption {

	public static String createOption(){
		int leftLimit = 48;
		int rightLimit = 122;
		int targetStringLength = 10;
		Random random = getRandom.RANDOM.getRandom();
		return random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}
	@Getter
	private enum getRandom{
		RANDOM(new Random());
		private final Random random;
		getRandom(Random random){
			this.random = random;
		}
	}
}
