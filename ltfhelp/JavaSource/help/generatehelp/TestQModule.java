package help.generatehelp;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.is_bg.ltf.db.common.ConnectionProperties;
import net.is_bg.ltf.db.common.DBConfig;
import net.is_bg.ltf.db.common.SqlStatement;
import net.is_bg.ltf.db.common.UpdateSqlStatement;
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
class TestQModule {

 

    // FIELDS OF INTEREST

    /** drivers. */
    private final static String ORCL_DRIVER = "oracle.jdbc.OracleDriver";

    /** The Constant PGR_DRIVER. */
    private final static String PGR_DRIVER = "org.postgresql.Driver";

    /** The Constant PGR_DRIVER_DIGEST. */
    private final static String PGR_DRIVER_DIGEST = "com.is.util.db.driver.digestdriver.DigestDriver";

    /** data bases url's. */
    public final static String URL_PGR_BRC = "digest:jdbc:postgresql://10.240.110.120:5432/brc";

    /** The Constant URL_PGR_MDT. */
    public final static String URL_PGR_MDT = "digest:jdbc:postgresql://10.240.44.129:5432/mdt";

    /** The Constant URL_ORC_SF_129. */
    public final static String URL_ORC_SF_129 = "jdbc:oracle:thin:@10.240.44.129:1521:ORCL";

    /** The Constant URL_ORC_SF_146. */
    public final static String URL_ORC_SF_146 = "jdbc:oracle:thin:@10.240.44.146:1521:orcl";

    /** The Constant URL_LOCAL. */
    public final static String URL_LOCAL = "jdbc:oracle:thin:@localhost:1521:ltf";

    /** УРЛ. */
    public final static String URL_PGR_149 = /* digest: */"jdbc:postgresql://10.240.44.149:5432/bnk11";

    /** The Constant URL_PGR_LOCLHOST. */
    public final static String URL_PGR_LOCLHOST = "jdbc:postgresql://localhost:5432/bnk";

    /** The Constant URL_PGR_PDV_7. */
    public final static String URL_PGR_PDV_7 = "jdbc:postgresql://10.240.110.70:5432/pdv";
    public final static String URL_PGR_PDV_BANITE = "jdbc:postgresql://10.240.110.70:5432/banite";
    public final static String URL_PGR_KLN_70 = "jdbc:postgresql://10.240.110.70:5432/kln";

    public final static String URL_PGR_SOF_184 = "jdbc:postgresql://10.240.44.184:5432/sofiamerge3";

    // .public final static String URL_PGR_LOCLHOST =
    // "digest:jdbc:postgresql://localhost:5432/postgres";

    /** SOME PREDEFINED CONNECTIONS. */
    /** data base connections */
    public static ConnectionProperties[] dBases = { new ConnectionProperties(ORCL_DRIVER, URL_ORC_SF_129, "brc", "brc", "orlc_brc_129"), // 0
	    new ConnectionProperties(ORCL_DRIVER, URL_ORC_SF_129, "krp", "krp", "orlc_krp_129"), // 1
	    new ConnectionProperties(ORCL_DRIVER, URL_ORC_SF_146, "brc", "brc", "orlc_brc_146"), // 2
	    new ConnectionProperties(ORCL_DRIVER, URL_ORC_SF_146, "sdk", "sdk", "orlc_sdk_146"), // 3
	    new ConnectionProperties(PGR_DRIVER, URL_PGR_BRC, "mdt", "mdt", "pgr_brc_129"), // 4
	    new ConnectionProperties(ORCL_DRIVER, URL_LOCAL, "brc", "brc", "pgr_brc_129"), // 5
	    new ConnectionProperties(ORCL_DRIVER, URL_PGR_MDT, "mdt", "mdt", "pgr_mdt_129"), // 6

	    new ConnectionProperties(PGR_DRIVER_DIGEST, URL_PGR_149, "bnk", "Bnk12345", "pgr_bnk_149"), // 7
													// bankq
													// 149
													// postgre
	    new ConnectionProperties(PGR_DRIVER_DIGEST, URL_PGR_LOCLHOST, "bnk", "Bnk12345", "localhost_pgr"), // 8
													       // postgre
													       // localhost
	    new ConnectionProperties(PGR_DRIVER_DIGEST, URL_PGR_PDV_7, "pdv", "pdv", "pdv10.240.110.7"), // 9
													 // postgre
													 // localhost
	    new ConnectionProperties(PGR_DRIVER, URL_PGR_SOF_184, "sofia2013", "12345", "sofia184"),//10
	    
	    
	    new ConnectionProperties(PGR_DRIVER, URL_PGR_PDV_7, "pdv", "pdv", "banite10.240.110.7"), //11
	    new ConnectionProperties(PGR_DRIVER, URL_PGR_KLN_70, "kln", "kln", "banite10.240.110.70") //12
	    
	    
    
    };

