import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AppReport {
    public void getreport()
    {
        ExtentReports report=new ExtentReports();
        ExtentSparkReporter spark=new ExtentSparkReporter("E:\\Software Testing\\Selenium\\skcet_software_teesting\\day 9\\demo\\src\\test\\java\\com\\example\\report.hml");
        report.attachReporter(spark);
        spark.config().setDocumentTitle("onelinguOneMotor");
        spark.config().setTheme(Theme.DARK);
    }   
} 