package model;

import java.util.ListResourceBundle;

public class Dictionary_en extends ListResourceBundle {
	Object obj[][] = {
			{"username", "username"},
			{"password", "password"}
	};
	@Override
	protected Object[][] getContents() {
		return obj;
	}
}
