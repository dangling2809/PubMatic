package com.pubmatic.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InputParser {
	
	public String[] parse(String textFileName) throws FileNotFoundException, IOException{
		List<String> symbols=new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(textFileName))) {
			stream.forEach(symbol->{symbols.add(symbol);});
		} catch (IOException e) {
			throw e;
		}
		return  symbols.toArray(new String[symbols.size()]);
	}
}
