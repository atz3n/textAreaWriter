/**
 * Class to easily write into an JTextArea
 */


import javax.swing.JTextArea;

public class TextAreaWriter {

	private static final String ENDLINE = System.getProperty("line.separator");

	JTextArea textArea;

	
	public TextAreaWriter(JTextArea textArea) {
		this.textArea = textArea;
	}

	
	public void write(String text) {
		textArea.append(text);
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
	
	public void write(long text) {
		write(Long.toString(text));
	}
	
	
	public void write(int text) {
		write(Integer.toString(text));
	}
	
	
	public void write(boolean text) {
		write(Boolean.toString(text));
	}
	
	
	public void write(double text) {
		write(Double.toString(text));
	}	

	
	public void write(float text) {
		write(Float.toString(text));
	}

	
	public void writeLine(String text) {
		textArea.append(text + ENDLINE);
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
	
	public void writeLine(long text) {
		writeLine(Long.toString(text));
	}
	
	
	public void writeLine(int text) {
		writeLine(Integer.toString(text));
	}
	
	
	public void writeLine(boolean text) {
		writeLine(Boolean.toString(text));
	}
	
	
	public void writeLine(double text) {
		writeLine(Double.toString(text));
	}	
	

	public void writeLine(float text) {
		writeLine(Float.toString(text));
	}
	
	
	public void writeEmptyLine() {
		textArea.append(ENDLINE);
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
	
	
	public void clear() {
		textArea.setText("");
	}

	
	public void removeLine() {
		String text = textArea.getText();
		String textWithoutLastLineEnding = text.substring(0, text.lastIndexOf(ENDLINE));
		String textWithoutLastLine = textWithoutLastLineEnding.substring(0, textWithoutLastLineEnding.lastIndexOf(ENDLINE) + ENDLINE.length());
		
		textArea.setText(textWithoutLastLine);
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
}
