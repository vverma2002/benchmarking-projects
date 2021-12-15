package com.vik.jmh;

import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import org.openjdk.jmh.runner.options.WarmupMode;



public class BenchmarkRunner {
	   public static void main(String[] args) throws RunnerException {
	        Options opt = new OptionsBuilder()
	                .include(HelloWorldBenchmark.class.getSimpleName())
	                .warmupIterations(1)
	                .warmupTime(TimeValue.milliseconds(100))
	                .measurementIterations(1)
	                .measurementTime(TimeValue.milliseconds(100))
	                .forks(1)
	                .warmupForks(2)
	                .build();

	        new Runner(opt).run();
	    }
}
