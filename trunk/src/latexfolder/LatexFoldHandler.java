package latexfolder;

import org.gjt.sp.jedit.buffer.JEditBuffer;
import org.gjt.sp.jedit.buffer.FoldHandler;
import javax.swing.text.Segment;

public class LatexFoldHandler extends FoldHandler {
	
	private int currentLevel = 0;

	public LatexFoldHandler(){
		super("latex");
	}
	
	public int getFoldLevel(JEditBuffer buffer, int lineIndex, Segment segment) {
		buffer.getLineText(lineIndex, segment);
		String line = segment.toString();
		
		if ( line.startsWith("\\section{") ) {
			currentLevel = 2;
			return 1;
		} else if ( line.startsWith("\\subsection{") ) {
			currentLevel = 3;
			return 2;
		} else if ( line.startsWith("\\subsubsection{") ) {
			currentLevel = 4;
			return 3;
		} else if ( line.startsWith("\\begin{") ) {
			return currentLevel++;
		} else if ( line.startsWith("\\end{") ){
			return currentLevel--;
		} else {
			return currentLevel;	
		}
	}
	
}