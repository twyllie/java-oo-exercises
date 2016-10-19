package javagram.filters;

import javagram.Picture;
import java.awt.Color;

public class BlueFilter implements Filter{

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
	          
	          int newBlue = (r + g + b) / 3;
	          
	          processed.set(x, y, new Color(0, 0, newBlue));
	    	  
	      }
	    }
		
		return processed;
	}
	
	
	@Override
	public String getTitle(){
		return "Blue Filter";
	}

	
	@Override
	public String getDesc(){
		return "Puts a blue hue over the image.";
	}
}
