package GsonUtil;

import java.util.List;
import java.util.Map;

public class MapperEntity {

	private String id;

	private Map<String, List<String>> methods;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, List<String>> getMethods() {
		return methods;
	}

	public void setMethods(Map<String, List<String>> methods) {
		this.methods = methods;
	}

	@Override
	public String toString() {
		return "MapperEntity [id=" + id + ", methods=" + methods + "]";
	}
	
}
