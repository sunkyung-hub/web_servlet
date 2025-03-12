package mallpage;

import java.util.ArrayList;

public abstract class ab_footer {

	//copyright 정보 model
	copyright cr = new copyright();
	ArrayList<String> cdata = null;
	
	public void fts() {
		this.cdata = cr.copyright_info();
		//System.out.println(cdata);
	}
}
