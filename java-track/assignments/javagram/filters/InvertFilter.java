package javagram.filters;

import javagram.Picture;
import java.awt.Color;

public class InvertFilter implements Filter{

	@Override
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int x = 0; x < original.width(); x++) {
	      for (int y = 0; y < original.height(); y++) {
	    	  
	    	  Color c = original.get(x, y);
	          
	          //get color components from each pixel
	          int r = c.getRed();
	          int g = c.getGreen();
	          int b = c.getBlue();
	          
	          int newRed = 255-r;
	          int newGreen = 255 - g;
	          int newBlue = 255 - b;
	          
	          processed.set(x, y, new Color(newRed, newGreen, newBlue));
	    	  
	      }
	    }
		
		return processed;
	}

	@Override
	public String getTitle() {
		return "Invert Filter";
	}

	@Override
	public String getDesc() {
		return "Flips the color values of the image.";
	}

}
