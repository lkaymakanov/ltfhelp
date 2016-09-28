package help.generatehelp;


import help.generatehelp.data.taxperiod.TaxperiodUtil;

import java.io.IOException;
import java.sql.Connection;

import net.is_bg.ltf.db.common.DBConfig;
import net.is_bg.ltf.db.common.impl.DataSourceConnectionFactoryDrManager;
import net.is_bg.ltf.db.common.impl.logging.LogFactorySystemOut;
import net.is_bg.ltf.db.common.impl.timer.ElapsedTimer;
import net.is_bg.ltf.db.common.impl.visit.VisitEmpty;
import net.is_bg.ltf.db.common.interfaces.IConnectionFactoryX;
import net.is_bg.ltf.db.common.interfaces.timer.IElaplsedTimer;
import net.is_bg.ltf.db.common.interfaces.timer.IElaplsedTimerFactory;
import net.is_bg.ltf.db.common.interfaces.visit.IVisit;
import net.is_bg.ltf.db.common.interfaces.visit.IVisitFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class TestQueriesModule.
 */
public class TestQModule {


    public static class DesktopAppConnectionFactory implements IConnectionFactoryX {
		public Connection getConnection() {
		    // TODO Auto-generated method stub
		    return new DataSourceConnectionFactoryDrManager(PredefinedDbConnections.dBases[12]).getConnection();
		}
	
		@Override
		public Connection getConnection(String name) {
			// TODO Auto-generated method stub
			return null;
		}
    }

    /**
     * * Тест модул - главна функция.
     *
     * @param args
     *            the arguments
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	
    	//init database connection
    	DBConfig.initDBConfig(new LogFactorySystemOut(), new IVisitFactory() {
    	    public IVisit getVist() {
    	    	return new VisitEmpty();
    	    }
    	}, new DesktopAppConnectionFactory(), new IElaplsedTimerFactory() {
    	    public IElaplsedTimer getElapsedTimer() {
    	    	return new ElapsedTimer();
    	    }
    	});
    	System.out.println("Data base connection initialized.....");
    	TaxperiodUtil.createTaxperiod();
    	HelpApplication hApp = new HelpApplication();
    	hApp.init();
    }
    
}
