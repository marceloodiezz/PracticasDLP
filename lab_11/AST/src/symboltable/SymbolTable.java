package symboltable;

import java.util.*;
import ast.definition.Definition;

public class SymbolTable {
	
	private int scope=0;
	private List<Map<String,Definition>> table;

	public SymbolTable()  {
		this.table = new ArrayList<>();
		this.table.add(new HashMap<>());
	}

	public void set() {
		scope++;
		table.add(new HashMap<>());
	}
	
	public void reset() {
		table.removeLast();
		scope--;
	}
	
	public boolean insert(Definition definition) {
		if (!findInCurrentScope(definition.getName())) {
			table.getLast().put(definition.getName(), definition);
			definition.setScope(scope);
			return true;
		}
		return false;
	}
	
	public Definition find(String id) {
		for (int i = table.size() - 1; i >= 0; i--) {
			Map<String,Definition> map = table.get(i);
			if(map.containsKey(id))
				return map.get(id);
		}
		return null;
	}

	//package-protected for testing pourposes
	boolean findInCurrentScope(String id) {
		Map<String, Definition> currentScope = table.get(scope);
		return currentScope.containsKey(id);
	}
}
