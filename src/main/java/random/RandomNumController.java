package random;

import java.util.ArrayList;

import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class RandomNumController {
	
	@GetMapping(value = "/randomNumber")
	public ArrayList<Dice> getDice() {
		Random rm = new Random();
		String name = "dice";
		NumberDAO dao = new NumberDAO();
		ArrayList <Dice> diceResult = new ArrayList<Dice>();	
		for (int i = 0; i < 3; i++) {
			Dice dice = new Dice(name+i, rm.nextInt(6)+1);
			diceResult.add(dice);
		}
		dao.insertDice(diceResult);
		return diceResult;
	}
}
