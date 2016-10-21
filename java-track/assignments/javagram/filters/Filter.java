package javagram.filters;

import javagram.Picture;

public interface Filter {
	public Picture process(Picture original);
	public String getTitle();
	public String getDesc();
}
