package Sandbox;

import com.google.common.collect.*;

public class GuavaSandbox {

	public static void main(String[] args) {

		BiMap<String, Integer> userId = HashBiMap.create();
		String userForId = userId.inverse().get("test");
	}
}
