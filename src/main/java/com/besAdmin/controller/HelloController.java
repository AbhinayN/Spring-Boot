package com.besAdmin.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {

	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@PostMapping("/hello")
	public String sayHello(@RequestParam("name") String name,Model model)
	{
		model.addAttribute("name", name);
		return "hello";
	}
	@GetMapping("/transfer")
	public String transfer() throws IOException
	{
		Path sourceDirectory = Paths.get("/Users/personal/tutorials/source");
        Path targetDirectory = Paths.get("/Users/personal/tutorials/target");

        //copy source to target using Files Class
        Files.copy(sourceDirectory, targetDirectory);
		return "transfer";
	}
}
