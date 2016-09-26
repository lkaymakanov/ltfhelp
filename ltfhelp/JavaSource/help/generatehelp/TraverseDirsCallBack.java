package help.generatehelp;

import java.io.File;

public interface TraverseDirsCallBack {
	void OnReturnFromRecursion(File node);
	void OnForward(File node);
}
