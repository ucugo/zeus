package com.mahull.zeus.dao.entity.location.iprange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.HashMap;

public class FileDatabase extends AbstractDatabase{
	private static final Logger logger = LoggerFactory.getLogger(FileDatabase.class);
	private final File file;
	private Calendar lastUpdate;

	public FileDatabase(File file) {
		this.file=file;
	}
	
	@Override
	public boolean isUpdateRequired() {
		Calendar currentTimestamp = Calendar.getInstance();
		currentTimestamp.setTimeInMillis(this.file.lastModified());
		currentTimestamp.set(Calendar.MILLISECOND, 0);
		return this.file != null && (getDatabase() == null || this.lastUpdate == null || currentTimestamp.after(this.lastUpdate));
	}

	@Override
	public void doUpdate() {
		try{
			Calendar currentTimestamp = Calendar.getInstance();
			currentTimestamp.setTimeInMillis(this.file.lastModified());
			currentTimestamp.set(Calendar.MILLISECOND, 0);
			HashMap<Key, Value> database = createDatabaseFromInputStream(new FileInputStream(this.file),true);
			if(getDatabase() != null){
				getDatabase().clear();
			}
			setDatabase(database);
			this.lastUpdate = currentTimestamp;
			logger.info("Updated database from File:[{}]", this.file);
		}catch (Exception e) {
			if(getDatabase() == null){
				logger.error("Failed to load database from file.  File:["+this.file+"] Reason:["+e.getMessage()+"]",e);
			}else{
				logger.warn("Failed to update database from file, will use out of date database.  File:[{}]", this.file);
			}
		}
	}
}