package javagram.filters;

import java.awt.Color;

import javagram.Picture;

public class GrayscaleFilter implements Filter{

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
		          
		          int grayValue = (int)(r + g + b)/3;
		          
		          int newRed = grayValue;
		          int newGreen = grayValue;
		          int newBlue = grayValue;
		          
		          processed.set(x, y, new Color(newRed, newGreen, newBlue));
		    	  
		      }
		    }
			
			return processed;
		}

		@Override
		public String getTitle() {
			return "Grayscale";
		}

		@Override
		public String getDesc() {
			return "Removes color from the image.";
		}
}
