package help.generatehelp;

import net.is_bg.ltf.db.common.interfaces.logging.ILog;

public class HelpConsoleLogger implements ILog{
	
	private ILog wrapper;
	private boolean allow;
	
	public HelpConsoleLogger(ILog w, boolean allow){
		this.wrapper = w;
		this.allow = allow;
	}

	@Override
	public void debug(Object arg0) {
		// TODO Auto-generated method stub
		if(allow) wrapper.debug(arg0);
	}

	@Override
	public void debug(Object arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		if(allow) wrapper.debug(arg0);
	}

	@Override
	public void error(Object arg0) {
		// TODO Auto-generated method stub
		if(allow) wrapper.error(arg0);
	}

	@Override
	public void error(Object arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		if(allow) wrapper.error(arg0, arg1);
	}

	@Override
	public void fatal(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(Object arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(Object arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDebugEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isErrorEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFatalEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInfoEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTraceEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWarnEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void trace(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void trace(Object arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(Object arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

}
