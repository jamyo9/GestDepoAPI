package com.gestdepo.model;

public class MaterialVO {
	
	private long materialId;
	private String nombre;
	private int quantity;
	
	// CONSTRUCTORS
	public MaterialVO() {
		this.materialId = 0L;
		this.nombre = "";
		this.quantity = 0;
	}

	public MaterialVO(long materialId, String nombre, int quantity) {
		super();
		this.materialId = materialId;
		this.nombre = nombre;
		this.quantity = quantity;
	}
	
	public MaterialVO(MaterialVO material) {
		this.setMaterialId(material.getMaterialId());
		this.setNombre(material.getNombre());
		this.setQuantity(material.getQuantity());
	}

	// GETTERS & SETTERS
	public long getMaterialId() {
		return materialId;
	}
	public void setMaterialId(long materialId) {
		this.materialId = materialId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
