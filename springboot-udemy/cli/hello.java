@RestController
public class Hello {

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}
}