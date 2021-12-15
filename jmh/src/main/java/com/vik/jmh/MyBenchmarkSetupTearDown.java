package com.vik.jmh;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

public class MyBenchmarkSetupTearDown {

	@State(Scope.Thread)
	public static class MyState {

		@Setup(Level.Trial)
		public void doSetup() {
			sum = 0;
			System.out.println("Do Setup");
		}

		@TearDown(Level.Trial)
		public void doTearDown() {
			System.out.println("Do TearDown");
		}

		public int a = 1;
		public int b = 2;
		public int sum;
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.MINUTES)
	public void testMethod(MyState state) {
		state.sum = state.a + state.b;
	}
}