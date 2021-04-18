package com.example.demo;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;

	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/greet")
	public String greet(@RequestParam(value = "name", defaultValue = "Stranger") String name) {
		return String.format("Hello %s!", name);
	}

	private List<Student> student = new ArrayList<>(Arrays.asList(new Student("Peter","Meyer")));

	@GetMapping("/greetStudent")
	public String greetStudent(@RequestParam(defaultValue = "Stranger") String vorname) {
		return String.format("Hello %s!", vorname);
	}

	@PostMapping("/join")
	public String join(@RequestBody Student student) {
		return String.format(student.vorname + " " + student.nachname + " wurde hinzugefügt!");
	}
}
