package com.ufps.conferencia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpSessionEvent;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("")
	public String rutaPorDefecto(HttpServletRequestWrapper request, HttpSessionEvent session, Model model) {
			return "main";
	}
}
