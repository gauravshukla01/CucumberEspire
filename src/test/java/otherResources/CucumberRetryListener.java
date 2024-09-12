package otherResources;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class CucumberRetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        // Ensure the annotation and method are correctly recognized
        Class<? extends IRetryAnalyzer> retry = annotation.getRetryAnalyzerClass();
        if (retry == null) {
            annotation.setRetryAnalyzer(RetryAnalyzer.class); // Assign the RetryAnalyzer
        }
    }
}