    /** The service locator. */

    /** The pr. */

    /** The factory. */

    /**
     * Gets the connection prop.
     *
     * @return the connection prop
     */

    /**
     * Gets the service locator.
     *
     * 
     * /** get connection to DB.
     */
    public void init() {
	SqlStatement.setTest(true);
    }

    /**
     * The Class Script.
     */
    public static class Script extends UpdateSqlStatement {

	/** The script. */
	String script = " CREATE TABLE if not exists test (test character varying ); \n";

	/**
	 * Instantiates a new script.
	 *
	 * @param sc
	 *            the sc
	 */
	public Script(String sc) {
	    // TODO Auto-generated constructor stub
	    script = sc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.is_bg.ltf.db.common.SqlStatement#getSqlString()
	 */
	@Override
	protected String getSqlString() {
	    // TODO Auto-generated method stub
	    return script;
	}

    }

    /** The prt pattern. */
    String prtPattern = "";

    ServiceLocator serviceLocator = null;

    // do the tests here
    /**
     * Test.
     * @throws IOException 
     */
    public void test() throws IOException {
      // DecodeTypesSelect s = new DecodeTypesSelect();
       //getServiceLocator().getActDao().execute(s);
       //s.getResult();
       HelpUtils.createTables();
       	
    	
    }

    /**
     * Sets the prt pattern.
     *
     * @param prtPattern
     *            the new prt pattern
     */
    public void setPrtPattern(String prtPattern) {
	this.prtPattern = prtPattern;
    }

    
    private ServiceLocator getServiceLocator() {
	// TODO Auto-generated method stub
	if (serviceLocator == null)
	    serviceLocator = new ServiceLocator();
	return serviceLocator;
    }

    public static class DesktopAppConnectionFactory implements IConnectionFactoryX {
	public Connection getConnection() {
	    // TODO Auto-generated method stub
	    return new DataSourceConnectionFactoryDrManager(dBases[12]).getConnection();
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
    	
    /*	BufferedReader f = new BufferedReader(new FileReader(new File("lib.txt")));	
    	String s;
    	s = f.readLine();
    	while(s != null){
    		System.out.println(s);
    		s = f.readLine();
    	}
    	
    	FileUtil.copyDirectory(new File("D:\\WEB-INF\\lib"), new File("D:\\WEB-INF\\libcopied"));*/
    	
    /*FileUtil.traverseDirs(new File("D:\\WEB-INF\\lib"), new TraverseDirsCallBack() {
		
		@Override
		public void OnReturnFromRecursion(File node) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void OnForward(File node) {
			// TODO Auto-generated method stub
			System.out.println(node.getName());
		}
	});*/
    	
	Locale.setDefault(new Locale("bg", "BG"));
	SimpleDateFormat daytime = new SimpleDateFormat("dd.MM.yyyy");
	Date d = new Date();
	System.out.println(daytime.format(d));

	TestQModule module = new TestQModule();
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
	module.init();
	module.test();
	System.out.println(module.prtPattern);

	String[] arr = module.prtPattern.split("@");

	for (int i = 0; i < arr.length; i++) {
	    System.out.println(arr[i]);
	}

    }
}
