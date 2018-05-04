package textAreaWriter;


import static org.junit.Assert.assertTrue;

import java.util.Random;

import javax.swing.JTextArea;

import org.junit.Before;
import org.junit.Test;

import textAreaWriter.TextAreaWriter;

public class TextAreaWriterTest {

	Random rnd = new Random();

	String stringValue;
	long longValue;
	int intValue;
	boolean boolValue;
	double doubleValue;
	float floatValue;
	
	JTextArea textArea = new JTextArea();
	TextAreaWriter textAreaWriter = new TextAreaWriter(textArea);
	
	
	@Before
	public void init() {
		
		/* init sValue with random chars and random length */
		String[] salt = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Q","Z",
						 "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","q","z"};
		
		stringValue = "";
		int maxChars = 100;
		int numberOfChars = rnd.nextInt(maxChars);
		
		for(int i = 0 ; i < numberOfChars ; i++) {
			int index = rnd.nextInt(salt.length);
			
			stringValue += salt[index]; 
		}
		
		
		longValue = rnd.nextLong();
		intValue = rnd.nextInt();
		doubleValue = rnd.nextDouble();
		boolValue = rnd.nextBoolean();
		floatValue = rnd.nextFloat();
		
	}
	
	
	@Test
	public void testCleanFunction() {
		textArea.setText("");
		
		textAreaWriter.write("test");
		textAreaWriter.clear();
		
		boolean isEmpty = textArea.getText().equals("");
		assertTrue("clean function should erase JTextArea text", isEmpty);
	}
	
	
	@Test
	public void testWriteFunction() {
		String cumulativeString = "";
		boolean isSameContent;
		textArea.setText("");

		
		/* string */
		textAreaWriter.write(stringValue);
		cumulativeString += stringValue;
		
		isSameContent = textArea.getText().equals(cumulativeString);
		assertTrue("write function should add a string", isSameContent);
		
		
		/* long */
		textAreaWriter.write(longValue);
		cumulativeString += longValue;
		
		isSameContent = textArea.getText().equals(cumulativeString);
		assertTrue("write function should add a long value as string", isSameContent);
		
		
		/* int */
		textAreaWriter.write(intValue);
		cumulativeString += intValue;
		
		isSameContent = textArea.getText().equals(cumulativeString);
		assertTrue("write function should add an int value as string", isSameContent);
		
		
		/* double */
		textAreaWriter.write(doubleValue);
		cumulativeString += doubleValue;
		
		isSameContent = textArea.getText().equals(cumulativeString);
		assertTrue("write function should add a double value as string", isSameContent);
		
		
		/* boolean */
		textAreaWriter.write(boolValue);
		cumulativeString += boolValue;
		
		isSameContent = textArea.getText().equals(cumulativeString);
		assertTrue("write function should add a boolean value as string", isSameContent);
		
		
		/* float */
		textAreaWriter.write(floatValue);
		cumulativeString += floatValue;
		
		isSameContent = textArea.getText().equals(cumulativeString);
		assertTrue("write function should add a float value as string", isSameContent);
	}
	
	
	@Test
	public void testWriteLineFunction() {
		String lineEnding = System.getProperty("line.separator");
		String cumulativeString = "";
		boolean isSameContent;
		textArea.setText("");

		
		/* string */
		textAreaWriter.writeLine(stringValue);
		cumulativeString += stringValue + lineEnding;
		
		isSameContent = textArea.getText().equals(cumulativeString);
		assertTrue("writeLine function should add a string", isSameContent);
		
		
		/* long */
		textAreaWriter.writeLine(longValue);
		cumulativeString += longValue + lineEnding;
		
		isSameContent = textArea.getText().equals(cumulativeString);
		assertTrue("writeLine function should add a long value as string", isSameContent);
		
		
		/* int */
		textAreaWriter.writeLine(intValue);
		cumulativeString += intValue + lineEnding;
		
		isSameContent = textArea.getText().equals(cumulativeString);
		assertTrue("writeLine function should add an int value as string", isSameContent);
		
		
		/* double */
		textAreaWriter.writeLine(doubleValue);
		cumulativeString += doubleValue + lineEnding;
		
		isSameContent = textArea.getText().equals(cumulativeString);
		assertTrue("writeLine function should add a double value as string", isSameContent);
		
		
		/* boolean */
		textAreaWriter.writeLine(boolValue);
		cumulativeString += boolValue + lineEnding;
		
		isSameContent = textArea.getText().equals(cumulativeString);
		assertTrue("writeLine function should add a boolean value as string", isSameContent);
		
		
		/* float */
		textAreaWriter.writeLine(floatValue);
		cumulativeString += floatValue + lineEnding;
		
		isSameContent = textArea.getText().equals(cumulativeString);
		assertTrue("writeLine function should add a float value as string", isSameContent);
	}
	
	
	@Test
	public void testWriteEmptyLineFunction() {
		String lineEnding = System.getProperty("line.separator");
		String cumulativeString = "";
		boolean isSameContent;
		textArea.setText("");

		
		/* write empty line */
		textAreaWriter.writeEmptyLine();
		cumulativeString += lineEnding;
		
		isSameContent = textArea.getText().equals(cumulativeString);
		assertTrue("writeEmptyLine function should add an empty line", isSameContent);
		
		
		/* write a second empty line */
		textAreaWriter.writeEmptyLine();
		cumulativeString += lineEnding;
		
		isSameContent = textArea.getText().equals(cumulativeString);
		assertTrue("writeEmptyLine function should add a second empty line", isSameContent);
	}
	
	
	@Test
	public void testRemoveLineFunction() {
		String lineEnding = System.getProperty("line.separator");
		String cumulativeString = "";
		boolean isSameContent;
		textArea.setText("");

		
		/* write two lines */
		textAreaWriter.writeLine(stringValue);
		textAreaWriter.writeLine(longValue);
		
		cumulativeString += stringValue + lineEnding;

		
		/* remove last line */
		textAreaWriter.removeLine();
		
		
		/* check if textAreas text consists of only the first line  */
		isSameContent = textArea.getText().equals(cumulativeString);
		assertTrue("removeLine function should remove one line", isSameContent);
	}
}
