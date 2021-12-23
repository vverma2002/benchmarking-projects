package benchmark;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

public class ApacheVsMavenBenchmark {

//	private File file = null;
//	
//	@Setup(Level.Invocation)
//	public void doSetup() {
//		System.out.println("setting the file");
//		  try {
//			  file = new File("..").getAbsoluteFile().getCanonicalPath() + File.separator
//		          + "maven" + File.separator + "target" + File.separator + "maven"
//		          + "-" + "0.0.1-SNAPSHOT" + ".jar";
//		    } catch (IOException e) {
//		      throw new IllegalStateException("Cannot find benchmarks", e);
//		    }
//	}

	@Benchmark
	public int mavenBuild() throws Exception {
//		return new ProcessBuilder("cmd", "/c", "mvn clean install").directory(new File("../maven")).inheritIO().start().waitFor();
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "mvn clean install");
		Map<String, String> envs = pb.environment();
		System.out.println(envs.get("JAVA_HOME"));
		envs.put("JAVA_HOME", "C:\\Program Files\\Java\\jdk-11");
		
		return pb.directory(new File("../maven")).inheritIO().start().waitFor();
	}

	@Benchmark
	public int gradleBuild() throws Exception {
		
//		return new ProcessBuilder("cmd", "/c", "gradle clean build").directory(new File("../gradle")).inheritIO().start().waitFor();
		
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "gradle --build-cache clean build"); //--info 
		Map<String, String> envs = pb.environment();
		System.out.println(envs.get("JAVA_HOME"));
		envs.put("JAVA_HOME", "C:\\Program Files\\Java\\jdk-11");
		
		return pb.directory(new File("../gradle")).inheritIO().start().waitFor();
	}
}