package com.gestdepo.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.DatatypeConverter;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.web.multipart.MultipartFile;

import com.gestdepo.dao.FileDAO;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

public class FileDAOImpl implements FileDAO {

	private GridFsOperations gridFSOps;
	private static final String FILES_COLLECTION = "files";

	public FileDAOImpl(GridFsOperations gridFSOps) {
		this.gridFSOps = gridFSOps;
	}

	public long saveFile(Object data, String name, String type, Class<?> parentCollectionClass, long parentId,
			long id) {

		GridFSDBFile file = null;

		if (null != data) {
			
			// 1. delete the existing file
			if (id != 0) {
				this.deleteFile(id);
			}
			
			// 2. save the actual file
			InputStream stream = null;
			try {
				DBObject metaData = new BasicDBObject();
				metaData.put("ParentCollectionClass", parentCollectionClass);
				metaData.put("ParentId", parentId);
				
				if (data instanceof MultipartFile) {
					// in case data is a video
					stream = ((MultipartFile)data).getInputStream();
				} else {
					// in case data is a image
					String dataStr = (String)data;
					if (!dataStr.isEmpty()) {
						String encodingPrefix = "base64,";
						int contentStartIndex = dataStr.indexOf(encodingPrefix) + encodingPrefix.length();
						byte[] bytes = DatatypeConverter.parseBase64Binary(dataStr.substring(contentStartIndex));
		
						stream = new ByteArrayInputStream(bytes);
					}	
				}
				file = (GridFSDBFile) gridFSOps.store(stream, name, type, metaData);
			} catch (Exception e) {
				return 0L;
			} finally {
				if (stream != null) {
					try {
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return (null != file) ? (long) file.getId(): 0l;
	}

	public void getImageById(long id) {
		GridFSDBFile result = gridFSOps.findOne(new Query().addCriteria(Criteria.where("_id").is(id)));
		/*
		try {
			result.writeTo("/Users/mkyong/Downloads/new-testing.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}

	public boolean deleteFile(long id) {
		boolean deleted = true;
		try {
			gridFSOps.delete(new Query(Criteria.where("_id").is(id)));
		} catch (Exception e) {
			deleted = false;
		}
		return deleted;
	}

	public boolean deleteFileByParentId(long id) {
		boolean deleted = true;
		try {
			gridFSOps.delete(new Query(Criteria.where("metadata.parentId").is(id)));
		} catch (Exception e) {
			deleted = false;
		}
		return deleted;
	}
}
