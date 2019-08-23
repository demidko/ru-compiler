package com.farpost.aot.compiler;

import org.apache.lucene.util.CharsRef;
import org.apache.lucene.util.IntsRef;
import org.apache.lucene.util.fst.Util;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;


public class CreateFstTest {

	private static IntsRef intsRefFromInt(int i) {
		return new IntsRef(new int[]{i}, 0, 1);
	}

	@Test
	public void testFrom() throws IOException {
		var fst = CreateFst.from(new String[]{"мясо", "хлеб", "овощи"});
		assertThat(Util.get(fst,  intsRefFromInt(2)), equalTo(new CharsRef("овощи")));
		assertThat(Util.get(fst,  intsRefFromInt(0)), equalTo(new CharsRef("мясо")));
		assertThat(Util.get(fst,  intsRefFromInt(1)), equalTo(new CharsRef("хлеб")));
	}
}