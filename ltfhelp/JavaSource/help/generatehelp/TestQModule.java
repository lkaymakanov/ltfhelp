package help.generatehelp;

import help.generatehelp.data.certreg.CertRegUtil;
import help.generatehelp.data.chargereg.ChargeReg;
import help.generatehelp.data.chargereg.ChargeRegUtil;
import help.generatehelp.data.city.CityUtil;
import help.generatehelp.data.country.CountrtyUtil;
import help.generatehelp.data.decode.DecodeTypeUtils;
import help.generatehelp.data.documenttype.DocumenttypeUtil;
import help.generatehelp.data.exchangereg.ExchangeReg;
import help.generatehelp.data.exchangereg.ExchangeRegUtil;
import help.generatehelp.data.kindhomeobjreg.KindHomeObjReg;
import help.generatehelp.data.kindhomeobjreg.KindHomeObjRegUtil;
import help.generatehelp.data.kindparreg.KindParRegUtil;
import help.generatehelp.data.menu.MenuUtil;
import help.generatehelp.data.municipality.MunicipalityUtil;
import help.generatehelp.data.patentactivityreg.PatentActivityRegUtil;
import help.generatehelp.data.province.ProvinceUtil;
import help.generatehelp.data.reasonreg.ReasonRegUtil;
import help.generatehelp.data.regnumber.RegNumberUtil;
import help.generatehelp.data.servicereg.ServiceRegUtil;
import help.generatehelp.data.transpmeansreg.TranspmeansReg;
import help.generatehelp.data.transpmeansreg.TranspmeansRegUtil;

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
    	//init resource locator
    	//ResourceLocator.initResourceLocator();
    	
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
    	
    	
    	//do the test!!!
    	TestQModule module = new TestQModule();
    	module.test();

    }
    
    
    // do the tests here
    /**
     * Test.
     * @throws IOException 
     */
    public void test() throws IOException {
       
    }
}
