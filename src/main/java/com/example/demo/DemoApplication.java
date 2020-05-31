
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello my %s!", name);
	}

	@GetMapping("/pi")
	public String pi(@RequestParam(value = "pi", defaultValue = "3.14159") String pi) {
		return String.format("Value for pi %s", pi);
	}

	@GetMapping("/e")
	public double e() {
		return Math.E;
	}
	
	@GetMapping("/atom")
	public Atom atom() {
		return new Atom(12, "Mg", 24.305);
	//	Atom atom = new Atom(12, "Mg");
//		atom.number = 12;
	//	atom.symbol = "Mg";
		//atom.weight = 24.305;
	
	
//		return atom;
	}
	
	public class Atom {
		private final int number;
		private final String symbol;
		private final double weight;
		
		Atom(int number, String symbol, double weight) {
			this.number = number; this.symbol = symbol; this.weight = weight;
		}
	
		public double getWeight() {return weight;}
		public int getNumber() {return number;}
		public String getSymbol() {return symbol;}
	}
	
	
	
}
