package com.farpost.aot.compiler;

import org.apache.lucene.util.CharsRef;
import org.apache.lucene.util.IntsRef;
import org.apache.lucene.util.fst.*;

import java.io.IOException;

/**
 * Класс полностью инкапсулирует процесс создания FST
 * Фасад для дефолтного билдера
 * По сути, этот класс - статическая функция, что и отражено в названии
 */
final class CreateFst {

	/**
	 * @param arr массив (необязательно уникальных) строк
	 * @return fst где в соответствие каждому индексу поставлена его строка
	 */
	public static FST<CharsRef> from(String[] arr) throws IOException {
		var builder = new Builder<CharsRef>(
			FST.INPUT_TYPE.BYTE1,
			CharSequenceOutputs.getSingleton()
		);
		for (int key = 0; key < arr.length; ++key) {
			builder.add(new IntsRef(new int[]{key}, 0, 1), new CharsRef(arr[key]));
		}
		return builder.finish();
	}
}
