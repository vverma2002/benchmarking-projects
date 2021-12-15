package com.vik.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StringJoinBenchmark {
	@Benchmark
	@Fork(value = 2)
	@Measurement(iterations = 10, time = 1)
	@Warmup(iterations = 5, time = 1)
	public String stringConcat() {
		String result = "";
		for (int i = 0; i < 1000; i++) {
			result += String.valueOf(i);
		}
		return result;
	}

	@Benchmark
	@Fork(value = 2)
	@Measurement(iterations = 10, time = 1)
	@Warmup(iterations = 5, time = 1)
	public String concatUsingStringBuilder() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < 1000; i++) {
			result.append(i);
		}
		return result.toString();
	}
}