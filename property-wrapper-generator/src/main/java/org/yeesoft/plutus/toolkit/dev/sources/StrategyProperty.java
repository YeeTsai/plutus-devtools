package org.yeesoft.plutus.toolkit.dev.sources;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
public class StrategyProperty implements Comparable<StrategyProperty> {
	private final SimpleStringProperty id;
	private final SimpleStringProperty name;
	private final SimpleStringProperty className;
	private final SimpleStringProperty description;
	public static Map<String, String> buildColumnMap() {
		Map<String, String> map = new  LinkedHashMap<String, String>();
		map.put("id", "id");
		map.put("name", "name");
		map.put("className", "className");
		map.put("description", "description");
		return map;
	}

	public static String hashMapKey(Strategy strategy) {
		StringBuffer sb =  new StringBuffer();
		sb.append(strategy.getName());
		return sb.toString();
	}

	public static String hashMapKey(StrategyProperty strategyProperty) {
		StringBuffer sb =  new StringBuffer();
		sb.append(strategyProperty.getName());
		return sb.toString();
	}
	public StrategyProperty(Strategy strategy) {
		id = new SimpleStringProperty(strategy.getId());
		name = new SimpleStringProperty(strategy.getName());
		className = new SimpleStringProperty(strategy.getClassName());
		description = new SimpleStringProperty(strategy.getDescription());
	}

	public void update(StrategyProperty o) { 
		setId(o.getId());
		setName(o.getName());
		setClassName(o.getClassName());
		setDescription(o.getDescription());
	}

	public void update(Strategy o) { 
		setId(o.getId());
		setName(o.getName());
		setClassName(o.getClassName());
		setDescription(o.getDescription());
	}

	public SimpleStringProperty idProperty() {
		return id;
	}
	public String getId() {
		return id.get();
	}

	public void setId(String id) {
		this.id.set(id);
	}

	public SimpleStringProperty nameProperty() {
		return name;
	}
	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public SimpleStringProperty classNameProperty() {
		return className;
	}
	public String getClassName() {
		return className.get();
	}

	public void setClassName(String className) {
		this.className.set(className);
	}

	public SimpleStringProperty descriptionProperty() {
		return description;
	}
	public String getDescription() {
		return description.get();
	}

	public void setDescription(String description) {
		this.description.set(description);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this == obj) return true;
		if (obj.getClass() == StrategyProperty.class) {
			StrategyProperty s = (StrategyProperty)obj;
			return new EqualsBuilder()
					.append(this.getName(), s.getName())
					.isEquals();
		}
		return false;
	}

	@Override
	public int compareTo(StrategyProperty o) {
		return new CompareToBuilder()
				.append(this.getName(), o.getName())
				.toComparison();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getName())
				.hashCode();
	}
}
