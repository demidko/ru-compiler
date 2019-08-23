package com.farpost.aot.compiler;

import org.apache.lucene.util.CharsRef;
import org.apache.lucene.util.fst.Builder;
import org.apache.lucene.util.fst.CharSequenceOutputs;
import org.apache.lucene.util.fst.FST;
import org.apache.lucene.util.fst.Util;

import java.io.IOException;

/// FST<Тип Значения>
/// Тип ключа - всегда байты или числа

public class Main {

	public static void main(String[] args)  {
		System.out.print(new CharsRef("тесто").chars);
	}
}
