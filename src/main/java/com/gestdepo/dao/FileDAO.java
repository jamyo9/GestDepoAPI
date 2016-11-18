package com.gestdepo.dao;

public interface FileDAO {

	public long saveFile(Object data, String name, String type, Class<?> parentClass, long parentId, long id);
	public void getImageById(long id);
	public boolean deleteFile(long id);
	public boolean deleteFileByParentId(long id);
	
}
