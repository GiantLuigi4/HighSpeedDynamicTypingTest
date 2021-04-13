import utils.Formatter;
import utils.Parser;
import utils.class_structure.ClassNode;
import utils.class_structure.MethodNodeSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TranspilerTest {
	public static void main(String[] args) throws IOException {
		transpileClass(new String(Files.readAllBytes(new File("testComp/TestClass.java").getAbsoluteFile().toPath())));
	}
	
	public static void transpileClass(String clazz) {
		ClassNode node = Parser.parse(Formatter.formatForCompile(clazz));
		for (MethodNodeSource method : node.methods) {
			System.out.println(method.code);
		}
	}
}
