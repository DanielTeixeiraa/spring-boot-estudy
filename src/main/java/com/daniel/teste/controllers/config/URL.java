package com.daniel.teste.controllers.config;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
//CONVERTER A URL DE STRINGS EM NUMEROS INTEIROS
public class URL {
	
	//DESCODIFICAR O PARAMETRO RECEBIDO
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} 
		catch (UnsupportedEncodingException e) {
			return "";
		}
	}	
	
	public static List<Integer> decodeIntList(String s) { 
		//SEPARANDO A STRING COM BASE NA ","
		String[] vet = s.split(",");
		List<Integer> list = new ArrayList<>();
		for (int i=0; i<vet.length; i++) {
			list.add(Integer.parseInt(vet[i]));
		}
		return list;
	}
}